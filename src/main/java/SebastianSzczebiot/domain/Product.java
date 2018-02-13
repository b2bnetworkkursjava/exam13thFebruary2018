package SebastianSzczebiot.domain;

/**
 * Opis produktu, z którego składa się dana potrawa
 *
 * dla uproszczenia: produkt ma nazwę, liczbę kcal oraz cenę
 * nie przeliczamy miary, wagi
 *
 * przykład: pomidor, 17 kcal, 2 zł
 *
 */
public class Product {
    private String name;
    private int kcal;
    private double price;

    public Product(String mleko, int i, int i1) {
        name=mleko;
        kcal=i;
        price=i1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
