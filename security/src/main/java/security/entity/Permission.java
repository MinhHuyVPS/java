package security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "_permission")
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Permission {
    @Id
    private String name;
    private String description;
}
