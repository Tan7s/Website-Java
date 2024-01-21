/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entiny;

/**
 *
 * @author nom
 */
public class menu {
    private int id;
    private String name;
    private String meta;
    private String link;
    

    public menu() {
    }

    public menu(int id, String name, String meta, String link) {
        this.id = id;
        this.name = name;
        this.meta = meta;
        this.link = link;
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

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "menu{" + "id=" + id + ", name=" + name + ", meta=" + meta + ", link=" + link + '}';
    }

   

    
    
}
