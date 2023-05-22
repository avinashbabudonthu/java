package com.hikaricp;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class HikariCPPractice {

    /**
     * mysql-tasksdb-connection-pool - configuration:
     * allowPoolSuspension................................false
     * autoCommit................................true
     * catalog................................none
     * connectionInitSql................................"select curdate()"
     * connectionTestQuery................................none
     * connectionTimeout................................5000
     * dataSource................................none
     * dataSourceClassName................................none
     * dataSourceJNDI................................none
     * dataSourceProperties................................{password=<masked>, prepStmtCacheSqlLimit=2048, cachePrepStmts=true, prepStmtCacheSize=250}
     * driverClassName................................none
     * exceptionOverrideClassName................................none
     * healthCheckProperties................................{}
     * healthCheckRegistry................................none
     * idleTimeout................................600000
     * initializationFailTimeout................................1
     * isolateInternalQueries................................false
     * jdbcUrl................................jdbc:mysql://localhost:3306/tasksdb?useSSL=false&verifyServerCertificate=false&noAccessToProcedureBodies=true
     * keepaliveTime................................0
     * leakDetectionThreshold................................0
     * maxLifetime................................1800000
     * maximumPoolSize................................20
     * metricRegistry................................none
     * metricsTrackerFactory................................none
     * minimumIdle................................20
     * password................................<masked>
     * poolName................................"mysql-tasksdb-connection-pool"
     * readOnly................................false
     * registerMbeans................................false
     * scheduledExecutor................................none
     * schema................................none
     * threadFactory................................internal
     * transactionIsolation................................default
     * username................................"tasksadmin"
     * validationTimeout................................5000
     * mysql-tasksdb-connection-pool - Starting...
     * Loaded driver with class name com.mysql.cj.jdbc.Driver for jdbcUrl=jdbc:mysql://localhost:3306/tasksdb?useSSL=false&verifyServerCertificate=false&noAccessToProcedureBodies=true
     * mysql-tasksdb-connection-pool - Added connection com.mysql.cj.jdbc.ConnectionImpl@6e20b53a
     * mysql-tasksdb-connection-pool - Start completed.
     * date=2023-04-18
     */
    @DisplayName("Execute query")
    @Test
    void executeQuery(){
        String sqlQuery = "select current_date() as date";
        try (Connection connection = MySQLDataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sqlQuery);
             ResultSet resultset = ps.executeQuery()) {
            while (resultset.next()){
                String date = resultset.getString("date");
                log.info("date={}", date);
            }
        } catch (SQLException e) {
            log.error("Exception", e);
        }
    }

    /**
     * mysql-tasksdb-connection-pool - configuration:
     * allowPoolSuspension................................false
     * autoCommit................................true
     * catalog................................none
     * connectionInitSql................................"select curdate()"
     * connectionTestQuery................................none
     * connectionTimeout................................5000
     * dataSource................................none
     * dataSourceClassName................................none
     * dataSourceJNDI................................none
     * dataSourceProperties................................{password=<masked>, prepStmtCacheSqlLimit=2048, cachePrepStmts=true, prepStmtCacheSize=250}
     * driverClassName................................none
     * exceptionOverrideClassName................................none
     * healthCheckProperties................................{}
     * healthCheckRegistry................................none
     * idleTimeout................................600000
     * initializationFailTimeout................................1
     * isolateInternalQueries................................false
     * jdbcUrl................................jdbc:mysql://localhost:3306/tasksdb?useSSL=false&verifyServerCertificate=false&noAccessToProcedureBodies=true
     * keepaliveTime................................0
     * leakDetectionThreshold................................0
     * maxLifetime................................1800000
     * maximumPoolSize................................20
     * metricRegistry................................none
     * metricsTrackerFactory................................none
     * minimumIdle................................20
     * password................................<masked>
     * poolName................................"mysql-tasksdb-connection-pool"
     * readOnly................................false
     * registerMbeans................................false
     * scheduledExecutor................................none
     * schema................................none
     * threadFactory................................internal
     * transactionIsolation................................default
     * username................................"tasksadmin"
     * validationTimeout................................5000
     * mysql-tasksdb-connection-pool - Starting...
     * Loaded driver with class name com.mysql.cj.jdbc.Driver for jdbcUrl=jdbc:mysql://localhost:3306/tasksdb?useSSL=false&verifyServerCertificate=false&noAccessToProcedureBodies=true
     * mysql-tasksdb-connection-pool - Added connection com.mysql.cj.jdbc.ConnectionImpl@6e20b53a
     * mysql-tasksdb-connection-pool - Start completed.
     * connection1=HikariProxyConnection@1666607455 wrapping com.mysql.cj.jdbc.ConnectionImpl@6e20b53a
     * mysql-tasksdb-connection-pool - Added connection com.mysql.cj.jdbc.ConnectionImpl@73fcfd34
     * connection2=HikariProxyConnection@899644639 wrapping com.mysql.cj.jdbc.ConnectionImpl@73fcfd34
     * mysql-tasksdb-connection-pool - Added connection com.mysql.cj.jdbc.ConnectionImpl@782cab3
     * connection3=HikariProxyConnection@530737374 wrapping com.mysql.cj.jdbc.ConnectionImpl@782cab3
     * mysql-tasksdb-connection-pool - Added connection com.mysql.cj.jdbc.ConnectionImpl@16dcbed3
     * connection4=HikariProxyConnection@1332668132 wrapping com.mysql.cj.jdbc.ConnectionImpl@16dcbed3
     */
    @Test
    void getConnection(){
        try {
            Connection connection1 = MySQLDataSource.getConnection();
            log.info("connection1={}", connection1);

            Connection connection2 = MySQLDataSource.getConnection();
            log.info("connection2={}", connection2);

            Connection connection3 = MySQLDataSource.getConnection();
            log.info("connection3={}", connection3);

            Connection connection4 = MySQLDataSource.getConnection();
            log.info("connection4={}", connection4);
        } catch (SQLException e) {
            log.error("Exception", e);
        }
    }

    /**
     * mysql-tasksdb-connection-pool - configuration:
     * allowPoolSuspension................................false
     * autoCommit................................true
     * catalog................................none
     * connectionInitSql................................"select curdate()"
     * connectionTestQuery................................none
     * connectionTimeout................................5000
     * dataSource................................none
     * dataSourceClassName................................none
     * dataSourceJNDI................................none
     * dataSourceProperties................................{password=<masked>, prepStmtCacheSqlLimit=2048, cachePrepStmts=true, prepStmtCacheSize=250}
     * driverClassName................................none
     * exceptionOverrideClassName................................none
     * healthCheckProperties................................{}
     * healthCheckRegistry................................none
     * idleTimeout................................600000
     * initializationFailTimeout................................1
     * isolateInternalQueries................................false
     * jdbcUrl................................jdbc:mysql://localhost:3306/tasksdb?useSSL=false&verifyServerCertificate=false&noAccessToProcedureBodies=true
     * keepaliveTime................................0
     * leakDetectionThreshold................................0
     * maxLifetime................................1800000
     * maximumPoolSize................................20
     * metricRegistry................................none
     * metricsTrackerFactory................................none
     * minimumIdle................................20
     * password................................<masked>
     * poolName................................"mysql-tasksdb-connection-pool"
     * readOnly................................false
     * registerMbeans................................false
     * scheduledExecutor................................none
     * schema................................none
     * threadFactory................................internal
     * transactionIsolation................................default
     * username................................"tasksadmin"
     * validationTimeout................................5000
     * mysql-tasksdb-connection-pool - Starting...
     * Loaded driver with class name com.mysql.cj.jdbc.Driver for jdbcUrl=jdbc:mysql://localhost:3306/tasksdb?useSSL=false&verifyServerCertificate=false&noAccessToProcedureBodies=true
     * mysql-tasksdb-connection-pool - Added connection com.mysql.cj.jdbc.ConnectionImpl@6e20b53a
     * mysql-tasksdb-connection-pool - Start completed.
     * -- listing properties --
     * prepStmtCacheSqlLimit=2048
     * cachePrepStmts=true
     * prepStmtCacheSize=250
     * pool size=20
     * pool name=mysql-tasksdb-connection-pool
     */
    @Test
    void datasource(){
        HikariDataSource hikariDataSource = MySQLDataSource.dataSource();
        Properties properties = hikariDataSource.getDataSourceProperties();
        properties.list(System.out);
        log.info("pool size={}", hikariDataSource.getMaximumPoolSize());
        log.info("pool name={}", hikariDataSource.getPoolName());
    }
}
