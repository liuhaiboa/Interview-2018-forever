package javabase.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author haibo.liu
 * @description
 * @date 2019/11/19
 */
public class Human {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


public void humanComparator(){
    new Comparator<Human>(){
        @Override
        public int compare(Human h1, Human h2) {
            return h1.getName().compareTo(h2.getName());
        }
    };
}

    @Test
    public void givenPreLambda_whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humans =new ArrayList<>();
        Human human=new Human();
        human.setAge(10);
        human.setName("Sarah");
        humans.add(human);
        Human human1=new Human();
        human1.setAge(11);
        human1.setName("Jack");
        humans.add(human1);

        Collections.sort(humans, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        });
        Assert.assertThat(humans.get(0), equalTo(humans.get(1)));
    }
    public static void main(String[] args) {

    }
}
