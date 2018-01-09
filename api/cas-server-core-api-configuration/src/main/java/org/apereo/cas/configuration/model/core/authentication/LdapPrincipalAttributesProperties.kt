package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.model.support.ldap.AbstractLdapSearchProperties
import org.apereo.cas.configuration.support.RequiresModule

import java.util.HashMap

/**
 * This is [LdapPrincipalAttributesProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-person-directory", automated = true)
class LdapPrincipalAttributesProperties : AbstractLdapSearchProperties() {

    /**
     * The order of this attribute repository in the chain of repositories.
     * Can be used to explicitly position this source in chain and affects
     * merging strategies.
     */
    var order: Int = 0

    /**
     * Map of attributes to fetch from the source.
     * Attributes are defined using a key-value structure
     * where CAS allows the attribute name/key to be renamed virtually
     * to a different attribute. The key is the attribute fetched
     * from the data source and the value is the attribute name CAS should
     * use for virtual renames.
     */
    var attributes: Map<String, String> = HashMap()

    companion object {
        private val serialVersionUID = 5760065368731012063L
    }
}
