package com.example.model; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import java.util.Date;
import javax.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employees")
public class EmployeeForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //@NotEmpty(message = "Name can't be empty")
    @Pattern(regexp = "[a-zA-Z ]+", message = "Number is not allowed for Name")
    @Size(min = 2, max = 50, message = "Name field must be between {min} and {max} characters")
    private String name;
    
    
    
    //@NotNull(message = "Date of Birth can't be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date of Birth must be in the past")
    private Date dateOfBirth;

//    @NotEmpty
    @Column(name = "gender")
    private String gender;

    //@NotEmpty(message = "Address can't be empty")
    @Size(min = 2, max = 100, message = "Address field must be between {min} and {max} characters")
    private String address;

    //@NotEmpty
    @Column(name = "city")
    private String city;

   // @NotEmpty
    @Column(name = "state")
    private String state;

   // @NotEmpty
    @Email
    @Column(name = "email")
    private String email;

    //@NotEmpty
    @Column(name = "password")
    private String password;

    

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public void setPassword(String password) {
        this.password = password;
    }
}
