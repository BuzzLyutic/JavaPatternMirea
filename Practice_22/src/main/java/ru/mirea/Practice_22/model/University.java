package ru.mirea.Practice_22.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    private Date creationDate;

    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Student> students;
}
