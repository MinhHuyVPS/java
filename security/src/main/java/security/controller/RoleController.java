package security.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import security.dto.request.PermissionRequest;
import security.dto.request.RoleRequest;
import security.dto.response.ApiResponse;
import security.dto.response.PermissionResponse;
import security.dto.response.RoleResponse;
import security.services.PermissionService;
import security.services.RoleService;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
    RoleService roleService;
    @PostMapping
    public ApiResponse<RoleResponse> create(@RequestBody RoleRequest request){
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }
    @GetMapping
    public ApiResponse<List<RoleResponse>> getAll(){
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }
    @DeleteMapping("/{role}")
    public ApiResponse<Void> deleteById(@PathVariable String roleId){
        roleService.delete(roleId);
        return ApiResponse.<Void>builder().build();
    }
}
