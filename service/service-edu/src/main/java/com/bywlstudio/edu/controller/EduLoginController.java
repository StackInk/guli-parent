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
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://edu-stream001.oss-cn-beijing.aliyuncs.com/2021-01-24/fe0b8077f842408b9f7322a277ab7779-955accc9694a6f483d3c7065fc4bc44f.jpg");
    }

}
