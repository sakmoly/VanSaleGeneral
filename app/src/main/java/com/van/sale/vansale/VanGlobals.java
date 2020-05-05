package com.van.sale.vansale;

import android.app.Application;
import android.content.Context;

public class VanGlobals extends Application {

    private Boolean isasset_reqd=false;
    private Boolean customer_visit_access=false;
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();

    }
    public static Context getAppContext() {
        return appContext;
    }

    public Boolean getIsasset_reqd() {
        return isasset_reqd;
    }

    public void setIsasset_reqd(Boolean isasset_reqd) {
        this.isasset_reqd = isasset_reqd;
    }

    public void setCustomer_visit_access(Boolean customer_visit_access) {
        this.customer_visit_access = customer_visit_access;
    }

    public Boolean getCustomer_visit_access() {
        return customer_visit_access;
    }
}
