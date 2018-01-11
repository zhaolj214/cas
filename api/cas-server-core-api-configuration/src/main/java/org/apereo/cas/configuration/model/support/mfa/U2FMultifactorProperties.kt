package org.apereo.cas.configuration.model.support.mfa

import org.apereo.cas.configuration.model.core.util.EncryptionJwtSigningJwtCryptographyProperties
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties
import org.apereo.cas.configuration.model.support.quartz.ScheduledJobProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RestEndpointProperties
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.util.concurrent.TimeUnit

/**
 * This is [U2FMultifactorProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-u2f")
class U2FMultifactorProperties : BaseMultifactorProviderProperties() {

    /**
     * Store device registration records inside a JDBC resource.
     */
    var jpa = Jpa()

    /**
     * Expire and forget device registration requests after this period.
     */
    var expireRegistrations: Long = 30
    /**
     * Device registration requests expiration time unit.
     */
    var expireRegistrationsTimeUnit = TimeUnit.SECONDS

    /**
     * Expire and forget device registration records after this period.
     */
    var expireDevices: Long = 30
    /**
     * Device registration record expiration time unit.
     */
    var expireDevicesTimeUnit = TimeUnit.DAYS
    /**
     * Store device registration records inside a MongoDb resource.
     */
    var mongo = MongoDb()
    /**
     * Store device registration records inside a static JSON resource.
     */
    var json = Json()
    /**
     * Store device registration records via a Groovy script.
     */
    var groovy = Groovy()
    /**
     * Store device registration records via REST APIs.
     */
    var rest = Rest()
    /**
     * Clean up expired records via a background cleaner process.
     */
    @NestedConfigurationProperty
    var cleaner = ScheduledJobProperties("PT10S", "PT1M")

    /**
     * Crypto settings that sign/encrypt the u2f registration records.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionJwtSigningJwtCryptographyProperties()

    init {
        id = DEFAULT_IDENTIFIER
    }

    class Jpa : AbstractJpaProperties() {
        companion object {
            private val serialVersionUID = -4334840263678287815L
        }
    }

    class MongoDb : SingleCollectionMongoDbProperties() {
        init {
            collection = "CasMongoDbU2FRepository"
        }

        companion object {
            private val serialVersionUID = -7963843335569634144L
        }
    }

    @RequiresModule(name = "cas-server-support-u2f")
    class Json : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = -6883660787308509919L
        }
    }

    @RequiresModule(name = "cas-server-support-u2f")
    class Rest : RestEndpointProperties() {
        companion object {
            private val serialVersionUID = -8102345678378393382L
        }
    }

    @RequiresModule(name = "cas-server-support-u2f")
    class Groovy : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 8079027843747126083L
        }
    }

    companion object {
        /**
         * Provider id by default.
         */
        const val DEFAULT_IDENTIFIER = "mfa-u2f"

        private val serialVersionUID = 6151350313777066398L
    }
}

