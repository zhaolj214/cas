package org.apereo.cas.configuration.model.support.radius

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [RadiusServerProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-radius")
class RadiusServerProperties : Serializable {
    /**
     * Radius protocol to use when communicating with the server.
     */
    var protocol = "EAP_MSCHAPv2"
    /**
     * Number of re-try attempts when dealing with connection and authentication failures.
     */
    var retries = 3
    /**
     * The NAS identifier.
     */
    var nasIdentifier: String? = null
    /**
     * The NAS port.
     */
    var nasPort: Long = -1
    /**
     * The NAS port id.
     */
    var nasPortId: Long = -1
    /**
     * The NAS real port.
     */
    var nasRealPort: Long = -1
    /**
     * The NAS port type.
     */
    var nasPortType = -1
    /**
     * The NAS IP address.
     */
    var nasIpAddress: String? = null
    /**
     * The NAS IPv6 address.
     */
    var nasIpv6Address: String? = null

    companion object {
        private const val serialVersionUID = -3911282132573730184L
    }
}
