package annasprysak.utils;

import annasprysak.domain.Dish;
import annasprysak.domain.Meal;
import annasprysak.domain.Person;
import annasprysak.domain.Product;

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
        for(Person person : persons){
            if(person.isWomen()) {
                int sum = 0;
                for (Meal meal : person.getMeals()) {
                    for (Dish dish : meal.getDishes()) {
                        for (Product prod : dish.getProducts()) {
                            sum += prod.getKcal();
                        }
                    }
                }
                if(person.calculateBMR() < sum){
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

        for(Person person : persons){

            int sum = 0;
            int obiady = 0;
            for (Meal meal : person.getMeals()) {
                if(meal.getName().equals("dinner")){
                    obiady++;
                }
                for (Dish dish : meal.getDishes()) {
                    for (Product prod : dish.getProducts()) {
                        sum += prod.getKcal();
                    }
                }
            }
            if(person.calculateBMR() < sum && obiady == 2){
                tmp.add(person.getSurname());
            }
        }
        return tmp;
    }
}
