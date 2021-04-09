package Alexander.demo.Model.Entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private int cost;

    @Column(length = 50)
    private String category;

    @Column(length = 255)
    private String productId;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String cat){
        this.category = cat;
    }

    public String getProductId(){
        return productId;
    }

    public void setProductId(String proID){
        this.productId = proID;
    }
}