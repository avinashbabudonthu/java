//uncomment entire file for multi tenant implementation
/*package springboot.data.jpa.multitenant;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiTenantDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
	return TenantContext.getCurrentTenant();
    }

}
*/