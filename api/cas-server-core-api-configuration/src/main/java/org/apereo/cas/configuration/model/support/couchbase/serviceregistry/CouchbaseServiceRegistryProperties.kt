package org.apereo.cas.configuration.model.support.couchbase.serviceregistry

import org.apereo.cas.configuration.model.support.couchbase.BaseCouchbaseProperties
import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [CouchbaseServiceRegistryProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-couchbase-service-registry")
class CouchbaseServiceRegistryProperties : BaseCouchbaseProperties(), Serializable {
    companion object {
        private const val serialVersionUID = -4975171412161962007L
    }
}
