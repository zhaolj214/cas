package org.apereo.cas.configuration.model.support.themes

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [ThemeProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-themes", automated = true)
class ThemeProperties : Serializable {
    /**
     * The default theme name of this CAS deployment.
     */
    var defaultThemeName = "cas-theme-default"
    /**
     * The parameter name used to switch themes.
     */
    var paramName = "theme"

    companion object {

        private const val serialVersionUID = 2248773823196496599L
    }
}
