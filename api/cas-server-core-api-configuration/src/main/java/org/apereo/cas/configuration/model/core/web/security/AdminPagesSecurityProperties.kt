package org.apereo.cas.configuration.model.core.web.security

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapAuthenticationProperties
import org.apereo.cas.configuration.model.support.ldap.LdapAuthorizationProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.core.io.Resource

import java.io.Serializable

/**
 * This is [AdminPagesSecurityProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-web", automated = true)
class AdminPagesSecurityProperties : Serializable {
    /**
     * The IP address pattern that can control access to the admin status endpoints.
     */
    var ip = "a^"

    /**
     * Alternative header name to use when extracting the IP address.
     * If left blank, the request's remote ip address will be pulled.
     * When dealing with proxies or load balancers, this value should likely
     * be set to `X-Forwarded-For`.
     */
    var alternateIpHeaderName: String? = null

    /**
     * Roles that are required for access to the admin status endpoint
     * in the event that access is controlled via external authentication
     * means such as Spring Security's authentication providers.
     */
    var adminRoles = mutableListOf("ROLE_ADMIN", "ROLE_ACTUATOR")

    /**
     * CAS server login URL to use.
     * When defined, will begin to protect the access status endpoints via CAS itself.
     */
    var loginUrl: String? = null
    /**
     * The service parameter for the admin status endpoint.
     * This is typically set to the dashboard url as the initial starting point
     * for the redirect.
     */
    var service: String? = null
    /**
     * List of users allowed access to the admin status endpoint
     * provided CAS is controlling access to the status endpoint.
     * If you decide to protect other administrative endpoints via CAS itself,
     * you will need to provide a reference to the list of authorized users in the CAS configuration.
     */
    var users: Resource? = null

    /**
     * Whether Spring Boot's actuator endpoints should show up on the dashboard.
     */
    var isActuatorEndpointsEnabled: Boolean = false

    /**
     * Enable Spring Security's JDBC authentication provider
     * for admin status authorization and access control.
     */
    var jdbc = Jdbc()
    /**
     * Enable Spring Security's LDAP authentication provider
     * for admin status authorization and access control.
     */
    var ldap = Ldap()

    /**
     * Enable Spring Security's JAAS authentication provider
     * for admin status authorization and access control.
     */
    var jaas = Jaas()

    class Jaas : Serializable {
        /**
         * JAAS login resource file.
         */
        var loginConfig: Resource? = null
        /**
         * If set, a call to `Configuration#refresh()`
         * will be made by `#configureJaas(Resource)` method.
         */
        var isRefreshConfigurationOnStartup = true

        /**
         * The login context name should coincide with a given index in the login config specified.
         * This name is used as the index to the configuration specified in the login config property.
         *
         * <pre>
         * JAASTest {
         * org.springframework.security.authentication.jaas.TestLoginModule required;
         * };
        </pre> *
         * In the above example, `JAASTest` should be set as the context name.
         */
        var loginContextName: String? = null

        companion object {
            private const val serialVersionUID = -3024678577827371641L
        }
    }

    class Ldap : AbstractLdapAuthenticationProperties() {

        /**
         * Control authorization settings via LDAP
         * after ldap authentication.
         */
        /**
         * Gets ldap authz.
         *
         * @return the ldap authz
         */
        @NestedConfigurationProperty
        var ldapAuthz = LdapAuthorizationProperties()
            get() {
                field.baseDn = baseDn
                field.searchFilter = searchFilter
                return field
            }

        companion object {
            private val serialVersionUID = -7333244539096172557L
        }
    }

    class Jdbc : AbstractJpaProperties() {

        /**
         * Prefix to add to the role.
         */
        var rolePrefix: String? = null

        /**
         * Query to execute in order to authenticate users via JDBC.
         * Example:
         * `SELECT username,password,enabled FROM users WHERE username=?`
         */
        var query: String? = null

        /**
         * Password encoder properties.
         */
        @NestedConfigurationProperty
        var passwordEncoder = PasswordEncoderProperties()

        companion object {
            private val serialVersionUID = 2625666117528467867L
        }
    }

    companion object {
        private const val serialVersionUID = 9129787932447507179L
    }
}
