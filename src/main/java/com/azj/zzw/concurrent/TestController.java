package com.azj.zzw.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author AZJ
 * @version V1.0
 * @package com.azj.zzw.concurrent
 * @desc 测试并发工具类
 */

@Controller
@Slf4j
public class TestController {

    @RequestMapping("testPostMan")
    @ResponseBody
    public String testPostMan(){
        return "testPostMan";
    }
}
