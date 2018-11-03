include conf/tdx_version.conf

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.4:"

LOCALVERSION = "-${TDX_VER_ITEM}"

SRCREV = "4f5df6df46d02b8fe23593461c003f689bd4dc4c"
SRCBRANCH = "toradex_vf_4.4"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_vf_4.4-next"
