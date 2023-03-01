package model.adapter;

import model.Person;
import model.remote.PersonDS1;
import model.remote.PersonDS2;

public class PersonDS1ObjectAdapter extends Person {
    PersonDS1 personds1;

    public PersonDS1ObjectAdapter(PersonDS1 personds1){
        this.personds1 = personds1;
    }

    public Long getId() {
        return personds1.getId();
    }

    public Long getSalary() {
        return personds1.getSalary();
    }

    public Boolean getMarried() {
        return personds1.getPartner() != null;
    }

    public String getfName() {
        // Assumes first name is everything before first whitespace
        return personds1.getName().split(" ")[0];
    }

    public String getlName() {
        return String.join(" ", personds1.getName().split(" "));
    }

    public Double getAge() {
        return personds1.getAge();
    }
}
