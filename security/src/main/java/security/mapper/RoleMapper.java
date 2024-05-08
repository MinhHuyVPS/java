package security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import security.dto.request.PermissionRequest;
import security.dto.request.RoleRequest;
import security.dto.response.PermissionResponse;
import security.dto.response.RoleResponse;
import security.entity.Permission;
import security.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permission", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
