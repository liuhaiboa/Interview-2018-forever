package DesignPattern.Filter;

import java.util.List;

/**
 * @author haibo
 * @date 19-9-19
 */
public class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstCriteriaPerson=criteria.meetCriteria(personList);
        return otherCriteria.meetCriteria(firstCriteriaPerson);
    }
}
