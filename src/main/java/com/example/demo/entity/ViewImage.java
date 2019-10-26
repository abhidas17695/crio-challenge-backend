package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class ViewImage {
    private String data;
    private String orderId;
    private String text;

    public ViewImage(String data, String orderId, String text) {
        this.data = data;
        this.orderId = orderId;
        this.text = text;
    }

    public ViewImage() {
        this.data = "";
        this.orderId = "";
        this.text = "";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
