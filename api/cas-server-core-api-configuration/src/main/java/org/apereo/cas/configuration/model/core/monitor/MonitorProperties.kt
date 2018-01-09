package org.apereo.cas.configuration.model.core.monitor

import org.apereo.cas.configuration.model.support.ConnectionPoolingProperties
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapProperties
import org.apereo.cas.configuration.model.support.memcached.BaseMemcachedProperties
import org.apereo.cas.configuration.model.support.mongo.BaseMongoDbProperties
import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * Configuration properties class for cas.monitor.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-monitor", automated = true)
class MonitorProperties : Serializable {
    /**
     * The free memory threshold for the memory monitor.
     * If the amount of free memory available reaches this point
     * the memory monitor will report back a warning status as a health check.
     */
    var freeMemThreshold = 10

    /**
     * Options for monitoring the status a nd production of TGTs.
     */
    var tgt = Tgt()

    /**
     * Options for monitoring the status a nd production of STs.
     */
    var st = St()

    /**
     * Warning options that generally deal with cache-based resources, etc.
     */
    @NestedConfigurationProperty
    var warn = MonitorWarningProperties()

    /**
     * Options for monitoring sensitive CAS endpoints and resources.
     * Acts as a parent class for all endpoints and settings
     * and exposes shortcuts so security and capability of endpoints
     * can be globally controlled from one spot and then overridden elsewhere.
     */
    var endpoints = Endpoints()

    /**
     * Options for monitoring JDBC resources.
     */
    var jdbc = Jdbc()

    /**
     * Options for monitoring LDAP resources.
     */
    var ldap = Ldap()

    /**
     * Options for monitoring Memcached resources.
     */
    var memcached = Memcached()

    /**
     * Options for monitoring MongoDb resources.
     */
    var mongo = MongoDb()

    @RequiresModule(name = "cas-server-core-monitor", automated = true)
    class St : Serializable {

        /**
         * Warning settings for this monitor.
         */
        @NestedConfigurationProperty
        var warn = MonitorWarningProperties(5000)

        companion object {
            private const val serialVersionUID = -8167395674267219982L
        }
    }

    @RequiresModule(name = "cas-server-core-monitor", automated = true)
    class Tgt : Serializable {
        /**
         * Warning options for monitoring TGT production.
         */
        @NestedConfigurationProperty
        var warn = MonitorWarningProperties(10000)

        companion object {

            private const val serialVersionUID = -2756454350350278724L
        }
    }

    @RequiresModule(name = "cas-server-core-monitor", automated = true)
    class Ldap : AbstractLdapProperties() {

        /**
         * When monitoring the LDAP connection pool, indicates the amount of time the operation must wait
         * before it times outs and considers the pool in bad shape.
         */
        private var maxWait = "PT5S"

        /**
         * Options that define the LDAP connection pool to monitor.
         */
        @NestedConfigurationProperty
        var pool = ConnectionPoolingProperties()

        fun getMaxWait(): Long {
            return Beans.newDuration(maxWait).toMillis()
        }

        fun setMaxWait(maxWait: String) {
            this.maxWait = maxWait
        }

        companion object {
            private val serialVersionUID = 4722929378440179113L
        }
    }

    @RequiresModule(name = "cas-server-support-memcached-monitor")
    class Memcached : BaseMemcachedProperties() {
        companion object {
            private val serialVersionUID = -9139788158851782673L
        }
    }

    @RequiresModule(name = "cas-server-support-mongo-monitor")
    class MongoDb : BaseMongoDbProperties() {
        companion object {
            private val serialVersionUID = -1918436901491275547L
        }
    }

    @RequiresModule(name = "cas-server-support-jdbc-monitor")
    class Jdbc : AbstractJpaProperties() {

        /**
         * The query to execute against the database to monitor status.
         */
        var validationQuery = "SELECT 1"

        /**
         * When monitoring the JDBC connection pool, indicates the amount of time the operation must wait
         * before it times outs and considers the pool in bad shape.
         */
        private var maxWait = "PT5S"

        fun getMaxWait(): Long {
            return Beans.newDuration(maxWait).toMillis()
        }

        fun setMaxWait(maxWait: String) {
            this.maxWait = maxWait
        }

        companion object {
            private val serialVersionUID = -7139788158851782673L
        }

    }

    /**
     * All endpoints are modeled after
     * Spring Boot’s own actuator endpoints and by default are considered sensitive.
     * By default, no endpoint is enabled or allowed access.
     * Endpoints may go through multiple levels and layers of security.
     */
    abstract class BaseEndpoint {

        /**
         * Disable access to the endpoint completely.
         */
        var isEnabled: Boolean? = null

        /**
         * Marking the endpoint as sensitive will force it to require authentication.
         * The authentication scheme usually is done via the presence of spring security
         * related modules who then handle the protocol and verifications of credentials.
         * If you wish to choose alternative methods for endpoint security, such as letting
         * CAS handle the sensitivity of the endpoint itself via CAS itself or via
         * IP pattern checking, etc, set this flag to false. For more elaborate means of authenticating
         * into an endpoint such as basic authn and verifications credentials with a master account, LDAP, JDBC, etc
         * set this endpoint to true and configure spring security appropriate as is described by the docs.
         *
         * By default all endpoints are considered disabled and sensitive.
         *
         *
         * It's important to note that these endpoints and their settings only affect
         * what CAS provides. Additional endpoints provided by Spring Boot are controlled
         * elsewhere by Spring Boot itself.
         */
        var isSensitive: Boolean? = null
    }

    @RequiresModule(name = "cas-server-support-reports", automated = true)
    class Endpoints : BaseEndpoint() {

        /**
         * Dashboard related settings.
         */
        var dashboard = Dashboard()

        /**
         * Audit events related settings.
         */
        var auditEvents = AuditEvents()

        /**
         * Authentication events related settings.
         */
        var authenticationEvents = AuthenticationEvents()

        /**
         * Configuration State related settings.
         */
        var configurationState = ConfigurationState()

        /**
         * Health check related settings.
         */
        var healthCheck = HealthCheck()

        /**
         * Logging configuration related settings.
         */
        var loggingConfig = LoggingConfig()

        /**
         * Metrics related settings.
         */
        var metrics = Metrics()

        /**
         * Attribute resolution related settings.
         */
        var attributeResolution = AttributeResolution()

        /**
         * Single Sign on sessions report related settings.
         */
        var singleSignOnReport = SingleSignOnReport()

        /**
         * Statistics related settings.
         */
        var statistics = Statistics()

        /**
         * Discovery related settings.
         */
        var discovery = Discovery()
        /**
         * Trusted devices related settings.
         */
        var trustedDevices = TrustedDevices()

        /**
         * Status related settings.
         */
        var status = Status()
        /**
         * Single Sign On Status related settings.
         */
        var singleSignOnStatus = SingleSignOnStatus()

        /**
         * Spring webflow related settings.
         */
        var springWebflowReport = SpringWebflowReport()

        /**
         * Registered services and service registry related settings.
         */
        var registeredServicesReport = RegisteredServicesReport()

        /**
         * Configuration metadata, documentation and fields, etc.
         */
        var configurationMetadata = ConfigurationMetadata()

        init {
            isSensitive = java.lang.Boolean.TRUE
            isEnabled = java.lang.Boolean.FALSE
        }

        @RequiresModule(name = "cas-server-support-reports", automated = true)
        class Dashboard : BaseEndpoint()

        @RequiresModule(name = "cas-server-support-reports", automated = true)
        class AuditEvents : BaseEndpoint()

        @RequiresModule(name = "cas-server-support-reports", automated = true)
        class AuthenticationEvents : BaseEndpoint()

        @RequiresModule(name = "cas-server-core-configuration", automated = true)
        class ConfigurationState : BaseEndpoint()

        @RequiresModule(name = "cas-server-core-monitor", automated = true)
        class HealthCheck : BaseEndpoint()

        @RequiresModule(name = "cas-server-core-logging", automated = true)
        class LoggingConfig : BaseEndpoint()

        @RequiresModule(name = "cas-server-support-metrics", automated = true)
        class Metrics : BaseEndpoint()

        @RequiresModule(name = "cas-server-support-person-directory", automated = true)
        class AttributeResolution : BaseEndpoint()

        @RequiresModule(name = "cas-server-core-web", automated = true)
        class SingleSignOnReport : BaseEndpoint()

        @RequiresModule(name = "cas-server-core-web", automated = true)
        class Statistics : BaseEndpoint()

        @RequiresModule(name = "cas-server-support-mfa-trusted", automated = true)
        class TrustedDevices : BaseEndpoint()

        @RequiresModule(name = "cas-server-core-web", automated = true)
        class Status : BaseEndpoint()

        @RequiresModule(name = "cas-server-support-discovery", automated = true)
        class Discovery : BaseEndpoint()

        @RequiresModule(name = "cas-server-core", automated = true)
        class SingleSignOnStatus : BaseEndpoint()

        @RequiresModule(name = "cas-server-core-webflow", automated = true)
        class SpringWebflowReport : BaseEndpoint()

        @RequiresModule(name = "cas-server-core-services", automated = true)
        class RegisteredServicesReport : BaseEndpoint()

        @RequiresModule(name = "cas-server-core-configuration", automated = true)
        class ConfigurationMetadata : BaseEndpoint()
    }

    companion object {

        private const val serialVersionUID = -7047060071480971606L
    }
}
