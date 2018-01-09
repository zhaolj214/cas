package org.apereo.cas.configuration.model.support.cosmosdb

import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [BaseCosmosDbProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-cosmosdb-core")
abstract class BaseCosmosDbProperties : Serializable {

    /**
     * Database throughput usually between 400 or 100,000.
     */
    var throughput = 10000

    /**
     * Document Db host address (i.e. https://localhost:8081).
     */
    @RequiredProperty
    var uri: String? = null

    /**
     * Document Db master key.
     */
    @RequiredProperty
    var key: String? = null

    /**
     * Document Db consistency level.
     * Azure Cosmos DB is designed from the ground up with global distribution in mind for every data model. It is designed to offer predictable
     * low latency guarantees, a 99.99% availability SLA, and multiple well-defined relaxed consistency models. Currently,
     * Azure Cosmos DB provides five consistency levels: strong, bounded-staleness, session, consistent prefix, and eventual.
     * Besides strong and eventual consistency models commonly offered by distributed databases, Azure Cosmos DB offers three more carefully
     * codified and operationalized consistency models, and has validated their usefulness against real world use cases. These are the
     * bounded staleness, session, and consistent prefix consistency levels. Collectively these
     * five consistency levels enable you to make well-reasoned trade-offs between consistency, availability, and latency.
     * Accepted values are:
     *
     *  * `Strong`: Linearizability
     *  * `Session`: Consistent Prefix. Monotonic reads, monotonic writes, read-your-writes, write-follows-reads
     *  * `Eventual`: Out of order reads
     *  * `BoundedStaleness`: Consistent Prefix. Reads lag behind writes by k prefixes or t interval
     *  * `ConsistentPrefix`: Updates returned are some prefix of all the updates, with no gaps
     *
     */
    var consistencyLevel = "Session"

    /**
     * Database name.
     */
    @RequiredProperty
    var database: String? = null

    /**
     * Whether telemetry should be enabled by default.
     */
    var isAllowTelemetry = true

    /**
     * Whether collections should be dropped on startup and re-created.
     */
    var isDropCollection: Boolean = false

    companion object {
        private const val serialVersionUID = 2528153816791719898L
    }
}
