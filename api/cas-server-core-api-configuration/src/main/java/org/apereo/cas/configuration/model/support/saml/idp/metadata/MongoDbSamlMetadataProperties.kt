package org.apereo.cas.configuration.model.support.saml.idp.metadata

import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties
import org.apereo.cas.configuration.support.RequiresModule

/**
 * Configuration properties class mongodb service registry.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-saml-idp-metadata-mongo")
class MongoDbSamlMetadataProperties : SingleCollectionMongoDbProperties() {
    init {
        collection = "cas-saml-metadata"
    }

    companion object {
        private val serialVersionUID = -227092724742371662L
    }
}
