package org.apereo.cas.configuration.model.support.cookie

import org.apereo.cas.configuration.support.RequiresModule

/**
 * Configuration properties class for warn.cookie.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-cookie", automated = true)
class WarningCookieProperties : CookieProperties() {
    init {
        super.name = "CASPRIVACY"
    }

    companion object {

        private val serialVersionUID = -266090748600049578L
    }
}
