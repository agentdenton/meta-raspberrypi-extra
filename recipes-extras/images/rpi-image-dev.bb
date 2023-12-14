require recipes-core/images/core-image-minimal-dev.bb

DESCRIPTION = "Development image for raspberry pi"

IMAGE_FEATURES += "\
    debug-tweaks \
    ssh-server-openssh \
"

IMAGE_INSTALL += "\
    linux-firmware \
    kernel-modules \
    wpa-supplicant \
    i2c-tools \
    python3 \
    vim \
    dhcpcd \
"

IMAGE_INSTALL += "\
    ssh-devkeys \
"
