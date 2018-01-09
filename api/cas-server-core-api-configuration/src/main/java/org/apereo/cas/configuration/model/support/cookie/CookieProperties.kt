package org.apereo.cas.configuration.model.support.cookie

import org.apache.commons.lang3.StringUtils
import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * Common properties for all cookie configs.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-cookie", automated = true)
open class CookieProperties : Serializable {
    /**
     * Cookie name. Constructs a cookie with a specified name and value.
     * The name must conform to RFC 2965. That means it can contain only ASCII alphanumeric characters and
     * cannot contain commas, semicolons, or white space or begin with a $ character.
     * The cookie's name cannot be changed after creation.
     * By default, cookies are created according to the RFC 2965 cookie specification.
     */
    var name: String? = null
    /**
     * Cookie path.
     * Specifies a path for the cookie to which the client should return the cookie.
     * The cookie is visible to all the pages in the directory you specify, and all the pages in that directory's
     * subdirectories. A cookie's path must include the servlet that set the cookie, for example, /catalog,
     * which makes the cookie visible to all directories on the server under /catalog.
     * Consult RFC 2965 (available on the Internet) for more information on setting path names for cookies.
     */
    var path = StringUtils.EMPTY
    /**
     * Cookie domain. Specifies the domain within which this cookie should be presented.
     * The form of the domain name is specified by RFC 2965. A domain name begins with a dot (.foo.com)
     * and means that the cookie is visible to servers in a
     * specified Domain Name System (DNS) zone (for example, www.foo.com, but not a.b.foo.com).
     * By default, cookies are only returned to the server that sent them.
     */
    var domain = StringUtils.EMPTY
    /**
     * True if sending this cookie should be restricted to a secure protocol, or false if the it can be sent using any protocol.
     */
    var isSecure = true
    /**
     * true if this cookie contains the HttpOnly attribute. This means that the cookie should not be accessible to scripting engines, like javascript.
     */
    var isHttpOnly = true
    /**
     * The maximum age of the cookie, specified in seconds. By default, -1 indicating the cookie will persist until browser shutdown.
     * A positive value indicates that the cookie will expire after that many seconds have passed. Note that the value is
     * the maximum age when the cookie will expire, not the cookie's current age.
     * A negative value means that the cookie is not stored persistently and will be deleted when the Web browser exits.
     * A zero value causes the cookie to be deleted.
     */
    var maxAge = -1

    companion object {

        private const val serialVersionUID = 6804770601645126835L
    }
}
