package org.apereo.cas.configuration.model.support.geo.maxmind

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.core.io.Resource

import java.io.Serializable

/**
 * This is [MaxmindProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-geolocation-maxmind")
class MaxmindProperties : Serializable {
    /**
     * Path to the location of the database file containing cities.
     */
    @RequiredProperty
    var cityDatabase: Resource? = null
    /**
     * Path to the location of the database file containing countries.
     */
    @RequiredProperty
    var countryDatabase: Resource? = null

    companion object {

        private const val serialVersionUID = 7883029275219817797L
    }
}
