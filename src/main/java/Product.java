import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private String name;
    private int price;
    static List<Product> prdList;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.prdList = new ArrayList<>(100);
    }

    public static List<Product> getPrdList() {
        return prdList;
    }

    public static void setPrdList(List<Product> prdList) {
        Product.prdList = prdList;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
