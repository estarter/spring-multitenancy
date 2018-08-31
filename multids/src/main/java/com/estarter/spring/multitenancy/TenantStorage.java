package com.estarter.spring.multitenancy;

public class TenantStorage {

    private static ThreadLocal<String> tenant = new ThreadLocal<>();

    public static void setTenantName(String tenantName) {
        tenant.set(tenantName);
    }

    public static String getTenantName() {
        return tenant.get();
    }

}
