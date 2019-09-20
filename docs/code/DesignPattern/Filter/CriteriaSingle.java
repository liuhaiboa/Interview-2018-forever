package DesignPattern.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haibo
 * @date 19-9-19
 */
public class CriteriaSingle implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> personList) {

        List<Person> malePerson=new ArrayList<Person>();
        for (Person person:personList){
            if(person.getMarryStatus().equalsIgnoreCase("single")){
                malePerson.add(person);
            }
        }
        return malePerson;
    }
}
