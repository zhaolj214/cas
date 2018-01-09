package org.apereo.cas.configuration.model.support.surrogate

import org.apereo.cas.configuration.model.support.email.EmailProperties
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapSearchProperties
import org.apereo.cas.configuration.model.support.sms.SmsProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RestEndpointProperties
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable
import java.util.LinkedHashMap

/**
 * This is [SurrogateAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-surrogate-webflow")
class SurrogateAuthenticationProperties : Serializable {
    /**
     * The separator character used to distinguish between the surrogate account and the admin account.
     */
    var separator = "+"
    /**
     * Locate surrogate accounts via CAS configuration, hardcoded as properties.
     */
    var simple = Simple()
    /**
     * Locate surrogate accounts via a JSON resource.
     */
    var json = Json()
    /**
     * Locate surrogate accounts via an LDAP server.
     */
    var ldap = Ldap()
    /**
     * Locate surrogate accounts via a JDBC resource.
     */
    var jdbc = Jdbc()

    /**
     * Locate surrogate accounts via a REST resource.
     */
    var rest = Rest()

    /**
     * Settings related to tickets issued for surrogate session, their expiration policy, etc.
     */
    var tgt = Tgt()

    /**
     * Email settings for notifications.
     */
    @NestedConfigurationProperty
    var mail = EmailProperties()

    /**
     * SMS settings for notifications.
     */
    @NestedConfigurationProperty
    var sms = SmsProperties()

    @RequiresModule(name = "cas-server-support-surrogate-webflow")
    class Simple : Serializable {
        /**
         * Define the list of accounts that are allowed to impersonate.
         * This is done in a key-value structure where the key is the admin user
         * and the value is a comma-separated list of identifiers that can be
         * impersonated by the admin-user.
         */
        var surrogates: Map<String, String> = LinkedHashMap()

        companion object {
            private const val serialVersionUID = 16938920863432222L
        }
    }

    @RequiresModule(name = "cas-server-support-surrogate-webflow")
    class Json : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 3599367681439517829L
        }
    }

    @RequiresModule(name = "cas-server-support-surrogate-authentication-rest")
    class Rest : RestEndpointProperties() {
        companion object {
            private val serialVersionUID = 8152273816132989085L
        }
    }

    @RequiresModule(name = "cas-server-support-surrogate-authentication-ldap")
    class Ldap : AbstractLdapSearchProperties() {
        /**
         * LDAP search filter used to locate the surrogate account.
         */
        var surrogateSearchFilter: String? = null
        /**
         * Attribute that must be found on the LDAP entry linked to the admin user
         * that tags the account as authorized for impersonation.
         */
        @RequiredProperty
        var memberAttributeName: String? = null
        /**
         * A pattern that is matched against the attribute value of the admin user,
         * that allows for further authorization of the admin user and accounts qualified for impersonation.
         * The regular expression pattern is expected to contain at least a single group whose value on a
         * successful match indicates the qualified impersonated user by admin.
         */
        var memberAttributeValueRegex: String? = null

        companion object {
            private val serialVersionUID = -3848837302921751926L
        }

    }

    @RequiresModule(name = "cas-server-support-surrogate-authentication")
    class Tgt : Serializable {

        /**
         * Timeout in seconds to kill the surrogate session and consider tickets expired.
         */
        var timeToKillInSeconds: Long = 1800

        companion object {
            private const val serialVersionUID = 2077366413438267330L
        }
    }

    @RequiresModule(name = "cas-server-support-surrogate-authentication-jdbc")
    class Jdbc : AbstractJpaProperties() {

        /**
         * Surrogate query to use to determine whether an admin user can impersonate another user.
         * The query must return an integer count of greater than zero.
         */
        @RequiredProperty
        var surrogateSearchQuery = "SELECT COUNT(*) FROM surrogate WHERE username=?"
        /**
         * SQL query to use in order to retrieve the list of qualified accounts for impersonation for a given admin user.
         */
        @RequiredProperty
        var surrogateAccountQuery = "SELECT surrogate_user AS surrogateAccount FROM surrogate WHERE username=?"

        companion object {
            private val serialVersionUID = 8970195444880123796L
        }
    }

    companion object {
        private const val serialVersionUID = -2088813217398883623L
    }
}
