package org.apereo.cas.configuration.model.support.oidc

import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource
import java.io.Serializable
import java.util.*

/**
 * This is [OidcProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-oidc")
class OidcProperties : Serializable {
    /**
     * Timeout that indicates how long should the JWKS file be kept in cache.
     */
    var jwksCacheInMinutes = 60
    /**
     * OIDC issuer.
     */
    @RequiredProperty
    var issuer = "http://localhost:8080/cas/oidc"
    /**
     * Skew value used to massage the authentication issue instance.
     */
    var skew = 5
    /**
     * Path to the JWKS file resource used to handle signing/encryption of authentication tokens.
     */
    @RequiredProperty
    var jwksFile: Resource = FileSystemResource("/etc/cas/keystore.jwks")
    /**
     * Whether dynamic registration operates in `OPEN` or `PROTECTED` mode.
     */
    var dynamicClientRegistrationMode: String? = null
    /**
     * List of supported scopes.
     */
    var scopes = mutableListOf("openid", "profile", "email", "address", "phone", "offline_access")
    /**
     * List of supported claims.
     */
    var claims = mutableListOf("sub", "name", "preferred_username",
            "family_name", "given_name", "middle_name", "given_name", "profile",
            "picture", "nickname", "website", "zoneinfo", "locale", "updated_at",
            "birthdate", "email", "email_verified", "phone_number",
            "phone_number_verified", "address")

    /**
     * List of supported subject types.
     */
    var subjectTypes = mutableListOf("public", "pairwise")

    /**
     * Mapping of user-defined scopes. Key is the new scope name
     * and value is a comma-separated list of claims mapped to the scope.
     */
    var userDefinedScopes: Map<String, String> = HashMap()
    /**
     * Map fixed claims to CAS attributes.
     * Key is the existing claim name for a scope and value is the new attribute
     * that should take its place and value.
     */
    var claimsMap: Map<String, String> = HashMap()

    companion object {

        private const val serialVersionUID = 813028615694269276L
    }
}
