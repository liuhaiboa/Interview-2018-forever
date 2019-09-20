package DesignPattern.Filter;

/**
 * @author haibo
 * @date 19-9-19
 */
public class Person {
    private String name;
    private String gender;
    private String marryStatus;

    public Person(String name, String gender, String marryStatus) {
        this.name = name;
        this.gender = gender;
        this.marryStatus = marryStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(String marryStatus) {
        this.marryStatus = marryStatus;
    }
}


