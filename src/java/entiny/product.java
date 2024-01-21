/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entiny;

import java.util.List;

/**
 *
 * @author uusiu
 */
public class product {

    private int id;
    private String name;
    private String image;
    private double price;
     private String cateid;
    private String describe;
   

    public product() {
    }

    public product(int id, String name, String image, double price, String cateid, String describe) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.cateid = cateid;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "product{" + "id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", cateid=" + cateid + ", describe=" + describe + '}';
    }

    
    
    
    
}
