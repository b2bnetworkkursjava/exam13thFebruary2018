package agatadziubala.utils;

import agatadziubala.domain.Dish;
import agatadziubala.domain.Meal;
import agatadziubala.domain.Person;
import agatadziubala.domain.Product;

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
            int sumOfAllCalories = 0;
            if (person.isWomen()) {
                for (Meal meal : person.getMeals()) {
                    for (Dish d : meal.getDishes()) {
                        for (Product product : d.getProducts()) {
                            sumOfAllCalories += product.getKcal();

                        }
                    }
                }
            }
            if (sumOfAllCalories > person.calculateBMR()) {
                names.add(person.getName());
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
            int sumOfAllCalories = 0;
            int countOfDinners = 0;
            for (Meal meal : person.getMeals()) {
                if (meal.getName().equalsIgnoreCase("Dinner")) {
                    countOfDinners++;
                }
                for (Dish dish : meal.getDishes()) {
                    for (Product product : dish.getProducts()) {
                        sumOfAllCalories += product.getKcal();

                    }
                }
            }
            if (countOfDinners == 2 && person.calculateBMR() < sumOfAllCalories) {
                tmp.add(person.getSurname());
            }
        }
        return tmp;
    }
}
