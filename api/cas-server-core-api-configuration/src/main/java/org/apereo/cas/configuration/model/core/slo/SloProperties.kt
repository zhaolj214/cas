package org.apereo.cas.configuration.model.core.slo

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [SloProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class SloProperties : Serializable {
    /**
     * Whether SLO callbacks should be done in an asynchronous manner via the HTTP client.
     * When true, CAS will not wait for the operation to fully complete and will resume control to carry on.
     */
    var isAsynchronous = true

    /**
     * Whether SLO should be entirely disabled globally for the CAS deployment.
     */
    var isDisabled: Boolean = false

    companion object {

        private const val serialVersionUID = 3676710533477055700L
    }
}
