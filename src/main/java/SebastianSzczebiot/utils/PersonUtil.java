package SebastianSzczebiot.utils;

import SebastianSzczebiot.domain.Dish;
import SebastianSzczebiot.domain.Meal;
import SebastianSzczebiot.domain.Person;
import SebastianSzczebiot.domain.Product;

import java.util.ArrayList;
import java.util.List;

/*
dane w klasie testowej są losowe. Proszę nie brać ich jako ostateczny wzór.
 */
public class PersonUtil {

    /*
    zwróć listę nazwisk kobiet, które jedzą więcej niż wskazuje Parametr Zapotrzebowania Kalorycznego (BMR)
     */
    public List<String> nameOfWomenWhoEatAboveTheirBMR(List<Person> persons) {
        List<String> names = new ArrayList<>();
        int suma=0;
        for (Person person : persons) {
            for (Meal meal : person.getMeals()) {
                for (Dish dish : meal.getDishes()) {
                    for (Product product : dish.getProducts()) {
                        suma+=product.getKcal();
                    }
                }
            }
            if (person.isWomen()==true&&suma>person.calculateBMR()){
                names.add(person.getName());
            }
            suma=0;
        }

        return names;

    }

    /*
    zróć listę osób, które jedzą dwa obiady dziennie i mimo to jedzą mniej
     niż wskazuje Parametr Zapotrzebowania Kalorycznego(BMR)
     */
    public List<String> surnameOfPersonsWhoEatTwoDinnersAndBelowTheirBMR(List<Person> persons) {
        List<String> tmp = new ArrayList<>();
        int indeks=0;
        for (Person person : persons) {
            for (Meal meal : person.getMeals()) {
                if (meal.getName()=="dinner"){
                    indeks++;
                }
            }

            if (indeks==2&&kalorie(person)>person.calculateBMR()){
                tmp.add(person.getSurname());
            }
            indeks=0;
        }

        return tmp;
    }

    public int kalorie(Person person) {
        int suma=0;
        for (Meal meal : person.getMeals()) {
                for (Dish dish : meal.getDishes()) {
                    for (Product product : dish.getProducts()) {
                        suma+=product.getKcal();
                    }
                }
            }
        return suma;
    }

}
