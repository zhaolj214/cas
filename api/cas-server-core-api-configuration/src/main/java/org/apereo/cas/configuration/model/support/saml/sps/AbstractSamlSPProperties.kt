package org.apereo.cas.configuration.model.support.saml.sps

import org.apereo.cas.configuration.support.RequiredProperty
import java.io.Serializable

/**
 * This is [AbstractSamlSPProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
abstract class AbstractSamlSPProperties : Serializable {
    /**
     * The location of the metadata for this service provider.
     * Can be a URL or another form of resource.
     */
    @RequiredProperty
    var metadata: String? = null
    /**
     * Name of this service provider.
     */
    var name: String? = this.javaClass.simpleName
    /**
     * Description of this service provider as it's stored in the registry.
     */
    var description: String? = this.javaClass.simpleName + " SAML SP Integration"
    /**
     * Attribute to use when generating nameids for this SP.
     */
    var nameIdAttribute: String? = null
    /**
     * The forced nameId format to use when generating a response.
     */
    var nameIdFormat: String? = null
    /**
     * Set up the attribute release policy for this service.
     * Allow attributes that are to be released to this SP.
     * Attributes should be separated by commas and can be virtually mapped and renamed.
     */
    var attributes = mutableListOf<String>()
    /**
     * Signature location used to verify metadata.
     */
    var signatureLocation: String? = null
    /**
     * List of entityIds allowed for this service provider.
     * Multiple ids can be specified in the event that the metadata is an aggregate.
     */
    var entityIds = mutableListOf<String>()

    /**
     * Indicate whether responses should be signed.
     */
    var isSignResponses = true
    /**
     * Indicate whether assertions should be signed.
     */
    var isSignAssertions: Boolean = false

    /**
     * Sets attributes.
     *
     * @param attributes the attributes
     */
    fun setAttributes(vararg attributes: String) {
        this.attributes = mutableListOf(*attributes)
    }

    companion object {
        private const val serialVersionUID = -5381463661659831898L
    }
}
