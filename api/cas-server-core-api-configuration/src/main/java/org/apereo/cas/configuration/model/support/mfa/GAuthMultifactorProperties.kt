package org.apereo.cas.configuration.model.support.mfa

import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties
import org.apereo.cas.configuration.model.support.quartz.ScheduledJobProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [GAuthMultifactorProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-gauth")
class GAuthMultifactorProperties : BaseMultifactorProviderProperties() {

    /**
     * Issuer used in the barcode when dealing with device registration events.
     * Used in the registration URL to identify CAS.
     */
    @RequiredProperty
    var issuer = "CASIssuer"
    /**
     * Label used in the barcode when dealing with device registration events.
     * Used in the registration URL to identify CAS.
     */
    @RequiredProperty
    var label = "CASLabel"
    /**
     * Length of the generated code.
     */
    var codeDigits = 6
    /**
     * The expiration time of the generated code in seconds.
     */
    var timeStepSize: Long = 30
    /**
     * Since TOTP passwords are time-based, it is essential that the clock of both the server and
     * the client are synchronised within
     * the tolerance defined here as the window size.
     */
    var windowSize = 3

    /**
     * Store google authenticator devices inside a MongoDb instance.
     */
    var mongo = MongoDb()
    /**
     * Store google authenticator devices inside a jdbc instance.
     */
    var jpa = Jpa()
    /**
     * Store google authenticator devices inside a json file.
     */
    var json = Json()
    /**
     * Store google authenticator devices via a rest interface.
     */
    var rest = Rest()

    /**
     * Control how stale expired tokens should be cleared from the underlying store.
     */
    @NestedConfigurationProperty
    var cleaner = ScheduledJobProperties("PT1M", "PT1M")

    init {
        id = DEFAULT_IDENTIFIER
    }

    class Json : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 4303355159388663888L
        }
    }

    class Rest : Serializable {
        /**
         * Endpoint url of the REST resource used for tokens that are kept to prevent replay attacks.
         */
        var endpointUrl: String? = null

        companion object {
            private const val serialVersionUID = 4518622579150572559L
        }
    }

    class MongoDb : SingleCollectionMongoDbProperties() {
        /**
         * Collection name where tokens are kept to prevent replay attacks.
         */
        var tokenCollection: String? = null

        init {
            collection = "MongoDbGoogleAuthenticatorRepository"
            tokenCollection = "MongoDbGoogleAuthenticatorTokenRepository"
        }

        companion object {
            private val serialVersionUID = -200556119517414696L
        }
    }

    class Jpa : Serializable {
        /**
         * Database instance where tokens are kept to prevent replay attacks.
         */
        var database = Database()

        class Database : AbstractJpaProperties() {
            init {
                super.url = "jdbc:hsqldb:mem:cas-gauth"
            }

            companion object {
                private val serialVersionUID = -7446381055350251885L
            }
        }

        companion object {
            private const val serialVersionUID = -2689797889546802618L
        }
    }

    companion object {
        /**
         * Provider id by default.
         */
        val DEFAULT_IDENTIFIER = "mfa-gauth"

        private val serialVersionUID = -7401748853833491119L
    }
}
