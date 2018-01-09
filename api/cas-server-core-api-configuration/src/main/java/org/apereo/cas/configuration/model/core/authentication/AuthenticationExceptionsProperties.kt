package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable
import java.util.ArrayList

/**
 * This is [AuthenticationExceptionsProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class AuthenticationExceptionsProperties : Serializable {
    /**
     * Define custom exceptions that can then be mapped to message bundles for custom error handling.
     *
     * By default CAS is configured to recognize and handle a number
     * of exceptions for during authentication. Each exception has the specific message bundle
     * mapping so that a specific message could be presented to end users on the login form.
     * Any un-recognized or un-mapped exceptions results in a generic message.
     * To map custom exceptions, one would need map the exception, they can be defined here
     * and then linked to custom messages.
     */
    var exceptions: List<Class<out Exception>> = ArrayList()

    companion object {
        private const val serialVersionUID = -2385347572099983874L
    }
}


