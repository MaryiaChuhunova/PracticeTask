package bean;

/**
 * Created by Maria on 31.03.2017.
 */
public class Product {

    private Integer id;
    private String name;
    private Double price;

    public Product() {}

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasEmptyFields() {
        if((name == "") || (price == 0)) {
            return true;
        }
        return false;
    }
}
