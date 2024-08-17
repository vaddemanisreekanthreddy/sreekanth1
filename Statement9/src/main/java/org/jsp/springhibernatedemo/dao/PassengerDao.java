package org.jsp.springhibernatedemo.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.jsp.springhibernatedemo.dto.Employee;
import org.jsp.springhibernatedemo.dto.PassengerDetails;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class PassengerDao {

	HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	
	
	@Transactional
	public PassengerDetails savePassenger(PassengerDetails passenger) {
		System.out.println("Executed");
		template.save(passenger);
		return passenger;
	}

	@Transactional
	public PassengerDetails updatePassenger(PassengerDetails passenger) {
		template.update(passenger);
		return passenger;
	}

	public List<PassengerDetails> finaAllPassenger() {
		return template.loadAll(PassengerDetails.class);
	}

	@Transactional
	public boolean deletePassenger(int id) {
		PassengerDetails passenger = template.get(PassengerDetails.class, id);
		if (passenger != null) {
			template.delete(passenger);
			return true;
		}
		return false;
	}

	public PassengerDetails findPassengerById(int id) {
		return template.get(PassengerDetails.class, id);
	}

}
