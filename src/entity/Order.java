/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author Dat
 */
public class Order {
    private String customerName;
    private ArrayList<Fruit> listOfItemBought;

    public Order() {
    }

    public Order(String customerNameString, ArrayList<Fruit> listOfItemBought) {
        this.customerName = customerNameString;
        this.listOfItemBought = listOfItemBought;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerNameString) {
        this.customerName = customerNameString;
    }

    public ArrayList<Fruit> getListOfItemBought() {
        return listOfItemBought;
    }

    public void setListOfItemBought(ArrayList<Fruit> listOfItemBought) {
        this.listOfItemBought = listOfItemBought;
    }

    
    
}
