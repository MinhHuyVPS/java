package security.exception;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public enum ErrorCode {
    USER_NOT_FOUND(404, "User Not Found"),
    USER_ALREADY_EXISTS(409, "User Already Exists"),


    ;

    private int code;
    private String message;

}
