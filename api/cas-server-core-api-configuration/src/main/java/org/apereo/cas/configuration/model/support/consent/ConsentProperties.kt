package org.apereo.cas.configuration.model.support.consent

import org.apereo.cas.configuration.model.core.util.EncryptionJwtSigningJwtCryptographyProperties
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapProperties
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapSearchProperties
import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable
import java.time.temporal.ChronoUnit

/**
 * This is [ConsentProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-consent-webflow")
class ConsentProperties : Serializable {
    /**
     * Global reminder time unit, to reconfirm consent
     * in cases no changes are detected.
     */
    var reminder = 30
    /**
     * Global reminder time unit of measure, to reconfirm consent
     * in cases no changes are detected.
     */
    var reminderTimeUnit = ChronoUnit.DAYS

    /**
     * Keep consent decisions stored via REST.
     */
    var rest = Rest()

    /**
     * Keep consent decisions stored via LDAP user records.
     */
    var ldap = Ldap()

    /**
     * Keep consent decisions stored via JDBC resources.
     */
    var jpa = Jpa()

    /**
     * Keep consent decisions stored via a static JSON resource.
     */
    var json = Json()

    /**
     * Keep consent decisions stored via a Groovy resource.
     */
    var groovy = Groovy()

    /**
     * Keep consent decisions stored via a MongoDb database resource.
     */
    var mongo = MongoDb()

    /**
     * Signing/encryption settings.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionJwtSigningJwtCryptographyProperties()

    @RequiresModule(name = "cas-server-consent-webflow")
    class Json : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 7079027843747126083L
        }
    }

    @RequiresModule(name = "cas-server-consent-webflow")
    class Groovy : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 7079027843747126083L
        }
    }

    @RequiresModule(name = "cas-server-consent-jdbc")
    class Jpa : AbstractJpaProperties() {
        companion object {
            private val serialVersionUID = 1646689616653363554L
        }
    }

    @RequiresModule(name = "cas-server-consent-ldap")
    class Ldap : AbstractLdapSearchProperties() {

        /**
         * Type of LDAP directory.
         */
        var type: AbstractLdapProperties.LdapType? = null

        /**
         * Name of LDAP attribute that holds consent decisions as JSON.
         */
        var consentAttributeName = "casConsentDecision"

        companion object {
            private val serialVersionUID = 1L
        }
    }

    @RequiresModule(name = "cas-server-consent-mongo")
    class MongoDb : SingleCollectionMongoDbProperties() {
        init {
            collection = "MongoDbCasConsentRepository"
        }

        companion object {
            private val serialVersionUID = -1918436901491275547L
        }
    }

    @RequiresModule(name = "cas-server-consent-rest")
    class Rest : Serializable {

        /**
         * REST endpoint to use to which consent decision records will be submitted.
         */
        var endpoint: String? = null

        companion object {
            private const val serialVersionUID = -6909617495470495341L
        }
    }

    companion object {
        private const val serialVersionUID = 5201308051524438384L
    }
}
