package org.apereo.cas.configuration.model.support.digest

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable
import java.util.HashMap

/**
 * This is [DigestProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-digest-authentication")
class DigestProperties : Serializable {
    /**
     * The digest realm to use.
     */
    var realm = "CAS"

    /**
     * Authentication method used when creating digest header.
     */
    var authenticationMethod = "auth"

    /**
     * Static/stub list of username and passwords to accept
     * if no other account store is defined.
     */
    var users: Map<String, String> = HashMap()

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    companion object {

        private const val serialVersionUID = -7920128284733546444L
    }
}


