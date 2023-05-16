package model;

// deptid, dname, mgrid, locid

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "department")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private Long deptid;

    @Column(name = "DEPARTMENT_NAME")
    private String dname;

    @Column(name = "MANAGER_ID")
    private Integer mgrid;

    @Column(name = "LOCATION_ID")
    private Long locid;
}
