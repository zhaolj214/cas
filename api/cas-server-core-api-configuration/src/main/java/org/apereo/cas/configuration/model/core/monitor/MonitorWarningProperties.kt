package org.apereo.cas.configuration.model.core.monitor

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [MonitorWarningProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-core-monitor", automated = true)
class MonitorWarningProperties : Serializable {

    /**
     * The monitor threshold where if reached, CAS might generate a warning status for health checks.
     */
    var threshold = 10

    /**
     * The monitor eviction threshold where if reached, CAS might generate a warning status for health checks.
     * The underlying data source and monitor (i.e. cache) must support the concept of evictions.
     */
    var evictionThreshold: Long = 0

    constructor() {}

    constructor(threshold: Int) {
        this.threshold = threshold
    }

    companion object {
        private const val serialVersionUID = 2788617778375787703L
    }
}
