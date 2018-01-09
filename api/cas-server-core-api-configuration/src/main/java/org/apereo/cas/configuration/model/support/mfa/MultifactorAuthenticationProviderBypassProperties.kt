package org.apereo.cas.configuration.model.support.mfa

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RestEndpointProperties
import org.apereo.cas.configuration.support.SpringResourceProperties

import java.io.Serializable

/**
 * This is [MultifactorAuthenticationProviderBypassProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class MultifactorAuthenticationProviderBypassProperties : Serializable {

    /**
     * Acceptable values are:
     *
     *  * `DEFAULT`: Default bypass rules to skip provider via attributes, etc.
     *  * `GROOVY`: Handle bypass decisions via a groovy script.
     *  * `REST`: Handle bypass rules via a REST endpoint
     *
     */
    var type = MultifactorProviderBypassTypes.DEFAULT
    /**
     * Skip multifactor authentication based on designated principal attribute names.
     */
    var principalAttributeName: String? = null
    /**
     * Optionally, skip multifactor authentication based on designated principal attribute values.
     */
    var principalAttributeValue: String? = null
    /**
     * Skip multifactor authentication based on designated authentication attribute names.
     */
    var authenticationAttributeName: String? = null
    /**
     * Optionally, skip multifactor authentication based on designated authentication attribute values.
     */
    var authenticationAttributeValue: String? = null
    /**
     * Skip multifactor authentication depending on form of primary authentication execution.
     * Specifically, skip multifactor if the a particular authentication handler noted by its name
     * successfully is able to authenticate credentials in the primary factor.
     */
    var authenticationHandlerName: String? = null
    /**
     * Skip multifactor authentication depending on method/form of primary authentication execution.
     * Specifically, skip multifactor if the authentication method attribute collected as part of
     * authentication metadata matches a certain value.
     */
    var authenticationMethodName: String? = null
    /**
     * Skip multifactor authentication depending on form of primary credentials.
     * Value must equal the fully qualified class name of the credential type.
     */
    var credentialClassType: String? = null

    /**
     * Skip multifactor authentication if the http request's remote address or host
     * matches the value defined here. The value may be specified as a regular expression.
     */
    var httpRequestRemoteAddress: String? = null

    /**
     * Skip multifactor authentication if the http request contains the defined header names.
     * Header names may be comma-separated and can be regular expressions; values are ignored.
     */
    var httpRequestHeaders: String? = null

    /**
     * Handle bypass using a Groovy resource.
     */
    var groovy = Groovy()
    /**
     * Handle bypass using a REST endpoint.
     */
    var rest = Rest()

    enum class MultifactorProviderBypassTypes {
        /**
         * Handle multifactor authentication bypass per default CAS rules.
         */
        DEFAULT,
        /**
         * Handle multifactor authentication bypass via a Groovy script.
         */
        GROOVY,
        /**
         * Handle multifactor authentication bypass via a REST endpoint.
         */
        REST
    }

    @RequiresModule(name = "cas-server-core-authentication", automated = true)
    class Groovy : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 8079027843747126083L
        }
    }

    @RequiresModule(name = "cas-server-core-authentication", automated = true)
    class Rest : RestEndpointProperties() {
        companion object {
            private val serialVersionUID = 1833594332973137011L
        }
    }

    companion object {
        private const val serialVersionUID = -9181362378365850397L
    }
}
