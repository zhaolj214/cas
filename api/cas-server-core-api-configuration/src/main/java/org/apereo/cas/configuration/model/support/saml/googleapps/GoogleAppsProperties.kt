package org.apereo.cas.configuration.model.support.saml.googleapps

import java.io.Serializable

/**
 * This is [GoogleAppsProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */

class GoogleAppsProperties : Serializable {
    /**
     * The public key location that is also shared with google apps.
     */
    var publicKeyLocation = "file:/etc/cas/public.key"
    /**
     * The private key location that is used to sign responses, etc.
     */
    var privateKeyLocation = "file:/etc/cas/private.key"

    /**
     * Signature algorithm used to generate keys.
     */
    var keyAlgorithm = "RSA"

    companion object {

        private const val serialVersionUID = -5133482766495375325L
    }
}
