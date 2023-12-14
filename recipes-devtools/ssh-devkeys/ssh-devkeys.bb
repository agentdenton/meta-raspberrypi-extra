SUMMARY = "Deploy ssh development keys to the target machine"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    file://ssh_config_dev \
    file://sshd_config_dev \
"

DEPENDS += "rpi-secrets"

KEYS_DIR = "${RPI_SECRETS_DIR}/ssh/devkeys"

do_install() {
    install -d ${D}${sysconfdir}/ssh

    install -m 0644 ${WORKDIR}/ssh_config_dev ${D}${sysconfdir}/ssh/ssh_config
    install -m 0644 ${WORKDIR}/sshd_config_dev ${D}${sysconfdir}/ssh/sshd_config

    install -m 0600 ${KEYS_DIR}/ssh_host_dsa_key ${D}${sysconfdir}/ssh
    install -m 0644 ${KEYS_DIR}/ssh_host_dsa_key.pub ${D}${sysconfdir}/ssh

    install -m 0600 ${KEYS_DIR}/ssh_host_ecdsa_key ${D}${sysconfdir}/ssh
    install -m 0644 ${KEYS_DIR}/ssh_host_ecdsa_key.pub ${D}${sysconfdir}/ssh

    install -m 0600 ${KEYS_DIR}/ssh_host_ed25519_key ${D}${sysconfdir}/ssh
    install -m 0644 ${KEYS_DIR}/ssh_host_ed25519_key.pub ${D}${sysconfdir}/ssh

    install -m 0600 ${KEYS_DIR}/ssh_host_rsa_key ${D}${sysconfdir}/ssh
    install -m 0644 ${KEYS_DIR}/ssh_host_rsa_key.pub ${D}${sysconfdir}/ssh
}

FILES:${PN} += "${sysconfdir}/ssh"
