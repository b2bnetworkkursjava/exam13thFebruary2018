package maciejwojcik.utils;

import maciejwojcik.domain.Dish;
import maciejwojcik.domain.Meal;
import maciejwojcik.domain.Person;
import maciejwojcik.domain.Product;

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
        for (Person xxx : persons) {
            for (Meal meals : xxx.getMeals()) {
                for (Dish dish : meals.getDishes()) {
                    for (Product product : dish.getProducts()) {
                        if (product.getKcal() > xxx.calculateBMR() && xxx.isWomen() != false) {
                            names.add(xxx.getName());
                        }
                    }
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
        double sum = 0;
        for (Person xxx : persons) {
            if (xxx.getMeals().size() == 2) {
                for (Meal meals : xxx.getMeals()) {
                    for (Dish dish : meals.getDishes()) {
                        for (Product product : dish.getProducts()) {
                            sum += product.getKcal();
                            if (sum > xxx.calculateBMR()) {
                                tmp.add(xxx.getSurname());

                            }
                        }
                    }
                }
            }
        }
        System.out.println(sum);
        return tmp;
    }
}
