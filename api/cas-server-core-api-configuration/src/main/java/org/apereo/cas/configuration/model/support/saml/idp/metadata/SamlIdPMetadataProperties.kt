package org.apereo.cas.configuration.model.support.saml.idp.metadata

import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource

import java.io.File
import java.io.Serializable
import java.util.ArrayList
import java.util.concurrent.TimeUnit

/**
 * This is [SamlIdPMetadataProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-saml-idp")
class SamlIdPMetadataProperties : Serializable {

    /**
     * Whether invalid metadata should eagerly fail quickly on startup
     * once the resource is parsed.
     */
    var isFailFast = true

    /**
     * Whether valid metadata is required.
     */
    var isRequireValidMetadata = true

    /**
     * How long should metadata be cached in minutes.
     */
    var cacheExpirationMinutes = TimeUnit.DAYS.toMinutes(1)

    /**
     * Directory location of SAML metadata and signing/encryption keys.
     * This directory will be used to hold the configuration files.
     */
    @RequiredProperty
    var location: Resource = FileSystemResource("/etc/cas/saml")

    /**
     * Properties pertaining to mongo db saml metadata resolvers.
     */
    @NestedConfigurationProperty
    var mongo = MongoDbSamlMetadataProperties()

    /**
     * Properties pertaining to jpa metadata resolution.
     */
    @NestedConfigurationProperty
    var jpa = JpaSamlMetadataProperties()

    /**
     * Algorithm name to use when generating private key.
     */
    var privateKeyAlgName = "RSA"

    /**
     * Basic auth username in case the metadata instance is connecting to an MDQ server.
     */
    var basicAuthnUsername: String? = null

    /**
     * Basic auth password in case the metadata instance is connecting to an MDQ server.
     */
    var basicAuthnPassword: String? = null

    /**
     * Supported content types in case the metadata instance is connecting to an MDQ server.
     */
    var supportedContentTypes: List<String> = ArrayList()

    /**
     * Gets full location of signing cert file.
     *
     * @return the signing cert file
     * @throws Exception the exception
     */
    val signingCertFile: Resource
        @Throws(Exception::class)
        get() = FileSystemResource(File(this.location.file, "/idp-signing.crt"))

    /**
     * Gets signing key file.
     *
     * @return the signing key file
     * @throws Exception the exception
     */
    val signingKeyFile: Resource
        @Throws(Exception::class)
        get() = FileSystemResource(File(this.location.file, "/idp-signing.key"))

    /**
     * Gets encryption cert file.
     *
     * @return the encryption cert file
     * @throws Exception the exception
     */
    val encryptionCertFile: Resource
        @Throws(Exception::class)
        get() = FileSystemResource(File(this.location.file, "/idp-encryption.crt"))

    /**
     * Gets encryption key file.
     *
     * @return the encryption key file
     * @throws Exception the exception
     */
    val encryptionKeyFile: Resource
        @Throws(Exception::class)
        get() = FileSystemResource(File(this.location.file, "/idp-encryption.key"))

    /**
     * Gets idp metadata file.
     *
     * @return the metadata file
     * @throws Exception the exception
     */
    val metadataFile: File
        @Throws(Exception::class)
        get() = File(this.location.file, "idp-metadata.xml")

    companion object {
        private const val serialVersionUID = -1020542741768471305L
    }
}
