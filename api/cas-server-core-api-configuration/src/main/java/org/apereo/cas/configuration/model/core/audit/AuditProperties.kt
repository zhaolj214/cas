package org.apereo.cas.configuration.model.core.audit

import org.apereo.inspektr.audit.support.AbstractStringAuditTrailManager
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [AuditProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
class AuditProperties : Serializable {

    /**
     * Whether ticket validation events in the audit log should include
     * information about the assertion that is validated; things such as
     * the principal id and attributes released.
     */
    var isIncludeValidationAssertion: Boolean = false

    /**
     * Application code to use in the audit logs.
     *
     * This is a unique code that acts as the identifier for the application.
     * In case audit logs are aggregated in a central location. This makes it easy
     * to identify the application and filter results based on the code.
     */
    var appCode = "CAS"

    /**
     * Character to separate audit fields if single-line audits are used.
     */
    var singlelineSeparator = "|"

    /**
     * Request header to use identify the server address.
     */
    var alternateServerAddrHeaderName: String? = null

    /**
     * Request header to use identify the client address.
     *
     * If the application is sitting behind a load balancer,
     * the client address typically ends up being the load balancer
     * address itself. A common example for a header here would be
     * `X-Forwarded-For` to glean the client address
     * from the request, assuming the load balancer is configured correctly
     * to pass that header along.
     */
    var alternateClientAddrHeaderName: String? = null

    /**
     * Determines whether a local DNS lookup should be made to query for the CAS server address.
     *
     * By default, the server is address is determined from the request. Aside from special headers,
     * this option allows one to query DNS to look up the server address of the CAS server processing requests.
     */
    var isUseServerHostAddress: Boolean = false

    /**
     * Indicates whether audit logs should be recorded as a single-line.
     *
     * By default, audit logs are split into multiple lines where each action and activity
     * takes up a full line. This is a more compact version.
     */
    var isUseSingleLine: Boolean = false

    /**
     * Family of sub-properties pertaining to Jdbc-based audit destinations.
     */
    @NestedConfigurationProperty
    var jdbc = AuditJdbcProperties()

    /**
     * Family of sub-properties pertaining to MongoDb-based audit destinations.
     */
    @NestedConfigurationProperty
    var mongo = AuditMongoDbProperties()

    /**
     * Family of sub-properties pertaining to rest-based audit destinations.
     */
    @NestedConfigurationProperty
    var rest = AuditRestProperties()

    /**
     * The audit format to use in the logs.
     */
    var auditFormat: AbstractStringAuditTrailManager.AuditFormats = AbstractStringAuditTrailManager.AuditFormats.DEFAULT

    /**
     * Indicates whether catastrophic audit failures should simply be logged
     * or whether errors should bubble up and thrown back.
     */
    var isIgnoreAuditFailures: Boolean = false

    companion object {

        private const val serialVersionUID = 3946106584608417663L
    }
}
