package ewelinakrawczuk.utils;

import ewelinakrawczuk.domain.Dish;
import ewelinakrawczuk.domain.Meal;
import ewelinakrawczuk.domain.Person;
import ewelinakrawczuk.domain.Product;

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

        double sum = 0;
        for (Person per : persons) {
            if (per.isWomen() == true) {
                for (Meal meal : per.getMeals()) {
                    for (Dish dish : meal.getDishes()) {
                        for (Product product : dish.getProducts()) {
                            sum += product.getKcal();
                        }
                    }
                }
                if (sum > per.calculateBMR()) {
                    names.add(per.getName());
                }
            }
            sum = 0;
        }

        return names;

    }

    /*
    zróć listę osób, które jedzą dwa obiady dziennie i mimo to jedzą mniej
     niż wskazuje Parametr Zapotrzebowania Kalorycznego(BMR)
     */
    public List<String> surnameOfPersonsWhoEatTwoDinnersAndBelowTheirBMR(List<Person> persons) {
        List<String> tmp = new ArrayList<>();

        for (Person pers : persons) {
            int sumOb = 0;
            int sumBmr = 0;
            for (Meal meal : pers.getMeals()) {
                if (meal.getName().equals("dinner")) {
                    sumOb++;
                }
                for (Dish di : meal.getDishes()) {
                    for (Product prod : di.getProducts()) {
                        sumBmr += prod.getKcal();
                    }
                }
            }
            if (sumOb == 2 && sumBmr > pers.calculateBMR()) {
                tmp.add(pers.getSurname());
            }
        }

        return tmp;
    }
}
