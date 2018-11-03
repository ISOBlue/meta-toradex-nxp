require recipes-kernel/linux/linux-imx.inc
include conf/tdx_version.conf

SUMMARY = "Linux kernel with real-time patch for Toradex Colibri VFxx Computer on Modules"

SRC_URI = " \
    git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
    https://www.kernel.org/pub/linux/kernel/projects/rt/4.4/older/patches-4.4.157-rt174.tar.xz;name=rt-patch \
    file://defconfig \
"

SRC_URI[rt-patch.md5sum] = "d4ef18cb46b2ae2bbdcfd44756f3dff9"
SRC_URI[rt-patch.sha256sum] = "24d36f61cc414050b53a25ee9d0ca0646f3e14847e093699a99c4102682c56dc"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_ITEM}"

SRCREV = "4f5df6df46d02b8fe23593461c003f689bd4dc4c"
SRCBRANCH = "toradex_vf_4.4"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_vf_4.4-next"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
