/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_4Helper;

import assignment_4.entities.Customer;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.SalesPerson;
import java.util.HashMap;
import java.util.Map;
import assignment_4.DataGenerator;
import assignment_4.entities.Item;
import assignment_4.entities.ProductCatalog;

/**
 *
 * @author 帅的一匹
 */
public class Datastore {
    private static Datastore datastore;
    
    Map<Integer,Product> products;
    Map<Integer,Order> orders;
    Map<Integer,SalesPerson> salespersons;
    Map<Integer,Customer> customers;

    public Map<Integer, Item> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Item> items) {
        this.items = items;
    }
    Map<Integer,Item> items;

    private Datastore(){
        products = new HashMap<>();
        orders = new HashMap<>();
        salespersons = new HashMap<>();
        customers = new HashMap<>();
        items=new HashMap<>();
    }
    
    public static Datastore getInstance(){
        if(datastore == null){
            datastore = new Datastore();
        }
        return datastore;
    }
    
    public static Datastore getDatastore() {
        return datastore;
    }

    public static void setDatastore(Datastore datastore) {
        Datastore.datastore = datastore;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    public Map<Integer, SalesPerson> getSalespersons() {
        return salespersons;
    }

    public void setSalespersons(Map<Integer, SalesPerson> salespersons) {
        this.salespersons = salespersons;
    }

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Map<Integer, Customer> customers) {
        this.customers = customers;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }
    
    
}
