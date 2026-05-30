package com.yeyu.mapper;

import com.yeyu.pojo.Emp;
import com.yeyu.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    /**
     * 查询员工总数
     * @return 员工总数
     */
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    Long count();

    /**
     * 查询员工列表
     * @param empQueryParam 查询参数
     * @return 员工列表
     */
    List<Emp> list(EmpQueryParam empQueryParam);

    /**
     * 插入员工信息
     * @param emp 员工信息
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values(#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    /**
     * 批量删除员工
     * @param ids 员工ID数组
     */
    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    /**
     * 更新员工信息
     * @param emp 员工信息
     */
    void updateById(Emp emp);

    /**
     * 统计各岗位的员工数量
     * @return 各岗位的员工数量列表
     */
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    /**
     * 统计男女员工数量
     * @return 男女员工数量列表
     */
    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();

    /**
     * 根据用户名和密码查询员工信息
     * @param emp 员工登录信息
     * @return 员工信息
     */
    @Select("select id, username, name from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}