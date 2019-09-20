package DesignPattern.Filter;

import java.util.List;

/**
 * @author haibo
 * @date 19-9-19
 */
public class OrCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstCriteriaPerson=criteria.meetCriteria(personList);
        List<Person> otherCriteriaPerson = otherCriteria.meetCriteria(personList);
        for(Person person:otherCriteriaPerson){
            if(!firstCriteriaPerson.contains(person)){
                firstCriteriaPerson.add(person);
            }
        }
        return firstCriteriaPerson;
    }
}
