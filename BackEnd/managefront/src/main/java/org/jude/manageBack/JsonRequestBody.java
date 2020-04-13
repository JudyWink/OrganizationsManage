package org.jude.manageBack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class JsonRequestBody<T> {
    private String userId;
    private String token;
    private String userType;
    private String requestTimeStamp;
    private List<String> jsonDate;
    private T requestData;
}
