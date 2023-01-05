//uncomment entire file for multi tenant implementation
/*package springboot.data.jpa.multitenant;

public class TenantContext {

    private static ThreadLocal<Object> currentTenant = new ThreadLocal<>();

    public static Object getCurrentTenant() {
	return currentTenant.get();
    }

    public static void setCurrentTenant(Object tenantName) {
	currentTenant.set(tenantName);
    }

}
*/