package com.fagenius.fleetapp.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="employeetypeid", insertable=false, updatable=false)
    private EmployeeType employeeType;
    private Integer employeetypeid;
    private String photo;
    private String firstname;
    private String lastname;
    private String title;
    private String initials;
    private String socialSecurityNumber;
    private String othername;
    private String gender;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date DateOfBirth;
    private String city;
    private String phone;
    private String mobile;
    private String maritalStatus;
    private String email;

    @ManyToOne
    @JoinColumn(name = "stateid", insertable = false, updatable = false)
    private State state;
    private Integer stateid;

    @ManyToOne
    @JoinColumn(name = "countryid", insertable = false,updatable = false)
    private Country contry;
    private Integer countryid;

    @ManyToOne
    @JoinColumn(name="jobtitleid", insertable=false, updatable=false)
    private JobTitle jobTitle;
    private Integer jobtitleid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;
}
