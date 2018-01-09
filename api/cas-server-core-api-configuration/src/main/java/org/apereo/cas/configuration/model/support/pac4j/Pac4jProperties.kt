package org.apereo.cas.configuration.model.support.pac4j

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable
import java.util.ArrayList

/**
 * This is [Pac4jProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-pac4j-webflow")
class Pac4jProperties : Serializable {
    /**
     * When constructing the final user profile from
     * the delegated provider, determines if the provider id
     * should be combined with the principal id.
     */
    var isTypedIdUsed: Boolean = false
    /**
     * Whether CAS should auto-redirect to the provider.
     */
    var isAutoRedirect: Boolean = false
    /**
     * Settings that deal with having Facebook as an external delegated-to authentication provider.
     */
    var facebook = Facebook()
    /**
     * Settings that deal with having Twitter as an external delegated-to authentication provider.
     */
    var twitter = Twitter()
    /**
     * Settings that deal with having SAML2 IdPs as an external delegated-to authentication provider.
     */
    var saml: List<Pac4jSamlProperties> = ArrayList()
    /**
     * Settings that deal with having OpenID Connect Providers as an external delegated-to authentication provider.
     */
    var oidc: List<Pac4jOidcProperties> = ArrayList()
    /**
     * Settings that deal with having OAuth2-capable providers as an external delegated-to authentication provider.
     */
    var oauth2: List<Pac4jOAuth20Properties> = ArrayList()

    /**
     * Settings that deal with having CAS Servers as an external delegated-to authentication provider.
     */
    var cas: List<Pac4jCasProperties> = ArrayList()

    /**
     * Settings that deal with having LinkedIn as an external delegated-to authentication provider.
     */
    var linkedIn = LinkedIn()
    /**
     * Settings that deal with having Dropbox as an external delegated-to authentication provider.
     */
    var dropbox = Dropbox()
    /**
     * Settings that deal with having Orcid as an external delegated-to authentication provider.
     */
    var orcid = Orcid()
    /**
     * Settings that deal with having Github as an external delegated-to authentication provider.
     */
    var github = Github()
    /**
     * Settings that deal with having Google as an external delegated-to authentication provider.
     */
    var google = Google()
    /**
     * Settings that deal with having Yahoo as an external delegated-to authentication provider.
     */
    var yahoo = Yahoo()
    /**
     * Settings that deal with having FourSquare as an external delegated-to authentication provider.
     */
    var foursquare = Foursquare()
    /**
     * Settings that deal with having WindowsLive as an external delegated-to authentication provider.
     */
    var windowsLive = WindowsLive()
    /**
     * Settings that deal with having Paypal as an external delegated-to authentication provider.
     */
    var paypal = Paypal()
    /**
     * Settings that deal with having WordPress as an external delegated-to authentication provider.
     */
    var wordpress = Wordpress()
    /**
     * Settings that deal with having BitBucket as an external delegated-to authentication provider.
     */
    var bitbucket = Bitbucket()

    /**
     * The name of the authentication handler in CAS used for delegation.
     */
    var name: String? = null

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class LinkedIn : Pac4jGenericClientProperties() {
        /**
         * The requested scope.
         */
        var scope: String? = null
        /**
         * Custom fields to include in the request.
         */
        var fields: String? = null

        init {
            clientName = "LinkedIn"
        }

        companion object {

            private val serialVersionUID = 4633395854143281872L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class Facebook : Pac4jGenericClientProperties() {
        /**
         * The requested scope.
         */
        var scope: String? = null
        /**
         * Custom fields to include in the request.
         */
        var fields: String? = null

        init {
            clientName = "Facebook"
        }

        companion object {
            private val serialVersionUID = -2737594266552466076L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class Bitbucket : Pac4jGenericClientProperties() {
        init {
            clientName = "Bitbucket"
        }

        companion object {
            private val serialVersionUID = -6189494666598669078L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class Wordpress : Pac4jGenericClientProperties() {
        init {
            clientName = "Wordpress"
        }

        companion object {
            private val serialVersionUID = 4636855941699435914L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class Paypal : Pac4jGenericClientProperties() {
        init {
            clientName = "Paypal"
        }

        companion object {
            private val serialVersionUID = -5663033494303169583L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class Twitter : Pac4jGenericClientProperties() {
        init {
            clientName = "Twitter"
        }

        companion object {
            private val serialVersionUID = 6906343970517008092L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class Github : Pac4jGenericClientProperties() {
        init {
            clientName = "Github"
        }

        companion object {
            private val serialVersionUID = 9217581995885784515L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class Yahoo : Pac4jGenericClientProperties() {
        init {
            clientName = "Yahoo"
        }

        companion object {
            private val serialVersionUID = 8011580257047982361L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class Foursquare : Pac4jGenericClientProperties() {
        init {
            clientName = "Foursquare"
        }

        companion object {
            private val serialVersionUID = -1784820695301605307L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class Dropbox : Pac4jGenericClientProperties() {
        init {
            clientName = "Dropbox"
        }

        companion object {
            private val serialVersionUID = -1508055128010569953L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class Orcid : Pac4jGenericClientProperties() {
        init {
            clientName = "ORCID"
        }

        companion object {
            private val serialVersionUID = 1337923364401817796L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class WindowsLive : Pac4jGenericClientProperties() {
        init {
            clientName = "Windows Live"
        }

        companion object {
            private val serialVersionUID = -1816309711278174847L
        }
    }

    @RequiresModule(name = "cas-server-support-pac4j-webflow")
    class Google : Pac4jGenericClientProperties() {
        /**
         * The requested scope from the provider.
         */
        var scope: String? = null

        init {
            clientName = "Google"
        }

        companion object {
            private val serialVersionUID = -3023053058552426312L
        }
    }

    companion object {

        private const val serialVersionUID = 4388567744591488495L
    }
}
