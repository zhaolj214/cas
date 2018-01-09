package org.apereo.cas.configuration.model.support.clouddirectory

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.core.io.Resource

import java.io.Serializable

/**
 * This is [CloudDirectoryProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-cloud-directory-authentication")
class CloudDirectoryProperties : Serializable {
    /**
     * Authenticate and bind into the instance via a credentials properties file.
     */
    @RequiredProperty
    var credentialsPropertiesFile: Resource? = null

    /**
     * Use access-key provided by AWS to authenticate.
     */
    @RequiredProperty
    var credentialAccessKey: String? = null
    /**
     * Use secret key provided by AWS to authenticate.
     */
    @RequiredProperty
    var credentialSecretKey: String? = null

    /**
     * AWS region used.
     */
    @RequiredProperty
    var region: String? = null

    /**
     * Profile name to use.
     */
    var profileName: String? = null
    /**
     * Profile path.
     */
    var profilePath: String? = null
    /**
     * Directory ARN.
     */
    @RequiredProperty
    var directoryArn: String? = null
    /**
     * Schema ARN.
     */
    @RequiredProperty
    var schemaArn: String? = null
    /**
     * Facet name.
     */
    var facetName: String? = null

    /**
     * Username attribute to choose when locating accounts.
     */
    @RequiredProperty
    var usernameAttributeName: String? = null
    /**
     * Password attribute to choose on the entry to compare.
     */
    @RequiredProperty
    var passwordAttributeName: String? = null
    /**
     * Username index path.
     */
    var usernameIndexPath: String? = null

    /**
     * The name of the authentication handler.
     */
    var name: String? = null

    /**
     * Password encoding properties.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * Principal transformation properties.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * The order of this authentication handler in the chain.
     */
    var order = Integer.MAX_VALUE

    companion object {
        private const val serialVersionUID = 6725526133973304269L
    }
}
