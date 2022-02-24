
package com.controller;

import com.model.ModelCategory;
import com.model.ModelOffer;
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

@Path("offercontroller")
public class OfferController {
    @GET
    @Path("/listeoffer")
    @Produces(("application/json"))
   public ArrayList <ModelOffer> listecategory() throws Exception{
       ArrayList<ModelOffer>listeo = new ArrayList<>();
       try{
           Statement etat=com.connexion.connexion.seconnecter().createStatement();
           ResultSet rs =etat.executeQuery("select * from joboffer ");
           while(rs.next()){
               ModelOffer oneuser = new ModelOffer();
               oneuser.setJobofferid(rs.getInt("jobofferid"));
               oneuser.setOffername(rs.getString("offername"));
               oneuser.setJobofferimage(rs.getString("jobofferimage"));
               oneuser.setDescription(rs.getString("description"));
               oneuser.setStatus(rs.getString("status"));
               listeo.add(oneuser);
           }
           etat.close();
           rs.close();
       }catch (Exception e){
           System.out.println("error on display"+e.getMessage());
       }
       return listeo;
   }   
   @POST
    @Path("/joboffer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelOffer createUser(ModelOffer user){
        try {
            String sqlStatment= "Insert into joboffer (offername,jobofferImage,description,status) "+ "values (?,?,?,?)";
            PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setString(1, user.getOffername());
            pstmt.setString(2, user.getJobofferimage());
          pstmt.setString(3, user.getDescription());
          pstmt.setString(4, user.getStatus());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
    @PUT
    @Path("/joboffer/{jobofferid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public ModelOffer updateUser(@PathParam("jobofferid") int userid, ModelOffer user){
        try {
           String sqlStatment= "update joboffer set offername=?,jobofferImage=?,descriprion=?,status=? where jobcategoryid =" + userid;
            
          PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
            pstmt.setString(1, user.getOffername());
            pstmt.setString(2, user.getJobofferimage());
          pstmt.setString(3, user.getDescription());
          pstmt.setString(4, user.getStatus());
          
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return user;
    }
    
   
   @DELETE
    @Path("/joboffer/{jobofferid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({"application/json"})
    public String deleteUser(@PathParam("jobofferid") int userid){
        try {
            String sqlStatment= "delete from joboffer where jobofferid =" + userid;
             PreparedStatement pstmt = com.connexion.connexion.seconnecter().prepareStatement(sqlStatment);
             pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("error in querry" + e.getMessage());
        }
        return "Deleted Successfully";
    }
    
}
