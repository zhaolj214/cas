package org.apereo.cas.configuration.model.support.mongo

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [MongoAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-mongo")
class MongoAuthenticationProperties : Serializable {
    /**
     * Attributes to fetch from Mongo.
     */
    var attributes: String? = null
    /**
     * Collection that holds credentials.
     */
    var collectionName = "users"
    /**
     * Mongo host uri where accounts are kept.
     */
    var mongoHostUri = "mongodb://uri"
    /**
     * Attributes that holds the username.
     */
    var usernameAttribute = "username"
    /**
     * Attribute that holds the password.
     */
    var passwordAttribute = "password"

    /**
     * Password encoder settings for the authentication handler.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * This is principal transformation properties.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    companion object {
        private const val serialVersionUID = -7304734732383722585L
    }

}
