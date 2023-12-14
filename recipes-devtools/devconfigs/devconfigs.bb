SUMMARY = "Provide custom configuration files"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "rpi-secrets"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${RPI_SECRETS_DIR}/wpa_supplicant.conf ${D}${sysconfdir}
}

FILES:${PN} += "${sysconfdir}"
