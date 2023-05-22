package multi.tenant.datasource.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MultiTenantDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary // to make this as primary or default data source
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.mysql.datasource")
    public DataSource mySqlDataSource(){
        return DataSourceBuilder.create().build();
    }

}
