import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Mikhail Kosenkov on 16.02.2017.
 * makosenkov@gmail.com
 * 13531/2 ИКНТ
 */
public final class PriceList {

    private Map<Long, Product> productMap = new HashMap<>();

    public void addProduct(long id, String name, String price) {
        if (price.contains("-")) throw new IllegalArgumentException();
        productMap.put(id, new Product(name, price));
    }

    public String getProduct(long id) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        return productMap.get(id).toString();
    }

    public String getProductPrice(long id) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        if (productMap.get(id).getPrice() == null) throw new IllegalStateException("The price of "
                + productMap.get(id).getName() + " is not set");
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

    public void setProductPrice(long id, String price) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        (productMap.get(id)).setPrice(price);
    }

    public void removeProduct(long id) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        productMap.remove(id);
    }

    public BigDecimal purchaseCost(long id, int number) {
        if (!productMap.containsKey(id)) throw new NoSuchElementException();
        return productMap.get(id).multiplication(number);
    }

    @Override
    public int hashCode() {
        return productMap.hashCode();
    }

    @Override
    public String toString() {
        return productMap.toString();
    }


    private static class Product {

        private String name;
        private BigDecimal price;

        Product(String name, String price) {
            this.name = name;
            this.price = strToBd(price);
        }

        private BigDecimal strToBd(String price){
            String[] newPrice = price.split("\\.");
            if (newPrice[1].length() > 2)throw new IllegalArgumentException("wrong format");
            if (newPrice.length < 2) price += ".00";
            if (newPrice[1].length() < 2) price += "0";
            return new BigDecimal(price);
            }

        private String getPrice(){
            return price.toString();
        }

        private String getName() {
            return name;
        }

        private void setPrice(String price){
            this.price = strToBd(price);
        }

        private void setName(String name) {
            this.name = name;
        }

        public BigDecimal multiplication(int number) {
            return price.multiply(new BigDecimal(number));
        }


        @Override
        public String toString() {
            if (this.price == null) return this.name + " " + "the price is not set";
            return this.name + "-" + this.price;
        }

        @Override
        public int hashCode() {
            return price.hashCode() * 13 + name.hashCode() * 31;
        }

        @Override
        public boolean equals(Object another){
            if (this == another) return true;
            if (another instanceof Product) {
                if (this.name.equals(((Product) another).name) &&
                        this.price.equals(((Product) another).price)) return true;
            }
            return false;
        }
    }


}
