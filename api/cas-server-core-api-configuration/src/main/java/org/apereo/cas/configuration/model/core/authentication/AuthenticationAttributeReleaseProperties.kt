package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule

import java.util.ArrayList

/**
 * Authentication attribute release properties.
 *
 * @author Daniel Frett
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-validation", automated = true)
class AuthenticationAttributeReleaseProperties {
    /**
     * List of authentication attributes that should never be released.
     */
    var neverRelease: List<String> = ArrayList()

    /**
     * List of authentication attributes that should be the only ones released. An empty list indicates all attributes
     * should be released.
     */
    var onlyRelease: List<String> = ArrayList()
}
