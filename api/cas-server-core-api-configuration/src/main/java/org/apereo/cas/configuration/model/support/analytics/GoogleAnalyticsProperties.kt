package org.apereo.cas.configuration.model.support.analytics

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [GoogleAnalyticsProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-web", automated = true)
class GoogleAnalyticsProperties : Serializable {
    /**
     * The tracking id. Configuring the tracking
     * activated google analytics in CAS on UI views, etc.
     */
    var googleAnalyticsTrackingId: String? = null

    companion object {

        private const val serialVersionUID = 5425678120443123345L
    }
}
