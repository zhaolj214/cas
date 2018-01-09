package org.apereo.cas.configuration.model.core.util

import org.apache.commons.lang3.StringUtils
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [EncryptionJwtCryptoProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class EncryptionJwtCryptoProperties : Serializable {
    /**
     * The encryption key is a JWT whose length is defined by the signing key size setting.
     */
    @RequiredProperty
    var key = StringUtils.EMPTY

    /**
     * The encryption key size.
     */
    var keySize = 512

    companion object {

        private const val serialVersionUID = 616825635591169628L
    }
}
