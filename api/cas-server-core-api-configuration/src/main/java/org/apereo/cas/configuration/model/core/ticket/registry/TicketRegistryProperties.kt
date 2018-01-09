package org.apereo.cas.configuration.model.core.ticket.registry

import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties
import org.apereo.cas.configuration.model.support.couchbase.ticketregistry.CouchbaseTicketRegistryProperties
import org.apereo.cas.configuration.model.support.dynamodb.DynamoDbTicketRegistryProperties
import org.apereo.cas.configuration.model.support.ehcache.EhcacheProperties
import org.apereo.cas.configuration.model.support.hazelcast.HazelcastTicketRegistryProperties
import org.apereo.cas.configuration.model.support.ignite.IgniteProperties
import org.apereo.cas.configuration.model.support.infinispan.InfinispanProperties
import org.apereo.cas.configuration.model.support.jms.JmsTicketRegistryProperties
import org.apereo.cas.configuration.model.support.jpa.ticketregistry.JpaTicketRegistryProperties
import org.apereo.cas.configuration.model.support.memcached.MemcachedTicketRegistryProperties
import org.apereo.cas.configuration.model.support.mongo.ticketregistry.MongoTicketRegistryProperties
import org.apereo.cas.configuration.model.support.quartz.ScheduledJobProperties
import org.apereo.cas.configuration.model.support.redis.RedisTicketRegistryProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [TicketRegistryProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-tickets", automated = true)
class TicketRegistryProperties : Serializable {

    /**
     * JMS registry settings.
     */
    @NestedConfigurationProperty
    var jms = JmsTicketRegistryProperties()

    /**
     * DynamoDb registry settings.
     */
    @NestedConfigurationProperty
    var dynamoDb = DynamoDbTicketRegistryProperties()

    /**
     * Infinispan registry settings.
     */
    @NestedConfigurationProperty
    var infinispan = InfinispanProperties()

    /**
     * Couchbase registry settings.
     */
    @NestedConfigurationProperty
    var couchbase = CouchbaseTicketRegistryProperties()

    /**
     * MongoDb registry settings.
     */
    @NestedConfigurationProperty
    var mongo = MongoTicketRegistryProperties()

    /**
     * Ehcache registry settings.
     */
    @NestedConfigurationProperty
    var ehcache = EhcacheProperties()

    /**
     * Hazelcast registry settings.
     */
    @NestedConfigurationProperty
    var hazelcast = HazelcastTicketRegistryProperties()

    /**
     * Apache Ignite registry settings.
     */
    @NestedConfigurationProperty
    var ignite = IgniteProperties()

    /**
     * JPA registry settings.
     */
    @NestedConfigurationProperty
    var jpa = JpaTicketRegistryProperties()

    /**
     * Memcached registry settings.
     */
    @NestedConfigurationProperty
    var memcached = MemcachedTicketRegistryProperties()

    /**
     * Redis registry settings.
     */
    @NestedConfigurationProperty
    var redis = RedisTicketRegistryProperties()

    /**
     * Settings relevant for the default in-memory ticket registry.
     */
    var inMemory = InMemory()

    /**
     * Ticket registry cleaner settings.
     */
    @NestedConfigurationProperty
    var cleaner = ScheduledJobProperties("PT10S", "PT1M")

    @RequiresModule(name = "cas-server-core-tickets", automated = true)
    class InMemory : Serializable {

        /**
         * Allow the ticket registry to cache ticket items for period of time
         * and auto-evict and clean up, removing the need to running a ticket
         * registry cleaner in the background.
         */
        var isCache: Boolean = false

        /**
         * The initial capacity of the underlying memory store.
         * The implementation performs internal sizing to accommodate this many elements.
         */
        var initialCapacity = 1000

        /**
         * The load factor threshold, used to control resizing.
         * Resizing may be performed when the average number of elements per bin exceeds this threshold.
         */
        var loadFactor = 1

        /**
         * The estimated number of concurrently updating threads.
         * The implementation performs internal sizing to try to accommodate this many threads.
         */
        var concurrency = 20

        /**
         * Crypto settings for the registry.
         */
        @NestedConfigurationProperty
        var crypto = EncryptionRandomizedSigningJwtCryptographyProperties()

        init {
            crypto.isEnabled = false
        }

        companion object {

            private const val serialVersionUID = -2600525447128979994L
        }
    }

    companion object {

        private const val serialVersionUID = -4735458476452635679L
    }
}
