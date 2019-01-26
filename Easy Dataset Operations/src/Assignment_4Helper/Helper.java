/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_4Helper;

import assignment_4.entities.Customer;
import assignment_4.entities.Item;
import assignment_4.entities.Order;
import assignment_4.entities.Product;
import assignment_4.entities.SalesPerson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author 帅的一匹
 */
public class Helper {
    
    public void topThreePopularProducts(){
        Map<Integer,Order> orders = Datastore.getInstance().getOrders();
        Map<Integer,Integer> productCount = new HashMap<>();
        for(Order o : orders.values()){
            int sum = 0;
            if(productCount.containsKey(o.getItem().getProductId())){
                sum += productCount.get(o.getItem().getProductId());
            }
            sum += o.getItem().getQuantity()*o.getItem().getSalesPrice();
            productCount.put(o.getItem().getProductId(),o.getItem().getQuantity()*o.getItem().getSalesPrice());
        }
        
        ArrayList<Integer> top = new ArrayList<>();
        for(int i=0;i<3;i++){
            int max = 0;
            int maxid = 0;
            for(int k:productCount.keySet()){
            if(productCount.get(k)>max){
                max = productCount.get(k);
                maxid = k;
            }
        }
            top.add(maxid);
            productCount.put(maxid, 0);
        }
        
        System.out.println("The top three popular products are:" + top.get(0)+","+top.get(1)+","+top.get(2));
    }
    
    public void threebestcustomers(){
        Map<Integer,Order> orders = Datastore.getInstance().getOrders();
        Map<Integer,Customer> customer=Datastore.getInstance().getCustomers();
        Map<Integer,Integer> customercount = new HashMap<>();
        Hashtable<Integer,Integer> t= new Hashtable<>();
            for(Order o:orders.values())  t.put(o.getCustomerId(), t.containsKey(o.getCustomerId())?t.get(o.getCustomerId())+1:1);
            for(Entry<Integer, Integer> e:t.entrySet()) 
            customercount.put(e.getKey(), e.getValue());
        List<Map.Entry<Integer, Integer>> customerlist = new ArrayList<Map.Entry<Integer, Integer>>(customercount.entrySet());
        Collections.sort(customerlist,new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println();
        System.out.println("The id of best 3 customers are:");
        
        for(int i=0;i<=2;i++){
            System.out.println(customerlist.get(i).getKey());
        }
    }
    
    public void topthreesalespeople(){
        Map<Integer,Order> orders = Datastore.getInstance().getOrders();
        Map<Integer,SalesPerson> sale=Datastore.getInstance().getSalespersons();
        Map<Integer,Integer> salecount = new HashMap<>();
        Hashtable<Integer,Integer> t= new Hashtable<>();
            for(Order o:orders.values())  t.put(o.getsalespeopleId(), t.containsKey(o.getsalespeopleId())?t.get(o.getsalespeopleId())+1:1);
            for(Entry<Integer, Integer> e:t.entrySet()) 
            salecount.put(e.getKey(), e.getValue());
        int count=0;
        List<Map.Entry<Integer, Integer>> salelist = new ArrayList<Map.Entry<Integer, Integer>>(salecount.entrySet());
        Collections.sort(salelist,new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        
        System.out.println("The id of best 3 salepeople are:");
        for(int i=0;i<=2;i++){
            System.out.println(salelist.get(i).getKey());
        }
    }
   
     public void totalRevenue()
     {
         Map<Integer,Order> order=Datastore.getInstance().getOrders();
         Map<Integer,Product> products=Datastore.getInstance().getProducts();
         int yearlyRevenue=0;
         for(Order o: order.values())
         {
             int revenue=0;
             for(Product p: products.values())
             {
                 if(p.getProductId()==o.getItem().getProductId())
                 {
                     revenue+=(((o.getItem().getSalesPrice())-(p.getMin()))*(o.getItem().getQuantity())); 
                 }      
             }
             yearlyRevenue+=revenue;   
         }
         System.out.println("Total revenue is: "+yearlyRevenue);
     }
     
     

}

