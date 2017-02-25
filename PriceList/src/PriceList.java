import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Created by Mikhail Kosenkov on 16.02.2017.
 * makosenkov@gmail.com
 * 13531/2 ИКНТ
 */
public final class PriceList {

    private Map<Long, Product> productMap = new HashMap<>();

    public void addProduct(long id, String name, Double price) {
        if (price < 0) throw new IllegalArgumentException();
        productMap.put(id, new Product(name, price));
    }

    public String getProduct(long id) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        return productMap.get(id).toString();
    }

    public double getProductPrice(long id) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        if (productMap.get(id).getPrice() == null) throw new IllegalStateException("Цена "
                + productMap.get(id).getName() + " не указана");
        return (productMap.get(id)).getPrice();
    }

    public String getProductName(long id) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        return productMap.get(id).getName();
    }

    public void setProductName(long id, String name) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        (productMap.get(id)).setName(name);
    }

    public void setProductPrice(long id, Double price) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        (productMap.get(id)).setPrice(price);
    }

    public void removeProduct(long id) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        productMap.remove(id);
    }

    public double purchaseCost(long id, int number) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        double cost = 0;
        for (int i = 0; i < number; i++){
            cost += getProductPrice(id);
        }
        return cost;
    }


    public class Product {

        private String name;
        private Double price;

        Product(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        private String getName() {
            return name;
        }

        private Double getPrice() {
            return price;
        }

        private void setName(String name) {
            this.name = name;
        }

        private void setPrice(Double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            if (this.price == null) return this.name + " " + "цена не указана";
            return this.name + " " + this.price;
        }
    }
}
