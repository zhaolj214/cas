package org.apereo.cas.configuration.model.support.wsfed

import org.apereo.cas.configuration.model.core.authentication.PersonDirectoryPrincipalResolverProperties
import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [WsFederationDelegationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-wsfederation-webflow")
class WsFederationDelegationProperties : Serializable {
    /**
     * The attribute extracted from the assertion and used to construct the CAS principal id.
     */
    @RequiredProperty
    var identityAttribute = "upn"
    /**
     * The entity id or the identifier of the Wsfed instance.
     */
    @RequiredProperty
    var identityProviderIdentifier = "https://adfs.example.org/adfs/services/trust"
    /**
     * Wsfed identity provider url.
     */
    @RequiredProperty
    var identityProviderUrl = "https://adfs.example.org/adfs/ls/"
    /**
     * Locations of signing certificates used to verify assertions.
     */
    @RequiredProperty
    var signingCertificateResources = "classpath:adfs-signing.crt"
    /**
     * The identifier for CAS (RP) registered with wsfed.
     */
    @RequiredProperty
    var relyingPartyIdentifier = "urn:cas:localhost"
    /**
     * Tolerance value used to skew assertions to support clock drift.
     */
    private var tolerance = "PT10S"
    /**
     * Indicates how attributes should be recorded into the principal object.
     * Useful if you wish to additionally resolve attributes on top of what wsfed provides.
     * Accepted values are `CAS,WSFED,BOTH`.
     */
    var attributesType = "WSFED"

    /**
     * Whether CAS should enable its own attribute resolution machinery
     * after having received a response from wsfed.
     */
    var isAttributeResolverEnabled = true

    /**
     * Whether CAS should auto redirect to this wsfed instance.
     */
    var isAutoRedirect = true

    /**
     * The path to the private key used to handle and verify encrypted assertions.
     */
    var encryptionPrivateKey = "classpath:private.key"
    /**
     * The path to the public key/certificate used to handle and verify encrypted assertions.
     */
    var encryptionCertificate = "classpath:certificate.crt"
    /**
     * The private key password.
     */
    var encryptionPrivateKeyPassword = "NONE"

    /**
     * Principal resolution settings.
     */
    @NestedConfigurationProperty
    var principal = PersonDirectoryPrincipalResolverProperties()

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    fun getTolerance(): Long {
        return Beans.newDuration(tolerance).toMillis()
    }

    fun setTolerance(tolerance: String) {
        this.tolerance = tolerance
    }

    companion object {

        private const val serialVersionUID = 5743971334977239938L
    }
}
