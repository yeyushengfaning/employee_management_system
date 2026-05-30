package com.yeyu.mapper;

import com.yeyu.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    /**
     * 插入操作日志
     * @param operateLog 操作日志对象
     */
    @Insert("insert into operate_log(operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values(#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})")
    void insert(OperateLog operateLog);

    /**
     * 统计操作日志总数
     * @return 操作日志总数
     */
    @Select("select count(*) from operate_log")
    long count();

    /**
     * 分页查询操作日志
     * @param start 起始位置
     * @param pageSize 每页记录数
     * @return 操作日志列表
     */
    @Select("select o.*, e.name operateEmpName from operate_log o left join emp e on o.operate_emp_id = e.id" +
                        " order by o.operate_time desc limit #{start}, #{pageSize}")
    List<OperateLog> list(int start, Integer pageSize);
}
