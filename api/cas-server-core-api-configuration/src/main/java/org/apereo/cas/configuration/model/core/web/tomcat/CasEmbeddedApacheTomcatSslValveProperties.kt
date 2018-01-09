package org.apereo.cas.configuration.model.core.web.tomcat

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [CasEmbeddedApacheTomcatSslValveProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-webapp-tomcat")
class CasEmbeddedApacheTomcatSslValveProperties : Serializable {
    /**
     * Enable the SSL valve for apache tomcat.
     */
    var isEnabled: Boolean = false

    /**
     * Allows setting a custom name for the ssl_client_cert header.
     * If not specified, the default of ssl_client_cert is used.
     */
    var sslClientCertHeader = "ssl_client_cert"
    /**
     * Allows setting a custom name for the ssl_cipher header.
     * If not specified, the default of ssl_cipher is used.
     */
    var sslCipherHeader = "ssl_cipher"
    /**
     * Allows setting a custom name for the ssl_session_id header.
     * If not specified, the default of ssl_session_id is used.
     */
    var sslSessionIdHeader = "ssl_session_id"
    /**
     * Allows setting a custom name for the ssl_cipher_usekeysize header.
     * If not specified, the default of ssl_cipher_usekeysize is used.
     */
    var sslCipherUserKeySizeHeader = "ssl_cipher_usekeysize"

    companion object {
        private const val serialVersionUID = 3164446071136700242L
    }

}
