package org.apereo.cas.configuration.model.support.saml.shibboleth

import java.io.Serializable

/**
 * This is [ShibbolethAttributeResolverProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
class ShibbolethAttributeResolverProperties : Serializable {
    /**
     * List of Shibboleth's attribute resolver XMLM resources to parse and load.
     * Each resource can either be found on the file system, as a classpath entry
     * or via a URL if needed.
     */
    var resources = mutableListOf("attribute-resolver.xml")

    companion object {

        private const val serialVersionUID = 6315982182145371022L
    }
}
