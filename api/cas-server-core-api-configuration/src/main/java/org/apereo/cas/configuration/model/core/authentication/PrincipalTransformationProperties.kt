package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.SpringResourceProperties

import java.io.Serializable

/**
 * This is [PrincipalTransformationProperties].
 * Transform the user id prior to executing the authentication sequence.
 * Each authentication strategy in CAS provides settings to properly transform
 * the principal. Refer to the relevant settings for the authentication strategy at hand to learn more.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class PrincipalTransformationProperties : Serializable {

    /**
     * Prefix to add to the principal id prior to authentication.
     */
    var prefix: String? = null

    /**
     * Suffix to add to the principal id prior to authentication.
     */
    var suffix: String? = null

    /**
     * A regular expression that will be used against the provided username
     * for username extractions. On a successful match, the first matched group
     * in the pattern will be used as the extracted username.
     */
    var pattern: String? = null

    /**
     * Transform usernames using a Groovy resource.
     */
    var groovy = Groovy()

    /**
     * Indicate whether the principal identifier should be transformed
     * into upper-case, lower-case, etc.
     * Accepted values are `NONE, UPPERCASE, LOWERCASE`,
     */
    var caseConversion = CaseConversion.NONE

    enum class CaseConversion {
        /**
         * No conversion.
         */
        NONE,
        /**
         * Lowercase conversion.
         */
        UPPERCASE,
        /**
         * Uppcase conversion.
         */
        LOWERCASE
    }

    @RequiresModule(name = "cas-server-core-authentication", automated = true)
    class Groovy : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 8079027843747126083L
        }
    }

    companion object {

        private const val serialVersionUID = 1678602647607236322L
    }
}
