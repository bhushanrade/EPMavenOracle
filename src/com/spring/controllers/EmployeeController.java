package com.spring.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.pojos.EmployeeLogin;
import com.spring.pojos.Employee;
import com.spring.services.EmployeeService;

@Controller
public class EmployeeController {

@Autowired
private EmployeeService service;

/*@RequestMapping(value = "/")
public String indexPage()
{
	return "index1";
}
*/
@RequestMapping(value = "/registerEmployee", method = RequestMethod.POST, produces = "application/json")
@Consumes(MediaType.APPLICATION_JSON)
@ResponseBody
public ResponseEntity registerEmployee(@RequestBody Employee Employee) {
System.out.println("inside registerEmployee");
//System.out.println(Employee.toString());
Employee reg = service.registerEmployee(Employee);
if (reg != null) {
return ResponseEntity.status(200).body(reg);
}
return ResponseEntity.status(500).body(
"{\"error\":\"registration failed.\"}");
}

@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
@Consumes(MediaType.APPLICATION_JSON)
@ResponseBody
public ResponseEntity employeeLogin(@RequestBody EmployeeLogin body) {
System.out.println("inside employeeLogin");
Employee employee = service.employeeLogin(body);
if (employee != null) {
return ResponseEntity.status(200).body(employee);
}
return ResponseEntity.status(401).body(
"{\"error\":\"un-authorized user.\"}");
}
@RequestMapping(value = "/employees", method = RequestMethod.GET)
@ResponseBody
public ResponseEntity gwtAllEmployees() throws InterruptedException {
System.out.println("inside gwtAllEmployees");
List<Employee> employees = service.gwtAllEmployees();
if (employees.size() > 0) {
return ResponseEntity.status(200).body(employees);
}
return ResponseEntity.status(401).body(
"{\"error\":\"un-authorized user.\"}");
}
@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
@Consumes(MediaType.APPLICATION_JSON)
public ResponseEntity employeeDelete(@PathVariable("id") int id) {
System.out.println("inside employeedelete");
boolean deleteFlag = service.deleteEmployee(id);
if (deleteFlag==true) {
return ResponseEntity.status(200).body("{\"id\":\"deleted\"}");
}
return ResponseEntity.status(401).body(
"{\"error\":\"un-authorized user.\"}");
}
@RequestMapping(value = "/getEmployeeInfo/{id}", method = RequestMethod.GET, produces = "application/json")
public ResponseEntity getEmployeeInfo(@PathVariable("id") int id) {
System.out.println("inside get employee info");
Employee employee= service.getEmployeeInfo(id);
if (employee != null) {
System.out.println(employee);
return ResponseEntity.status(200).body(employee); 
}
return ResponseEntity.status(401).body(
"{\"error\":\"un-authorized user.\"}");
}
@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST, produces = "application/json")
@Consumes(MediaType.APPLICATION_JSON)
@ResponseBody
public ResponseEntity updateEmployee(@RequestBody Employee Employee) {
System.out.println("inside registerEmployee");
//System.out.println(Employee.toString());
Employee reg = service.updateEmployee(Employee);
if (reg != null) {
return ResponseEntity.status(200).body(reg);
}
return ResponseEntity.status(500).body(
"{\"error\":\"registration failed.\"}");
}

}