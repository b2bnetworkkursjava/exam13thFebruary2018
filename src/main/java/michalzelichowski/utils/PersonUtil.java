package michalzelichowski.utils;

import michalzelichowski.domain.Person;

import java.util.ArrayList;
import java.util.List;
import michalzelichowski.domain.*;

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
            if (person.isWomen() == true) {
                int sum = 0;
                for (Meal meal : person.getMeals()) {
                    for (Dish dish : meal.getDishes()) {
                        for (Product product : dish.getProducts()) {
                            sum += product.getKcal();
                        }
                    }
                }

                if (sum > person.calculateBMR()) {
                    names.add(person.getName());
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

        for (Person person : persons) {
            int sum = 0;
            int counter = 0;

            for (Meal meal : person.getMeals()) {
                if (meal.getName().equals("dinner")) {
                    counter++;
                    for (Dish dish : meal.getDishes()) {
                        for (Product product : dish.getProducts()) {
                            sum += product.getKcal();
                        }
                    }
                }

                if (counter > 1 && sum > person.calculateBMR()) {
                    tmp.add(person.getSurname());
                }
            }
        }


        return tmp;
    }
}
