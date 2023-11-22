SUMMARY = "Download and share rpi-secrets between packages"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}/git"

# TODO: Create a more generic interface to access secrets that is easily
# reproducible
# TODO: Fetching from a private repo currently feels like a hack. This is
# because, upon docker container creation, I have to copy the known_hosts file
# along with the SSH keys. Is there a more efficient method to make this
# process less dependent on the host machine?
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/agentdenton/rpi-secrets.git;protocol=ssh;branch=main"

SECRETS_DIR = "${D}${datadir}/${BPN}"

do_install() {
    install -d ${SECRETS_DIR}

    cp -r ${S}/* ${SECRETS_DIR}
}

BBCLASSEXTEND += "native nativesdk"
