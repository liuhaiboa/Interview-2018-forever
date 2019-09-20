package DesignPattern.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haibo
 * @date 19-9-19
 */
public class CriteriaPatternDemo {


    public static void main(String[] args) {
        List<Person> personList =new ArrayList<Person>();
        personList.add(new Person("xiaoming","male","single"));
        personList.add(new Person("xiaoli","female","single"));
        personList.add(new Person("zhangsan","female","Married"));
        personList.add(new Person("wanger","female","Married"));


        Criteria male=new CriteriaMale();
        CriteriaFemale criteriaFemale = new CriteriaFemale();
        CriteriaSingle criteriaSingle = new CriteriaSingle();
        AndCriteria andCriteria = new AndCriteria(criteriaFemale, criteriaSingle);
        OrCriteria orCriteria = new OrCriteria(criteriaFemale, criteriaSingle);


       printPersons(male.meetCriteria(personList));
        System.out.println("male");
       printPersons(criteriaFemale.meetCriteria(personList));
        System.out.println("female");
       printPersons(criteriaSingle.meetCriteria(personList));
        System.out.println("single");
       printPersons(andCriteria.meetCriteria(personList));
        System.out.println("and");
       printPersons(orCriteria.meetCriteria(personList));
        System.out.println("or");

    }

    public static void printPersons( List<Person> personList){
        for (Person person : personList) {
            System.out.println("Person : [ Name : " + person.getName()
                    +", Gender : " + person.getGender()
                    +", Marital Status : " + person.getMarryStatus()
                    +" ]");
        }
    }
}
