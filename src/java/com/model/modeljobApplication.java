
package com.model;

import java.sql.Timestamp;

public class modeljobApplication {
    private int jobappid;
    private ModelJobSeeker applicantid;
    private String jobapptitle;
    private String jobappcv;
    private String jobappletter;
    private Timestamp jobappdate;
    private String jobappdocs;

    public int getJobappid() {
        return jobappid;
    }

    public void setJobappid(int jobappid) {
        this.jobappid = jobappid;
    }

    public ModelJobSeeker getApplicantid() {
        return applicantid;
    }

    public void setApplicantid(ModelJobSeeker applicantid) {
        this.applicantid = applicantid;
    }

    public String getJobapptitle() {
        return jobapptitle;
    }

    public void setJobapptitle(String jobapptitle) {
        this.jobapptitle = jobapptitle;
    }

    public String getJobappcv() {
        return jobappcv;
    }

    public void setJobappcv(String jobappcv) {
        this.jobappcv = jobappcv;
    }

    public String getJobappletter() {
        return jobappletter;
    }

    public void setJobappletter(String jobappletter) {
        this.jobappletter = jobappletter;
    }

    public Timestamp getJobappdate() {
        return jobappdate;
    }

    public void setJobappdate(Timestamp jobappdate) {
        this.jobappdate = jobappdate;
    }

  

    public String getJobappdocs() {
        return jobappdocs;
    }

    public void setJobappdocs(String jobappdocs) {
        this.jobappdocs = jobappdocs;
    }
    
    
}
