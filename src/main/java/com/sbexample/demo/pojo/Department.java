package com.sbexample.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//部门表

//插件lombok的注解
@Data//省去getter和setter
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造

public class Department {
    private Integer id;
    private String DepartmentName;
}
