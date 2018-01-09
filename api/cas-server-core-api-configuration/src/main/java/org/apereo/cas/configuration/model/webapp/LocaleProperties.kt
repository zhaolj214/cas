package org.apereo.cas.configuration.model.webapp

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * Configuration properties class for locale.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-web")
class LocaleProperties : Serializable {
    /**
     * Parameter name to use when switching locales.
     */
    var paramName = "locale"

    /**
     * Default locale.
     */
    var defaultValue = "en"

    companion object {

        private const val serialVersionUID = -1644471820900213781L
    }
}
