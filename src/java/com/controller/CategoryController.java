
package com.controller;

import com.model.ModelCategory;
import com.model.ModelJobSeeker;
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


@Path("categorycontroller")
public class CategoryController {
     @GET
    @Path("/listecategory")
    @Produces(("application/json"))
   public ArrayList <ModelCategory> listecategory() throws Exception{
       ArrayList<ModelCategory>listec = new ArrayList<>();
       try{
           Statement etat=com.connexion.connexion.seconnecter().createStatement();
           ResultSet rs =etat.executeQuery("select * from jobcategory ");
           while(rs.next()){
               ModelCategory oneuser = new ModelCategory();
               oneuser.setJobcategory_id(rs.getInt("jobcategoryid"));
               oneuser.setJcname(rs.getString("jcname"));
               oneuser.setJcdesc(rs.getString("jcdesc"));
               listec.add(oneuser);
           }
           etat.close();
           rs.close();
       }catch (Exception e){
           System.out.println("error on display"+e.getMessage());
       }
       return listec;
   }   
   @POST
    @Path("/category")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelCategory createUser(ModelCategory user){
        try {
            String sqlStatment= "Insert into jobapplicant (jcname,jcdesc) "+ "values (?,?)";
            PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setString(1, user.getJcname());
            pstmt.setString(2, user.getJcdesc());
          
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
    @PUT
    @Path("/Category/{jobcategoryid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelCategory updateUser(@PathParam("jobcategoryid") int userid, ModelCategory user){
        try {
           String sqlStatment= "update jobcategory set jcname=?,jcdesc=? where jobcategoryid =" + userid;
            
          PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setString(1, user.getJcname());
            pstmt.setString(2, user.getJcdesc());
          
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
   
   @DELETE
    @Path("/jobcategory/{jobcategoryid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public String deleteUser(@PathParam("jobcategoryid") int userid){
        try {
            String sqlStatment= "delete from jobcategory where jobcategoryid =" + userid;
             PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
             pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return "Deleted Successfully";
    }
    
}
