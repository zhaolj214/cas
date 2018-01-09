package org.apereo.cas.configuration.model.support.saml.mdui

import org.apereo.cas.configuration.model.support.quartz.SchedulingProperties
import org.apereo.cas.configuration.support.RequiresModule
import org.apereo.cas.configuration.support.RequiredProperty
import org.springframework.boot.context.properties.NestedConfigurationProperty

import java.io.Serializable
import java.util.ArrayList

/**
 * This is [SamlMetadataUIProperties].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-support-saml-mdui")
class SamlMetadataUIProperties : Serializable {
    /**
     * The parameter name that indicates the entity id of the service provider
     * submitted to CAS.
     */
    var parameter = "entityId"

    /**
     * If specified, creates a validity filter on the metadata to check for
     * metadata freshness based on the max validity. Value is specified in seconds.
     */
    var maxValidity: Long = 0

    /**
     * When parsing metadata, whether the root element is required to be signed.
     */
    var isRequireSignedRoot: Boolean = false
    /**
     * Whether valid metadata is required when parsing metadata.
     */
    var isRequireValidMetadata = true

    /**
     * Metadata resources to load and parse through based on the incoming entity id
     * in order to locate MDUI. Resources can be classpath/file/http resources.
     * If each metadata resource has a signing certificate, they can be added onto the resource with a `::`
     * separator. Example: `classpath:/sp-metadata.xml::classpath:/pub.key`.
     */
    @RequiredProperty
    var resources: List<String> = ArrayList()

    /**
     * Scheduler settings to indicate how often is metadata reloaded.
     */
    @NestedConfigurationProperty
    var schedule = SchedulingProperties()

    init {
        schedule.isEnabled = true
        schedule.setStartDelay("PT30S")
        schedule.setRepeatInterval("PT2M")
    }

    companion object {

        private const val serialVersionUID = 2113479681245996975L
    }

}
