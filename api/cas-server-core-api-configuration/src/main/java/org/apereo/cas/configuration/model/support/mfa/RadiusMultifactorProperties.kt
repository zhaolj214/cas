package org.apereo.cas.configuration.model.support.mfa

import org.apereo.cas.configuration.model.support.radius.RadiusClientProperties
import org.apereo.cas.configuration.model.support.radius.RadiusServerProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * This is [RadiusMultifactorProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-radius-mfa")
class RadiusMultifactorProperties : BaseMultifactorProviderProperties() {

    /**
     * In the event that radius authentication fails due to a catastrophic event,
     * fail over to the next server in the list.
     */
    var isFailoverOnException: Boolean = false
    /**
     * In the event that radius authentication fails,
     * fail over to the next server in the list.
     */
    var isFailoverOnAuthenticationFailure: Boolean = false

    /**
     * RADIUS server settings.
     */
    @NestedConfigurationProperty
    var server = RadiusServerProperties()

    /**
     * RADIUS client settings.
     */
    @NestedConfigurationProperty
    var client = RadiusClientProperties()

    /**
     * Indicates whether this provider should support trusted devices.
     */
    var isTrustedDeviceEnabled: Boolean = false

    init {
        id = DEFAULT_IDENTIFIER
    }

    companion object {
        /**
         * Provider id by default.
         */
        const val DEFAULT_IDENTIFIER = "mfa-radius"

        private val serialVersionUID = 7021301814775348087L
    }
}
