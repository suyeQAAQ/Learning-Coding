/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4;

import Assignment_4Helper.Datastore;
import Assignment_4Helper.Helper;
import assignment_4.entities.Customer;
import assignment_4.entities.Item;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.ProductCatalog;
import java.io.IOException;
import java.util.Map;
import assignment_4.DataReader;

/**
 *
 * @author harshalneelkamal
 */
public class GateWay {
    DataReader productReader;
    DataReader customerReader;
    DataReader orderReader;
    Helper helper;
    
    public GateWay() throws IOException {
        DataGenerator datagenerator = DataGenerator.getInstance();
        orderReader = new DataReader(datagenerator.getOrderFilePath());
        productReader = new DataReader(datagenerator.getProductCataloguePath());
        helper = new Helper();
    }
    
    public static void main(String[] args) throws IOException {     
        GateWay inst = new GateWay();
        inst.readData();
    }
    
    private void readData() throws IOException{
        String[] row;
        while((row=productReader.getNextRow())!=null){
            generateProduct(row);
        }
        while((row=orderReader.getNextRow())!=null){
            Item item = generateItem(row);
            generateOrder(row,item);
        }
        
        runAnalysis();
    }
    
    private void generateProduct(String[] row){
        int productId = Integer.parseInt(row[0]);
        int min = Integer.parseInt(row[1]);
        int max = Integer.parseInt(row[2]);
        int target = Integer.parseInt(row[3]);
        Product p = new Product(productId,min,max,target);
        Datastore.getInstance().getProducts().put(productId, p);
    }
    
    private void generateOrder(String[] row,Item item){
        int orderId = Integer.parseInt(row[0]);
        int salesId = Integer.parseInt(row[4]);
        int customerId = Integer.parseInt(row[5]);
        Order o = new Order(orderId,salesId,customerId,item);
        Map<Integer,Order> orders = Datastore.getInstance().getOrders();
        Datastore.getInstance().getOrders().put(orderId, o);
    }
    
    private Item generateItem(String[] row){
        int itemId = Integer.parseInt(row[1]);
        int salesprice = Integer.parseInt(row[6]);
        int productId = Integer.parseInt(row[2]);
        int quantity = Integer.parseInt(row[3]);
        Item i = new Item(itemId,productId,salesprice,quantity);
        return i;
    }

    private void runAnalysis() {
        helper.topThreePopularProducts();
        helper.threebestcustomers();
        helper.topthreesalespeople();
        helper.totalRevenue();
    }
}
