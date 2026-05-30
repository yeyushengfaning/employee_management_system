package com.yeyu.controller;

import com.yeyu.pojo.Emp;
import com.yeyu.pojo.LoginInfo;
import com.yeyu.pojo.Result;
import com.yeyu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    /**
     * 员工登录
     * @param emp 员工登录信息
     * @return 登录结果
     */
    @PostMapping
    public Result login(@RequestBody Emp emp){
        LoginInfo loginInfo = empService.login(emp);
        if (loginInfo != null) {
            return Result.success(loginInfo);
        } else {
            return Result.error("用户名或密码错误");
        }
    }
}
