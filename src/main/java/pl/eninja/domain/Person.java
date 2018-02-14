package pl.eninja.domain;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Opis osoby, na który składa się: imię i nazwisko, lista posiłków tej osoby
 * <p>
 * oprócz tego potrzebne są dane o wadze, wzroście, płci i roku urodzenia każdej osoby
 **/

public class Person {

    private int actualYear = ZonedDateTime.now(ZoneId.of("Europe/Warsaw")).getYear();
    private String name;
    private String surname;
    private List<Meal> meals = new ArrayList();
    private double weight;
    private double height;
    private boolean isWomen;
    private int yearOfBirth;

    public Person(String name, String surname, List<Meal> meals, boolean isWomen, double height, double weight, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.meals = meals;
        this.weight = weight;
        this.height = height;
        this.isWomen = isWomen;
        this.yearOfBirth = yearOfBirth;
    }

    public int getActualYear() {
        return actualYear;
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

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isWomen() {
        return isWomen;
    }

    public void setWomen(boolean women) {
        isWomen = women;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
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
            bmr = (9.99 * getWeight()) + (6.25 * getHeight()) - 4.92 * (2018 - getYearOfBirth()) - 161;

        } else {
            bmr = (9.99 * getWeight()) + (6.25 * getHeight()) - 4.92 * (2018 - getYearOfBirth()) + 5;
        }


        return bmr;
    }


}
