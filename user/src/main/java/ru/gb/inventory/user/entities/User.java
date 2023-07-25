package ru.gb.inventory.user.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "grade")
    private Long grade;

    @JoinColumn(name = "job_id")
    private Long jobId;

    @JoinColumn(name = "department_id")
    private Long departmentId;

    @Column(name = "email")
    private String email;


}
