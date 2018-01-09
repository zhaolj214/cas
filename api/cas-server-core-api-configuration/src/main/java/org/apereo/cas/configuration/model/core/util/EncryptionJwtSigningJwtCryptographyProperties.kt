package org.apereo.cas.configuration.model.core.util

import org.apereo.cas.CipherExecutor

import java.io.Serializable

/**
 * Common properties for all cryptography related configs.
 * A number of components in CAS accept signing and encryption keys.
 * In most scenarios if keys are not provided, CAS will auto-generate them.
 * The following instructions apply if you wish to manually and beforehand
 * create the signing and encryption keys.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
open class EncryptionJwtSigningJwtCryptographyProperties : Serializable {
    /**
     * Whether crypto operations are enabled.
     */
    var isEnabled = true

    /**
     * Settings that deal with encryption of values.
     */
    var encryption = EncryptionJwtCryptoProperties()

    /**
     * Settings that deal with signing of values.
     */
    var signing = SigningJwtCryptoProperties()

    /**
     * The signing/encryption algorithm to use.
     */
    var alg = CipherExecutor.DEFAULT_CONTENT_ENCRYPTION_ALGORITHM

    companion object {

        private const val serialVersionUID = -3015641631298039059L
    }
}
