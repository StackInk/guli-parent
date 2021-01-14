package com.bywlstudio.edu.controller;

import com.bywlstudio.common.entity.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zl
 * @Date: Create in 2021/1/13 22:52
 * @Description:
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class EduLoginController {

    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("/info")
    public R info(){
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://mmbiz.qpic.cn/mmbiz_jpg/iaIdQfEric9Tyg3fTfFiaDBCXTdOyabicCfWEhtcV2S9cvdaCFWUJpP4NuOXNbb6vsKSYUMDXzt4CPapibkB5FQLTyw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1");
    }

}
