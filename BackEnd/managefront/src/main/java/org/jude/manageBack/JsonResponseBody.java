package org.jude.manageBack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class JsonResponseBody<T> {
    private String userId;
    private String token;
    private String userType;
    private String responseTimeStamp;
    private String responseCode;
    private String errorCode;
    private T responseData;
}
