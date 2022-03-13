/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ListProduct;

/**
 *
 * @author FSC
 */
public class ProductDao {
    public List<ListProduct> getAllListProduct() throws SQLException {
        List<ListProduct> listProducts = new ArrayList<ListProduct>();
        String sql = "select * from Product";
        try {
            Connection connection = JDBCConnection.JDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ListProduct listProduct = new ListProduct();
                listProduct.setIdSP(rs.getInt("idSP"));
                listProduct.setTenSp(rs.getString("TenSP"));
                listProduct.setSoLuong(rs.getInt("SoLuong"));
                listProduct.setGiaTien(rs.getDouble("GiaTien"));
                listProducts.add(listProduct);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listProducts;
    }

    public void addListProduct(ListProduct listProduct) throws SQLException {

        try {
            Connection connection = JDBCConnection.JDBCConnection();
            String sql = "insert into Product (TenSP, SoLuong, GiaTien) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, listProduct.getTenSp());
            preparedStatement.setInt(2, listProduct.getSoLuong());
            preparedStatement.setDouble(3, listProduct.getGiaTien());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateListProduct(ListProduct listProduct) throws SQLException {
        Connection connection = JDBCConnection.JDBCConnection();
        String sql = "Update Product set TenSP = ? , SoLuong = ? , GiaTien = ? where idSP=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, listProduct.getTenSp());
            preparedStatement.setInt(2, listProduct.getSoLuong());
            preparedStatement.setDouble(3, listProduct.getGiaTien());
            preparedStatement.setInt(4, listProduct.getIdSP());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteListProduct(int id) throws SQLException {
        Connection connection = JDBCConnection.JDBCConnection();
        String sql = "delete from Product where idSP = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ListProduct getProductById(int id) throws SQLException {
        Connection connection = JDBCConnection.JDBCConnection();
        String sql = "select * from Product where idSP=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ListProduct listProduct = new ListProduct();
                listProduct.setIdSP(rs.getInt("idSP"));
                listProduct.setTenSp(rs.getString("TenSP"));
                listProduct.setSoLuong(rs.getInt("SoLuong"));
                listProduct.setGiaTien(rs.getDouble("GiaTien"));
                
                return listProduct;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
