package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.controller.EmployeeNotFoundException;
import com.example.demo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		Query query = entityManager.createQuery("From Employee");
		return query.getResultList();
	}

	@Override
	public void save(Employee employee) {
		Employee temployee = entityManager.merge(employee);
		employee.setEmployeeId(temployee.getEmployeeId());
		/*entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();*/
		
	}

	@Override
	public Employee update(Employee theEmployee) {
		save(theEmployee);
		return theEmployee;
	}

	@Override
	public Employee fingById(int theId) {
		Employee emp = entityManager.find(Employee.class,theId);
		if(emp==null)
		{
			throw new EmployeeNotFoundException("Employee with the given id is not found: "+theId);
		}
		return emp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> fingByEmail(String email) {
		Query query = entityManager.createQuery("FROM Employee e where e.email=:eml");
		query.setParameter("eml", email);
		return query.getResultList();
	}

	@Override
	public void delete(int theId) {
		Employee mep = fingById(theId);
		if(mep==null)
		{
			throw new EmployeeNotFoundException("Employee not found with the given id: "+theId);
		}
		entityManager.remove(mep);
		
	}
}
