package org.apereo.cas.configuration.model.support.saml.idp.metadata

import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.support.RequiresModule

/**
 * Configuration properties class for saml metadata based on JPA.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-saml-idp-metadata-jpa")
class JpaSamlMetadataProperties : AbstractJpaProperties() {
    init {
        super.url = "jdbc:hsqldb:mem:cas-saml-metadata"
    }

    companion object {

        private val serialVersionUID = 352435146313504995L
    }
}
