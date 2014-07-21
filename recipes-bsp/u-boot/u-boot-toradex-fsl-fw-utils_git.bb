DESCRIPTION = "U-boot bootloader fw_printenv/setenv utils"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"
SECTION = "bootloader"
PROVIDES = "u-boot-fw-utils"
DEPENDS = "mtd-utils"

COMPATIBLE_MACHINE = "(colibri-vf|apalis-imx6)"
DEFAULT_PREFERENCE_colibri-vf = "1"
DEFAULT_PREFERENCE_apalis-imx6 = "1"

FILESPATHPKG =. "git:"
S="${WORKDIR}/git"
SRCREV_colibri-vf = "a62f99816066992c7a3793f944d253c3c5484cda"
SRCREV_apalis-imx6 = "a62f99816066992c7a3793f944d253c3c5484cda"
SRCBRANCH_colibri-vf = "2014.04-toradex"
SRCBRANCH_apalis-imx6 = "2014.04-toradex"
SRC_URI = "git://git.toradex.com/u-boot-toradex.git;protocol=git;branch=${SRCBRANCH} \
           file://fw_env.config \
"

PV = "${PR}+gitr${SRCREV}"
PR = "r0"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}"'

inherit uboot-config

do_compile () {
    oe_runmake ${UBOOT_MACHINE}
    oe_runmake env
}

do_install () {
    install -d ${D}${base_sbindir} ${D}${sysconfdir}
    install -m 755 ${S}/tools/env/fw_printenv_unstripped ${D}${base_sbindir}/fw_printenv
    ln -s fw_printenv ${D}${base_sbindir}/fw_setenv
    install -m 644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
