include conf/tdx_version.conf

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-toradex-4.4:"

LOCALVERSION = "-${TDX_VER_ITEM}"

SRCREV = "a126a5e5dc2fcc5cb36af14c89b440cc8e3bab30"
SRCBRANCH = "toradex_vf_4.4"
SRCREV_use-head-next = "${AUTOREV}"
SRCBRANCH_use-head-next = "toradex_vf_4.4-next"
