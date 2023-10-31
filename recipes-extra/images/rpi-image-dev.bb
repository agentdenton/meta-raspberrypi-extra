require recipes-core/images/core-image-minimal-dev.bb

DESCRIPTION = "Development image for rpi0w"

IMAGE_FEATURES += "\
    debug-tweaks \
    ssh-server-openssh \
"

IMAGE_INSTALL += "\
    linux-firmware \
    kernel-modules \
    wpa-supplicant \
    i2c-tools \
"
