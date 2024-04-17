package security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import security.dto.request.UserCreationRequest;
import security.dto.request.UserUpdateRequest;
import security.entity.User;
import security.exception.AppException;
import security.exception.ErrorCode;
import security.repository.IUserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public User createRequest(UserCreationRequest request){
        User user = new User();
        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_ALREADY_EXISTS);
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setPhone(request.getPhone());
        user.setBirthday(request.getBirthday());
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(String id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public User updateUser(String userId, UserUpdateRequest request){
        User users = getUserById(userId);
        users.setBirthday(request.getBirthday());
        users.setFirstname(request.getFirstname());
        users.setLastname(request.getLastname());
        users.setEmail(request.getEmail());
        users.setPhone(request.getPhone());
        return userRepository.save(users);
    }
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
