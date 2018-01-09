package org.apereo.cas.configuration.model.support.couchbase

import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [BaseCouchbaseProperties].
 *
 * @author Misagh Moayyed
 * @since 5.2.0
 */
abstract class BaseCouchbaseProperties : Serializable {
    /**
     * Flag to indicate if query is enabled.
     */
    var isQueryEnabled = true

    /**
     * Nodeset name.
     */
    @RequiredProperty
    var nodeSet = "localhost:8091"

    /**
     * String representation of connection timeout.
     */
    private var timeout = "PT10S"

    /**
     * Password.
     */
    @RequiredProperty
    var password: String? = null

    /**
     * Bucket name.
     */
    @RequiredProperty
    var bucket = "default"

    fun getTimeout(): Long {
        return Beans.newDuration(timeout).seconds
    }

    fun setTimeout(timeout: String) {
        this.timeout = timeout
    }

    companion object {
        private const val serialVersionUID = 6550895842866988551L
    }
}
