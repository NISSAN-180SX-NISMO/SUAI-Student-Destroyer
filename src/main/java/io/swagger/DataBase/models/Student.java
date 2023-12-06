package io.swagger.DataBase.models;


import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name = null;

    @Column(name = "surname")
    private String surname = null;

    @Column(name = "patronymic")
    private String patronymic = null;

    @Column(name = "variant")
    private Integer variant = null;

    @Column(name = "works_submitted")
    private Integer worksSubmitted = null;

    @Column(name = "rating")
    private Integer rating = null;

}

