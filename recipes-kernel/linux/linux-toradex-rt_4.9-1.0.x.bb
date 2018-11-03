require recipes-kernel/linux/linux-toradex_4.9-1.0.x.bb
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-rt-4.9-1.0.x:"

SUMMARY = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI += " \
    file://0001-Revert-timers-Forward-timer-base-before-migrating-ti.patch \
    https://www.kernel.org/pub/linux/kernel/projects/rt/4.9/older/patch-4.9.84-rt62.patch.xz;name=rt-patch \
    file://0003-timers-Forward-timer-base-before-migrating-timers.patch \
    file://0001-gpu-viv-enable-PREEMPT-RT-fixes.patch \
    file://0002-mm-Work-around-the-oops-below-by-disabling-split-ptl.patch \
"

SRC_URI[rt-patch.md5sum] = "c0c5e47f37c0b25dbab934c2a2e456bb"
SRC_URI[rt-patch.sha256sum] = "399c873031599e356231fcf5694c7a438fb1f9faaa9bedcc0df4ef13fd8efc80"

SRCREV = "3bb6e3284a1bb88f142528537e6573f9d9f39aaa"
SRCBRANCH = "toradex_4.9-1.0.x-imx"
