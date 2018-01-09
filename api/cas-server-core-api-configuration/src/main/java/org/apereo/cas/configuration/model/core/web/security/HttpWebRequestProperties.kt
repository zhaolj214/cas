package org.apereo.cas.configuration.model.core.web.security

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable
import java.nio.charset.StandardCharsets

/**
 * This is [HttpWebRequestProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-core-web", automated = true)
class HttpWebRequestProperties : Serializable {
    /**
     * Control and specify the encoding for all http requests.
     */
    var encoding = StandardCharsets.UTF_8.name()
    /**
     * Whether specified encoding should be forced for every request.
     * Whether the specified encoding is supposed to
     * override existing request and response encodings
     */
    var isForceEncoding = true

    companion object {
        private const val serialVersionUID = -4711604991237695091L
    }
}
