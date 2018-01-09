package org.apereo.cas.configuration.model.support.jpa.serviceregistry

import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.support.RequiresModule

/**
 * Configuration properties class for JPA service registry.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-jpa-service-registry")
class JpaServiceRegistryProperties : AbstractJpaProperties() {
    init {
        super.url = "jdbc:hsqldb:mem:cas-service-registry"
    }

    companion object {

        private val serialVersionUID = 352435146313504995L
    }
}
