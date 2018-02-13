package marcinwrobel.utils;

import marcinwrobel.domain.Dish;
import marcinwrobel.domain.Meal;
import marcinwrobel.domain.Person;
import marcinwrobel.domain.Product;

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
                double tempBMR = person.calculateBMR();
                int sum = 0;
                for (Meal meal : person.getMeals()) {
                    for (Dish dish : meal.getDishes()) {
                        for (Product product : dish.getProducts()) {
                            sum+=product.getKcal();
                            if (tempBMR < sum) {
                                names.add(person.getName());
                            }
                        }
                    }
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
        List<String> tmp = new ArrayList<>();
        for (Person person : persons) {
            double tempBMR = person.calculateBMR();
            int dinnerCounter = 0;
            int sum = 0;
            for (Meal meal : person.getMeals()) {
                if (meal.getName().toLowerCase().contains("dinner")) {
                    dinnerCounter++;
                    for (Dish dish : meal.getDishes()) {
                        for (Product product : dish.getProducts()) {
                            sum+=product.getKcal();
                            if (dinnerCounter > 1 && tempBMR > sum) {
                                tmp.add(person.getSurname());
                            }
                        }
                    }
                }
            }
        }
        return tmp;
    }
}
