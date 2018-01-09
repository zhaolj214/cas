package org.apereo.cas.configuration.model.support.ldap

import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [LdapSearchEntryHandlersProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
class LdapSearchEntryHandlersProperties : Serializable {

    /**
     * The type of search entry handler to choose.
     * Accepted values are `OBJECT_GUID,OBJECT_SID,CASE_CHANGE,DN_ATTRIBUTE_ENTRY,MERGE,PRIMARY_GROUP,RANGE_ENTRY,RECURSIVE_ENTRY`
     */
    var type: SearchEntryHandlerTypes? = null

    /**
     * Provides the ability to modify the case of search entry DNs, attribute names, and attribute values.
     */
    @NestedConfigurationProperty
    var casChange = CaseChangeSearchEntryHandlersProperties()

    /**
     * Adds the entry DN as an attribute to the result set. Provides a client side implementation of RFC 5020.
     */
    @NestedConfigurationProperty
    var dnAttribute = DnAttributeSearchEntryHandlersProperties()

    /**
     * Merges the values of one or more attributes into a single attribute. The merged attribute may or may not already
     * exist on the entry. If it does exist it's existing values will remain intact.
     */
    @NestedConfigurationProperty
    var mergeAttribute = MergeAttributesSearchEntryHandlersProperties()

    /**
     * Constructs the primary group SID and then searches for that group and puts it's DN in the 'memberOf' attribute of the
     * original search entry. This handler requires that entries contain both the 'objectSid' and 'primaryGroupID'
     * attributes. If those attributes are not found this handler is a no-op. This handler should be used in conjunction
     * with the `ObjectSidHandler` to ensure the 'objectSid' attribute is in the proper form. See
     * http://support2.microsoft.com/kb/297951
     */
    @NestedConfigurationProperty
    var primaryGroupId = PrimaryGroupIdSearchEntryHandlersProperties()

    /**
     * This recursively searches based on a supplied attribute and merges those results into the original entry.
     */
    @NestedConfigurationProperty
    var recursive = RecursiveSearchEntryHandlersProperties()

    /**
     * The enum Search entry handler types.
     */
    enum class SearchEntryHandlerTypes {
        /**
         * Object guid search entry handler.
         */
        OBJECT_GUID,
        /**
         * Object sid search entry handler.
         */
        OBJECT_SID,
        /**
         * Case change search entry handler.
         */
        CASE_CHANGE,
        /**
         * DN attribute entry handler.
         */
        DN_ATTRIBUTE_ENTRY,
        /**
         * Merge search entry handler.
         */
        MERGE,
        /**
         * Primary group search handler.
         */
        PRIMARY_GROUP,
        /**
         * Range entry search handler.
         */
        RANGE_ENTRY,
        /**
         * Recursive entry search handler.
         */
        RECURSIVE_ENTRY
    }

    companion object {
        private const val serialVersionUID = -5198990160347131821L
    }
}
