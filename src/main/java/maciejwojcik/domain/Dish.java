package maciejwojcik.domain;

import java.util.ArrayList;
import java.util.List;

/*
danie przygotowuje się ze składników (produktów); np, sałatka pomidorowa zawiera pomidory i sos winegret;
 kubek kakao robi się z mleka, kakao i cukru
 */
public class Dish {

    private String nazwa;
    private List<Product> products = new ArrayList<Product>();

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Dish(String nazwa, List<Product> products) {
        this.nazwa = nazwa;
        this.products = products;
    }

}
