package org.apereo.cas.configuration.model.core.sso

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * Configuration properties class for `create.sso`.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class SsoProperties : Serializable {
    /**
     * Flag that indicates whether to create SSO session on re-newed authentication event.
     */
    var isRenewedAuthn = true

    /**
     * Flag that indicates whether to allow SSO session with a missing target service.
     */
    var isMissingService = true

    companion object {

        private const val serialVersionUID = -8777647966370741733L
    }
}
