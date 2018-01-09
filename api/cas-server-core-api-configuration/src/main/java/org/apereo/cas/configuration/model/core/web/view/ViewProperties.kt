package org.apereo.cas.configuration.model.core.web.view

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable
import java.util.ArrayList

/**
 * This is [ViewProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-web", automated = true)
class ViewProperties : Serializable {
    /**
     * The default redirect URL if none is specified
     * after a successful authentication event.
     */
    var defaultRedirectUrl: String? = null

    /**
     * Comma separated paths to where CAS templates may be found.
     */
    var templatePrefixes: List<String> = ArrayList()

    /**
     * CAS2 views and locations.
     */
    var cas2 = Cas2()
    /**
     * CAS3 views and locations.
     */
    var cas3 = Cas3()

    class Cas2 : Serializable {
        /**
         * The relative location of the CAS2 success view bean.
         */
        var success = "protocol/2.0/casServiceValidationSuccess"
        /**
         * The relative location of the CAS3 failure view bean.
         */
        var failure = "protocol/2.0/casServiceValidationFailure"
        /**
         * Whether v2 protocol support should be forward compatible
         * to act like v3 and match its response, mainly for attribute release.
         */
        var isV3ForwardCompatible: Boolean = false

        /**
         * Proxy views and settings.
         */
        var proxy = Proxy()

        class Proxy : Serializable {
            /**
             * The relative location of the CAS2 proxy success view bean.
             */
            var success = "protocol/2.0/casProxySuccessView"
            /**
             * The relative location of the CAS2 proxy failure view bean.
             */
            var failure = "protocol/2.0/casProxyFailureView"

            companion object {
                private const val serialVersionUID = 6765987342872282599L
            }
        }

        companion object {
            private const val serialVersionUID = -7954879759474698003L
        }
    }

    class Cas3 : Serializable {
        /**
         * The relative location of the CAS3 success validation bean.
         */
        var success = "protocol/3.0/casServiceValidationSuccess"
        /**
         * The relative location of the CAS3 success validation bean.
         */
        var failure = "protocol/3.0/casServiceValidationFailure"

        companion object {
            private const val serialVersionUID = -2345062034300650858L
        }
    }

    companion object {
        private const val serialVersionUID = 2719748442042197738L
    }
}
