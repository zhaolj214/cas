package org.apereo.cas.configuration.model.core.web

import org.apereo.cas.configuration.support.RequiresModule

import java.io.Serializable
import java.nio.charset.StandardCharsets

/**
 * Configuration properties class for message.bundle.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
@RequiresModule(name = "cas-server-core-web", automated = true)
class MessageBundleProperties : Serializable {
    /**
     * Message bundle character encoding.
     */
    var encoding = StandardCharsets.UTF_8.name()

    /**
     * Cache size.
     */
    var cacheSeconds = 180

    /**
     * Flag that controls whether to fallback to the default system locale if no locale is specified explicitly.
     */
    var isFallbackSystemLocale: Boolean = false

    /**
     * Flag that controls whether to use code message.
     */
    var isUseCodeMessage = true

    /**
     * A list of strings representing base names for this message bundle.
     */
    var baseNames = mutableListOf("classpath:custom_messages", "classpath:messages")

    /**
     * A list of strings representing common names for this message bundle.
     *
     *
     * Entries in last common names override first values (as opposed to baseNames used in message bundles).
     */
    var commonNames = mutableListOf("classpath:common_messages.properties", "file:/etc/cas/config/common_messages.properties")

    companion object {

        private const val serialVersionUID = 3769733438559663237L
    }
}
