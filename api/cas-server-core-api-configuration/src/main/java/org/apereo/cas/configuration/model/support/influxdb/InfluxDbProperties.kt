package org.apereo.cas.configuration.model.support.influxdb

import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [InfluxDbProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
open class InfluxDbProperties : Serializable {

    /**
     * InfluxDb connection url.
     */
    @RequiredProperty
    var url = "http://localhost:8086"

    /**
     * InfluxDb connection username.
     */
    @RequiredProperty
    var username = "root"

    /**
     * InfluxDb connection password.
     */
    @RequiredProperty
    var password = "root"

    /**
     * Database name.
     */
    @RequiredProperty
    var database: String? = null

    /**
     * Database retention policy to use.
     */
    var retentionPolicy = "autogen"

    /**
     * Whether the indicated database should be dropped
     * and recreated.
     */
    var isDropDatabase: Boolean = false

    /**
     * The number of point to flush and write to the database
     * as part of the batch.
     */
    var pointsToFlush = 100

    /**
     * The interval used to run batch jobs
     * to flush points.
     */
    private var batchInterval = "PT5S"

    /**
     * Database consistency level.
     * Acceptable values are `ALL, ANY, ONE, QUORUM`.
     *
     *  * ALL - Write succeeds only if write reached all cluster members.
     *  * ANY - Write succeeds if write reached any cluster members.
     *  * ONE - Write succeeds if write reached at least one cluster members.
     *  * QUORUM - Write succeeds only if write reached a quorum of cluster members.
     *
     */
    var consistencyLevel = "ALL"

    fun getBatchInterval(): Int {
        return Beans.newDuration(this.batchInterval).toMillis().toInt()
    }

    fun setBatchInterval(batchInterval: String) {
        this.batchInterval = batchInterval
    }

    companion object {
        private const val serialVersionUID = -1945287308473842616L
    }
}
