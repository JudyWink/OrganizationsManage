package org.jude.manageBack;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;



@Data
@Getter
@Setter
public class JsonRequestBody{
    //时间戳
    private Date timestamp;
    //用户账号
    private String userAcount;
    //token验证
    private String token;
    //数据
    private JSONObject data;
}
