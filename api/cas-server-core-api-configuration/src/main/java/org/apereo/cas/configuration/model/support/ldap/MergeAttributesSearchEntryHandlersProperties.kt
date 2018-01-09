package org.apereo.cas.configuration.model.support.ldap

import java.io.Serializable

/**
 * This is [MergeAttributesSearchEntryHandlersProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class MergeAttributesSearchEntryHandlersProperties : Serializable {
    /**
     * The Merge attribute name.
     */
    var mergeAttributeName: String? = null
    /**
     * The Attribute names.
     */
    var attributeNames: List<String>? = null

    companion object {
        private const val serialVersionUID = -3988972992084584349L
    }
}
