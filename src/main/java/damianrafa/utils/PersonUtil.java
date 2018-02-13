package damianrafa.utils;

import damianrafa.domain.Dish;
import damianrafa.domain.Meal;
import damianrafa.domain.Person;
import damianrafa.domain.Product;

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
        String name = "";
        int maxbmr = 0;
        for (Person person : persons) {
            if (person.isWomen()) {
                for (Meal meal : person.getMeals()) {
                    for (Dish dish : meal.getDishes()) {
                        for (Product product : dish.getProducts()) {
//                            if (product.getKcal() > maxbmr) {
                            maxbmr += product.getKcal();
                            //name=person.getName();
                            //names.add(name);

                        }
                    }
                }
                if (person.calculateBMR() < maxbmr) {
                    name = person.getName();
                    names.add(name);
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
        String result = "";
        int maxbmr = 0;

        for (Person person : persons) {
            for (Meal meal : person.getMeals()) {
                for (Dish dish : meal.getDishes()) {
                    for (Product produsct : dish.getProducts()) {

                    }
                }
            }
        }

        return tmp;
    }
}
