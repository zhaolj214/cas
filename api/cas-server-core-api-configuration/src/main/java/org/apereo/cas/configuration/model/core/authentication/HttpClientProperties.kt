package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.Beans
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.core.io.Resource

import java.io.Serializable

/**
 * Configuration properties class for http.client.truststore.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class HttpClientProperties : Serializable {
    /**
     * Connection timeout for all operations that reach out to URL endpoints.
     */
    private var connectionTimeout = "PT5S"

    /**
     * Read timeout for all operations that reach out to URL endpoints.
     */
    private var readTimeout = "PT5S"

    /**
     * Indicates timeout for async operations.
     */
    private var asyncTimeout = "PT5S"

    /**
     * Enable hostname verification when attempting to contact URL endpoints.
     * May also be set to `none` to disable verification.
     */
    var hostNameVerifier = "default"

    /**
     * Configuration properties namespace for embedded Java SSL trust store.
     */
    var truststore = Truststore()

    /**
     * Whether CAS should accept local logout URLs.
     * For example http(s)://localhost/logout
     */
    var isAllowLocalLogoutUrls: Boolean = false

    /**
     * If specified the regular expression will be used to validate the url's authority.
     */
    var authorityValidationRegEx: String? = null

    /**
     * Whether the regular expression specified with `authorityValidationRegEx` should be handled as case-sensitive
     * (`true`) or case-insensitive (`false`). If no `authorityValidationRegEx` is set, this value does not have any effect.
     */
    var isAuthorityValidationRegExCaseSensitiv = true

    fun getAsyncTimeout(): Long {
        return Beans.newDuration(this.asyncTimeout).toMillis()
    }

    fun setAsyncTimeout(asyncTimeout: String) {
        this.asyncTimeout = asyncTimeout
    }

    fun getConnectionTimeout(): Long {
        return Beans.newDuration(this.connectionTimeout).toMillis()
    }

    fun setConnectionTimeout(connectionTimeout: String) {
        this.connectionTimeout = connectionTimeout
    }

    fun getReadTimeout(): Long {
        return Beans.newDuration(this.readTimeout).toMillis()
    }

    fun setReadTimeout(readTimeout: String) {
        this.readTimeout = readTimeout
    }

    class Truststore : Serializable {
        /**
         * The CAS local truststore resource to contain certificates to the CAS deployment.
         * In the event that local certificates are to be imported into the CAS running environment,
         * a local truststore is provided by CAS to improve portability of configuration across environments.
         */
        var file: Resource? = null

        /**
         * The truststore password.
         */
        var psw = "changeit"

        companion object {

            private const val serialVersionUID = -1357168622083627654L
        }
    }

    companion object {
        private const val serialVersionUID = -7494946569869245770L
    }
}
