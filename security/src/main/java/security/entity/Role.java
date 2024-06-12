package security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Table(name = "_role")
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Role {
    @Id
    private String name;
    private String description;
    @ManyToMany
    private Set<Permission> permission;
}
