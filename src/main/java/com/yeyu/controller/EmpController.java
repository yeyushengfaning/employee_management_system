package com.yeyu.controller;

import com.yeyu.anno.Log;
import com.yeyu.pojo.Emp;
import com.yeyu.pojo.EmpQueryParam;
import com.yeyu.pojo.PageResult;
import com.yeyu.pojo.Result;
import com.yeyu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 分页查询员工信息
     * @param empQueryParam 分页查询参数
     * @return 分页查询结果
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        System.out.println(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 新增员工信息
     * @param emp 员工信息
     * @return 新增结果
     */
    @Log
    @PostMapping
    public Result save(@RequestBody Emp emp){
        empService.save(emp);
        return Result.success();
    }

    /**
     * 删除员工信息
     * @param ids 员工ID数组
     * @return 删除结果
     */
    @Log
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 根据ID查询员工信息
     * @param id 员工ID
     * @return 员工信息
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    /**
     * 更新员工信息
     * @param emp 员工信息
     * @return 更新结果
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        return Result.success();
    }
}
