package pl.b2bnetwork.domain;

import java.util.ArrayList;
import java.util.List;

/*
danie przygotowuje się ze składników (produktów); np, sałatka pomidorowa zawiera pomidory i sos winegret;
 kubek kakao robi się z mleka, kakao i cukru
 */
public class Dish {

    private String nazwa;
    private List<Product> products = new ArrayList<Product>();

}
