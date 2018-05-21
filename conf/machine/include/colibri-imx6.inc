IMAGE_CLASSES_append = " image_type_tezi"
IMAGE_FSTYPES_append = " teziimg"
TORADEX_PRODUCT_IDS = "0014 0015 0016 0017"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
OFFSET_SPL_PAYLOAD = "138"

KERNEL_IMAGETYPE_${MACHINE} = "zImage"

UBOOT_SUFFIX = "img"

PREFERRED_PROVIDER_virtual/libg2d_mx6 ?= "imx-gpu-g2d"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"
