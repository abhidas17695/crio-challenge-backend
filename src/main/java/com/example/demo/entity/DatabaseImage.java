package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class DatabaseImage {
    @Id
    private String orderId;
    private String text;


    public DatabaseImage(String text, String orderId) {
        this.text = text;
        this.orderId = orderId;
    }

    public DatabaseImage() {
        this.text = "";
        this.orderId = "";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
