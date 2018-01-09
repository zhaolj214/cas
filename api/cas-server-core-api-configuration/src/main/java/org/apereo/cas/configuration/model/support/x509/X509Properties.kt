package org.apereo.cas.configuration.model.support.x509

import org.apereo.cas.configuration.model.core.authentication.PersonDirectoryPrincipalResolverProperties
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapSearchProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable
import java.util.ArrayList
import java.util.concurrent.TimeUnit

/**
 * This is [X509Properties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-x509-webflow")
class X509Properties : Serializable {

    /**
     * The serial number prefix used for principal resolution
     * when type is set to [PrincipalTypes.SERIAL_NO_DN].
     */
    var serialNumberPrefix = "SERIALNUMBER="
    /**
     * Value delimiter used for principal resolution
     * when type is set to [PrincipalTypes.SERIAL_NO_DN].
     */
    var valueDelimiter = ", "
    /**
     * Threshold value if expired CRL revocation policy is to be handled via threshold.
     */
    var revocationPolicyThreshold = 172800
    /**
     * Whether revocation checking should check all resources, or stop at first one.
     */
    var isCheckAll: Boolean = false
    /**
     * The refresh interval of the internal scheduler in cases where CRL revocation checking
     * is done via resources.
     */
    var refreshIntervalSeconds = 3600
    /**
     * The principal descriptor used for principal resolution
     * when type is set to [PrincipalTypes.SUBJECT].
     */
    var principalDescriptor: String? = null
    /**
     * When CRL revocation checking is done via distribution points,
     * decide if fetch failures should throw errors.
     */
    var isThrowOnFetchFailure: Boolean = false
    /**
     * Indicates the type of principal resolution for X509.
     *
     *  * `SERIAL_NO`: Resolve the principal by the serial number with a configurable radix,
     * ranging from 2 to 36. If radix is 16, then the serial number could be filled with leading zeros to even the number of digits.
     *  * `SERIAL_NO_DN`: Resolve the principal by serial number and issuer dn.
     *  * `SUBJECT`: Resolve the principal by extracting one or more attribute values from the
     * certificate subject DN and combining them with intervening delimiters.
     *  * `SUBJECT_ALT_NAME`: Resolve the principal by the subject alternative name extension.
     *  * `SUBJECT_DN`: The default type; Resolve the principal by the certificate’s subject dn.
     *
     */
    var principalType: PrincipalTypes? = null
    /**
     * Revocation certificate checking can be carried out in one of the following ways:
     *
     *  * `NONE`: No revocation is performed.
     *  * `CRL`: The CRL URI(s) mentioned in the certificate cRLDistributionPoints extension field.
     * Caches are available to prevent excessive IO against CRL endpoints; CRL data is fetched if does not exist in the cache or if it is expired.
     *  * `RESOURCE`: A CRL hosted at a fixed location. The CRL is fetched at periodic intervals and cached.
     *
     */
    var revocationChecker = "NONE"
    /**
     * To fetch CRLs, the following options are available:
     *
     *  * `RESOURCE`: By default, all revocation checks use fixed resources to fetch the CRL resource from the specified location.
     *  * `LDAP`: A CRL resource may be fetched from a pre-configured attribute, in the event that the CRL resource location is an LDAP URI.
     *
     */
    var crlFetcher = "RESOURCE"
    /**
     * List of CRL resources to use for fetching.
     */
    var crlResources: List<String> = ArrayList()
    /**
     * When CRLs are cached, indicate maximum number of elements kept in memory.
     */
    var cacheMaxElementsInMemory = 1000
    /**
     * When CRLs are cached, indicate whether cache should overflow to disk.
     */
    var isCacheDiskOverflow: Boolean = false
    /**
     * When CRLs are cached, indicate if cache items should be eternal.
     */
    var isCacheEternal: Boolean = false
    /**
     * When CRLs are cached, indicate the time-to-live of cache items.
     */
    var cacheTimeToLiveSeconds = TimeUnit.HOURS.toSeconds(4)
    /**
     * When CRLs are cached, indicate the idle timeout of cache items.
     */
    var cacheTimeToIdleSeconds = TimeUnit.MINUTES.toSeconds(30)
    /**
     * If the CRL resource is unavailable, activate the this policy.
     * Activated if [.revocationChecker] is `RESOURCE`.
     * Accepted values are:
     *
     *  * `ALLOW`: Allow authentication to proceed.
     *  * `DENY`: Deny authentication and block.
     *  * `THRESHOLD`: Applicable to CRL expiration, throttle the request whereby expired
     * data is permitted up to a threshold period of time but not afterward.
     *
     */
    var crlResourceUnavailablePolicy = "DENY"
    /**
     * If the CRL resource has expired, activate the this policy.
     * Activated if [.revocationChecker] is `RESOURCE`.
     * Accepted values are:
     *
     *  * `ALLOW`: Allow authentication to proceed.
     *  * `DENY`: Deny authentication and block.
     *  * `THRESHOLD`: Applicable to CRL expiration, throttle the request whereby expired
     * data is permitted up to a threshold period of time but not afterward.
     *
     */
    var crlResourceExpiredPolicy = "DENY"
    /**
     * If the CRL is unavailable, activate the this policy.
     * Activated if [.revocationChecker] is `CRL`.
     * Accepted values are:
     *
     *  * `ALLOW`: Allow authentication to proceed.
     *  * `DENY`: Deny authentication and block.
     *  * `THRESHOLD`: Applicable to CRL expiration, throttle the request whereby expired
     * data is permitted up to a threshold period of time but not afterward.
     *
     */
    var crlUnavailablePolicy = "DENY"
    /**
     * If the CRL has expired, activate the this policy.
     * Activated if [.revocationChecker] is `CRL`.
     * Accepted values are:
     *
     *  * `ALLOW`: Allow authentication to proceed.
     *  * `DENY`: Deny authentication and block.
     *  * `THRESHOLD`: Applicable to CRL expiration, throttle the request whereby expired
     * data is permitted up to a threshold period of time but not afterward.
     *
     */
    var crlExpiredPolicy = "DENY"

    /**
     * Radix used when [.principalType] is [PrincipalTypes.SERIAL_NO].
     */
    var principalSNRadix: Int = 0
    /**
     * If radix hex padding should be used when [.principalType] is [PrincipalTypes.SERIAL_NO].
     */
    var isPrincipalHexSNZeroPadding: Boolean = false

    /**
     * Principal resolution properties.
     */
    @NestedConfigurationProperty
    var principal = PersonDirectoryPrincipalResolverProperties()

    /**
     * LDAP settings when fetching CRLs from LDAP.
     */
    var ldap = Ldap()

    /**
     * The compiled pattern supplied by the deployer.
     */
    var regExTrustedIssuerDnPattern: String? = null

    /**
     * Deployer supplied setting for maximum pathLength in a SUPPLIED
     * certificate.
     */
    var maxPathLength = DEFAULT_MAXPATHLENGTH

    /**
     * Deployer supplied setting to allow unlimited pathLength in a SUPPLIED
     * certificate.
     */
    var isMaxPathLengthAllowUnspecified = DEFAULT_MAXPATHLENGTH_ALLOW_UNSPECIFIED

    /**
     * Deployer supplied setting to check the KeyUsage extension.
     */
    var isCheckKeyUsage = DEFAULT_CHECK_KEYUSAGE

    /**
     * Deployer supplied setting to force require the correct KeyUsage
     * extension.
     */
    var isRequireKeyUsage = DEFAULT_REQUIRE_KEYUSAGE

    /**
     * The pattern that authorizes an acceptable certificate by its subject dn.
     */
    var regExSubjectDnPattern = ".+"

    /**
     * The authentication handler name.
     */
    var name: String? = null

    /**
     * The  Principal types.
     */
    enum class PrincipalTypes {
        /**
         * Create principal by subject.
         */
        SUBJECT,
        /**
         * Create principal by subject DN.
         */
        SUBJECT_DN,
        /**
         * Create principal by serial no.
         */
        SERIAL_NO,
        /**
         * Create principal by serial no and DN.
         */
        SERIAL_NO_DN,
        /**
         * Create principal by subject alternative name.
         */
        SUBJECT_ALT_NAME,
        /**
         * Create principal by common name and EDIPI.
         */
        CN_EDIPI
    }

    class Ldap : AbstractLdapSearchProperties() {
        /**
         * The LDAP attribute that holds the certificate revocation list.
         */
        var certificateAttribute = "certificateRevocationList"

        companion object {
            private val serialVersionUID = -1655068554291000206L
        }

    }

    companion object {

        private const val serialVersionUID = -9032744084671270366L

        /**
         * Default setting to limit the number of intermediate certificates.
         */
        private val DEFAULT_MAXPATHLENGTH = 1

        /**
         * Default setting whether to allow unspecified number of intermediate certificates.
         */
        private val DEFAULT_MAXPATHLENGTH_ALLOW_UNSPECIFIED = false

        /**
         * Default setting to check keyUsage extension.
         */
        private val DEFAULT_CHECK_KEYUSAGE = false

        /**
         * Default setting to force require "KeyUsage" extension.
         */
        private val DEFAULT_REQUIRE_KEYUSAGE = false
    }
}
