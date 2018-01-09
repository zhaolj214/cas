package org.apereo.cas.configuration.model.core.util

import org.apache.commons.lang3.StringUtils
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [EncryptionRandomizedCryptoProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class EncryptionRandomizedCryptoProperties : Serializable {
    /**
     * The encryption key.
     * The encryption key by default and unless specified otherwise
     * must be randomly-generated string whose length
     * is defined by the encryption key size setting.
     */
    @RequiredProperty
    var key = StringUtils.EMPTY
    /**
     * Encryption key size.
     */
    var keySize = 16

    companion object {
        private const val serialVersionUID = -6945916782426505112L
    }
}
