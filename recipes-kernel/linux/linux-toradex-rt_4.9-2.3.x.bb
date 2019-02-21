require recipes-kernel/linux/linux-toradex_4.9-2.3.x.bb
FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-rt-4.9-2.3.x:"

SUMMARY = "Real-Time Linux kernel for Toradex Freescale i.MX based modules"

SRC_URI += " \
    file://001.patch \
    file://001b.patch \
    file://002.patch \
    file://002b.patch \
    file://002c.patch \
    file://002d.patch \
    file://002e.patch \
    file://002f.patch \
    file://002g.patch \
    file://002h.patch \
    file://002i.patch \
    file://002j.patch \
    file://002k.patch \
    file://002l.patch \
    file://003.patch \
    file://004.patch \
    https://www.kernel.org/pub/linux/kernel/projects/rt/4.9/older/patch-4.9.115-rt94.patch.xz;name=rt-patch \
    file://0002-mm-Work-around-the-oops-below-by-disabling-split-ptl.patch \
"

SRC_URI[rt-patch.md5sum] = "7c19c496fe4b1e268f5f185b1b266043"
SRC_URI[rt-patch.sha256sum] = "5d6ac2e1fe94dfea1ac0353bf1907653413bcbf6b795b833e4edf9586b79d68a"

SRCREV = "5758a8e648a3947d974fbcaad49db6e513a77a9d"
SRCBRANCH = "toradex_4.9-2.3.x-imx"
