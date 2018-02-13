package marcinwrobel.domain;

import java.util.ArrayList;
import java.util.List;

/*
danie przygotowuje się ze składników (produktów); np, sałatka pomidorowa zawiera pomidory i sos winegret;
 kubek kakao robi się z mleka, kakao i cukru
 */
public class Dish {

    private String name;
    private List<Product> products = new ArrayList<Product>();

    public Dish(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
