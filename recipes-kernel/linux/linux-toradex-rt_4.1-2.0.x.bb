require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc
include conf/tdx_version.conf

SUMMARY = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI = "git://git.toradex.com/linux-toradex.git;protocol=git;branch=${SRCBRANCH}"

SRC_URI += "\
    https://www.kernel.org/pub/linux/kernel/projects/rt/4.1/older/patch-4.1.35-rt41.patch.gz;name=rt-patch \
    file://0001-fix-build.patch \
    file://0002-no-split-ptlocks.patch \
    file://0003-Work-around-CPU-stalls-in-the-imx-sdma-driver.patch \
    file://defconfig \
"

SRC_URI[rt-patch.md5sum] = "375bb334b265898a94214c3199308298"
SRC_URI[rt-patch.sha256sum] = "284a1bc0094df0a61e6dcb9996eceea6a3791ccba1e5763e36f251d0dfeecd32"

# Load USB functions configurable through configfs (CONFIG_USB_CONFIGFS)
KERNEL_MODULE_AUTOLOAD += "${@bb.utils.contains('COMBINED_FEATURES', 'usbgadget', ' libcomposite', '',d)}"

LOCALVERSION = "-${PR}"
PR = "${TDX_VER_INT}-rt"

#SRCBRANCH = "toradex_4.1-2.0.x-imx"
#SRCREV = "ba2f75f559bc54406e8938ab5be722298fe7166c"
SRCREV = "98b774f93e5d5167321734fd114c6570e804b7b2"
SRCBRANCH = "toradex_4.1-2.0.x-imx-next"

DEPENDS += "lzop-native bc-native"
COMPATIBLE_MACHINE = "(mx7|mx6)"
