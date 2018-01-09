package org.apereo.cas.configuration.model.support.oauth

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable

/**
 * This is [OAuthProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-oauth")
class OAuthProperties : Serializable {

    /**
     * Settings related to oauth grants.
     */
    var grants = OAuthGrantsProperties()
    /**
     * Settings related to oauth codes.
     */
    var code = OAuthCodeProperties()
    /**
     * Settings related to oauth access tokens.
     */
    var accessToken = OAuthAccessTokenProperties()
    /**
     * Settings related to oauth refresh tokens.
     */
    var refreshToken = OAuthRefreshTokenProperties()

    /**
     * User profile view type determines how the final user profile should be rendered
     * once an access token is "validated".
     */
    var userProfileViewType = UserProfileViewTypes.NESTED

    /**
     * Name of the oauth throttling bean, assuming authentication throttling is turned on. Acceptable values are:
     *
     *
     *  * `neverThrottle`: Disable throttling
     *  * `authenticationThrottle`: Enable authentication throttling.
     *
     */
    var throttler = "neverThrottle"

    /**
     * Profile view types.
     */
    enum class UserProfileViewTypes {
        /**
         * Return and render the user profile view in nested mode.
         * This is the default option, most usually.
         */
        NESTED,
        /**
         * Return and render the user profile view in flattened mode
         * where all attributes are flattened down to one level only.
         */
        FLAT
    }

    companion object {
        private const val serialVersionUID = 2677128037234123907L
    }
}

