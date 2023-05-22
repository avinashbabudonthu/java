//uncomment entire file for multi tenant implementation
/*package springboot.data.jpa.multitenant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiTenantConfiguration {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
	//	File[] files = Paths.get("tenant").toFile().listFiles();
	File[] files = new File("E:\\Backup\\JavaPrep\\practiceProjects\\Spring\\SpringDataPractice\\src\\main\\resources\\tenant").listFiles();
	Map<Object, Object> resolvedDataSources = new HashMap<>();
	for (File propertyFile : files) {
	    Properties tenantProperties = new Properties();
	    DataSourceBuilder dataSourceBuilder = new DataSourceBuilder(this.getClass().getClassLoader());
	    try {
		tenantProperties.load(new FileInputStream(propertyFile));
		String tenantId = tenantProperties.getProperty("name");
		dataSourceBuilder.driverClassName(tenantProperties.getProperty("tenant.datasource.driver-class-name"))
			.url(tenantProperties.getProperty("tenant.datasource.url"))
			.username(tenantProperties.getProperty("tenant.datasource.username"))
			.password(tenantProperties.getProperty("tenant.datasource.password"));
		resolvedDataSources.put(tenantId, dataSourceBuilder.build());
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	MultiTenantDataSource multiTenantDataSource = new MultiTenantDataSource();
	multiTenantDataSource.setDefaultTargetDataSource(defaultDataSource());
	multiTenantDataSource.setTargetDataSources(resolvedDataSources);
	multiTenantDataSource.afterPropertiesSet();
	return multiTenantDataSource;
    }

    private DataSource defaultDataSource() {
	DataSourceBuilder dataSourceBuilder = new DataSourceBuilder(this.getClass().getClassLoader());
	dataSourceBuilder.driverClassName(dataSourceProperties.getDriverClassName()).url(dataSourceProperties.getUrl())
		.username(dataSourceProperties.getUsername()).password(dataSourceProperties.getPassword());
	return dataSourceBuilder.build();
    }
}
*/