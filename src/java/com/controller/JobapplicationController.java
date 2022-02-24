
package com.controller;

import com.model.ModelCategory;
import com.model.modeljobApplication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("jobapplicationcontroller")
public class JobapplicationController {
     @GET
    @Path("/listeapply")
    @Produces(("application/json"))
   public ArrayList <modeljobApplication> listecategory() throws Exception{
       ArrayList<modeljobApplication>listeapp = new ArrayList<>();
       try{
           Statement etat=com.connexion.connexion.seconnecter().createStatement();
           ResultSet rs =etat.executeQuery("select * from jobapplication ");
           while(rs.next()){
               modeljobApplication oneuser = new modeljobApplication();
               oneuser.setJobappid(rs.getInt("jobappid"));
               oneuser.setJobapptitle(rs.getString("jobapptitle"));
               oneuser.setJobappcv(rs.getString("jobappcv"));
               oneuser.setJobappletter(rs.getString("jobappletter"));
               oneuser.setJobappdate(rs.getTimestamp("jobappdate"));
               oneuser.setJobappdocs(rs.getString("jobappdocs"));
               listeapp.add(oneuser);
           }
           etat.close();
           rs.close();
       }catch (Exception e){
           System.out.println("error on display"+e.getMessage());
       }
       return listeapp;
   }   
   @POST
    @Path("/jobapply")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public modeljobApplication createUser(modeljobApplication user){
        try {
            String sqlStatment= "Insert into jobapplication (jobapptitle,jobappcv,jobappletter,jobappdate,jobappdocs) "+ "values (?,?,?,?,?)";
            PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setString(1, user.getJobapptitle());
            pstmt.setString(2, user.getJobappcv());
             pstmt.setString(3, user.getJobappletter());
             pstmt.setTimestamp(4,user.getJobappdate());
              pstmt.setString(5, user.getJobappdocs());
          
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
    @PUT
    @Path("/apply/{jobapplicationid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public modeljobApplication updateUser(@PathParam("jobapplicationid") int userid, modeljobApplication user){
        try {
           String sqlStatment= "update jobapplication set jobapptitle=?,jobappcv=?,jobappletter=?,jobappdate=?,jobappdocs=? where jobapplicationid =" + userid;
            
          PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
             pstmt.setString(1, user.getJobapptitle());
            pstmt.setString(2, user.getJobappcv());
             pstmt.setString(3, user.getJobappletter());
             pstmt.setTimestamp(4,user.getJobappdate());
              pstmt.setString(5, user.getJobappdocs());
          
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
   
   @DELETE
    @Path("/apply/{jobapplicationid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public String deleteUser(@PathParam("jobapplicationid") int userid){
        try {
            String sqlStatment= "delete from jobapplication where jobapplicationid =" + userid;
             PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
             pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return "Deleted Successfully";
    }
}
