IMAGE_CLASSES_append = " image_type_tezi"
IMAGE_FSTYPES_append = " teziimg"
TORADEX_PRODUCT_IDS = "0027 0028 0029 0035"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
OFFSET_SPL_PAYLOAD = "138"

KERNEL_DEVICETREE_remove = "imx6q-apalis_v1_0-eval.dtb imx6q-apalis_v1_0-ixora.dtb"
KERNEL_IMAGETYPE_${MACHINE} = "zImage"

UBOOT_SUFFIX = "img"

PREFERRED_PROVIDER_virtual/libg2d_mx6 ?= "imx-gpu-g2d"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"

# Use i.MX Gstreamer Version
PREFERRED_VERSION_gstreamer1.0 = "1.12.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-base = "1.12.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-good = "1.12.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-bad = "1.12.imx"
