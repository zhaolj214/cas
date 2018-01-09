package org.apereo.cas.configuration.model.support.dynamodb

import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.core.io.Resource

import java.io.Serializable

/**
 * This is [AbstractDynamoDbProperties].
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
abstract class AbstractDynamoDbProperties : Serializable {

    /**
     * File containing credentials properties.
     */
    var credentialsPropertiesFile: Resource? = null

    /**
     * Credentials access key.
     */
    @RequiredProperty
    var credentialAccessKey: String? = null

    /**
     * Credentials secret key.
     */
    @RequiredProperty
    var credentialSecretKey: String? = null

    /**
     * Dynamo DB endpoint.
     */
    @RequiredProperty
    var endpoint: String? = null

    /**
     * EC2 region.
     */
    @RequiredProperty
    var region: String? = null

    /**
     * EC2 region override.
     */
    var regionOverride: String? = null

    /**
     * Service name pattern.
     */
    var serviceNameIntern: String? = null

    /**
     * Flag that indicates whether to drop tables on start up.
     */
    var isDropTablesOnStartup: Boolean = false

    /**
     * Time offset.
     */
    var timeOffset: Int = 0

    /**
     * Read capacity.
     */
    var readCapacity: Long = 10

    /**
     * Write capacity.
     */
    var writeCapacity: Long = 10

    /**
     * Connection timeout.
     */
    var connectionTimeout = 5000

    /**
     * Request timeout.
     */
    var requestTimeout = 5000

    /**
     * Socket timeout.
     */
    var socketTimeout = 5000

    /**
     * Flag that indicates whether to use Gzip compression.
     */
    var isUseGzip: Boolean = false

    /**
     * Flag that indicates whether to use reaper.
     */
    var isUseReaper: Boolean = false

    /**
     * Flag that indicates whether to throttle retries.
     */
    var isUseThrottleRetries: Boolean = false

    /**
     * Flag that indicates whether to keep TCP connection alive.
     */
    var isUseTcpKeepAlive: Boolean = false

    /**
     * Protocol setting.
     */
    var protocol = "HTTPS"

    /**
     * Client execution timeout.
     */
    var clientExecutionTimeout = 10000

    /**
     * Flag that indicates whether to cache response metadata.
     */
    var isCacheResponseMetadata: Boolean = false

    /**
     * Local address.
     */
    var localAddress: String? = null

    /**
     * Maximum connections setting.
     */
    var maxConnections = 10

    companion object {
        private const val serialVersionUID = -8349917272283787550L
    }
}
