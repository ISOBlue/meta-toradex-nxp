require recipes-kernel/linux/linux-imx.inc
include conf/tdx_version.conf

SUMMARY = "Linux kernel with real-time patch for Toradex Colibri VFxx Computer on Modules"

SRC_URI = " \
    git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
    https://www.kernel.org/pub/linux/kernel/projects/rt/4.4/older/patch-4.4.164-rt176.patch.xz;name=rt-patch \
    file://defconfig \
"

SRC_URI[rt-patch.md5sum] = "39d25cb2f119c9b4053ce1e40f2d00a8"
SRC_URI[rt-patch.sha256sum] = "ecaaf3e329b4b4bf2b57c84344e3ae2ae8f0209ec40093ae6589decb48089b15"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_ITEM}"

SRCREV = "09733c33a1e232097653c96bd788848129c95c7e"
SRCBRANCH = "toradex_vf_4.4"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_vf_4.4-next"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
