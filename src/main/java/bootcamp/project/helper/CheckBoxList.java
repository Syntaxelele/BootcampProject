package bootcamp.project.helper;

import java.util.ArrayList;
import java.util.List;

public class CheckBoxList {
	List<Boolean> listOfCheck;

	public List<Boolean> getListOfCheck() {
		return listOfCheck;
	}

	public void setListOfCheck(List<Boolean> listOfCheck) {
		this.listOfCheck = listOfCheck;
	}

	public CheckBoxList() {
		listOfCheck = new ArrayList<Boolean>();
	}

	public void addCheck(Boolean b) {
		listOfCheck.add(b);
	}

	@Override
	public String toString() {
		return "CheckBoxList{" + "listOfCheck=" + listOfCheck + '}';
	}
}
