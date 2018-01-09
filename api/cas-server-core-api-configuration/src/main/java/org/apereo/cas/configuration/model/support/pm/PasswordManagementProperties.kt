package org.apereo.cas.configuration.model.support.pm

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.util.EncryptionJwtSigningJwtCryptographyProperties
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapProperties
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapSearchProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty
import java.io.Serializable
import java.util.*

/**
 * This is [PasswordManagementProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-pm-webflow")
class PasswordManagementProperties : Serializable {
    /**
     * Flag to indicate if password management facility is enabled.
     */
    var isEnabled: Boolean = false

    /**
     * Flag to indicate whether successful password change should trigger login automatically.
     */
    var isAutoLogin: Boolean = false

    /**
     * A String value representing password policy regex pattarn.
     *
     *
     * Minimum 8 and Maximum 10 characters at least 1 Uppercase Alphabet, 1 Lowercase Alphabet, 1 Number and 1 Special Character.
     */
    var policyPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,10}"

    /**
     * Manage account passwords in LDAP.
     */
    var ldap = Ldap()
    /**
     * Manage account passwords in database.
     */
    var jdbc = Jdbc()
    /**
     * Manage account passwords via REST.
     */
    var rest = Rest()
    /**
     * Manage account passwords in JSON resources.
     */
    var json = Json()

    /**
     * Settings related to resetting password.
     */
    var reset = Reset()

    @RequiresModule(name = "cas-server-support-pm-jdbc")
    class Jdbc : AbstractJpaProperties() {

        /**
         * Password encoder properties.
         */
        @NestedConfigurationProperty
        var passwordEncoder = PasswordEncoderProperties()

        /**
         * SQL query to change the password and update.
         */
        var sqlChangePassword: String? = null
        /**
         * SQL query to locate the user email address.
         */
        var sqlFindEmail: String? = null
        /**
         * SQL query to locate security questions for the account, if any.
         */
        var sqlSecurityQuestions: String? = null

        companion object {
            private val serialVersionUID = 4746591112640513465L
        }
    }

    @RequiresModule(name = "cas-server-support-pm-rest")
    class Rest : Serializable {
        /**
         * Endpoint URL to use when locating email addresses.
         */
        var endpointUrlEmail: String? = null
        /**
         * Endpoint URL to use when locating security questions.
         */
        var endpointUrlSecurityQuestions: String? = null
        /**
         * Endpoint URL to use when updating passwords..
         */
        var endpointUrlChange: String? = null

        companion object {
            private const val serialVersionUID = 5262948164099973872L
        }
    }

    @RequiresModule(name = "cas-server-support-pm-ldap")
    class Ldap : AbstractLdapSearchProperties() {
        /**
         * Collection of attribute names that indicate security questions answers.
         * This is done via a key-value structure where the key is the attribute name
         * for the security question and the value is the attribute name for the answer linked to the question.
         */
        var securityQuestionsAttributes: Map<String, String> = LinkedHashMap()

        /**
         * The specific variant of LDAP
         * based on which update operations will be constructed.
         */
        var type: AbstractLdapProperties.LdapType = AbstractLdapProperties.LdapType.AD

        companion object {
            private val serialVersionUID = -2610186056194686825L
        }
    }

    @RequiresModule(name = "cas-server-support-pm-webflow")
    class Reset : Serializable {
        /**
         * Crypto settings on how to reset the password.
         */
        @NestedConfigurationProperty
        var crypto = EncryptionJwtSigningJwtCryptographyProperties()

        /**
         * Text one might receive as a notification to reset the password.
         */
        var text = "Reset your password via this link: %s"
        /**
         * The subject of the notification for password resets.
         */
        var subject = "Password Reset"
        /**
         * From address of the notification.
         */
        var from: String? = null
        /**
         * Attribute indicating the an email address where notification is sent.
         */
        var emailAttribute = "mail"
        /**
         * Whether reset operations require security questions,
         * or should they be marked as optional.
         */
        var isSecurityQuestionsEnabled = true

        /**
         * How long in minutes should the password expiration link remain valid.
         */
        var expirationMinutes = 1f

        companion object {
            private const val serialVersionUID = 3453970349530670459L
        }
    }

    @RequiresModule(name = "cas-server-support-pm")
    class Json : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 1129426669588789974L
        }
    }

    companion object {

        private const val serialVersionUID = -260644582798411176L
    }
}
