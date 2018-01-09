package org.apereo.cas.configuration.model.support.saml

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [SamlCoreProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-saml")
class SamlCoreProperties : Serializable {
    /**
     * Skew allowance that controls the issue instance of the authentication.
     */
    var skewAllowance = 5

    /**
     * Issue length that controls the validity period of the assertion.
     */
    var issueLength = 30

    /**
     * Attribute namespace to use when generating SAML1 responses.
     */
    var attributeNamespace = "http://www.ja-sig.org/products/cas/"

    /**
     * Issuer of the assertion when generating SAML1 responses.
     */
    var issuer = "localhost"

    /**
     * Whether ticket ids generated should be saml2 compliant when generating SAML1 responses.
     */
    var isTicketidSaml2: Boolean = false

    /**
     * Qualified name of the security manager class used for creating a SAML parser pool.
     */
    var securityManager = "com.sun.org.apache.xerces.internal.util.SecurityManager"

    companion object {
        private const val serialVersionUID = -8505851926931247878L
    }
}
