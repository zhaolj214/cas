package org.apereo.cas.configuration.model.support.mfa

import org.apereo.cas.configuration.model.core.util.EncryptionJwtSigningJwtCryptographyProperties
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties
import org.apereo.cas.configuration.model.support.quartz.ScheduledJobProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable
import java.util.concurrent.TimeUnit

/**
 * This is [TrustedDevicesMultifactorProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-trusted-mfa")
class TrustedDevicesMultifactorProperties : Serializable {
    /**
     * If an MFA request is bypassed due to a trusted authentication decision, applications will
     * receive a special attribute as part of the validation payload that indicates this behavior.
     * Applications must further account for the scenario where they ask for an MFA mode and
     * yet don’t receive confirmation of it in the response given the authentication
     * session was trusted and MFA bypassed.
     */
    var authenticationContextAttribute = "isFromTrustedMultifactorAuthentication"

    /**
     * Indicates whether CAS should ask for device registration consent
     * or execute it automatically.
     */
    var isDeviceRegistrationEnabled = true
    /**
     * Indicates how long should record/devices be remembered as trusted devices.
     */
    var expiration: Long = 30
    /**
     * Indicates the time unit by which record/devices are remembered as trusted devices.
     */
    var timeUnit = TimeUnit.DAYS
    /**
     * Store devices records via REST.
     */
    var rest = Rest()
    /**
     * Store devices records via JDBC resources.
     */
    var jpa = Jpa()

    /**
     * Record trusted devices via a JSON resource.
     */
    var json = Json()

    /**
     * Settings that control the background cleaner process.
     */
    @NestedConfigurationProperty
    var cleaner = ScheduledJobProperties("PT15S", "PT2M")
    /**
     * Store devices records inside MongoDb.
     */
    var mongo = MongoDb()

    /**
     * Crypto settings that sign/encrypt the device records.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionJwtSigningJwtCryptographyProperties()

    class Rest : Serializable {
        /**
         * Endpoint where trusted device records will be submitted to.
         */
        var endpoint: String? = null

        companion object {
            private const val serialVersionUID = 3659099897056632608L
        }
    }

    class Jpa : AbstractJpaProperties() {
        companion object {
            private val serialVersionUID = -8329950619696176349L
        }
    }

    class MongoDb : SingleCollectionMongoDbProperties() {
        init {
            collection = "MongoDbCasTrustedAuthnMfaRepository"
        }

        companion object {
            private val serialVersionUID = 4940497540189318943L
        }
    }

    class Json : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 3599367681439517829L
        }
    }

    companion object {
        private const val serialVersionUID = 1505013239016790473L
    }
}
