/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entiny.Account;

import entiny.category;
import entiny.menu;
import entiny.product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.apache.tomcat.jni.User.username;

/**
 *
 * @author uusiu
 */
public class dao {

    //ket noi voi sql sever
    Connection conn = null;

    // nem cao query sang sql sever
    PreparedStatement ps = null;

    // nhan ket qua tra ve
    ResultSet rs = null;

    // lay tat ca cac san pham trong bang product
    public List<product> getAllProduct() {
        List<product> List = new ArrayList<>();
        String query = "Select * from product";
        try {
            conn = new DBContext().getConnection(); // mo ket noi voi SQL SEVER
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                List.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {

        }
        return List;
    }

    public List<category> getAllCategory() {
        List<category> List = new ArrayList<>();
        String query = "Select * from category";
        try {
            conn = new DBContext().getConnection(); // mo ket noi voi SQL SEVER
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                List.add(new category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {

        }
        return List;
    }

    public List<product> getProductByCID(String cid) {
        List<product> List = new ArrayList<>();
        String query = "SELECT * FROM product where cateid = ?";
        try {
            conn = new DBContext().getConnection(); // mo ket noi voi SQL SEVER
            ps = conn.prepareStatement(query);

            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                List.add(new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {

        }
        return List;
    }

    public product getProductByID(String id) {
        String query = "SELECT * FROM product where id = ?";
        try {
            conn = new DBContext().getConnection(); // mo ket noi voi SQL SEVER
            ps = conn.prepareStatement(query);

            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Account login(String username, String password) {
        String query = " SELECT * FROM Users where username = ? and password = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account checkaccount(String username) {
        String query = " SELECT * FROM Users where username = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void signup(String username, String password) {
        String query = " Insert into Users (username,password,type) values (?,?,1)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<menu> getAllMenu() {
        List<menu> List = new ArrayList<>();
        String query = "Select * from menu";
        try {
            conn = new DBContext().getConnection(); // mo ket noi voi SQL SEVER
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                List.add(new menu(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {

        }
        return List;
    }

    public void deleteProduct(String pid) {
        String query = "delete from product where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int insertProduct(String name, String image, String price, String descr, String cate) {
        String query = "INSERT INTO product (name, image, price, description, cateid) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, descr);
            ps.setString(5, cate);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int updateProduct(int productId, String name, String image, String price, String descr, String cate) {
        String query = "UPDATE product SET name = ?, image = ?, price = ?, description = ?, cateid = ? WHERE id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, descr);
            ps.setString(5, cate);
            ps.setInt(6, productId);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng kết nối và tài nguyên
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

//UPDATE product SET name = ?, image = ?, price = ?, cateid = ?, description = ? where id = ?;
//    public static void main(String[] args) 
//        dao db = new dao();
//        List<product> List = db.getAllProduct();
//        for (product o : List) {
//            System.out.println(o);
//        }
//    }
}
