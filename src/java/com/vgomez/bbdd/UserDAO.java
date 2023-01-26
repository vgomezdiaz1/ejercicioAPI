/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vgomez.bbdd;

import java.util.ArrayList;

public interface UserDAO {
    
    public ArrayList<User> getUsers() throws Exception;
    public User getUserByID(String id) throws Exception;
    public ArrayList<User> getUsersByYeartbirht(int year) throws Exception;
    public boolean addUser(User u)throws Exception;
}
