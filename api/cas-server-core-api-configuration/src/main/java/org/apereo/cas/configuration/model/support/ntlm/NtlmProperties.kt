package org.apereo.cas.configuration.model.support.ntlm

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [NtlmProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-spnego")
class NtlmProperties : Serializable {
    /**
     * The domain controller to retrieve if load balanced.
     * Otherwise retrieve the domain controller as a possible NT or workgroup.
     */
    var domainController: String? = null
    /**
     * If specified, gets all domain controllers in the specified [.domainController]
     * and then filters hosts that match the pattern.
     */
    var includePattern: String? = null
    /**
     * Indicates how the domain controller should be retrieved, whether matched
     * and filtered by a pattern or retrieved as possible NT or workgroup.
     */
    var isLoadBalance = true
    /**
     * The name of the authentication handler.
     */
    var name: String? = null

    companion object {
        private const val serialVersionUID = 1479912148936123469L
    }
}
