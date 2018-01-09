package org.apereo.cas.configuration.model.support.mongo

import org.apereo.cas.configuration.support.RequiredProperty

/**
 * This is [SingleCollectionMongoDbProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
open class SingleCollectionMongoDbProperties : BaseMongoDbProperties() {

    /**
     * MongoDb database collection name to fetch and/or create.
     */
    @RequiredProperty
    var collection: String? = null

    /**
     * Whether collections should be dropped on startup and re-created.
     */
    var isDropCollection: Boolean = false

    companion object {
        private val serialVersionUID = 4869686250345657447L
    }
}
