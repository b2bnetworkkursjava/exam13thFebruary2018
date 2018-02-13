package michalzelichowski.utils;

import michalzelichowski.domain.Dish;
import michalzelichowski.domain.Meal;
import michalzelichowski.domain.Person;
import michalzelichowski.domain.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

public class PersonUtilTest {
    private List<Person> persons = new ArrayList<>();
    private PersonUtil  util = new PersonUtil();

    private void createPersonWithCorrectAnswer() {
        List<Meal> meals = new ArrayList<>();
        List<Dish> dishes = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        products.add(new Product("mleko", 200, 12));
        dishes.add(new Dish("kakao", products));
        meals.add(new Meal("dinner", dishes));
        Person kowalska = new Person("Maria", "Kowalska", meals, 67, 124, true, 1990);
        List<Meal> mealsDagmara = new ArrayList<>();
        List<Dish> dishesDagmara = new ArrayList<>();
        List<Product> productsDagmara = new ArrayList<>();
        productsDagmara.add(new Product("ziemniak", 1100, 2));
        productsDagmara.add(new Product("mleko", 1800, 12));
        dishesDagmara.add(new Dish("kakao", productsDagmara));
        mealsDagmara.add(new Meal("dinner", dishesDagmara));
        Person dagmara = new Person("Dagmara", "Zielińska", mealsDagmara, 57, 164, true, 1990);
        List<Meal> mealsNowak = new ArrayList<>();
        List<Dish> dishesNowak = new ArrayList<>();
        List<Product> productsSalatka = new ArrayList<>();
        productsSalatka.add(new Product("sałata", 100, 8));
        productsSalatka.add(new Product("śmietana", 850, 8));
        List<Product> productsGlownyObiad = new ArrayList<>();
        productsGlownyObiad.add(new Product("ziemniak", 1100, 2));
        List<Product> productsKompot = new ArrayList<>();
        productsKompot.add(new Product("sok", 50, 1));
        dishesNowak.add(new Dish("sałatka", productsSalatka));
        dishesNowak.add(new Dish("główne danie", productsGlownyObiad));
        dishesNowak.add(new Dish("kompot", productsKompot));
        mealsNowak.add(new Meal("dinner", dishesNowak));
        mealsNowak.add(new Meal("dinner", dishesNowak));
        Person nowak = new Person("Jan", "Nowak", mealsNowak, 67, 167, false, 1992);

        persons.add(kowalska);
        persons.add(nowak);
        persons.add(dagmara);
    }
    private void createPersonWithWrongAnswer() {
        List<Meal> meals = new ArrayList<>();
        List<Dish> dishes = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        products.add(new Product("mleko", 200, 12));
        dishes.add(new Dish("kakao", products));
        meals.add(new Meal("dinner", dishes));
        Person kowalska = new Person("Maria", "Kowalska", meals, 67, 124, true, 1990);
        List<Meal> mealsDagmara = new ArrayList<>();
        List<Dish> dishesDagmara = new ArrayList<>();
        List<Product> productsDagmara = new ArrayList<>();
        productsDagmara.add(new Product("ziemniak", 1100, 2));
        dishesDagmara.add(new Dish("kakao", productsDagmara));
        mealsDagmara.add(new Meal("dinner", dishesDagmara));
        Person dagmara = new Person("Dagmara", "Zielińska", mealsDagmara, 57, 164, true, 1960);
        List<Meal> mealsNowak = new ArrayList<>();
        List<Dish> dishesNowak = new ArrayList<>();
        List<Product> productsSalatka = new ArrayList<>();
        productsSalatka.add(new Product("sałata", 100, 8));
        productsSalatka.add(new Product("śmietana", 850, 8));
        List<Product> productsGlownyObiad = new ArrayList<>();
        productsGlownyObiad.add(new Product("ziemniak", 1100, 2));
        List<Product> productsKompot = new ArrayList<>();
        productsKompot.add(new Product("sok", 50, 1));
        dishesNowak.add(new Dish("sałatka", productsSalatka));
        dishesNowak.add(new Dish("głowne danie", productsGlownyObiad));
        dishesNowak.add(new Dish("kompot", productsKompot));
        mealsNowak.add(new Meal("dinner", dishesNowak));
        Person nowak = new Person("Jan", "Nowak", mealsNowak, 67, 167, false, 1992);

        persons.add(kowalska);
        persons.add(nowak);
        persons.add(dagmara);
    }

    @Test
    public void nameOfWomenWhoEatAboveTheirBMR() {
        createPersonWithCorrectAnswer();
        assertThat(util.nameOfWomenWhoEatAboveTheirBMR(persons), containsInAnyOrder("Dagmara"));

    }
    @Test
    public void nameOfWomenWhoEatAboveTheirBMRWrong() {
        createPersonWithWrongAnswer();
        assertTrue(util.nameOfWomenWhoEatAboveTheirBMR(persons).isEmpty());

    }

    @Test
    public void surnameOfPersonsWhoEatTwoDinnersAndBelowTheirBMR() {
        createPersonWithCorrectAnswer();
        assertThat(util.surnameOfPersonsWhoEatTwoDinnersAndBelowTheirBMR(persons), containsInAnyOrder("Nowak"));
    }

    @Test
    public void surnameOfPersonsWhoEatTwoDinnersAndBelowTheirBMRWrong() {
        createPersonWithWrongAnswer();
        assertTrue(util.surnameOfPersonsWhoEatTwoDinnersAndBelowTheirBMR(persons).isEmpty());
    }


}