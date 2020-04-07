package org.jude.managefront.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController      //=@Controller+@ResponseBody
public class HelloController {
    @RequestMapping("/Hello")
    public String testSpringBoot() {
        return "恭喜您！测试成功，您可以开心的编写代码了";
    }
}