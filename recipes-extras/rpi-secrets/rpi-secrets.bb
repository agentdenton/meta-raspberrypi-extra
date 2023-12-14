SUMMARY = "Share private configurations between recipes"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://git@github.com/agentdenton/rpi-secrets.git;protocol=ssh;branch=main"

do_install() {
    install -d ${RPI_SECRETS_DIR}

    cp -r ${S}/* ${RPI_SECRETS_DIR}
}
