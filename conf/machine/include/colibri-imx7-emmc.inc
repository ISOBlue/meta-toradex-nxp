IMAGE_CLASSES += "image_type_tezi"
IMAGE_FSTYPES_append = " teziimg"
# The payload offsets are given in number of 512 byte blocks.
OFFSET_BOOTROM_PAYLOAD = "2"
TORADEX_PRODUCT_IDS = "0039"
TORADEX_FLASH_TYPE = "emmc"

MACHINE_FIRMWARE_remove = "firmware-imx-epdc"

# Use i.MX Gstreamer Version (for PXP DMA-ENGINE Driver)
PREFERRED_VERSION_gstreamer1.0 = "1.14.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-base = "1.14.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-good = "1.14.imx"
PREFERRED_VERSION_gstreamer1.0-plugins-bad = "1.14.imx"
