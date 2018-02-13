package annawyszomirska.utils;

import annawyszomirska.domain.Dish;
import annawyszomirska.domain.Meal;
import annawyszomirska.domain.Person;
import annawyszomirska.domain.Product;

import java.util.ArrayList;
import java.util.List;

/*
dane w klasie testowej są losowe. Proszę nie brać ich jako ostateczny wzór.
 */
public class PersonUtil {

    /*
    zwróć listę nazwisk kobiet, które jedzą więcej niż wskazuje Parametr Zapotrzebowania Kalorycznego (BMR)
     */
    public List <String> nameOfWomenWhoEatAboveTheirBMR(List <Person> persons) {
        List <String> names = new ArrayList <>();
        double more = 0;

        for (Person p : persons) {
            if (p.isWomen()) {
                for (Meal m : p.getMeals()) {
                    for (Dish d : m.getDishes()) {
                        for (Product product : d.getProducts()) {
                            if (p.calculateBMR() < product.getKcal()) {
                                names.add( p.getName() );
                            }

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
    public List <String> surnameOfPersonsWhoEatTwoDinnersAndBelowTheirBMR(List <Person> persons) {
        List <String> tmp = new ArrayList <>();
        int dinner = 0;
        double kcl = 0;

        for (Person p : persons) {
            for (Meal m : p.getMeals()) {
                if (m.getName().contains( "dinner" )) {
                    dinner++;
                }
                for (Dish d : m.getDishes()) {
                    for (Product product : d.getProducts()) {
                        kcl += product.getKcal();

                    }
                    if (dinner == 2 && p.calculateBMR() > kcl) {
                        tmp.add( p.getSurname() );
                    }
                }
            }
        }
        return tmp;
    }
}
