package org.apereo.cas.configuration.model.support.ignite

import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties
import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty
import java.io.Serializable
import java.time.Duration

/**
 * This is [IgniteProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-ignite-ticket-registry")
class IgniteProperties : Serializable {
    /**
     * Used by `TcpDiscoveryVmIpFinder` which is an
     * IP Finder which works only with pre-configured list of IP addresses specified via this setting.
     * By default, this IP finder is not shared, which means that all grid nodes have
     * to be configured with the same list of IP addresses when this IP finder is used.
     * Parses provided values and initializes the internal collection of addresses.
     * Addresses may be represented as follows:
     *
     *  * IP address (e.g. 127.0.0.1, 9.9.9.9, etc);
     *  * IP address and port (e.g. 127.0.0.1:47500, 9.9.9.9:47501, etc);
     *  * IP address and port range (e.g. 127.0.0.1:47500..47510, 9.9.9.9:47501..47504, etc);
     *  * Hostname (e.g. host1.com, host2, etc);
     *  * Hostname and port (e.g. host1.com:47500, host2:47502, etc).
     *  * Hostname and port range (e.g. host1.com:47500..47510, host2:47502..47508, etc).
     *
     * If port is 0 or not provided then default port will be used (depends on discovery SPI configuration).
     * If port range is provided (e.g. host:port1..port2) the following should be considered:
     *
     *  * port1 &lt; port2 should be true;
     *  * Both port1 and port2 should be greater than 0.
     *
     */
    @RequiredProperty
    var igniteAddress = mutableListOf("localhost:47500")

    /**
     * Settings related to tickets cache.
     */
    var ticketsCache = TicketsCache()

    /**
     * Keystore type used to create a SSL context for the ticket registry.
     */
    var keyStoreType = "JKS"

    /**
     * Keystore file path used to create a SSL context for the ticket registry.
     */
    var keyStoreFilePath: String? = null

    /**
     * Keystore password used to create a SSL context for the ticket registry.
     */
    var keyStorePassword: String? = null

    /**
     * Truststore type used to create a SSL context for the ticket registry.
     */
    var trustStoreType = "JKS"

    /**
     * SSL protocol used to create a SSL context for the ticket registry.
     */
    var protocol = "TLS"

    /**
     * The key algorithm to use when creating SSL context.
     */
    var keyAlgorithm = "SunX509"

    /**
     * Truststore file path used to create a SSL context for the ticket registry.
     */
    var trustStoreFilePath: String? = null

    /**
     * Truststore password used to create a SSL context for the ticket registry.
     */
    var trustStorePassword: String? = null

    /**
     * Sets timeout for receiving acknowledgement for sent message.
     * If acknowledgement is not received within this timeout, sending is considered as failed and SPI tries to repeat message sending.
     */
    private var ackTimeout = "PT2S"

    /**
     * Sets join timeout.
     * If non-shared IP finder is used and node fails to connect to any address from IP finder,
     * node keeps trying to join within this timeout. If all addresses are still unresponsive, exception is thrown and node startup fails.
     */
    private var joinTimeout = "PT1S"

    /**
     * Sets local host IP address that discovery SPI uses.
     * If not provided, by default a first found non-loopback address will be used. If there is
     * no non-loopback address available, then `InetAddress.getLocalHost()` will be used.
     */
    var localAddress: String? = null

    /**
     * Sets local port to listen to.
     */
    @RequiredProperty
    var localPort = -1

    /**
     * Sets maximum network timeout to use for network operations.
     */
    private var networkTimeout = "PT5S"

    /**
     * Sets socket operations timeout. This timeout is used to limit connection time and write-to-socket time.
     * Note that when running Ignite on Amazon EC2, socket timeout must be set to a value significantly greater than the default (e.g. to 30000).
     */
    private var socketTimeout = "PT5S"

    /**
     * Sets thread priority. All threads within SPI will be started with it.
     */
    var threadPriority = 10

    /**
     * Start in client mode.
     * If true the local node is started as a client.
     */
    var isClientMode: Boolean = false

    /**
     * Sets force server mode flag.
     * If true `TcpDiscoverySpi` is started in server mode regardless of `IgniteConfiguration.isClientMode()`.
     */
    var isForceServerMode: Boolean = false

    /**
     * Crypto settings for the registry.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionRandomizedSigningJwtCryptographyProperties()

    init {
        this.crypto.isEnabled = false
    }

    fun getAckTimeout(): Long {
        return Duration.parse(ackTimeout).toMillis()
    }

    fun setAckTimeout(ackTimeout: String) {
        this.ackTimeout = ackTimeout
    }

    fun getJoinTimeout(): Long {
        return Beans.newDuration(joinTimeout).toMillis()
    }

    fun setJoinTimeout(joinTimeout: String) {
        this.joinTimeout = joinTimeout
    }

    fun getNetworkTimeout(): Long {
        return Beans.newDuration(networkTimeout).toMillis()
    }

    fun setNetworkTimeout(networkTimeout: String) {
        this.networkTimeout = networkTimeout
    }

    fun getSocketTimeout(): Long {
        return Beans.newDuration(socketTimeout).toMillis()
    }

    fun setSocketTimeout(socketTimeout: String) {
        this.socketTimeout = socketTimeout
    }

    class TicketsCache : Serializable {
        /**
         * Specified the caching mode.
         *
         *  * `LOCAL`: Specifies local-only cache behaviour. In this mode caches residing on different grid nodes will not know about each other.
         * Other than distribution, local caches still have all the caching features, such as eviction, expiration, swapping, querying, etc...
         * This mode is very useful when caching read-only data or data that automatically expires at a certain interval and
         * then automatically reloaded from persistence store.
         *  *
         * `REPLICATED`: Specifies fully replicated cache behavior. In this mode all the keys are distributed to all participating nodes.
         * User still has affinity control over subset of nodes for any given key via AffinityFunction configuration.
         *
         *  *
         * `PARTITIONED`: Specifies partitioned cache behaviour. In this mode the overall key set will be divided into
         * partitions and all partitions will be split equally between participating nodes. User has affinity control over key
         * assignment via AffinityFunction configuration.
         * Note that partitioned cache is always fronted by local 'near' cache which stores most recent data. You can configure the
         * size of near cache via NearCacheConfiguration.getNearEvictionPolicy() configuration property.
         *
         *
         */
        var cacheMode = "REPLICATED"
        /**
         * Specifies the atomicity mode.
         *
         *  * `ATOMIC`: Specifies atomic-only cache behaviour. In this mode distributed transactions and distributed locking
         * are not supported. Disabling transactions and locking allows to achieve much higher performance and throughput ratios.
         * In addition to transactions and locking, one of the main differences in ATOMIC mode is that bulk writes, such as putAll(...),
         * removeAll(...), and transformAll(...) methods, become simple batch operations which can partially fail. In case of
         * partial failure CachePartialUpdateCheckedException will be thrown which will contain a list of keys for which the update
         * failed. It is recommended that bulk writes are used whenever multiple keys need to be inserted or updated in cache,
         * as they reduce number of network trips and provide better performance.
         * Note that even without locking and transactions, ATOMIC mode still provides full consistency guarantees across all cache nodes.
         * Also note that all data modifications in ATOMIC mode are guaranteed to be atomic and consistent with writes
         * to the underlying persistent store, if one is configured.
         *  * `TRANSACTIONAL`: Specifies fully ACID-compliant transactional cache behavior.
         *
         */
        var atomicityMode = "TRANSACTIONAL"
        /**
         * Mode indicating how Ignite should wait for write replies from other nodes.
         * Default value is FULL_ASYNC}, which means that Ignite will not wait for responses from participating nodes. This means that by default remote
         * nodes may get their state updated slightly after any of the cache write methods complete, or after Transaction.commit() method completes.
         *
         *  *
         * `FULL_ASYNC`: Flag indicating that Ignite will not wait for write or commit responses from participating nodes, which means that
         * remote nodes may get their state updated a bit after any of the cache write methods complete,
         * or after `Transaction.commit()` method completes.
         *
         *  *
         * `FULL_SYNC`: Flag indicating that Ignite should wait for write or commit replies from all nodes. This behavior guarantees
         * that whenever any of the atomic or transactional writes complete, all other participating nodes which
         * cache the written data have been updated.
         *
         *  *
         * `PRIMARY_SYNC`: This flag only makes sense for CacheMode.PARTITIONED mode. When enabled, Ignite will wait for write or
         * commit to complete on primary node, but will not wait for backups to be updated.
         *
         *
         */
        var writeSynchronizationMode = "FULL_SYNC"

        companion object {

            private const val serialVersionUID = 4715167757542984471L
        }
    }

    companion object {

        private const val serialVersionUID = -5259465262649559156L
    }
}
