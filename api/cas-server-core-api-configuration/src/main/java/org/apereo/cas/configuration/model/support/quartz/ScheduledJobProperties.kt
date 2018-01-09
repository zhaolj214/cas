package org.apereo.cas.configuration.model.support.quartz

import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [ScheduledJobProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-core-util", automated = true)
class ScheduledJobProperties : Serializable {

    /**
     * Scheduler settings to indicate how often the job should run.
     */
    @NestedConfigurationProperty
    var schedule = SchedulingProperties()

    constructor() {}

    constructor(startDelay: String, repeatInterval: String) {
        schedule.isEnabled = true
        schedule.setStartDelay(startDelay)
        schedule.setRepeatInterval(repeatInterval)
    }

    companion object {
        private const val serialVersionUID = 9059671958275130605L
    }
}
