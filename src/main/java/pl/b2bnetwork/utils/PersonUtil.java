package pl.b2bnetwork.utils;

import pl.b2bnetwork.domain.Dish;
import pl.b2bnetwork.domain.Meal;
import pl.b2bnetwork.domain.Person;
import pl.b2bnetwork.domain.Product;

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
        double bmr=0;
        double kalorie = 0;
        List<String> names = new ArrayList<>();
        for(int i = 0; i<persons.size(); i++) {
            //same kobiety
            if (persons.get(i).isWomen() == true) {
                //aktualny bmr tej kobiety
                bmr= persons.get(i).calculateBMR();
                //ile zjadła, suma kalorii jej posiłków.
                for(int j =0; j<persons.size(); j++) {
                    for(int k = 0; k<persons.size(); k++) {
                        for(int l=0; l<persons.size(); l++) {
                            //sumuję kalorie produktów
                           kalorie+= persons.get(i).getMeals().get(j).getDishes().get(k).getProducts().get(l).getKcal();
                            //obliczam czy ileść zjedzonych kalorii jest większy niż brm
                            if (kalorie > bmr) {
                                names.add(persons.get(i).getName());
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
    public List<String> surnameOfPersonsWhoEatTwoDinnersAndBelowTheirBMR(List<Person> persons) {
        int obiady=0;
        List<String> tmp = new ArrayList<>();
        for(int i = 0; i<persons.size(); i++) {
            for(int j =0; j<persons.size(); j++) {
                if (persons.get(i).getMeals().get(j).getName() == "dinner") {
                    obiady++;
                    if (obiady == 2) {

                    }
                }



            }
        }
        return tmp;
        }




}
