package org.apereo.cas.configuration.model.support.redis

import org.apereo.cas.configuration.support.RequiresModule

/**
 * Configuration properties for Redis.
 *
 * @author serv
 * @since 5.2.0
 */
@RequiresModule(name = "cas-server-support-redis-service-registry")
class RedisServiceRegistryProperties : BaseRedisProperties() {
    companion object {
        private val serialVersionUID = -9012996050439638782L
    }
}
