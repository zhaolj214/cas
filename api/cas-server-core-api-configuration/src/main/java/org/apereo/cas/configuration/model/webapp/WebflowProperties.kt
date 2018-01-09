package org.apereo.cas.configuration.model.webapp

import org.apereo.cas.configuration.model.core.util.EncryptionRandomizedSigningJwtCryptographyProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * Configuration properties class for webflow.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-webflow")
class WebflowProperties : Serializable {
    /**
     * Encryption/signing setting for webflow.
     */
    @NestedConfigurationProperty
    var crypto = EncryptionRandomizedSigningJwtCryptographyProperties()

    /**
     * Whether CAS should take control of all spring webflow modifications
     * and dynamically alter views, states and actions.
     */
    var isAutoconfigure = true

    /**
     * Whether webflow should remain in "live reload" mode, able to auto detect
     * changes and react. This is useful if the location of the webflow is externalized
     * and changes are done ad-hoc to the webflow to accommodate changes.
     */
    var isRefresh: Boolean = false

    /**
     * Whether flow executions should redirect after they pause before rendering.
     */
    var isAlwaysPauseRedirect: Boolean = false

    /**
     * Whether flow executions redirect after they pause for transitions that remain in the same view state.
     */
    var isRedirectSameState: Boolean = false

    /**
     * Webflow session management settings.
     */
    @NestedConfigurationProperty
    var session = WebflowSessionManagementProperties()

    /**
     * Path to groovy resource that may auto-configure the webflow context
     * dynamically creating/removing states and actions.
     */
    var groovy = Groovy()

    @RequiresModule(name = "cas-server-core-webflow", automated = true)
    class Groovy : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 8079027843747126083L
        }
    }

    companion object {

        private const val serialVersionUID = 4949978905279568311L
    }
}
