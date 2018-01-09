package org.apereo.cas.configuration.model.support.services.yaml

import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.SpringResourceProperties
import org.springframework.core.io.ClassPathResource

/**
 * This is [YamlServiceRegistryProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-yaml-service-registry")
class YamlServiceRegistryProperties : SpringResourceProperties() {
    init {
        location = ClassPathResource("services")
    }

    companion object {
        private val serialVersionUID = 4863603996990314548L
    }
}
