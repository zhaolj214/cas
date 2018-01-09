package org.apereo.cas.configuration.model.core.services

import org.apereo.cas.configuration.model.support.cosmosdb.CosmosDbServiceRegistryProperties
import org.apereo.cas.configuration.model.support.couchbase.serviceregistry.CouchbaseServiceRegistryProperties
import org.apereo.cas.configuration.model.support.dynamodb.DynamoDbServiceRegistryProperties
import org.apereo.cas.configuration.model.support.email.EmailProperties
import org.apereo.cas.configuration.model.support.jpa.serviceregistry.JpaServiceRegistryProperties
import org.apereo.cas.configuration.model.support.ldap.serviceregistry.LdapServiceRegistryProperties
import org.apereo.cas.configuration.model.support.mongo.serviceregistry.MongoDbServiceRegistryProperties
import org.apereo.cas.configuration.model.support.quartz.SchedulingProperties
import org.apereo.cas.configuration.model.support.redis.RedisServiceRegistryProperties
import org.apereo.cas.configuration.model.support.services.json.JsonServiceRegistryProperties
import org.apereo.cas.configuration.model.support.services.stream.StreamingServiceRegistryProperties
import org.apereo.cas.configuration.model.support.services.yaml.YamlServiceRegistryProperties
import org.apereo.cas.configuration.model.support.sms.SmsProperties
import org.apereo.cas.configuration.support.BaseRestEndpointProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * Configuration properties class for service.registry.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-services", automated = true)
class ServiceRegistryProperties : Serializable {
    /**
     * Properties pertaining to Cosmos DB service registry.
     */
    @NestedConfigurationProperty
    var cosmosDb = CosmosDbServiceRegistryProperties()

    /**
     * Properties pertaining to REST service registry.
     */
    @NestedConfigurationProperty
    var rest = BaseRestEndpointProperties()

    /**
     * Properties pertaining to redis service registry.
     */
    @NestedConfigurationProperty
    var redis = RedisServiceRegistryProperties()

    /**
     * Properties pertaining to JSON service registry.
     */
    @NestedConfigurationProperty
    var json = JsonServiceRegistryProperties()

    /**
     * Properties pertaining to YAML service registry.
     */
    @NestedConfigurationProperty
    var yaml = YamlServiceRegistryProperties()

    /**
     * Properties pertaining to jpa service registry.
     */
    @NestedConfigurationProperty
    var jpa = JpaServiceRegistryProperties()

    /**
     * Properties pertaining to ldap service registry.
     */
    @NestedConfigurationProperty
    var ldap = LdapServiceRegistryProperties()

    /**
     * Properties pertaining to mongo db service registry.
     */
    @NestedConfigurationProperty
    var mongo = MongoDbServiceRegistryProperties()

    /**
     * Properties pertaining to couchbase service registry.
     */
    @NestedConfigurationProperty
    var couchbase = CouchbaseServiceRegistryProperties()

    /**
     * Properties pertaining to dynamo db service registry.
     */
    @NestedConfigurationProperty
    var dynamoDb = DynamoDbServiceRegistryProperties()

    /**
     * Properties pertaining to streaming service registry content over the wire.
     */
    @NestedConfigurationProperty
    var stream = StreamingServiceRegistryProperties()

    /**
     * Scheduler settings to indicate how often is metadata reloaded.
     */
    @NestedConfigurationProperty
    var schedule = SchedulingProperties()

    /**
     * Email settings for notifications.
     */
    @NestedConfigurationProperty
    var mail = EmailProperties()

    /**
     * SMS settings for notifications.
     */
    @NestedConfigurationProperty
    var sms = SmsProperties()

    /**
     * Flag that indicates whether to initialise active service registry implementation with a default set of service definition included
     * with CAS in JSON format.
     */
    var isInitFromJson: Boolean = false

    /**
     * Flag indicating whether a background watcher thread is enabled for the purposes of live reloading of service registry data changes
     * from persistent data store.
     */
    var isWatcherEnabled = true

    /**
     * Determine how services are internally managed, queried, cached and reloaded by CAS.
     * Accepted values are the following:
     *
     *
     *  * DEFAULT: Keep all services inside a concurrent map.
     *  * DOMAIN: Group registered services by their domain having been explicitly defined.
     *
     */
    var managementType = ServiceManagementTypes.DEFAULT

    /**
     * Types of service managers that one can control.
     */
    enum class ServiceManagementTypes {
        /**
         * Group service definitions by their domain.
         */
        DOMAIN,
        /**
         * Default option to keep definitions in a map as they arrive.
         */
        DEFAULT
    }

    companion object {

        private const val serialVersionUID = -368826011744304210L
    }
}
