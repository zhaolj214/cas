package org.apereo.cas.configuration.model.support.services.stream.hazelcast

import org.apereo.cas.configuration.model.support.hazelcast.BaseHazelcastProperties
import org.apereo.cas.configuration.model.support.services.stream.BaseStreamServicesProperties
import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [StreamServicesHazelcastProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-service-registry-stream-hazelcast")
class StreamServicesHazelcastProperties : BaseStreamServicesProperties(), Serializable {

    /**
     * Duration that indicates how long should items be kept in the hazelcast cache.
     * Note that generally this number needs to be short as once an item is delivered
     * to a target, it is explicitly removed from the cache/queue. This duration needs to be
     * adjusted if the latency between the CAS nodes in the cluster is too large. Having too
     * short a value will cause the record to expire before it reaches other members of the cluster.
     */
    private var duration = "PT1M"

    /**
     * Configuration of the hazelcast instance to queue and stream items.
     */
    @NestedConfigurationProperty
    var config = BaseHazelcastProperties()

    init {
        config.cluster.port = PORT
        config.cluster.instanceName = "localhost-services-replication"
    }

    fun getDuration(): Long {
        return Beans.newDuration(this.duration).toMillis()
    }

    fun setDuration(duration: String) {
        this.duration = duration
    }

    companion object {
        private const val serialVersionUID = -1583614089051161614L

        /**
         * Default port.
         */
        private val PORT = 5801
    }
}
