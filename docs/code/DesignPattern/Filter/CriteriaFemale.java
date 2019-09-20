package DesignPattern.Filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haibo
 * @date 19-9-19
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        //list里面是女性的
        List<Person> malePerson=new ArrayList<Person>();
        for (Person person:personList){
            if(person.getGender().equalsIgnoreCase("FeMale")){
                malePerson.add(person);
            }
        }
        return malePerson;
    }

}
