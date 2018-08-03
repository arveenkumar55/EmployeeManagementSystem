package application.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	
	StringProperty P_id;
	StringProperty Startdate;
	StringProperty Duedate;
	StringProperty Supervisor_id;

	public Person(String p_id, String startdate, String duedate, String supervisor_id) {
		super();
		P_id = new SimpleStringProperty(p_id);;
		Startdate = new SimpleStringProperty(startdate);
		Duedate = new SimpleStringProperty(duedate);
		Supervisor_id =new SimpleStringProperty(supervisor_id);;

	}	
	/**
	 * @return the p_id
	 */
	public StringProperty getP_id() {
		return P_id;
	}

	/**
	 * @param p_id the p_id to set
	 */
	public void setP_id(StringProperty p_id) {
		P_id = p_id;
	}

	/**
	 * @return the startdate
	 */
	public StringProperty getStartdate() {
		return Startdate;
	}

	/**
	 * @param startdate the startdate to set
	 */
	public void setStartdate(StringProperty startdate) {
		Startdate = startdate;
	}

	/**
	 * @return the duedate
	 */
	public StringProperty getDuedate() {
		return Duedate;
	}

	/**
	 * @param duedate the duedate to set
	 */
	public void setDuedate(StringProperty duedate) {
		Duedate = duedate;
	}

	/**
	 * @return the supervisor_id
	 */
	public StringProperty getSupervisor_id() {
		return Supervisor_id;
	}

	/**
	 * @param supervisor_id the supervisor_id to set
	 */
	public void setSupervisor_id(StringProperty supervisor_id) {
		Supervisor_id = supervisor_id;
	}

}
	

