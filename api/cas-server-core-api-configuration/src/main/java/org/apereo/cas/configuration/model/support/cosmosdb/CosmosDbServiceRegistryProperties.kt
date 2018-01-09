package org.apereo.cas.configuration.model.support.cosmosdb

import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [CosmosDbServiceRegistryProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-cosmosdb-service-registry")
class CosmosDbServiceRegistryProperties : BaseCosmosDbProperties(), Serializable {

    /**
     * Collection to store CAS service definitions.
     */
    @RequiredProperty
    var collection = "CasCosmosDbServiceRegistry"

    companion object {
        private const val serialVersionUID = 6194689836396653458L
    }
}
