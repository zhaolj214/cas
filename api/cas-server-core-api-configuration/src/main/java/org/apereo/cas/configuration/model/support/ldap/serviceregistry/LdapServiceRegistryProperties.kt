package org.apereo.cas.configuration.model.support.ldap.serviceregistry

import org.apereo.cas.configuration.model.support.ldap.AbstractLdapSearchProperties
import org.apereo.cas.configuration.support.RequiresModule

/**
 * This is [LdapServiceRegistryProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-ldap-service-registry")
class LdapServiceRegistryProperties : AbstractLdapSearchProperties() {

    /**
     * Object class used for the registered service entry in LDAP.
     */
    var objectClass = "casRegisteredService"

    /**
     * ID attribute used for the registered service entry in LDAP
     * to keep track of the service numeric identifier.
     */
    var idAttribute = "uid"

    /**
     * Service definintion attribute used for the registered service entry in LDAP
     * to keep a representation of the service body.
     */
    var serviceDefinitionAttribute = "description"

    /**
     * The search filter used to load entries by the [.idAttribute].
     * This is typically used to load a specific service definition by its id during search operations.
     */
    override var searchFilter: String? = "(%s={0})"
        get() = String.format(field!!, idAttribute)

    /**
     * The search filter used to load entries by the [.objectClass].
     * This is typically used to load all definitions that might be mapped to a service definition.
     */
    var loadFilter = "(objectClass=%s)"
        get() = String.format(field, objectClass)

    companion object {

        private val serialVersionUID = 2372867394066286022L
    }
}



