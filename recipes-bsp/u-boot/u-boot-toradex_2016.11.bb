require recipes-bsp/u-boot/u-boot-toradex.inc

DESCRIPTION = "U-Boot for NXP based Toradex Computer on Modules"
PV = "2016.11"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

SRCREV = "1b121c6ab548a9af0a27876e9eaa0c654c1dc3e1"
SRCBRANCH = "2016.11-toradex"
COMPATIBLE_MACHINE = "(mx6|mx7|vf)"


# Hack around building two U-Boot configurations, one with, one without SPL
# if using UBOOT_CONFIG to build more than one configuration, the current code in
# u-boot.inc assumes all are either with or without SPL.
do_compile_append_mx6() {
    if [ -n "${UBOOT_CONFIG}" ]
    then
        for config in ${UBOOT_MACHINE}; do
            touch ${B}/${config}/${SPL_BINARY}
        done
    fi
}
do_deploy_append_mx6() {
    # if SPL is zero sized file, remove all deployed artefacts
    if [ -n "${SPL_BINARY}" ]
    then
        if [ -n "${UBOOT_CONFIG}" ]
        then
            for config in ${UBOOT_MACHINE}; do
                i=$(expr $i + 1);
                for type in ${UBOOT_CONFIG}; do
                    j=$(expr $j + 1);
                    if [ $j -eq $i ]
                    then
                        if [ ! -s ${DEPLOYDIR}/${SPL_IMAGE}-${type}-${PV}-${PR} ]
                        then
                            rm -f ${DEPLOYDIR}/${SPL_IMAGE}-${type}-${PV}-${PR}
                            rm -f ${DEPLOYDIR}/${SPL_BINARYNAME}-${type}
                            rm -f ${DEPLOYDIR}/${SPL_SYMLINK}-${type}
                            rm -f ${DEPLOYDIR}/${SPL_SYMLINK}
                        else
                            ln -sf ${SPL_IMAGE}-${type}-${PV}-${PR} ${SPL_BINARYNAME}
                        fi
                    fi
                done
                unset  j
            done
            unset  i
        fi
    fi
}
