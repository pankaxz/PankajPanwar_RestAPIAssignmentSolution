package com.greatlearning.EmployeeManagementREST.entites;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="role_table")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;

    public Roles(String roleName) {
        super();
        this.roleName = roleName;
    }

    private String roleName;
}
