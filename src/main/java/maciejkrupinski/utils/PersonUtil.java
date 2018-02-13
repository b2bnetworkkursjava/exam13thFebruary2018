package maciejkrupinski.utils;

import maciejkrupinski.domain.Dish;
import maciejkrupinski.domain.Meal;
import maciejkrupinski.domain.Person;
import maciejkrupinski.domain.Product;

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
        double sum=0;
        for(Person pr: persons){
            if(pr.isWomen()) {
                for (Meal ml : pr.getMeals()) {
                    for (Dish dh : ml.getDishes()) {
                        for (Product pd : dh.getProducts()) {
                            sum += pd.getKcal();
                        }
                    }
                }
                if (pr.calculateBMR() < sum) {
                    names.add(pr.getName());
                }
                sum=0;
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
        int dinners=0;
        double sum=0;
        for(Person pr: persons){
            for(Meal ml: pr.getMeals()) {
                if (ml.getName().equals("dinner")) {
                    dinners++;
                }
            }
                if(dinners==2){
                    for (Meal ml : pr.getMeals()) {
                        for (Dish dh : ml.getDishes()) {
                            for (Product pd : dh.getProducts()) {
                                sum += pd.getKcal();
                            }
                        }
                    }
                    if (pr.calculateBMR() > sum) {
                        tmp.add(pr.getSurname());
                    }
                    sum=0;
                }
        }
        return tmp;
    }
}
