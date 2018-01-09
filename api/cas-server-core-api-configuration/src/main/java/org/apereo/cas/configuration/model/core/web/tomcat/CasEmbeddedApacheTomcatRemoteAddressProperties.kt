package org.apereo.cas.configuration.model.core.web.tomcat

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [CasEmbeddedApacheTomcatRemoteAddressProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-webapp-tomcat")
class CasEmbeddedApacheTomcatRemoteAddressProperties : Serializable {

    /**
     * Enable filter.
     */
    var isEnabled: Boolean = false

    /**
     * A regular expression (using java.util.regex) that the remote client's IP address is compared to.
     * If this attribute is specified, the remote address MUST match for this request to be accepted.
     * If this attribute is not specified, all requests will be accepted UNLESS the remote address matches a deny pattern.
     */
    var allowedClientIpAddressRegex = ".+"

    /**
     * A regular expression (using java.util.regex) that the remote client's IP address is compared to.
     * If this attribute is specified, the remote address MUST NOT match for this request to be accepted.
     * If this attribute is not specified, request acceptance is governed solely by the accept attribute.
     */
    var deniedClientIpAddressRegex = ".+"

    companion object {
        private const val serialVersionUID = -32143821503580896L
    }
}
