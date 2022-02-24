
package com.restful;

import java.util.Set;
import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.controller.CategoryController.class);
        resources.add(com.controller.JobapplicationController.class);
        resources.add(com.controller.OfferController.class);
        resources.add(com.controller.applicantController.class);
        resources.add(com.controller.companyController.class);
        resources.add(com.restful.GenericResource.class);
    }
    
}
