/*
 * Copyright 2017 Toradex AG.
 *
 * SPDX-License-Identifier:	GPL-2.0+
 */

/*
 * Running this will set GPR9/GPR10 to values which will make the module
 * go to recovery mode on next reboot.
 * It has the same effect as 'bmode usb noreset' in U-Boot
 *
 * $ arm-linux-gnueabihf-gcc -o bmode_usb bmode_usb.c
 * $ arm-linux-gnueabihf-strip bmode_usb
 */

#include <fcntl.h>
#include <stdio.h>
#include <sys/mman.h>
#include <unistd.h>

/* valid for i.MX6DL/i.MX6Q */
#define SRC_BASE_ADDR	0x020D8000
#define SRC_GPR9_OFF	(0x40/4)
#define SRC_GPR10_OFF	(0x44/4)

int main(void)
{
	int fd;
	unsigned reg;
	unsigned *src;

	fd = open("/dev/mem", O_RDWR);
	src = (unsigned *)mmap(0, SRC_GPR10_OFF + 4, PROT_READ|PROT_WRITE,
			       MAP_SHARED, fd, 0x020D8000);
	if(src == NULL) {
		printf("Failed to mmap register\n");
		return -1;
	}

	src[SRC_GPR9_OFF] = 0x10;
	src[SRC_GPR10_OFF] |= 0x10000000;

	printf("Next reboot (not powercycle!) will boot to recovery mode\n");
	return 0;
}
