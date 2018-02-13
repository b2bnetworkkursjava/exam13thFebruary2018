package marcinwrobel.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Opis osoby, na który składa się: imię i nazwisko, lista posiłków tej osoby
 * <p>
 * oprócz tego potrzebne są dane o wadze, wzroście, płci i roku urodzenia każdej osoby
 **/

public class Person {

    private String name;
    private String surname;
    private List<Meal> meals = new ArrayList();

    private double weight;
    private double height;
    private boolean isWomen;
    private int yearOfBirth;

    public Person(String name, String surname, List<Meal> meals, boolean isWoman, double height, double weight, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.meals = meals;
        this.isWomen = isWoman;
        this.weight = weight;
        this.height = height;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public boolean isWomen() {
        return isWomen;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * Oblicz Parametr Zapotrzebowania Kalorycznego = Basal Metabolic Rate (BMR) dla podanej osoby
     */
    /*
   Dla kobiety
BMR = (9,99 x waga (kg)) + (6,25 x wzrost (cm)) – (4,92 x wiek) – 161
Dla mężczyzny
BMR = (9,99 x waga (kg)) + (6,25 x wzrost (cm)) – (4,92 x wiek) + 5
    */
    public double calculateBMR() {
        double bmr = 0;
        if (isWomen) {
            bmr = (9.99 * getWeight()) + (6.25 * getHeight()) - (4.92 * (2018 - getYearOfBirth())) - 161;
        } else {
            bmr = (9.99 * getWeight()) + (6.25 * getHeight()) - (4.92 * (2018 - getYearOfBirth())) + 5;
        }
        return bmr;
    }
}
