package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.model.support.ldap.AbstractLdapProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.util.LinkedCaseInsensitiveMap

import javax.security.auth.login.LoginException
import java.io.Serializable

/**
 * Configuration properties class for password.policy.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class PasswordPolicyProperties : Serializable {

    /**
     * Decide how LDAP authentication should handle password policy changes.
     * Acceptable values are:
     *
     *  * `DEFAULT`: Default password policy rules handling account states.
     *  * `GROOVY`: Handle account changes and warnings via Groovy scripts
     *  * `REJECT_RESULT_CODE`: Handle account state only if the ldap authentication result code isn't blocked
     *
     */
    var strategy = PasswordPolicyHandlingOptions.DEFAULT

    /**
     * Key-value structure (Map) that indicates a list of boolean attributes as keys.
     * If either attribute value is true, indicating an account state is flagged,
     * the corresponding error can be thrown.
     * Example `accountLocked=javax.security.auth.login.AccountLockedException`
     */
    var policyAttributes: Map<String, Class<LoginException>> = LinkedCaseInsensitiveMap()

    /**
     * Whether password policy should be enabled.
     */
    var isEnabled = true

    /**
     * An implementation of a policy class that knows how to handle LDAP responses.
     * The class must be an implementation of `org.ldaptive.auth.AuthenticationResponseHandler`.
     */
    var customPolicyClass: String? = null
    /**
     * When dealing with FreeIPA, indicates the number of allows login failures.
     */
    var loginFailures = 5

    /**
     * Used by an account state handling policy that only calculates account warnings
     * in case the LDAP entry carries an attribute [.warningAttributeName]
     * whose value matches this field.
     */
    var warningAttributeValue: String? = null
    /**
     * Used by an account state handling policy that only calculates account warnings
     * in case the LDAP entry carries this attribute.
     */
    var warningAttributeName: String? = null
    /**
     * Indicates if warning should be displayed, when the ldap attribute value
     * matches the [.warningAttributeValue].
     */
    var isDisplayWarningOnMatch = true
    /**
     * Always display the password expiration warning regardless.
     */
    var isWarnAll: Boolean = false
    /**
     * In the event that AD is chosen as the type, this is used to calculate
     * a warning period to see if account expiry is within the calculated window.
     */
    var warningDays = 30
    /**
     * LDAP type. Accepted values are `GENERIC,AD,FreeIPA,EDirectory`
     */
    var type: AbstractLdapProperties.LdapType = AbstractLdapProperties.LdapType.GENERIC

    /**
     * Handle password policy via Groovy script.
     */
    var groovy = Groovy()

    enum class PasswordPolicyHandlingOptions {
        /**
         * Default option to handle policy changes.
         */
        DEFAULT,
        /**
         * Handle account password policies via Groovy.
         */
        GROOVY,
        /**
         * Strategy to only activate password policy
         * if the authentication response code is not blacklisted.
         */
        REJECT_RESULT_CODE
    }

    @RequiresModule(name = "cas-server-support-ldap")
    class Groovy : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 8079027843747126083L
        }
    }

    companion object {
        private const val serialVersionUID = -3878237508646993100L
    }
}
