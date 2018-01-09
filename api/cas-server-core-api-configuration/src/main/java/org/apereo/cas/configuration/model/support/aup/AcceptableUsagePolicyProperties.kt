package org.apereo.cas.configuration.model.support.aup

import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapSearchProperties
import org.apereo.cas.configuration.model.support.mongo.SingleCollectionMongoDbProperties
import org.apereo.cas.configuration.support.RequiredProperty
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RestEndpointProperties

import java.io.Serializable

/**
 * This is [AcceptableUsagePolicyProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-aup-webflow")
class AcceptableUsagePolicyProperties : Serializable {
    /**
     * Control AUP via LDAP.
     */
    var ldap = Ldap()

    /**
     * Control AUP via Redis.
     */
    var jdbc = Jdbc()

    /**
     * Control AUP via Redis.
     */
    var rest = Rest()

    /**
     * Keep consent decisions stored via a MongoDb database resource.
     */
    var mongo = MongoDb()

    /**
     * AUP attribute to choose in order to determine whether policy
     * has been accepted or not.
     */
    @RequiredProperty
    var aupAttributeName = "aupAccepted"

    @RequiresModule(name = "cas-server-support-aup-mongo")
    class MongoDb : SingleCollectionMongoDbProperties() {
        init {
            collection = "MongoDbCasAUPRepository"
        }

        companion object {
            private val serialVersionUID = -1918436901491275547L
        }
    }

    @RequiresModule(name = "cas-server-support-aup-jdbc")
    class Jdbc : AbstractJpaProperties() {

        /**
         * The table name in the database that holds the AUP attribute to update for the user.
         */
        var tableName: String? = null

        companion object {
            private val serialVersionUID = -1325011278378393385L
        }
    }

    @RequiresModule(name = "cas-server-support-aup-rest")
    class Rest : RestEndpointProperties() {
        companion object {
            private val serialVersionUID = -8102345678378393382L
        }
    }

    @RequiresModule(name = "cas-server-support-aup-ldap")
    class Ldap : AbstractLdapSearchProperties() {
        companion object {
            private val serialVersionUID = -7991011278378393382L
        }
    }

    companion object {
        private const val serialVersionUID = -7703477581675908899L
    }

}
