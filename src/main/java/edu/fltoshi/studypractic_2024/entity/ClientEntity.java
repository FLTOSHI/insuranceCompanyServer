package edu.fltoshi.studypractic_2024.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    private String name;
    @NotBlank
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    private String lastname;
    @NotBlank
    @Pattern(regexp ="[А-Я][а-я]{1,20}")
    private String surname;
    private Boolean osago;
    private Boolean property;
    private Boolean medical;
    private Boolean life;
}