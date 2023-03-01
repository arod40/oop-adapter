package business;

import java.util.List;

import model.IPerson;

public interface IPersonService {
	List<? extends IPerson> getPersonList();
}
