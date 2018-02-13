package pl.eninja.utils;

import pl.eninja.domain.Dish;
import pl.eninja.domain.Meal;
import pl.eninja.domain.Person;
import pl.eninja.domain.Product;

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


        for (Person person : persons) {
            if (person.isWomen()) {
                int tmp = 0;
                for (Meal meal : person.getMeals()) {
                    for (Dish dish : meal.getDishes()) {
                        for (Product product : dish.getProducts()) {
                            tmp += product.getKcal();
                        }
                    }
                }
                if (tmp > person.calculateBMR()) {
                    names.add(person.getName());
                }
            }
        }

        return names;

    }

    /*
    zwróć listę osób, które jedzą dwa obiady dziennie i mimo to jedzą mniej
     niż wskazuje Parametr Zapotrzebowania Kalorycznego(BMR)
     */
    public List<String> surnameOfPersonsWhoEatTwoDinnersAndBelowTheirBMR(List<Person> persons) {
        List<String> surnames = new ArrayList<>();

//            int counter = 0;
//            if (person.getMeals().contains("dinner")) {
//                counter++;
//            }
//            if (counter > 1) {
        for (Person person : persons) {
            int tmp = 0;
            int counter = 0;
            for (Meal meal : person.getMeals()) {

                if (meal.getName().equals("dinner")) {
                    counter++;
                    for (Dish dish : meal.getDishes()) {
                        for (Product product : dish.getProducts()) {
                            tmp += product.getKcal();
                        }
                    }
                }

                if (counter > 1 && tmp > person.calculateBMR()) {
                    surnames.add(person.getSurname());
                }
            }

        }


        return surnames;
    }
}
