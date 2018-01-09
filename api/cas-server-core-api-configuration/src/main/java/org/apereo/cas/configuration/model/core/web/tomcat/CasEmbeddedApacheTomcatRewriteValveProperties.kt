package org.apereo.cas.configuration.model.core.web.tomcat

import org.apereo.cas.configuration.support.RequiresModule
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource

import java.io.Serializable

/**
 * This is [CasEmbeddedApacheTomcatRewriteValveProperties].
 *
 * @author Misagh Moayyed
 * @since 5.3.0
 */
@RequiresModule(name = "cas-server-webapp-tomcat")
class CasEmbeddedApacheTomcatRewriteValveProperties : Serializable {
    /**
     * Location of a rewrite valve specifically by Apache Tomcat
     * to activate URL rewriting.
     */
    var location: Resource = ClassPathResource("container/tomcat/rewrite.config")

    companion object {
        private const val serialVersionUID = 9030094143985594411L
    }
}
