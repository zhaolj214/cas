package org.apereo.cas.configuration.model.support.mfa

import org.apache.commons.lang3.StringUtils
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.core.io.Resource

import java.util.ArrayList

/**
 * This is [YubiKeyMultifactorProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-yubikey")
class YubiKeyMultifactorProperties : BaseMultifactorProviderProperties() {

    /**
     * Yubikey client id.
     */
    @RequiredProperty
    var clientId: Int? = 0
    /**
     * Yubikey secret key.
     */
    @RequiredProperty
    var secretKey = StringUtils.EMPTY

    /**
     * Keep device registration records inside a static JSON resource.
     */
    var jsonFile: Resource? = null
    /**
     * Collection of allowed devices whitelisted per user.
     * This is done using a key-value structure where the key is the user
     * the value is the whitelisted collection of yubikey device ids.
     */
    var allowedDevices: Map<String, String>? = null
    /**
     * YubiKey API urls to contact for verification of credentials.
     */
    var apiUrls: List<String> = ArrayList()
    /**
     * Indicates whether this provider should support trusted devices.
     */
    var isTrustedDeviceEnabled: Boolean = false
    /**
     * Keep device registration records inside a JDBC resource.
     */
    var jpa = Jpa()
    /**
     * Keep device registration records inside a MongoDb resource.
     */
    var mongo = MongoDb()

    init {
        id = DEFAULT_IDENTIFIER
    }

    class Jpa : AbstractJpaProperties() {
        companion object {
            private val serialVersionUID = -4420099402220880361L
        }
    }

    class MongoDb : SingleCollectionMongoDbProperties() {
        init {
            collection = "MongoDbYubiKeyRepository"
        }

        companion object {
            private val serialVersionUID = 6876845341227039713L
        }
    }

    companion object {
        /**
         * Provider id by default.
         */
        val DEFAULT_IDENTIFIER = "mfa-yubikey"

        private val serialVersionUID = 9138057706201201089L
    }
}

