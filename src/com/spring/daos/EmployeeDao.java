
package com.spring.daos;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.pojos.Employee;
import com.spring.pojos.EmployeeLogin;

@Transactional
@Repository
public class EmployeeDao {

@Autowired
private SessionFactory factory;
private Session session;

/*@PostConstruct
public void open() throws Exception {
session = factory.openSession();
}*/

// close connection
/*@PreDestroy
public void close() {
if (session != null)
session.close();
}*/

public Employee RegisterEmployee(Employee Employee) {
System.out.println("inside dao"); 
Session session = factory.openSession();
session.save(Employee);
Employee.getId();
session.flush();
session.close();
return Employee;
// transaction.commit();

}

@SuppressWarnings("unchecked")
public Employee employeeLogin(EmployeeLogin body) {
Session session = factory.openSession();
Employee employee = (Employee) session
.createQuery(
"FROM Employee where email = '" + body.getEmail()
+ "' and password = '" + body.getPassword()
+ "'").list().get(0);
session.flush();
session.close();
// System.out.println(employee.toString());
return employee;
}

public List<Employee> getAllEmployees() throws InterruptedException {
Session session = factory.openSession();
List<Employee> employees = (List<Employee>) session.createQuery(
"FROM Employee").list();
//for (long i = 0; i < 10000000000l; i++);
//System.out.println(employees.toString());
session.flush();
session.close();
return employees;
}

public Employee getEmployeeInfo(int id) {
Session session = factory.openSession();
Employee employee;

employee = (Employee) session.get(Employee.class, new Integer(id));
System.out.println(employee);
session.flush();
session.close();
if (employee != null)
return employee;
else
return null;
// System.out.println(employees.toString());

}

public boolean deleteEmployee(int id) {
Session session = factory.openSession();
Employee employee;

employee = (Employee) session.load(Employee.class, id);
System.out.println(employee);
session.delete(employee);
session.flush();
session.close();
if (employee != null)
return true;
else
return false;
// System.out.println(employees.toString());

}

public Employee updateEmployee(Employee Employee) {
System.out.println("inside dao");
Session session = factory.openSession();
Transaction tx = session.beginTransaction();
// session.update(Employee);
session.update(Employee);
tx.commit();
session.flush();
session.close();
// session.flush();
return Employee;

// transaction.commit();

}

}


