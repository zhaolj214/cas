package org.apereo.cas.configuration.model.support.radius

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [RadiusClientProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-radius")
class RadiusClientProperties : Serializable {
    /**
     * Server address to connect and establish a session.
     */
    @RequiredProperty
    var inetAddress = "localhost"
    /**
     * Secret/password to use for the initial bind.
     */
    @RequiredProperty
    var sharedSecret = "N0Sh@ar3d\$ecReT"
    /**
     * Socket connection timeout in milliseconds.
     */
    var socketTimeout: Int = 0
    /**
     * The authentication port.
     */
    var authenticationPort = 1812
    /**
     * The accounting port.
     */
    var accountingPort = 1813

    companion object {
        private const val serialVersionUID = -7961769318651312854L
    }

}
