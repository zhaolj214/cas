package org.apereo.cas.configuration.model.support.mongo

import org.apache.commons.lang3.StringUtils
import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiredProperty

import java.io.Serializable

/**
 * This is [BaseMongoDbProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
abstract class BaseMongoDbProperties : Serializable {

    /**
     * core connection-related settings.
     */
    var conns = MongoDbConnections()

    /**
     * The connection uri to the mongodb instance.
     * This typically takes on the form of `mongodb://user:psw@ds135522.somewhere.com:35522/db`.
     * If not specified, will fallback onto other individual settings.
     * If specified, takes over all other settings where applicable.
     */
    @RequiredProperty
    var clientUri = StringUtils.EMPTY

    /**
     * MongoDb database port.
     */
    @RequiredProperty
    var port = 27017

    /**
     * MongoDb database user for authentication.
     */
    @RequiredProperty
    var userId = StringUtils.EMPTY

    /**
     * MongoDb database password for authentication.
     */
    @RequiredProperty
    var password = StringUtils.EMPTY

    /**
     * MongoDb database host for authentication.
     * Multiple host addresses may be defined, separated by comma.
     * If more than one host is defined, it is assumed that each host contains the port as well, if any.
     * Otherwise the configuration may fallback onto [.getPort].
     */
    @RequiredProperty
    var host = "localhost"

    /**
     * MongoDb database connection timeout.
     */
    private var timeout = "PT5S"

    /**
     * MongoDb database connection idle timeout.
     */
    private var idleTimeout = "PT30S"

    /**
     * Write concern describes the level of acknowledgement requested from
     * MongoDB for write operations to a standalone
     * mongo db or to replica sets or to sharded clusters. In sharded clusters,
     * mongo db instances will pass the write concern on to the shards.
     */
    var writeConcern = "NORMAL"

    /**
     * MongoDb database instance name.
     */
    @RequiredProperty
    var databaseName = StringUtils.EMPTY

    /**
     * Whether the database socket connection should be tagged with keep-alive.
     */
    var isSocketKeepAlive: Boolean = false

    /**
     * Name of the database to use for authentication.
     */
    var authenticationDatabaseName: String? = null

    /**
     * A replica set in MongoDB is a group of `mongod` processes that maintain
     * the same data set. Replica sets provide redundancy and high availability, and are the basis for all production deployments.
     */
    var replicaSet: String? = null

    /**
     * Whether connections require SSL.
     */
    var isSslEnabled: Boolean = false

    fun getTimeout(): Long {
        return Beans.newDuration(timeout).toMillis()
    }

    fun setTimeout(timeout: String) {
        this.timeout = timeout
    }

    fun getIdleTimeout(): Long {
        return Beans.newDuration(idleTimeout).toMillis()
    }

    fun setIdleTimeout(idleTimeout: String) {
        this.idleTimeout = idleTimeout
    }

    class MongoDbConnections : Serializable {
        /**
         * Maximum number of connections to keep around.
         */
        var lifetime = 60000

        /**
         * Total number of connections allowed per host.
         */
        var perHost = 10

        companion object {

            private const val serialVersionUID = -2398415870062168474L
        }
    }

    companion object {
        private const val serialVersionUID = -2471243083598934186L
    }
}
