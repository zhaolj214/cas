package org.apereo.cas.configuration.model.support.ldap

import java.io.Serializable

/**
 * This is [CaseChangeSearchEntryHandlersProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class CaseChangeSearchEntryHandlersProperties : Serializable {
    /**
     * The Dn case change.
     */
    var dnCaseChange: String? = null
    /**
     * The Attribute name case change.
     */
    var attributeNameCaseChange: String? = null
    /**
     * The Attribute value case change.
     */
    var attributeValueCaseChange: String? = null
    /**
     * The Attribute names.
     */
    var attributeNames: List<String>? = null

    companion object {
        private const val serialVersionUID = 2420895955116725666L
    }
}
