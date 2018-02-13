package nataliakrzciuk.utils;

import nataliakrzciuk.domain.Dish;
import nataliakrzciuk.domain.Meal;
import nataliakrzciuk.domain.Person;
import nataliakrzciuk.domain.Product;

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
        int sumKcal=0;
        for (Person p: persons) {
            for (Meal m : p.getMeals()) {
                for (Dish d : m.getDishes()) {
                    for (Product pro : d.getProducts()) {
                        sumKcal += pro.getKcal();
                    }
                }
                if (sumKcal > p.calculateBMR() && p.isWomen()) {
                    names.add(p.getName());
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
        int kcal =0;
        int countDinner=0;
        for (Person p: persons){
            for(Meal m: p.getMeals()){
                if(m.getName().equals("dinner")){
                    countDinner++;
                }
                for(Dish d: m.getDishes()){
                    for (Product pro: d.getProducts()){
                        kcal+=pro.getKcal();
                    }
                }

            }
            if (countDinner==2&&kcal<p.calculateBMR()){
                tmp.add(p.getSurname());
            }
        }
        return tmp;
    }
}
