package annawyszomirska.domain;

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
    private List <Meal> meals = new ArrayList();


    private double weight;
    private double height;
    private boolean isWomen;
    private int yearOfBirth;


    public Person(String name, String surname, List <Meal> meals, boolean isWomen, double height, double weight, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.meals = meals;
        this.isWomen = isWomen;
        this.height = height;
        this.weight = weight;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List <Meal> getMeals() {
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
        int age = 2018 - yearOfBirth;

        if (isWomen == true) {
            bmr = (9.99 * weight) + (6.25 * height) - (4.92 * age) - 161;
        } else if (isWomen == false) {
            bmr = (9.99 * weight) + (6.25 * height) - (4.92 * age) + 5;
        }

        return bmr;
    }


}
