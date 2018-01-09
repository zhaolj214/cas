package org.apereo.cas.configuration.model.support.sms

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [TextMagicProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-sms-textmagic")
class TextMagicProperties : Serializable {
    /**
     * Secure token used to establish a handshake.
     */
    @RequiredProperty
    var token: String? = null
    /**
     * Username authorized to use the service as the bind account.
     */
    @RequiredProperty
    var username: String? = null

    companion object {

        private const val serialVersionUID = 5645993472155203013L
    }
}
