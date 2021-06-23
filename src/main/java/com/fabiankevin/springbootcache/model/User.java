package com.fabiankevin.springbootcache.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@Builder
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    @Transient
    private Integer age;

    private String motherMaideName;

    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
