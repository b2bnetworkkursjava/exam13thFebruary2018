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

    private String name;
    private String surname;
    private List<Meal> meals = new ArrayList();



    private double weight;
    private double height;
    private boolean isWomen;
    private int yearOfBirth;


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


        return bmr;
    }


}
