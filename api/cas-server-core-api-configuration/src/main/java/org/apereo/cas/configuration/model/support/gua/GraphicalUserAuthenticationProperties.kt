package org.apereo.cas.configuration.model.support.gua

import org.apereo.cas.configuration.model.support.ldap.AbstractLdapSearchProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.SpringResourceProperties

import java.io.Serializable

/**
 * This is [GraphicalUserAuthenticationProperties]
 * that contains settings needed for identification
 * of users graphically prior to executing primary authn.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@RequiresModule(name = "cas-server-support-gua")
class GraphicalUserAuthenticationProperties : Serializable {
    /**
     * Locate GUA settings and images from LDAP.
     */
    var ldap = Ldap()
    /**
     * Locate GUA settings and images from a static image.
     */
    var resource = SpringResourceProperties()

    class Ldap : AbstractLdapSearchProperties() {
        /**
         * Entry attribute that holds the user image.
         */
        @RequiredProperty
        var imageAttribute: String? = null

        companion object {
            private val serialVersionUID = 4666838063728336692L
        }
    }

    companion object {
        private const val serialVersionUID = 7527953699378415460L
    }

}
