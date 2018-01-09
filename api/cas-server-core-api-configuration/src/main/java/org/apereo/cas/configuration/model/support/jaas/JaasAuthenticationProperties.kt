package org.apereo.cas.configuration.model.support.jaas

import org.apereo.cas.configuration.model.core.authentication.PasswordEncoderProperties
import org.apereo.cas.configuration.model.core.authentication.PrincipalTransformationProperties
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable

/**
 * This is [JaasAuthenticationProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
class JaasAuthenticationProperties : Serializable {
    /**
     * JAAS realm to use.
     */
    @RequiredProperty
    var realm: String? = null
    /**
     * Typically, the default realm and the KDC for that realm are indicated in the Kerberos `krb5.conf` configuration file.
     * However, if you like, you can instead specify the realm value by setting this following system property value.
     *
     * If you set the realm property, you SHOULD also configure the [.setKerberosKdcSystemProperty].
     *
     * Also note that if you set these properties, then no cross-realm authentication is possible unless
     * a `krb5.conf` file is also provided from which the additional information required for cross-realm authentication
     * may be obtained.
     *
     * If you set values for these properties, then they override the default realm and KDC values specified
     * in `krb5.conf` (if such a file is found). The `krb5.conf` file is still consulted if values for items
     * other than the default realm and KDC are needed. If no `krb5.conf` file is found,
     * then the default values used for these items are implementation-specific.
     *
     * @see [
     * Oracle documentation](http://docs.oracle.com/javase/7/docs/technotes/guides/security/jgss/tutorials/KerberosReq.html)
     */
    var kerberosRealmSystemProperty: String? = null
    /**
     * Typically, the default realm and the KDC for that realm are indicated in the Kerberos `krb5.conf` configuration file.
     * However, if you like, you can instead specify the realm value by setting this following system property value.
     *
     * If you set the realm property, you SHOULD also configure the [.setKerberosKdcSystemProperty].
     *
     * Also note that if you set these properties, then no cross-realm authentication is possible unless
     * a `krb5.conf` file is also provided from which the additional information required for cross-realm authentication
     * may be obtained.
     *
     * If you set values for these properties, then they override the default realm and KDC values specified
     * in `krb5.conf` (if such a file is found). The `krb5.conf` file is still consulted if values for items
     * other than the default realm and KDC are needed. If no `krb5.conf` file is found,
     * then the default values used for these items are implementation-specific.
     *
     * @see [
     * Oracle documentation](http://docs.oracle.com/javase/7/docs/technotes/guides/security/jgss/tutorials/KerberosReq.html)
     */
    var kerberosKdcSystemProperty: String? = null

    /**
     * A number of authentication handlers are allowed to determine whether they can operate on the provided credential
     * and as such lend themselves to be tried and tested during the authentication handler selection phase.
     * The credential criteria may be one of the following options:
     *  * 1) A regular expression pattern that is tested against the credential identifier.
     *  * 2) A fully qualified class name of your own design that implements `Predicate<Credential>`.
     *  * 3) Path to an external Groovy script that implements the same interface.
     *
     */
    var credentialCriteria: String? = null

    /**
     * Principal transformation settings.
     */
    @NestedConfigurationProperty
    var principalTransformation = PrincipalTransformationProperties()

    /**
     * Password encoder settings for JAAS authentication.
     */
    @NestedConfigurationProperty
    var passwordEncoder = PasswordEncoderProperties()

    /**
     * Name of the authentication handler.
     */
    var name: String? = null

    companion object {
        private const val serialVersionUID = 4643338626978471986L
    }
}
