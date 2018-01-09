package org.apereo.cas.configuration.model.support.mongo.serviceregistry

import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties
import org.apereo.cas.configuration.support.RequiresModule

/**
 * Configuration properties class mongodb service registry.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-mongo-service-registry")
class MongoDbServiceRegistryProperties : SingleCollectionMongoDbProperties() {
    init {
        collection = "cas-service-registry"
    }

    companion object {
        private val serialVersionUID = -227092724742371662L
    }
}
