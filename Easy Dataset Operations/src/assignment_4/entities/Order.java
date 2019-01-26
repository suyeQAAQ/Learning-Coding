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
public class Order {
    int orderId;
    int salespeopleId;
    int customerId;
    Item item;
    ArrayList<Item> orderItem;

    public Order(int orderId, int salespeopleId, int customerId, Item item) {
        this.orderId = orderId;
        this.salespeopleId = salespeopleId;
        this.customerId = customerId;
        this.item = item;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getsalespeopleId() {
        return salespeopleId;
    }

    public void setsalespeopleId(int salespeopleId) {
        this.salespeopleId = salespeopleId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ArrayList<Item> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(ArrayList<Item> orderItem) {
        this.orderItem = orderItem;
    }

    
    
    public Item newOrderItem(int itemId,int productId, int salesPrice, int quantity){
        Item i = new Item(itemId,productId, salesPrice, quantity);
        this.orderItem.add(i);
        return i;
    }
    
    public int getOrderTotal(){
        int sum = 0;
        for(Item i:this.orderItem){
            sum += i.getOrderItemTotal();
        }
        return sum;
    }
    
}
