package org.apereo.cas.configuration.model.support.couchbase.authentication

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.model.support.couchbase.BaseCouchbaseProperties
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [CouchbaseAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class CouchbaseAuthenticationProperties : BaseCouchbaseProperties(), Serializable {
    /**
     * Principal transformation settings.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * The name of the authentication handler.
     */
    var name: String? = null

    /**
     * Password encoder settings for this handler.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * Order of authentication handler in chain.
     */
    private var order = Integer.MAX_VALUE
    /**
     * Username attribute to fetch and compare against credential.
     */
    @RequiredProperty
    var usernameAttribute = "username"
    /**
     * Password attribute to fetch and compare against credential.
     */
    @RequiredProperty
    var passwordAttribute = "psw"

    fun setOrder(order: Int) {
        this.order = order
    }

    fun getOrder(): Int? {
        return order
    }

    companion object {
        private const val serialVersionUID = -7257332242368463818L
    }

}
