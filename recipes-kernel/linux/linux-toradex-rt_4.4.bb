require recipes-kernel/linux/linux-imx.inc
include conf/tdx_version.conf

SUMMARY = "Linux kernel with real-time patch for Toradex Colibri VFxx Computer on Modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH} \
           https://www.kernel.org/pub/linux/kernel/projects/rt/4.4/patch-4.4.60-rt73.patch.xz \
           file://defconfig"

SRC_URI[md5sum] = "9084b5fe511383d0588a15d6034116cb"
SRC_URI[sha256sum] = "cbe77f8db27bae1d018b786bead3996c753f0e45fdec6dab088fbe2cffd0f890"

KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_ITEM}"

SRCREV = "a126a5e5dc2fcc5cb36af14c89b440cc8e3bab30"
SRCBRANCH = "toradex_vf_4.4"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_vf_4.4-next"
DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(vf)"
