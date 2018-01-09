package org.apereo.cas.configuration.model.core.web.security

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [HttpHeadersRequestProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-core-web", automated = true)
class HttpHeadersRequestProperties : Serializable {
    /**
     * When true, will inject the following headers into the response for non-static resources.
     * <pre>
     * Cache-Control: no-cache, no-store, max-age=0, must-revalidate
     * Pragma: no-cache
     * Expires: 0
    </pre> *
     */
    var isCache = true
    /**
     * When true, will inject the following headers into the response:
     * `Strict-Transport-Security: max-age=15768000 ; includeSubDomains`.
     */
    var isHsts = true
    /**
     * When true, will inject the following headers into the response: `X-Frame-Options: DENY`.
     */
    var isXframe = true
    /**
     * When true, will inject the following headers into the response: `X-Content-Type-Options: nosniff`.
     */
    var isXcontent = true
    /**
     * When true, will inject the following headers into the response: `X-XSS-Protection: 1; mode=block`.
     */
    var isXss = true

    /**
     * Will inject values into the `X-Frame-Options` header into the response.
     */
    var xframeOptions = "DENY"

    /**
     * Will inject values into the `X-XSS-Protection` header into the response.
     */
    var xssOptions = "1; mode=block"

    /**
     * Helps you reduce XSS risks on modern browsers by declaring what dynamic
     * resources are allowed to load via a HTTP Header.
     * Header value is made up of one or more directives.
     * Multiple directives are separated with a semicolon.
     */
    var contentSecurityPolicy: String? = null

    companion object {

        private const val serialVersionUID = 5993704062519851359L
    }

}
