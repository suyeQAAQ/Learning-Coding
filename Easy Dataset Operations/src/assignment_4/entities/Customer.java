/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.entities;

import java.util.ArrayList;

/**
 *
 * @author harshalneelkamal
 */
public class Customer {
    private String name;
    private String address;
    private ArrayList<Order> orderlist;
    
    public Customer(){
        this.orderlist = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Order> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(ArrayList<Order> orderlist) {
        this.orderlist = orderlist;
    }
    
    public int getTotalRevenue(){
        int revenue = 0;
        for(Order o:this.orderlist){
            revenue += o.getOrderTotal();
        }
        return revenue;
    }
}
