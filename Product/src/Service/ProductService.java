/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import dao.JDBCConnection;
import dao.ProductDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author FSC
 */
import model.ListProduct;
public class ProductService {
    private ProductDao productDao;

    public ProductService() {
        productDao = new ProductDao();
    }

    public  List<ListProduct> getAllListProduct() throws SQLException{
        return productDao.getAllListProduct();
    }
    
    public void addProduct(ListProduct product) throws SQLException{
        productDao.addListProduct(product);
    }
    
    public void deleteProduct(int id) throws SQLException {
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
    
    public void updateProduct(ListProduct product) throws SQLException{
        
        productDao.updateListProduct(product);
    }
    
    public ListProduct getProductById(int id) throws SQLException{
        return productDao.getProductById(id);
    }
}
