SUMMARY = "USB/UART loader for i.MX51/53/6x/7 and Vybrid"
SECTION = "base"
HOMEPAGE = "https://github.com/boundarydevices/imx_usb_loader"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "libusb"

SRCREV = "138c0b25a4df6bc25567882ba80337543c22fd93"
SRC_URI = "git://github.com/boundarydevices/imx_usb_loader.git;protocol=git;branch=master"
SRC_URI += " \
    file://imx_usb.conf \
    file://mx6ull_usb_rom.conf \
    file://mx6ull_usb_sdp_uboot.conf \
    file://mx6_usb_rom.conf \
    file://mx6_usb_sdp_spl.conf \
    file://mx6_usb_sdp_uboot.conf \
    file://mx7_usb_rom.conf \
    file://mx7_usb_sdp_uboot.conf \
    file://vybrid_usb_rom.conf \
"

S = "${WORKDIR}/git/"

#we want imx_usb binary to run on a 32-bit architecture, on x86_64 this requires the 32-bit compatibility libs
EXTRA_OEMAKE_class-native = "CC='${CC} -m32' CXX='${CXX} -m32'"

do_install () {
    oe_runmake DESTDIR=${D} install
    # inject our conf files
    rm -rf ${D}{sysconfdir}/imx-loader.d/*.conf
    install -m 644 ${WORKDIR}/*.conf ${D}/${sysconfdir}/imx-loader.d/
}

inherit pkgconfig

BBCLASSEXTEND = "native nativesdk"
