package kubaczajkowski.utils;


import kubaczajkowski.domain.Dish;
import kubaczajkowski.domain.Meal;
import kubaczajkowski.domain.Person;
import kubaczajkowski.domain.Product;

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

        double bmr = 0;


        for (Person per : persons) {
            if (per.isWomen()) {

                int sum = 0;
                for (Meal meal : per.getMeals()) {
                    for (Dish dish : meal.getDishes()) {
                        for (Product prod : dish.getProducts()) {
                            sum += prod.getKcal();
                        }
                    }
                }

                if (sum > per.calculateBMR()) {
                    names.add(per.getName());
                }
            }
        }

        return names;

    }

    /*
    zróć listę osób, które jedzą dwa obiady dziennie i mimo to jedzą mniej
     niż wskazuje Parametr Zapotrzebowania Kalorycznego(BMR)
     */
    public List<String> surnameOfPersonsWhoEatTwoDinnersAndBelowTheirBMR(List<Person> persons) {
        List<String> tmp = new ArrayList<>();


        for (Person per : persons) {
            int dinner = 0;
            for (Meal meal : per.getMeals()) {

                if (meal.getName().equals("dinner")) {
                    dinner++;
                }
            }
            if (dinner == 2) {
                int sum = 0;
                for (Meal meal : per.getMeals()) {
                    for (Dish dish : meal.getDishes()) {
                        for (Product prod : dish.getProducts()) {
                            sum += prod.getKcal();
                        }
                    }
                }

                double bmr = per.calculateBMR();
                if (sum >bmr) {
                    tmp.add(per.getSurname());
                }
            }

        }


        return tmp;
    }
}
