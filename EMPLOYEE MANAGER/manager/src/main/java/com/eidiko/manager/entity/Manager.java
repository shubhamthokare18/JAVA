package com.eidiko.manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MANAGER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manager_seq")
    @SequenceGenerator(
            name = "manager_seq",
            sequenceName = "MANAGER_SEQ",
            allocationSize = 1
    )
    private Long id;

    private Long employeeId;

    private String managerName;

}