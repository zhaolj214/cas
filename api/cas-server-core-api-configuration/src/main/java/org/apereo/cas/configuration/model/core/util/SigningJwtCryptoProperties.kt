package org.apereo.cas.configuration.model.core.util

import org.apache.commons.lang3.StringUtils
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [SigningJwtCryptoProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class SigningJwtCryptoProperties : Serializable {
    /**
     * The signing key is a JWT whose length is defined by the signing key size setting.
     */
    @RequiredProperty
    var key = StringUtils.EMPTY
    /**
     * The signing key size.
     */
    var keySize = 512

    companion object {
        private const val serialVersionUID = -552544781333015532L
    }
}
