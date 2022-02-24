/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

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

/**
 *
 * @author Nguemo Aymard
 */
@Path("applicantcontroller")
public class applicantController {
  @GET
    @Path("/listeapplicant")
    @Produces(("application/json"))
   public ArrayList <ModelJobSeeker> listeapplicant() throws Exception{
       ArrayList<ModelJobSeeker>listea = new ArrayList<>();
       try{
           Statement etat=com.connexion.connexion.seconnecter().createStatement();
           ResultSet rs =etat.executeQuery("select * from jobapplicant ");
           while(rs.next()){
               ModelJobSeeker oneuser = new ModelJobSeeker();
               oneuser.setApplicantid(rs.getInt("applicantid"));
               oneuser.setName(rs.getString("name"));
               oneuser.setEmail(rs.getString("email"));
               oneuser.setCity(rs.getString("city"));
               oneuser.setCountry(rs.getString("country"));
               
               oneuser.setPassword(rs.getString("password"));
               oneuser.setDob(rs.getTimestamp("dob"));
               oneuser.setStatus(rs.getString("status"));
               listea.add(oneuser);
           }
           etat.close();
           rs.close();
       }catch (Exception e){
           System.out.println("error on display"+e.getMessage());
       }
       return listea;
   }   
   @POST
    @Path("/applicant")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelJobSeeker createUser(ModelJobSeeker user){
        try {
            String sqlStatment= "Insert into jobapplicant (name,phone, email,password,dob,city,country,status) "+ "values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPhone());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setTimestamp(5, user.getDob());
            pstmt.setString(6, user.getCity());
            pstmt.setString(7, user.getCountry());
            pstmt.setString(8, user.getStatus());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
    @PUT
    @Path("/applicant/{applicantid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelJobSeeker updateUser(@PathParam("applicantid") int userid, ModelJobSeeker user){
        try {
           String sqlStatment= "update jobapplicant set name=?,phone=?, email=?,password=?,dob=?,city=?,country=?,status=? where applicantid =" + userid;
            PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment); 
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPhone());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setTimestamp(5, user.getDob());
            pstmt.setString(6, user.getCity());
            pstmt.setString(7, user.getCountry());
            pstmt.setString(8, user.getStatus());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
   
   @DELETE
    @Path("/jobapplicant/{applicantid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public String deleteUser(@PathParam("applicantid") int userid){
        try {
            String sqlStatment= "delete from jobapplicant where applicantid =" + userid;
             PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
             pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return "Deleted Successfully";
    }
}
