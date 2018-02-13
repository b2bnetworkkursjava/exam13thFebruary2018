package marcinwrobel.domain;

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

    public Product(String name, int kcal, double price) {
    }
}
