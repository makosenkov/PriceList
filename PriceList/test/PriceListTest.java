import org.junit.Before;

import static org.junit.Assert.assertEquals;
/**
 * Created by Mikhail Kosenkov on 06.03.2017.
 * makosenkov@gmail.com
 * 13531/2 ИКНТ
 */
public class PriceListTest {
    PriceList priceList = new PriceList();

    String product1 = "Кактус";
    String product2 = "CD-диск Жока & Бока";
    String product3 = "Кофе Уругвай";
    String product4 = "Кекс-пекс";
    String product5 = "Шаурма сырный лаваш";
    String product6 = "Медвежьи пельмени";

    String price1 = "445.9";
    String price2 = "1599.99";
    String price3 = "195.34";
    String price4 = "45";

    long id1 = 1;
    long id2 = 2;
    long id3 = 3;
    long id4 = 4;
    long id5 = 5;

    @Before
    public void setup() {
        priceList.addProduct(id1, product1, price1);
        priceList.addProduct(id2, product2, price2);
        priceList.addProduct(id3, product3, price3);
        priceList.addProduct(id4, product4, price4);
    }

    @org.junit.Test
    public void getProduct() throws Exception {
        assertEquals(product1 + " - 445.99", priceList.getProduct(id1));
        assertEquals(product2 + " - 49.90", priceList.getProduct(id2));
        assertEquals(product3 + " - 15.50", priceList.getProduct(id3));
    }

    @org.junit.Test
    public void getProductPrice() throws Exception {

    }

    @org.junit.Test
    public void getProductName() throws Exception {

    }

    @org.junit.Test
    public void setProductName() throws Exception {

    }

    @org.junit.Test
    public void setProductPrice() throws Exception {

    }

    @org.junit.Test
    public void purchaseCost() throws Exception {

    }

}