package org.jude.manageBack;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class JsonResponseBody{
    //状态码
    private int code;
    //信息内容
    private String msg;
    //数据
    private JSONObject data;
}
