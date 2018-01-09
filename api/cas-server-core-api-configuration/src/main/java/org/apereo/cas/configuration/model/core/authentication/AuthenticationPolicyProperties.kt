package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable
import java.util.ArrayList

/**
 * Configuration properties class for cas.authn.policy.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class AuthenticationPolicyProperties : Serializable {
    /**
     * Global authentication policy that is applied when CAS attempts to vend and validate tickets.
     * Checks to make sure a particular authentication handler has successfully executed and validated credentials.
     * Required handlers are defined per registered service.
     */
    var isRequiredHandlerAuthenticationPolicyEnabled: Boolean = false

    /**
     * Satisfied if any authentication handler succeeds.
     * Allows options to avoid short circuiting and try every handler even if one prior succeeded.
     */
    var any = Any()

    /**
     * Satisfied if an only if a specified handler successfully authenticates its credential.
     */
    var req = Req()

    /**
     * Satisfied if and only if all given credentials are successfully authenticated.
     * Support for multiple credentials is new in CAS and this handler would
     * only be acceptable in a multi-factor authentication situation.
     */
    var all = All()

    /**
     * Execute a groovy script to detect authentication policy.
     */
    var groovy: List<GroovyAuthenticationPolicyProperties> = ArrayList()

    /**
     * Execute a rest endpoint to detect authentication policy.
     */
    var rest: List<RestAuthenticationPolicyProperties> = ArrayList()

    /**
     * Satisfied if an only if the authentication event is not blocked by a `PreventedException`.
     */
    var notPrevented = NotPrevented()

    /**
     * Satisfied if an only if the principal has not already authenticated
     * and does not have an sso session with CAS. Otherwise, prevents
     * the user from logging in more than once. Note that this policy
     * adds an extra burden to the ticket store/registry as CAS needs
     * to query all relevant tickets found in the registry to cross-check
     * the requesting username with existing tickets.
     */
    var uniquePrincipal = UniquePrincipal()

    class NotPrevented : Serializable {
        /**
         * Enables the policy.
         */
        var isEnabled: Boolean = false

        companion object {
            private const val serialVersionUID = -4930217018850738715L
        }
    }

    class UniquePrincipal : Serializable {
        /**
         * Enables the policy.
         */
        var isEnabled: Boolean = false

        companion object {
            private const val serialVersionUID = -4930217087310738715L
        }
    }

    class Any : Serializable {
        /**
         * Enables the policy.
         */
        var isEnabled = true

        /**
         * Avoid short circuiting and try every handler even if one prior succeeded.
         * Ensure number of provided credentials does not match the sum of authentication successes and failures
         */
        var isTryAll: Boolean = false

        companion object {
            private const val serialVersionUID = 4600357071276768175L
        }
    }

    class All : Serializable {
        /**
         * Enables the policy.
         */
        var isEnabled: Boolean = false

        companion object {

            private const val serialVersionUID = 928409456096460793L
        }
    }

    class Req : Serializable {
        /**
         * Enables the policy.
         */
        var isEnabled: Boolean = false

        /**
         * Ensure number of provided credentials does not match the sum of authentication successes and failures.
         */
        var isTryAll: Boolean = false

        /**
         * The handler name which must have successfully executed and validated credentials.
         */
        var handlerName = "handlerName"

        companion object {
            private const val serialVersionUID = -4206244023952305821L
        }
    }

    companion object {

        private const val serialVersionUID = 2039700004862120066L
    }
}
