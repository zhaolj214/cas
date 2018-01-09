package org.apereo.cas.configuration.model.support.ldap

import org.apache.commons.lang3.StringUtils
import org.apereo.cas.configuration.support.RequiresModule
import java.io.Serializable

/**
 * This is [LdapValidatorProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-support-ldap")
class LdapValidatorProperties : Serializable {
    /**
     * The following LDAP validators can be used to test connection health status:
     *
     *  * `search`: Validates a connection is healthy by performing a search operation.
     * Validation is considered successful if the search result size is greater than zero.
     *  * `none`: No validation takes place.
     *  * `compare`: Validates a connection is healthy by performing a compare operation.
     *
     */
    var type = "search"
    /**
     * Base DN to use for the search request of the search validator.
     */
    var baseDn = StringUtils.EMPTY
    /**
     * Search filter to use for the search request of the search validator.
     */
    var searchFilter = "(objectClass=*)"
    /**
     * Search scope to use for the search request of the search validator.
     */
    var scope = "OBJECT"
    /**
     * Attribute name to use for the compare validator.
     */
    var attributeName = "objectClass"
    /**
     * Attribute values to use for the compare validator.
     */
    var attributeValues = mutableListOf("top")
    /**
     * DN to compare to use for the compare validator.
     */
    var dn = StringUtils.EMPTY

    companion object {
        private const val serialVersionUID = 1150417354213235193L
    }
}
