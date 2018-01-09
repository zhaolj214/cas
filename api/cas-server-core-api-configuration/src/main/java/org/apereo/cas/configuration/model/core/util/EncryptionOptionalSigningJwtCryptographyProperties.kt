package org.apereo.cas.configuration.model.core.util

/**
 * This is [EncryptionOptionalSigningJwtCryptographyProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class EncryptionOptionalSigningJwtCryptographyProperties : EncryptionJwtSigningJwtCryptographyProperties() {
    /**
     * Whether crypto encryption operations are enabled.
     */
    var isEncryptionEnabled = true

    companion object {

        private val serialVersionUID = 7185404480671258520L
    }
}
