package maciejkrupinski.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * posiłek to jest śniadanie, obiad lub kolacja
 *
 * posiłek składa się z kilku dań; przykładowo kubek kakako lub sałatka jest jednym z dań podanych przy obiedzie
 *
 **/
public class Meal {

    private String name;
    private List<Dish> dishes = new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
    public Meal(String name, List<Dish> dishes){
        this.name=name;
        this.dishes=dishes;
    }
}
