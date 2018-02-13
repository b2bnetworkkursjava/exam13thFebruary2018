package pl.b2bnetwork.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {
    private Person person;

    @Before
    public void init(){
        List<Meal> meals = new ArrayList<>();
        List<Dish> dishes = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        products.add(new Product("mleko", 200, 12));
        dishes.add(new Dish("kakao", products));
        meals.add(new Meal("dinner", dishes));
        person = new Person("Jan", "Kowalski", meals, false, 124, 67, 1990);
    }

    @Test
    public void getName() {
        assertTrue(person.getName().equals("Jan"));
    }

    @Test
    public void getSurname() {
        assertTrue(person.getSurname().equals("Kowalski"));
    }

    @Test
    public void getMeals() {
        assertEquals(1, person.getMeals().size());
    }

    @Test
    public void getWeight() {
        assertEquals(67, person.getWeight(),0);
    }

    @Test
    public void getHeight() {
        assertEquals(124, person.getHeight(),0);
    }

    @Test
    public void isWomen() {
        assertFalse(person.isWomen());
    }

    @Test
    public void getYearOfBirth() {
        assertEquals(1990, person.getYearOfBirth());
    }

    @Test
    public void calculateBMR() {
        assertEquals(1145.57, person.calculateBMR(),0);
    }
}