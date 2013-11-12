package nl.vorstdev.domain;

public class Person {

    private String id;
    private String lastname;

    public Person(String id, String lastname) {
        this.id = id;
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
