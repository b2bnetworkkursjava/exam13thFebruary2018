package pl.b2bnetwork.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Opis osoby, na który składa się: imię i nazwisko, lista posiłków tej osoby
 *
 * oprócz tego potrzebne są dane o wadze, wzroście, płci i roku urodzenia każdej osoby
 *
 **/

public class Person {

    public static final double PARAMETER = 9.99;
    public static final double PARAMETER_2 = 6.25;
    public static final double PARAMETER_3 = 4.92;
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
     *
     */

    /*
   Dla kobiety
BMR = (9,99 x waga (kg)) + (6,25 x wzrost (cm)) – (4,92 x wiek) – 161
Dla mężczyzny
BMR = (9,99 x waga (kg)) + (6,25 x wzrost (cm)) – (4,92 x wiek) + 5
    */
    public double calculateBMR() {
        double bmr = 0;
        double parameter = PARAMETER;
        double parameter2= PARAMETER_2;
        double parameter3= PARAMETER_3;
        //dla kobiet
        if (isWomen() == true) {
            bmr=(parameter*getWeight())+ (parameter2*getHeight())- (parameter3*getYearOfBirth()) -161;
        }
        //dla mężczyzn
        else {
            bmr=(parameter*getWeight())+ (parameter2*getHeight())- (parameter3*getYearOfBirth()) +5;
        }

        return bmr;
    }


}
