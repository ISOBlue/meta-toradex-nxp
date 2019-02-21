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

# As per meta-freescale commit 927b31771dab ("xf86-video-imx-vivante: Remove fb
# from name") this package got renamed. Use new one!
XSERVER_DRIVER_colibri-imx6 = "xf86-video-imx-vivante"

# Use i.MX Gstreamer Version
PREFERRED_VERSION_gstreamer1.0 = "1.14.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-base = "1.14.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-good = "1.14.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-bad = "1.14.imx"
