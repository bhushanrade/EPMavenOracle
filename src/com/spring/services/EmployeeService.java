package com.spring.services;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.daos.EmployeeDao;
import com.spring.pojos.EmployeeLogin;
import com.spring.pojos.Employee;

@Service
public class EmployeeService {
@Autowired
private  EmployeeDao dao;

public Employee registerEmployee(Employee Employee) {
Employee regi = null;
try {
System.out.println("inside service");
regi = dao.RegisterEmployee(Employee);
//success = true;
} catch (Exception e)

{
e.printStackTrace();
}
return regi;
}

public Employee employeeLogin(EmployeeLogin body) {
Employee employee = null;
try {
System.out.println("inside service");
employee = dao.employeeLogin(body);
//success = true;
} catch (Exception e)

{
e.printStackTrace();
}
return employee;
}

public List<Employee> gwtAllEmployees() {
List<Employee> employees = null;
try {
System.out.println("inside service");
employees = dao.getAllEmployees();
//TimeUnit.SECONDS.sleep(5);
//success = true;
} catch (Exception e)

{
e.printStackTrace();
}
return employees;
}

public boolean deleteEmployee(int id) {
boolean flag=false;
try {
System.out.println("inside delete service");
flag = dao.deleteEmployee(id);
//success = true;
} catch (Exception e)

{
e.printStackTrace();
}
return flag;
}
public Employee getEmployeeInfo(int id) {
Employee employee=null;
try {
System.out.println("inside getEmployeeInfo service");
employee = dao.getEmployeeInfo(id);
//success = true;
} catch (Exception e)

{
e.printStackTrace();
}
return employee;
}
public Employee updateEmployee(Employee Employee) {
Employee regi = null;
try {
System.out.println("inside service");
regi = dao.updateEmployee(Employee);
//success = true;
} catch (Exception e)

{
e.printStackTrace();
}
return regi;
}




}


