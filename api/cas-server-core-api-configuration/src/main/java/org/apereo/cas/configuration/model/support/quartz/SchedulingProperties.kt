package org.apereo.cas.configuration.model.support.quartz

import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [SchedulingProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-core-util", automated = true)
class SchedulingProperties : Serializable {
    /**
     * Whether scheduler is should schedule the job to run.
     */
    var isEnabled = true

    /**
     * String representation of a start delay of loading data for a data store implementation.
     * This is the delay between scheduler startup and first job’s execution
     */
    private var startDelay = "PT15S"

    /**
     * String representation of a repeat interval of re-loading data for an data store implementation.
     * This is the timeout between consecutive job’s executions.
     */
    private var repeatInterval = "PT2M"

    fun getStartDelay(): Long {
        return Beans.newDuration(startDelay).toMillis()
    }

    fun setStartDelay(startDelay: String) {
        this.startDelay = startDelay
    }

    fun getRepeatInterval(): Long {
        return Beans.newDuration(repeatInterval).toMillis()
    }

    fun setRepeatInterval(repeatInterval: String) {
        this.repeatInterval = repeatInterval
    }

    companion object {

        private const val serialVersionUID = -1522227059439367394L
    }
}
