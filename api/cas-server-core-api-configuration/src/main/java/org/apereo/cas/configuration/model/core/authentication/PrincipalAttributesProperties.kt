package org.apereo.cas.configuration.model.core.authentication

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable
import java.util.ArrayList
import java.util.HashSet
import java.util.concurrent.TimeUnit

/**
 * This is [PrincipalAttributesProperties].
 * Attribute sources are defined and configured to describe the global set of attributes to be fetched for each authenticated principal.
 * That global set of attributes is then filtered by the service manager according to service-specific attribute release rules.
 * The goal of the resolver is to construct a final identifiable authenticated principal for CAS
 * which carries a number of attributes inside it.
 *
 * The behavior of the resolver is such that it attempts to locate the principal id,
 * which in most cases is the same thing as the credential id provided
 * during authentication or it could be noted by a custom attribute.
 * Then the resolver starts to construct attributes from attribute repositories defined.
 * If it realizes that a custom attribute is used to determine the principal id
 * AND the same attribute is also set to be collected into the final set of attributes,
 * it will then remove that attribute from the final collection.
 * Note that by default, CAS auto-creates attribute repository sources that are appropriate for LDAP, JDBC, etc.
 * If you need something more, you will need to resort to more elaborate measures of defining the bean configuration.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-authentication", automated = true)
class PrincipalAttributesProperties : Serializable {
    /**
     * Indicates the global cache expiration period, once attributes
     * are fetched from the underlying attribute repository.
     */
    var expirationTime = 30

    /**
     * Expiration caching timeunit for attributes.
     */
    var expirationTimeUnit = TimeUnit.MINUTES.name

    /**
     * Indicates the global cache size used to store attributes
     * retrieved from the attribute repository.
     */
    var maximumCacheSize = 10000

    /**
     * Merging strategies can be used to resolve conflicts when the same attribute are found from multiple sources.
     * Accepted values are the following:
     *
     *  * `REPLACE`: Overwrites existing attribute values, if any.
     *  * `ADD`: Retains existing attribute values if any, and ignores
     * values from subsequent sources in the resolution chain.
     *  * `MERGE`: Combines all values into a single attribute, essentially creating a multi-valued attribute.
     *
     */
    var merger = "REPLACE"

    /**
     * CAS provides the ability to release a bundle of principal attributes to all services by default.
     * This bundle is not defined on a per-service basis and is always combined with attributes
     * produced by the specific release policy of the service, such that for instance,
     * you can devise rules to always release `givenName` and `cn` to every application,
     * and additionally allow other specific principal attributes for only some applications
     * per their attribute release policy.
     */
    var defaultAttributesToRelease: Set<String> = HashSet()

    /**
     * Retrieve attributes from multiple JDBC repositories.
     */
    var jdbc: List<JdbcPrincipalAttributesProperties> = ArrayList()

    /**
     * Retrieve attributes from multiple REST endpoints.
     */
    var rest: List<RestPrincipalAttributesProperties> = ArrayList()

    /**
     * Retrieve attributes from multiple Groovy scripts.
     */
    var groovy: List<GroovyPrincipalAttributesProperties> = ArrayList()

    /**
     * Retrieve attributes from multiple LDAP servers.
     */
    var ldap: List<LdapPrincipalAttributesProperties> = ArrayList()

    /**
     * Retrieve attributes from multiple JSON file repositories.
     */
    var json: List<JsonPrincipalAttributesProperties> = ArrayList()

    /**
     * Retrieve attributes from multiple scripted repositories.
     */
    var script: List<ScriptedPrincipalAttributesProperties> = ArrayList()

    /**
     * Use stubbed attribute definitions as the underlying attribute repository source.
     * Static attributes that need to be mapped to a hardcoded value belong here.
     */
    var stub = StubPrincipalAttributesProperties()

    /**
     * Use Grouper to fetch principal attributes.
     * You will also need to ensure `grouper.client.properties`
     * is available on the classpath (i.e. `src/main/resources`)
     * and it contains the following:
     * <pre>
     * grouperClient.webService.url = http://192.168.99.100:32768/grouper-ws/servicesRest
     * grouperClient.webService.login = banderson
     * grouperClient.webService.password = password
    </pre> *
     */
    var grouper = GrouperPrincipalAttributesProperties()

    companion object {

        private const val serialVersionUID = -4515569588579072890L
    }
}
