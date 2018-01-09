package org.apereo.cas.configuration.model.core.web.security

import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable
import java.util.LinkedHashMap

/**
 * This is [HttpRequestProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-web", automated = true)
class HttpRequestProperties : Serializable {
    /**
     * Whether CAS should accept multi-valued parameters
     * in incoming requests. Example block would to prevent
     * requests where more than one `service` parameter is specified.
     */
    var isAllowMultiValueParameters: Boolean = false
    /**
     * Parameters that are only allowed and accepted during posts.
     */
    var onlyPostParams = "username,password"

    /**
     * Parameters to sanitize and cross-check in incoming requests.
     * The special value * instructs the Filter to check all parameters.
     */
    var paramsToCheck = "ticket,service,renew,gateway,warn,method,target,SAMLart," + "pgtUrl,pgt,pgtId,pgtIou,targetService,entityId,token"

    /**
     * Custom response headers to inject into the response as needed.
     */
    var customHeaders: Map<String, String> = LinkedHashMap()

    /**
     * Control http request settings.
     */
    @NestedConfigurationProperty
    var web = HttpWebRequestProperties()
    /**
     * Enforce request header options and security settings.
     */
    @NestedConfigurationProperty
    var header = HttpHeadersRequestProperties()
    /**
     * Control CORS settings for requests.
     */
    @NestedConfigurationProperty
    var cors = HttpCorsRequestProperties()

    companion object {

        private const val serialVersionUID = -5175966163542099866L
    }
}
