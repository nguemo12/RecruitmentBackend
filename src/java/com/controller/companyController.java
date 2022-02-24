
package com.controller;

import com.model.ModelJobSeeker;
import com.model.modelCompany;
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

@Path("companycontroller")
public class companyController {
     @GET
    @Path("/listecompany")
    @Produces(("application/json"))
   public ArrayList <modelCompany> listeapplicant() throws Exception{
       ArrayList<modelCompany>listecom = new ArrayList<>();
       try{
           Statement etat=com.connexion.connexion.seconnecter().createStatement();
           ResultSet rs =etat.executeQuery("select * from company ");
           while(rs.next()){
               modelCompany oneuser = new modelCompany();
               oneuser.setCompanyid(rs.getInt("companyid"));
               oneuser.setCompanyname(rs.getString("companyname"));
               oneuser.setCompanyemail(rs.getString("companyemail"));
               oneuser.setCompanycity(rs.getString("companycity"));
               oneuser.setCompanycountry(rs.getString("companycountry"));
               
               oneuser.setCompanypassword(rs.getString("companypassword"));
               oneuser.setCompanyphone(rs.getString("companyphone"));
               oneuser.setCompanydescription(rs.getString("compaydescription"));
               listecom.add(oneuser);
           }
           etat.close();
           rs.close();
       }catch (Exception e){
           System.out.println("error on display"+e.getMessage());
       }
       return listecom;
   }   
   @POST
    @Path("/company")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public modelCompany createUser(modelCompany user){
        try {
            String sqlStatment= "Insert into company (companyname,companyphone, companyemail,companypassword,companyImage,companycity,companycountry,companydescription) "+ "values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setString(1, user.getCompanyname());
            pstmt.setString(2, user.getCompanyphone());
            pstmt.setString(3, user.getCompanyemail());
            pstmt.setString(4, user.getCompanypassword());
            pstmt.setString(5, user.getCompanycity());
            pstmt.setString(6, user.getCompanycountry());
            pstmt.setString(7, user.getCompanyimage());
            pstmt.setString(8, user.getCompanydescription());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
    @PUT
    @Path("/company/{companyid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public modelCompany updateUser(@PathParam("companyid") int userid, modelCompany user){
        try {
           String sqlStatment= "update company set companyname,companyphone=?, companyemail=?,companypassword=?,companyImage=?,companycity=?,companycountry,companydescription=? where companyid =" + userid;
            PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment); 
         pstmt.setString(1, user.getCompanyname());
            pstmt.setString(2, user.getCompanyphone());
            pstmt.setString(3, user.getCompanyemail());
            pstmt.setString(4, user.getCompanypassword());
            pstmt.setString(5, user.getCompanycity());
            pstmt.setString(6, user.getCompanycountry());
            pstmt.setString(7, user.getCompanyimage());
            pstmt.setString(8, user.getCompanydescription());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
   
   @DELETE
    @Path("/company/{companyid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public String deleteUser(@PathParam("companyid") int userid){
        try {
            String sqlStatment= "delete from company where companyid =" + userid;
             PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
             pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return "Deleted Successfully";
    }
    
}
