package org.apereo.cas.configuration.model.support.ehcache

import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties
import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource

import java.io.Serializable

/**
 * This is [EhcacheProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-ehcache-ticket-registry")
class EhcacheProperties : Serializable {

    /**
     * Sets the persistence write mode.
     */
    var isSynchronousWrites: Boolean = false

    /**
     * Whether to load the cache bootstrapper asynchronously.
     */
    var isLoaderAsync = true

    /**
     * The maximum serialized size of the elements to request
     * from a remote cache peer during bootstrap.
     */
    var maxChunkSize = 5000000

    /**
     * Maximum batch size for replication ops.
     */
    var maximumBatchSize = 100

    /**
     * The replication interval in milliseconds for the cache replicator.
     */
    private var replicationInterval = "PT10S"

    /**
     * Whether to replicate puts.
     */
    var isReplicatePuts = true

    /**
     * Whether an update (a put) should be by copy or by invalidation, (a remove).
     * By copy is best when the entry is expensive to produce. By invalidation is best when we are
     * really trying to force other caches to sync back to a canonical source like a database.
     * An example of a latter usage would be a read/write cache being used in Hibernate.
     * This setting only has effect if #replicateUpdates is true.
     */
    var isReplicateUpdatesViaCopy = true

    /**
     * Whether to replicate removes.
     */
    var isReplicateRemovals = true

    /**
     * Whether to replicate updates.
     */
    var isReplicateUpdates = true

    /**
     * Whether a put should replicated by copy or by invalidation, (a remove).
     * By copy is best when the entry is expensive to produce. By invalidation is best when we are really
     * trying to force other caches to sync back to a canonical source like a database.
     * An example of a latter usage would be a read/write cache being used in Hibernate.
     * This setting only has effect if #replicateUpdates is true.
     */
    var isReplicatePutsViaCopy = true

    /**
     * Set the location of the EhCache config file. A typical value is "/WEB-INF/ehcache.xml".
     * Default is "ehcache.xml" in the root of the class path,
     * or if not found, "ehcache-failsafe.xml" in the EhCache jar (default EhCache initialization).
     */
    @RequiredProperty
    var configLocation: Resource = ClassPathResource("ehcache-replicated.xml")

    /**
     * Set whether the EhCache CacheManager should be shared (as a singleton at the ClassLoader level)
     * or independent (typically local within the application). Default is "false", creating an independent local instance.
     * NOTE: This feature allows for sharing this EhCacheManagerFactoryBean's CacheManager with any
     * code calling CacheManager.create() in the same ClassLoader space, with no need to agree on a specific
     * CacheManager name. However, it only supports a single
     * EhCacheManagerFactoryBean involved which will control the lifecycle of
     * the underlying CacheManager (in particular, its shutdown).
     */
    var isShared: Boolean = false

    /**
     * The name of the cache manager instance.
     */
    @RequiredProperty
    var cacheManagerName = "ticketRegistryCacheManager"
    /**
     * The interval in seconds between runs of the disk expiry thread.
     */
    var diskExpiryThreadIntervalSeconds: Int = 0
    /**
     * Sets whether elements are eternal.
     * If eternal, timeouts are ignored and the element is never expired. False by default.
     */
    var isEternal: Boolean = false

    /**
     * Builder that sets the maximum objects to be held in memory (0 = no limit).
     */
    var maxElementsInMemory = 10000

    /**
     * Builder which sets the maximum number entries in cache.
     */
    var maxElementsInCache: Int = 0

    /**
     * Builder which sets the maximum number elements on Disk. 0 means unlimited.
     */
    var maxElementsOnDisk: Int = 0

    /**
     * Builder which Sets the eviction policy. An invalid argument will set it to null.
     *
     *  * LRU - least recently used
     *  * LFU - least frequently used
     *  * FIFO - first in first out, the oldest element by creation time
     *
     */
    var memoryStoreEvictionPolicy = "LRU"

    /**
     * Sets the persistence strategy.
     * Acceptable values are:
     *
     *  * LOCALTEMPSWAP: Standard open source (non fault-tolerant) on-disk persistence.
     *  * DISTRIBUTED: Terracotta clustered persistence (requires a Terracotta clustered cache)
     *  * LOCALRESTARTABL: Enterprise fault tolerant persistence
     *  * NONE: No persistence
     *
     */
    var persistence = "NONE"

    /**
     * Crypto settings for the registry.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionRandomizedSigningJwtCryptographyProperties()

    init {
        this.crypto.isEnabled = false
    }

    fun getReplicationInterval(): Long {
        return Beans.newDuration(replicationInterval).toMillis()
    }

    fun setReplicationInterval(replicationInterval: String) {
        this.replicationInterval = replicationInterval
    }

    companion object {
        private const val serialVersionUID = 7772510035918976450L
    }
}


