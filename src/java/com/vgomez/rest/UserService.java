/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vgomez.rest;

import com.vgomez.bbdd.User;
import com.vgomez.bbdd.UserDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/users")
public class UserService {

    @GET
    @Path("/XML")
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<User> getUsersXML() {
        UserDAOImpl bd = new UserDAOImpl();
        ArrayList<User> al = null;
        try {
            al = bd.getUsers();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return al;
    }

    @GET
    @Path("/JSON")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUsersJSON() {
        UserDAOImpl bd = new UserDAOImpl();
        ArrayList<User> al = new ArrayList<>();
        try {
            al = bd.getUsers();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return al;
    }

    @GET
    @Path("/idXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public User getUsersbyIDXML(@PathParam("id") String id) {
        UserDAOImpl bd = new UserDAOImpl();
        User al = null;
        try {
            al = bd.getUserByID(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return al;
    }

    @GET
    @Path("/idJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUsersbyIDJSON(@PathParam("id") String id) {
        UserDAOImpl bd = new UserDAOImpl();
        User al = null;
        try {
            al = bd.getUserByID(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return al;
    }

    @GET
    @Path("/yearXML/{yearBirth}")
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<User> getUsersXML(@PathParam("yearBirth") int yearBirth) {
        UserDAOImpl bd = new UserDAOImpl();
        ArrayList<User> al = new ArrayList<>();
        try {
            al = bd.getUsersByYeartbirht(yearBirth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return al;
    }

    @GET
    @Path("/yearJSON/{yearBirth}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUsersJSON(@PathParam("yearBirth") int yearBirth) {
        UserDAOImpl bd = new UserDAOImpl();
        ArrayList<User> al = new ArrayList<>();
        try {
            al = bd.getUsersByYeartbirht(yearBirth);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return al;
    }

    @POST
    @Path("addUserXML")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public boolean addUserXML(User u) {
        UserDAOImpl bd = new UserDAOImpl();
        boolean t = false;
        try {
            t = bd.addUser(u);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return t;
    }

    @POST
    @Path("addUserJSON")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addUserJSON(User u) {
        UserDAOImpl bd = new UserDAOImpl();
        boolean t = false;
        try {
            t = bd.addUser(u);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return t;
    }
}
