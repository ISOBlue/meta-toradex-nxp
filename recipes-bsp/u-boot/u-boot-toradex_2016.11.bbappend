require recipes-bsp/u-boot/u-boot-toradex-env.inc
include conf/tdx_version.conf

LOCALVERSION = "-${TDX_VER_ITEM}"

SRCREV = "087e95a2dcff4a21cf86bba2654f8948684d7d50"
SRCBRANCH = "2016.11-toradex"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "2016.11-toradex-next"

