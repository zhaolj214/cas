package org.apereo.cas.configuration.model.support.jpa

import org.springframework.orm.jpa.JpaVendorAdapter

import javax.sql.DataSource
import java.io.Serializable

/**
 * Simple structure to collect and pass around pieces of JPA config data reusable across
 * different JPA configuration components.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */
class JpaConfigDataHolder @JvmOverloads constructor(val jpaVendorAdapter: JpaVendorAdapter,
                                                    val persistenceUnitName: String,
                                                    val packagesToScan: List<String>,
                                                    val dataSource: DataSource? = null) : Serializable {
    companion object {

        private const val serialVersionUID = -3940423575751579622L
    }
}
