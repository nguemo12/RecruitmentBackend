
package com.model;

public class ModelOffer {
    private int jobofferid;
    private modelCompany companyid;
    private String offername;
    private String description;
    private String status;
    private String jobofferimage;

    public int getJobofferid() {
        return jobofferid;
    }

    public void setJobofferid(int jobofferid) {
        this.jobofferid = jobofferid;
    }

    public modelCompany getCompanyid() {
        return companyid;
    }

    public void setCompanyid(modelCompany companyid) {
        this.companyid = companyid;
    }

    public String getOffername() {
        return offername;
    }

    public void setOffername(String offername) {
        this.offername = offername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJobofferimage() {
        return jobofferimage;
    }

    public void setJobofferimage(String jobofferimage) {
        this.jobofferimage = jobofferimage;
    }
    
    
    
}
