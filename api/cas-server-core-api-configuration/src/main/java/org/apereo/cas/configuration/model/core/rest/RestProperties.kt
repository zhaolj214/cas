package org.apereo.cas.configuration.model.core.rest

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [RestProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-rest", automated = true)
class RestProperties : Serializable {
    /**
     * Authorization attribute name required by the REST endpoint in order to allow for the requested operation.
     * Attribute must be resolvable by the authenticated principal, or must have been already.
     */
    var attributeName: String? = null
    /**
     * Matching authorization attribute value, pulled from the attribute
     * required by the REST endpoint in order to allow for the requested operation.
     * The attribute value may also be constructed as a regex pattern.
     */
    var attributeValue: String? = null

    /**
     * The bean id of the throttler component whose job is to control rest authentication requests
     * an throttle requests per define policy.
     */
    var throttler = "neverThrottle"

    companion object {
        private const val serialVersionUID = -1833107478273171342L
    }
}



