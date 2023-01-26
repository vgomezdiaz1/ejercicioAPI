/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vgomez.bbdd;

import java.sql.*;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO{

    String URL = "";
    Connection cn = null;
    
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public UserDAOImpl() {
        try {
            this.URL = "jdbc:sqlite:/home/dev/NetBeansProjects/Test/bbdd.db";
            cn = DriverManager.getConnection(URL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getUsers() throws Exception{
        ArrayList<User> al = new ArrayList<>();
        Statement st = null;
        try (PreparedStatement stmt = cn.prepareStatement("SELECT * FROM users")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String rol = rs.getString("rol");
                int year = rs.getInt("yearBirth");
                al.add(new User(id, name, rol, year));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new Exception("Error en la devolucion");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                throw new Exception("Error al cerrar la conexion");
            }
        }
        return al;
    }

    @Override
    public User getUserByID(String id) throws Exception{
        User al = null;
        Statement st = null;
        try (PreparedStatement stmt = cn.prepareStatement("SELECT * FROM users where ID = ?")) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String iden = rs.getString("id");
                String name = rs.getString("name");
                String rol = rs.getString("rol");
                int year = rs.getInt("yearBirth");
                al = new User(iden, name, rol, year);
            }
        } catch (SQLException sqle) {
            throw new Exception("Error en la devolucion");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                throw new Exception("Error al cerrar la conexion");
            }
        }
        return al;
    }

    @Override
    public ArrayList<User> getUsersByYeartbirht(int year) throws Exception{
        ArrayList<User> al = new ArrayList<>();
        Statement st = null;
        try (PreparedStatement stmt = cn.prepareStatement("SELECT * FROM users where yearBirth = ?")) {
            stmt.setInt(1, year);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String iden = rs.getString("id");
                String name = rs.getString("name");
                String rol = rs.getString("rol");
                int ye = rs.getInt("yearBirth");
                al.add(new User(iden, name, rol, ye));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new Exception("Error en la devolucion");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                throw new Exception("Error al cerrar la conexion");
            }
        }
        return al;
    }

    @Override
    public boolean addUser(User u) throws Exception{
        boolean hecho = false;
        try (PreparedStatement stmt = cn.prepareStatement("Insert into users (name,rol,yearBirth)values (?,?,?)")) {
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getRol());
            stmt.setInt(3, u.getYearBirth());
            stmt.execute();
            System.out.println("pasado");
            hecho = true;
        } catch (Exception sqle) {
            throw new Exception("Error al insertar datos");
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
                throw new Exception("Error al cerrar la conexion");
            }
        }
        return hecho;
    }
}
