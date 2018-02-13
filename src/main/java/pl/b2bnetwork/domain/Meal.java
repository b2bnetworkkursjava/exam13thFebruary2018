package pl.b2bnetwork.domain;

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


}
