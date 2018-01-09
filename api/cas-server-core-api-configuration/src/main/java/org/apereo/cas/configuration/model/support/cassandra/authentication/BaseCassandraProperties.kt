package org.apereo.cas.configuration.model.support.cassandra.authentication

import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [BaseCassandraProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
abstract class BaseCassandraProperties : Serializable {
    /**
     * Username to bind and establish a connection to cassandra.
     */
    @RequiredProperty
    var username: String? = null
    /**
     * Password to bind and establish a connection to cassandra.
     */
    @RequiredProperty
    var password: String? = null

    /**
     * Cassandra protocol version.
     */
    var protocolVersion = "V3"
    /**
     * Keyspace address to use where the cluster would connect.
     */
    @RequiredProperty
    var keyspace: String? = null
    /**
     * The list of contact points to use for the new cluster.
     */
    @RequiredProperty
    var contactPoints = "localhost"
    /**
     * Used by a DC-ware round-robin load balancing policy.
     * This policy provides round-robin queries over the node of the local data center. It also includes in the query plans returned a
     * configurable number of hosts in the remote data centers, but those are always tried after the local nodes.
     * In other words, this policy guarantees that no host in a remote data center will be queried unless no host in the local data center can be reached.
     */
    var localDc: String? = null
    /**
     * The DC policy is wrapped inside a token-aware policy that may be set to shuffle replicas.
     * This indicates whether to shuffle the replicas returned by getRoutingKey. Note that setting this parameter to true might decrease the effectiveness of
     * caching (especially at consistency level ONE), since the same row will be retrieved from any
     * replica (instead of only the "primary" replica without shuffling).
     * On the other hand, shuffling will better distribute writes, and can alleviate hotspots caused by "fat" partitions.
     */
    var isShuffleReplicas = true
    /**
     * A policy that defines a default behavior to adopt when a request fails.
     * Such policy allows to centralize the handling of query retries, allowing to minimize the need for exception catching/handling in business code.
     * Accepted options are `DEFAULT_RETRY_POLICY, DOWNGRADING_CONSISTENCY_RETRY_POLICY, FALLTHROUGH_RETRY_POLICY`.
     *
     *
     * The default policy retries queries in only two cases:
     *
     *  * On a read timeout, if enough replicas replied but data was not retrieved.
     *  * On a write timeout, if we timeout while writing the distributed log used by batch statements.
     * This retry policy is conservative in that it will never retry with a different consistency level than the one of the initial operation.
     *
     *
     */
    var retryPolicy = "DEFAULT_RETRY_POLICY"
    /**
     * Protocol compression options.
     * Accepted options are `NONE, SNAPPY, LZ4`.
     */
    var compression = "LZ4"
    /**
     * Query option consistency level.
     * The consistency level set through this method will be use for queries that don't explicitly have a consistency level.
     * Accepted values are:`ALL, ANY, EACH_QUORUM, LOCAL_ONE, LOCAL_QUORUM, LOCAL_SERIAL, ONE, QUORUM, SERIAL, THREE, TWO`.
     */
    var consistencyLevel = "LOCAL_QUORUM"
    /**
     * Query option serial consistency level.
     * The serial consistency level set through this method will be use for queries that don't explicitly have a serial consistency level.
     * Accepted values are:`ALL, ANY, EACH_QUORUM, LOCAL_ONE, LOCAL_QUORUM, LOCAL_SERIAL, ONE, QUORUM, SERIAL, THREE, TWO`.
     */
    var serialConsistencyLevel = "LOCAL_SERIAL"

    /**
     * Sets the maximum number of connections.
     */
    var maxConnections = 10
    /**
     * Sets the core number of connections per host.
     */
    var coreConnections = 1
    /**
     * Sets the maximum number of connection requests per host.
     */
    var maxRequestsPerConnection = 1024
    /**
     * The connection timeout in milliseconds.
     * As the name implies, the connection timeout defines how long the driver waits to establish a new connection to a Cassandra node before giving up.
     */
    var connectTimeoutMillis = 5000
    /**
     * The per-host read timeout in milliseconds.
     * This defines how long the driver will wait for a given Cassandra node to answer a query.
     */
    var readTimeoutMillis = 5000

    /**
     * Cassandra instance port.
     */
    @RequiredProperty
    var port = 9042

    companion object {
        private const val serialVersionUID = 3708645268337674572L
    }
}
