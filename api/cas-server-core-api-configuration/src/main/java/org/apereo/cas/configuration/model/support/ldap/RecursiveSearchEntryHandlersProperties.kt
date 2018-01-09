package org.apereo.cas.configuration.model.support.ldap

import java.io.Serializable

/**
 * This is [RecursiveSearchEntryHandlersProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class RecursiveSearchEntryHandlersProperties : Serializable {
    /**
     * The Search attribute.
     */
    var searchAttribute: String? = null
    /**
     * The Merge attributes.
     */
    var mergeAttributes: List<String>? = null

    companion object {
        private const val serialVersionUID = 7038108925310792763L
    }
}
