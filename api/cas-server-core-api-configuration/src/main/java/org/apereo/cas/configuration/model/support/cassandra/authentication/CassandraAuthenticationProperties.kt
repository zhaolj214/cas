package org.apereo.cas.configuration.model.support.cassandra.authentication

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * This is [CassandraAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-cassandra-authentication")
class CassandraAuthenticationProperties : BaseCassandraProperties() {
    /**
     * Name of the authentication handler.
     */
    var name: String? = null
    /**
     * The authentication handler order in the chain.
     */
    var order: Int? = null
    /**
     * Username attribute to fetch and compare.
     */
    @RequiredProperty
    var usernameAttribute: String? = null
    /**
     * Password attribute to fetch and compare.
     */
    @RequiredProperty
    var passwordAttribute: String? = null
    /**
     * Table name to fetch credentials.
     */
    @RequiredProperty
    var tableName: String? = null

    /**
     * Password encoding settings for this authentication.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * Principal transformation settings for this authentication.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    companion object {
        private val serialVersionUID = 1369405266376125234L
    }
}
