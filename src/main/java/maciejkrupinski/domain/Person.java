package maciejkrupinski.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Opis osoby, na który składa się: imię i nazwisko, lista posiłków tej osoby
 *
 * oprócz tego potrzebne są dane o wadze, wzroście, płci i roku urodzenia każdej osoby
 *
 **/

public class Person {

    private String name;
    private String surname;
    private List<Meal> meals = new ArrayList();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
    public Person(String name, String surname, List<Meal> meals,boolean isWomen , double height,  double weight, int yearOfBirth){
        this.name=name;
        this.surname=surname;
        this.meals=meals;
        this.isWomen=isWomen;

        this.height=height;

        this.weight=weight;
        this.yearOfBirth=yearOfBirth;
    }
    private double weight;
    private double height;
    private boolean isWomen;
    private int yearOfBirth;

    public void setWomen(boolean women) {
        isWomen = women;
    }

    public boolean isWomen() {
        return isWomen;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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
        if(isWomen==true){
            bmr=(9.99*weight)+(6.25*height)-(4.92*(2018-yearOfBirth))-161;
        }
        else{
            bmr=(9.99*weight)+(6.25*height)-(4.92*(2018-yearOfBirth))+5;
        }

        return bmr;
    }


}
