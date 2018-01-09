package org.apereo.cas.configuration.model.support.geo.googlemaps

import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [GoogleMapsProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-geolocation-googlemaps")
class GoogleMapsProperties : Serializable {
    /**
     * Authenticate into google maps via an API key.
     */
    @RequiredProperty
    var apiKey: String? = null
    /**
     * Authenticate into google maps via a client id.
     */
    @RequiredProperty
    var clientId: String? = null
    /**
     * Authenticate into google maps via a client secret.
     */
    @RequiredProperty
    var clientSecret: String? = null
    /**
     * The connection timeout when reaching out to google maps.
     */
    private var connectTimeout = "PT3S"
    /**
     * When true, a strategy for handling URL requests using Google App Engine's URL Fetch API.
     */
    var isGoogleAppsEngine: Boolean = false

    fun getConnectTimeout(): Long {
        return Beans.newDuration(connectTimeout).toMillis()
    }

    fun setConnectTimeout(connectTimeout: String) {
        this.connectTimeout = connectTimeout
    }

    companion object {
        private const val serialVersionUID = 4661113818711911462L
    }
}
