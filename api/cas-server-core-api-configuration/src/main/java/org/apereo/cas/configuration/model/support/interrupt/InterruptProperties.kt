package org.apereo.cas.configuration.model.support.interrupt

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RestEndpointProperties
import org.apereo.cas.configuration.support.SpringResourceProperties

import java.io.Serializable

/**
 * This is [InterruptProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-interrupt-webflow")
class InterruptProperties : Serializable {

    /**
     * Inquire for interrupt using a JSON resource.
     */
    var json = Json()
    /**
     * Inquire for interrupt using a Groovy resource.
     */
    var groovy = Groovy()
    /**
     * Inquire for interrupt using a REST resource.
     */
    var rest = Rest()

    @RequiresModule(name = "cas-server-support-interrupt-webflow")
    class Json : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 1079027840047126083L
        }
    }

    @RequiresModule(name = "cas-server-support-interrupt-webflow")
    class Groovy : SpringResourceProperties() {
        companion object {
            private val serialVersionUID = 8079027843747126083L
        }
    }

    @RequiresModule(name = "cas-server-support-interrupt-webflow")
    class Rest : RestEndpointProperties() {
        companion object {
            private val serialVersionUID = 1833594332973137011L
        }
    }

    companion object {
        private const val serialVersionUID = -4945287309473842615L
    }
}
