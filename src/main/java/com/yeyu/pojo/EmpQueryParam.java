package com.yeyu.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmpQueryParam {
    private String name;
    private Integer gender;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
    private Integer page = 1;  // 默认值
    private Integer pageSize = 10; // 默认值
    
    // 计算分页起始位置
    public Integer getStart() {
        return (page - 1) * pageSize;
    }
}