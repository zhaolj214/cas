package org.apereo.cas.configuration.model.core.metrics

import org.apereo.cas.configuration.model.support.influxdb.InfluxDbProperties
import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties
import org.apereo.cas.configuration.model.support.redis.BaseRedisProperties
import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [MetricsProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class MetricsProperties : Serializable {

    /**
     * String representation of refresh interval for metrics collection.
     */
    private var refreshInterval = "PT30S"

    /**
     * Log destination name of the logging system in use for metrics output.
     */
    var loggerName = "perfStatsLogger"

    /**
     * Export metrics to a redis database.
     */
    var redis = Redis()

    /**
     * Export metrics to a statsd database.
     */
    var statsd = Statsd()
    /**
     * Export metrics to an mongodb database.
     */
    var mongo = MongoDb()
    /**
     * Export metrics to an influxdb database.
     */
    var influxDb = InfluxDb()

    /**
     * Export metrics to an open tsdb database.
     */
    var openTsdb = OpenTsdb()

    fun getRefreshInterval(): Long {
        return Beans.newDuration(this.refreshInterval).seconds
    }

    fun setRefreshInterval(refreshInterval: String) {
        this.refreshInterval = refreshInterval
    }

    @RequiresModule(name = "cas-server-support-metrics")
    class MongoDb : SingleCollectionMongoDbProperties() {
        companion object {
            private val serialVersionUID = 8131713495513399930L
        }
    }

    @RequiresModule(name = "cas-server-support-metrics")
    class InfluxDb : InfluxDbProperties() {
        companion object {
            private val serialVersionUID = 1231713495513399930L
        }
    }

    @RequiresModule(name = "cas-server-support-metrics")
    class Statsd : Serializable {

        /**
         * Statsd host.
         */
        @RequiredProperty
        var host: String? = null

        /**
         * Statd port.
         */
        @RequiredProperty
        var port = 8125

        /**
         * Define a prefix for statd metrics.
         */
        var prefix = "cas"

        companion object {
            private const val serialVersionUID = 6541713495513399930L
        }
    }

    @RequiresModule(name = "cas-server-support-metrics")
    class OpenTsdb : Serializable {

        /**
         * Connection timeout.
         */
        var connectTimeout = 10000

        /**
         * Reading input timeout.
         */
        var readTimeout = 30000

        /**
         * Url of the Open TSDB server.
         * Typically, this is `http://localhost:4242/api/put`.
         */
        @RequiredProperty
        var url: String? = null

        companion object {
            private const val serialVersionUID = 7419713490013390030L
        }
    }

    @RequiresModule(name = "cas-server-support-metrics")
    class Redis : BaseRedisProperties() {

        /**
         * It is best to use a prefix that is unique to the application instance (e.g. using a random value and maybe the
         * logical name of the application to make it possible to correlate with other instances of the same application)
         */
        @RequiredProperty
        var prefix: String? = null

        /**
         * The key is used to keep a global index of all metric names, so it should be unique globally,
         * whatever that means for your system
         * (e.g. two instances of the same system could share a Redis cache if they have distinct keys).
         */
        @RequiredProperty
        var key: String? = null

        companion object {
            private val serialVersionUID = 6419713490013390030L
        }
    }

    companion object {
        private const val serialVersionUID = 345002357523418414L
    }
}
