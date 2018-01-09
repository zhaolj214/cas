package org.apereo.cas.configuration.model.support.throttle

import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.quartz.SchedulingProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * Configuration properties class for cas.throttle.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-throttle", automated = true)
class ThrottleProperties : Serializable {

    /**
     * Throttling failure events.
     */
    var failure = Failure()
    /**
     * Record authentication throttling events in a JDBC resource.
     */
    var jdbc = Jdbc()

    /**
     * Username parameter to use in order to extract the username from the request.
     */
    var usernameParameter: String? = null

    /**
     * Application code used to identify this application in the audit logs.
     */
    var appcode = DEFAULT_APPLICATION_CODE

    /**
     * Scheduler settings to clean up throttled attempts.
     */
    @NestedConfigurationProperty
    var schedule = SchedulingProperties()

    init {
        schedule.isEnabled = true
        schedule.setStartDelay("PT10S")
        schedule.setRepeatInterval("PT30S")
    }

    /**
     * Failure.
     */
    @RequiresModule(name = "cas-server-support-throttle", automated = true)
    class Failure : Serializable {

        /**
         * Failure code to record in the audit log.
         * Generally this indicates an authentication failure event.
         */
        var code = DEFAULT_AUTHN_FAILED_ACTION
        /**
         * Number of failed login attempts permitted in the above period.
         * All login throttling components that ship with CAS limit successive failed
         * login attempts that exceed a threshold rate in failures per second.
         */
        var threshold = -1
        /**
         * Period of time in seconds during which the threshold applies.
         */
        var rangeSeconds = -1

        companion object {
            private const val serialVersionUID = 1246256695801461610L
        }
    }

    @RequiresModule(name = "cas-server-support-throttle-jdbc")
    class Jdbc : AbstractJpaProperties() {

        /**
         * Audit query to execute against the database
         * to locate audit records based on IP, user, date and
         * an application code along with the relevant audit action.
         */
        var auditQuery = SQL_AUDIT_QUERY

        companion object {
            /**
             * SQL throttling query.
             */
            private val SQL_AUDIT_QUERY = "SELECT AUD_DATE FROM COM_AUDIT_TRAIL WHERE AUD_CLIENT_IP = ? AND AUD_USER = ? " + "AND AUD_ACTION = ? AND APPLIC_CD = ? AND AUD_DATE >= ? ORDER BY AUD_DATE DESC"
            private val serialVersionUID = -9199878384425691919L
        }
    }

    companion object {
        /**
         * Default app code for throttling and audits.
         */
        private val DEFAULT_APPLICATION_CODE = "CAS"
        /**
         * Default authentication failed action used as the code.
         */
        private val DEFAULT_AUTHN_FAILED_ACTION = "AUTHENTICATION_FAILED"

        private const val serialVersionUID = 6813165633105563813L
    }


}
