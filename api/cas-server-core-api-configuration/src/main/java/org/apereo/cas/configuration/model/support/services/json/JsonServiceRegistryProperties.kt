package org.apereo.cas.configuration.model.support.services.json

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.core.io.ClassPathResource

/**
 * This is [JsonServiceRegistryProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-json-service-registry")
class JsonServiceRegistryProperties : SpringResourceProperties() {
    init {
        location = ClassPathResource("services")
    }

    companion object {
        private val serialVersionUID = -3022199446494732533L
    }
}
