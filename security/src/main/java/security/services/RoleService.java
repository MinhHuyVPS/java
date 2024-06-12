package security.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import security.dto.request.PermissionRequest;
import security.dto.request.RoleRequest;
import security.dto.response.PermissionResponse;
import security.dto.response.RoleResponse;
import security.entity.Permission;
import security.entity.Role;
import security.mapper.PermissionMapper;
import security.mapper.RoleMapper;
import security.repository.IRoleRepository;
import security.repository.PermissionRepository;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleService {
    IRoleRepository roleRepository;
    RoleMapper roleMapper;
    PermissionRepository permissionRepository;
    public RoleResponse create(RoleRequest request){
        Role role = roleMapper.toRole(request);
        List<Permission> permission = permissionRepository.findAllById(request.getPermission());
        role.setPermission(new HashSet<>(permission));
        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }
    public List<RoleResponse> getAll(){
        return roleRepository.findAll()
                .stream().map(roleMapper::toRoleResponse).toList();
    }
    public void delete(String role){
        roleRepository.deleteById(role);
    }
}
