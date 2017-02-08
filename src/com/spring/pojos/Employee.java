
package com.spring.pojos;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Employee")
@XmlRootElement
public class Employee implements Serializable {

@Id
@GeneratedValue
@Column(name = "ID", length = 10)
private int id;
@Column(name = "name", length = 30)
private String name;
@Column(name = "location", length = 30)
private String location;
@Column(name = "contacno", length = 12)
private int contactno;
@Column(name = "email", length = 30)
private String email;
@Column(name = "password", length = 30)
private String password;
@Column(name = "orgunit", length = 20)
private String orgunit;
@Column(name = "skills", length = 50)
private String skills;
@Column(name = "project", length = 50)
private String project;

public int getId() {
return id;
}



public void setId(int id) {
this.id = id;
}



public String getName() {
return name;
}



public void setName(String name) {
this.name = name;
}



public String getLocation() {
return location;
}



public void setLocation(String location) {
this.location = location;
}



public int getcontactno() {
return contactno;
}



public void setcontactno(int contactno) {
this.contactno = contactno;
}



public String getEmail() {
return email;
}



public void setEmail(String email) {
this.email = email;
}



public String getPassword() {
return password;
}



public void setPassowrd(String password) {
this.password = password;
}



public String getOrgunit() {
return orgunit;
}



public void setOrgunit(String orgunit) {
this.orgunit = orgunit;
}



public String getSkills() {
return skills;
}



public void setSkills(String skills) {
this.skills = skills;
}



public String getProject() {
return project;
}



public void setProject(String project) {
this.project = project;
}



@Override
public String toString() {
return "{id:" + id + ", name:" + name + ", location:" + location + ", contactno:" + contactno + ", email:" + email
+ ", password:" + password + ", orgunit:" + orgunit + ", skills:" + skills + ", project:" + project + "}";
}

}

