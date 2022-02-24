package com.model;

public class ModelCategory {
    private int jobcategory_id;
    private String jcname;
    private String jcdesc;
  
    public int getJobcategory_id() {
        return jobcategory_id;
    }

    public void setJobcategory_id(int jobcategory_id) {
        this.jobcategory_id = jobcategory_id;
    }

    public String getJcname() {
        return jcname;
    }

    public void setJcname(String jcname) {
        this.jcname = jcname;
    }

    public String getJcdesc() {
        return jcdesc;
    }

    public void setJcdesc(String jcdesc) {
        this.jcdesc = jcdesc;
    } 
}
