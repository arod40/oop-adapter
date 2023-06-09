package business;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.IPerson;
import model.adapter.PersonDS1ObjectAdapter;
import model.adapter.PersonDS2ClassAdapter;
import model.remote.PersonDS1;
import model.remote.PersonDS2;

import org.exolab.castor.xml.Unmarshaller;

public class RemotePersonService implements IPersonService {

    private static final String PERSON_XML_DS1 = "person-ds1.xml";
    private static final String PERSON_XML_DS2 = "person-ds2.xml";

    @SuppressWarnings("unchecked")
    public List<? extends IPerson> getPersonList() {
        return Stream.concat(
            getPersonListDS1().stream().map(personDS1 -> new PersonDS1ObjectAdapter(personDS1)),
            getPersonListDS2().stream()).collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public List<PersonDS1> getPersonListDS1() {
        try {
            FileReader reader = new FileReader(PERSON_XML_DS1);
            return (List<PersonDS1>) Unmarshaller.unmarshal(ArrayList.class, reader);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<PersonDS2ClassAdapter> getPersonListDS2() {
        try {
            FileReader reader = new FileReader(PERSON_XML_DS2);
            return (List<PersonDS2ClassAdapter>) Unmarshaller.unmarshal(ArrayList.class, reader);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        }
        return null;
    }

    public static void main(String[] args) {
        List<PersonDS1> list = new RemotePersonService().getPersonListDS1();
        List<PersonDS2ClassAdapter> list2 = new RemotePersonService().getPersonListDS2();
        System.out.println(list);
        System.out.println(list2);
    }

}
