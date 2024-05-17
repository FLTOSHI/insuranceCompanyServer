package edu.fltoshi.studypractic_2024.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contracts")
public class ContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timelapse;
    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
