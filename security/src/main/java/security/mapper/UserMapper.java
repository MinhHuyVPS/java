package security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import security.dto.request.UserCreationRequest;
import security.dto.request.UserUpdateRequest;
import security.dto.response.UserResponse;
import security.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
