package security.mapper;

import org.mapstruct.Mapper;
import security.dto.request.PermissionRequest;
import security.dto.response.PermissionResponse;
import security.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
