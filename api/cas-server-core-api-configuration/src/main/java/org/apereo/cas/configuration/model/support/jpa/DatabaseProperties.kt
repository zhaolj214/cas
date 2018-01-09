package org.apereo.cas.configuration.model.support.jpa

import java.io.Serializable

/**
 * Configuration properties class for database.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */

class DatabaseProperties : Serializable {
    /**
     * Whether SQL queries should be displayed in the console/logs.
     */
    var isShowSql: Boolean = false

    /**
     * Whether to generate DDL after the EntityManagerFactory has been initialized creating/updating all relevant tables.
     */
    var isGenDdl = true

    companion object {

        private const val serialVersionUID = 7740236971148591965L
    }

}
