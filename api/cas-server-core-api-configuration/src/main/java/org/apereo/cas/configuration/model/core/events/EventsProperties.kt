package org.apereo.cas.configuration.model.core.events

import org.apereo.cas.configuration.model.support.influxdb.InfluxDbProperties
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties
import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * Configuration properties class for events.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-events", automated = true)
class EventsProperties : Serializable {
    /**
     * Whether geolocation should be tracked as part of collected authentication events.
     * This of course require's consent from the user's browser to collect stats on location.
     */
    var isTrackGeolocation: Boolean = false

    /**
     * Whether CAS should track the underlying configuration store for changes.
     * This depends on whether the store provides that sort of functionality.
     * When running in standalone mode, this typically translates to CAS monitoring
     * configuration files and reloading context conditionally if there are any changes.
     */
    var isTrackConfigurationModifications = true

    /**
     * Track authentication events inside a database.
     */
    var jpa = Jpa()
    /**
     * Track authentication events inside an influxdb database.
     */
    var influxDb = InfluxDb()
    /**
     * Track authentication events inside a mongodb instance.
     */
    var mongo = MongoDb()

    @RequiresModule(name = "cas-server-support-events-jpa")
    class Jpa : AbstractJpaProperties() {
        companion object {
            private val serialVersionUID = 7647381223153797806L
        }
    }

    @RequiresModule(name = "cas-server-support-events-mongo")
    class MongoDb : SingleCollectionMongoDbProperties() {
        init {
            collection = "MongoDbCasEventRepository"
        }

        companion object {
            private val serialVersionUID = -1918436901491275547L
        }
    }

    @RequiresModule(name = "cas-server-support-events-influxdb")
    class InfluxDb : InfluxDbProperties() {
        init {
            database = "CasInfluxDbEvents"
        }

        companion object {
            private val serialVersionUID = -3918436901491275547L
        }
    }

    companion object {

        private const val serialVersionUID = 1734523424737956370L
    }
}
