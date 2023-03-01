package model.adapter;

import model.IPerson;
import model.remote.PersonDS2;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class PersonDS2ClassAdapter extends PersonDS2 implements IPerson  {

    public Long getSalary() {
        return getSalaryYear() / 12;
    }

    public Double getAge() {
        Period period = Period.between(getBorn().toInstant().atZone(
            ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        return Double.valueOf(period.getYears());
    }
}
