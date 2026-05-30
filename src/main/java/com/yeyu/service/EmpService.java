package com.yeyu.service;

import com.yeyu.pojo.Emp;
import com.yeyu.pojo.EmpQueryParam;
import com.yeyu.pojo.LoginInfo;
import com.yeyu.pojo.PageResult;

import java.util.List;

public interface EmpService {

    /**
     * 分页查询员工信息
     * @param empQueryParam 分页查询参数
     * @return 分页查询结果
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增员工信息
     * @param emp 员工信息
     */
    void save(Emp emp);

    /**
     * 删除员工信息
     * @param ids 员工ID数组
     */
    void delete(List<Integer> ids);

    /**
     * 根据ID查询员工信息
     * @param id 员工ID
     * @return 员工信息
     */
    Emp getInfo(Integer id);

    /**
     * 更新员工信息
     * @param emp 员工信息
     */
    void update(Emp emp);

    /**
     * 员工登录
     * @param emp 员工登录信息
     * @return 登录结果
     */
    LoginInfo login(Emp emp);
}
