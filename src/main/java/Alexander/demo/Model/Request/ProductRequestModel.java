package Alexander.demo.Model.Request;

public class ProductRequestModel {
    
    private String name;

    private int cost;

    private String category;

    private String productId;

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

    public void setProductId(String productId){
        this.productId = productId;
    }
}