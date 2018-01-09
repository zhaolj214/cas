package org.apereo.cas.configuration.model.core.audit

import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties
import org.apereo.cas.configuration.support.RequiresModule

/**
 * This is [AuditMongoDbProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-audit-mongo")
class AuditMongoDbProperties : SingleCollectionMongoDbProperties() {
    init {
        collection = "MongoDbCasAuditRepository"
    }

    companion object {
        private val serialVersionUID = 4940497540189318943L
    }
}
