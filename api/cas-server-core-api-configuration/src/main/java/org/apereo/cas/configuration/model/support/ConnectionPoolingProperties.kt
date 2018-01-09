package org.apereo.cas.configuration.model.support

import org.apereo.cas.configuration.support.Beans

import java.io.Serializable

/**
 * This is [ConnectionPoolingProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
class ConnectionPoolingProperties : Serializable {

    /**
     * Controls the maximum size that the pool is allowed to reach, including both idle and in-use connections.
     */
    var minSize = 6

    /**
     * Controls the maximum number of connections to keep in the pool, including both idle and in-use connections.
     */
    var maxSize = 18

    /**
     * Sets the maximum time in seconds that this data source will wait
     * while attempting to connect to a database.
     *
     * A value of zero specifies that the timeout is the default system timeout
     * if there is one; otherwise, it specifies that there is no timeout.
     */
    private var maxWait = "PT2S"

    /**
     * Whether or not pool suspension is allowed.
     *
     * There is a performance impact when pool suspension is enabled.
     * Unless you need it (for a redundancy system for example) do not enable it.
     */
    var isSuspension: Boolean = false

    /**
     * The maximum number of milliseconds that the pool will wait for a connection to be validated as alive.
     */
    var timeoutMillis: Long = 1000

    fun getMaxWait(): Long {
        return Beans.newDuration(maxWait).toMillis()
    }

    fun setMaxWait(maxWait: String) {
        this.maxWait = maxWait
    }

    companion object {
        private const val serialVersionUID = -5307463292890944799L
    }
}
