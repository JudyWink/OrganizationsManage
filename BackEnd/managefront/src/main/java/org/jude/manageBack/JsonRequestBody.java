package org.jude.manageBack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;


@Data
@Getter
@Setter
public class JsonRequestBody{
    private Date timestamp;
    private String userId;
    private String token;
    //0:游客;1学生;2老师
    private String userType;
    private HashMap jsonDate;
}
