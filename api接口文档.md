# ems接口文档

## 1. 部门管理

### 1.1 部门列表查询

#### 1.1.1 基本信息

> 请求路径：/depts
> 
> 请求方式：GET
> 
> 接口描述：该接口用于部门列表数据查询

#### 1.1.2 请求参数

无

#### 1.1.3 响应数据

参数格式：application/json

参数说明：

| 参数名            | 类型        | 是否必须 | 备注                |
| -------------- | --------- | ---- | ----------------- |
| code           | number    | 必须   | 响应码，1 代表成功，0 代表失败 |
| msg            | string    | 非必须  | 提示信息              |
| data           | object[ ] | 非必须  | 返回的数据             |
| \|- id         | number    | 非必须  | id                |
| \|- name       | string    | 非必须  | 部门名称              |
| \|- createTime | string    | 非必须  | 创建时间              |
| \|- updateTime | string    | 非必须  | 修改时间              |

响应数据样例：

```json
{
  "code": 1,
  "msg": "success",
  "data": [
    {
      "id": 1,
      "name": "学工部",
      "createTime": "2024-09-01T23:06:29",
      "updateTime": "2024-09-01T23:06:29"
    },
    {
      "id": 2,
      "name": "教研部",
      "createTime": "2022-09-01T23:06:29",
      "updateTime": "2022-09-01T23:06:29"
    }
  ]
}
```









### 1.2 删除部门

#### 1.2.1 基本信息

> 请求路径：/depts
> 
> 请求方式：DELETE
> 
> 接口描述：该接口用于根据ID删除部门数据



#### 1.2.2 请求参数

参数说明：

| 参数名 | 类型     | 是否必须 | 备注   |
| --- | ------ | ---- | ---- |
| id  | number | 必须   | 部门ID |

请求参数样例：

```
/depts?id=1
/depts?id=2
```



#### 1.2.3 响应数据

参数格式：application/json

参数说明：

| 参数名  | 类型     | 是否必须 | 备注                |
| ---- | ------ | ---- | ----------------- |
| code | number | 必须   | 响应码，1 代表成功，0 代表失败 |
| msg  | string | 非必须  | 提示信息              |
| data | object | 非必须  | 返回的数据             |

响应数据样例：

```json
{
    "code":1,
    "msg":"success",
    "data":null
}
```







### 1.3 添加部门

#### 1.3.1 基本信息

> 请求路径：/depts
> 
> 请求方式：POST
> 
> 接口描述：该接口用于添加部门数据



#### 1.3.2 请求参数

格式：application/json

参数说明：

| 参数名  | 类型     | 是否必须 | 备注   |
| ---- | ------ | ---- | ---- |
| name | string | 必须   | 部门名称 |

请求参数样例：

```json
{
    "name": "教研部"
}
```



#### 1.3.3 响应数据

参数格式：application/json

参数说明：

| 参数名  | 类型     | 是否必须 | 备注                |
| ---- | ------ | ---- | ----------------- |
| code | number | 必须   | 响应码，1 代表成功，0 代表失败 |
| msg  | string | 非必须  | 提示信息              |
| data | object | 非必须  | 返回的数据             |

响应数据样例：

```json
{
    "code":1,
    "msg":"success",
    "data":null
}
```





### 1.4 根据ID查询

#### 1.4.1 基本信息

> 请求路径：/depts/{id}
> 
> 请求方式：GET
> 
> 接口描述：该接口用于根据ID查询部门数据



#### 1.4.2 请求参数

参数格式：路径参数

参数说明：

| 参数名 | 类型     | 是否必须 | 备注   |
| --- | ------ | ---- | ---- |
| id  | number | 必须   | 部门ID |

请求参数样例：

```
/depts/1
/depts/3
```





#### 1.4.3 响应数据

参数格式：application/json

参数说明：

| 参数名            | 类型     | 是否必须 | 备注                |
| -------------- | ------ | ---- | ----------------- |
| code           | number | 必须   | 响应码，1 代表成功，0 代表失败 |
| msg            | string | 非必须  | 提示信息              |
| data           | object | 非必须  | 返回的数据             |
| \|- id         | number | 非必须  | id                |
| \|- name       | string | 非必须  | 部门名称              |
| \|- createTime | string | 非必须  | 创建时间              |
| \|- updateTime | string | 非必须  | 修改时间              |

响应数据样例：

```json
{
  "code": 1,
  "msg": "success",
  "data": {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  }
}
```





### 1.5 修改部门

#### 1.5.3 基本信息

> 请求路径：/depts
> 
> 请求方式：PUT
> 
> 接口描述：该接口用于修改部门数据



#### 1.5.2 请求参数

格式：application/json

参数说明：

| 参数名  | 类型     | 是否必须 | 备注   |
| ---- | ------ | ---- | ---- |
| id   | number | 必须   | 部门ID |
| name | string | 必须   | 部门名称 |

请求参数样例：

```json
{
    "id": 1,
    "name": "教研部"
}
```



#### 1.5.3 响应数据

参数格式：application/json

参数说明：

| 参数名  | 类型     | 是否必须 | 备注                |
| ---- | ------ | ---- | ----------------- |
| code | number | 必须   | 响应码，1 代表成功，0 代表失败 |
| msg  | string | 非必须  | 提示信息              |
| data | object | 非必须  | 返回的数据             |

响应数据样例：

```json
{
    "code":1,
    "msg":"success",
    "data":null
}
```

















## 2. 员工管理

### 2.1 员工列表查询

#### 2.1.1 基本信息

> 请求路径：/emps
> 
> 请求方式：GET
> 
> 接口描述：该接口用于员工列表数据的条件分页查询

#### 2.1.2 请求参数

参数格式：queryString

参数说明：

| 参数名称     | 是否必须 | 示例         | 备注                     |
| -------- | ---- | ---------- | ---------------------- |
| name     | 否    | 张          | 姓名                     |
| gender   | 否    | 1          | 性别 , 1 男 , 2 女         |
| begin    | 否    | 2010-01-01 | 范围匹配的开始时间(入职日期)        |
| end      | 否    | 2020-01-01 | 范围匹配的结束时间(入职日期)        |
| page     | 是    | 1          | 分页查询的页码，如果未指定，默认为1     |
| pageSize | 是    | 10         | 分页查询的每页记录数，如果未指定，默认为10 |

请求数据样例：

```shell
/emps?name=张&gender=1&begin=2007-09-01&end=2022-09-01&page=1&pageSize=10
```





#### 2.1.3 响应数据

参数格式：application/json

参数说明：

| 名称             | 类型        | 是否必须 | 备注                                        |
| -------------- | --------- | ---- | ----------------------------------------- |
| code           | number    | 必须   | 响应码, 1 成功 , 0 失败                          |
| msg            | string    | 非必须  | 提示信息                                      |
| data           | object    | 必须   | 返回的数据                                     |
| \|- total      | number    | 必须   | 总记录数                                      |
| \|- rows       | object [] | 必须   | 数据列表                                      |
| \|- id         | number    | 非必须  | id                                        |
| \|- username   | string    | 非必须  | 用户名                                       |
| \|- name       | string    | 非必须  | 姓名                                        |
| \|- password   | string    | 非必须  | 密码                                        |
| \|- gender     | number    | 非必须  | 性别 , 1 男 ; 2 女                            |
| \|- image      | string    | 非必须  | 图像                                        |
| \|- job        | number    | 非必须  | 职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师 |
| \|- salary     | number    | 非必须  | 薪资                                        |
| \|- entryDate  | string    | 非必须  | 入职日期                                      |
| \|- deptId     | number    | 非必须  | 部门id                                      |
| \|- deptName   | string    | 非必须  | 部门名称                                      |
| \|- createTime | string    | 非必须  | 创建时间                                      |
| \|- updateTime | string    | 非必须  | 更新时间                                      |

响应数据样例：

```json
{
  "code": 1,
  "msg": "success",
  "data": {
    "total": 2,
    "rows": [
       {
        "id": 1,
        "username": "jinyong",
        "password": "123456",
        "name": "金庸",
        "gender": 1,
        "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2022-09-02-00-27-53B.jpg",
        "job": 2,
        "salary": 8000,
        "entryDate": "2013.31-01",
        "deptId": 2,
        "deptName": "教研部",
        "createTime": "2022-09-01T23:06:30",
        "updateTime": "2022-09-02T00:29:04"
      },
      {
        "id": 2,
        "username": "zhangwuji",
        "password": "123456",
        "name": "张无忌",
        "gender": 1,
        "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2022-09-02-00-27-53B.jpg",
        "job": 2,
        "salary": 6000,
        "entryDate": "2013.31-01",
        "deptId": 2,
        "deptName": "教研部",
        "createTime": "2022-09-01T23:06:30",
        "updateTime": "2022-09-02T00:29:04"
      }
    ]
  }
}
```







### 2.2 删除员工

#### 2.2.1 基本信息

> 请求路径：/emps
> 
> 请求方式：DELETE
> 
> 接口描述：该接口用于批量删除员工的数据信息



#### 2.2.2 请求参数

参数格式：查询参数

参数说明：

| 参数名 | 类型       | 示例    | 是否必须 | 备注      |
| --- | -------- | ----- | ---- | ------- |
| ids | 数组 array | 1,2,3 | 必须   | 员工的id数组 |

请求参数样例：

```
/emps?ids=1,2,3
```



#### 2.2.3 响应数据

参数格式：application/json

参数说明：

| 参数名  | 类型     | 是否必须 | 备注                |
| ---- | ------ | ---- | ----------------- |
| code | number | 必须   | 响应码，1 代表成功，0 代表失败 |
| msg  | string | 非必须  | 提示信息              |
| data | object | 非必须  | 返回的数据             |

响应数据样例：

```json
{
    "code":1,
    "msg":"success",
    "data":null
}
```







### 2.3 添加员工

#### 2.3.1 基本信息

> 请求路径：/emps
> 
> 请求方式：POST
> 
> 接口描述：该接口用于添加员工的信息



#### 2.3.2 请求参数

参数格式：application/json

参数说明：

| 名称          | 类型       | 是否必须 | 备注                                        |
| ----------- | -------- | ---- | ----------------------------------------- |
| username    | string   | 必须   | 用户名                                       |
| name        | string   | 必须   | 姓名                                        |
| gender      | number   | 必须   | 性别, 说明: 1 男, 2 女                          |
| image       | string   | 非必须  | 图像                                        |
| deptId      | number   | 非必须  | 部门id                                      |
| entryDate   | string   | 非必须  | 入职日期                                      |
| job         | number   | 非必须  | 职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师 |
| salary      | number   | 非必须  | 薪资                                        |
| exprList    | object[] | 非必须  | 工作经历列表                                    |
| \|- company | string   | 非必须  | 所在公司                                      |
| \|- job     | string   | 非必须  | 职位                                        |
| \|- begin   | string   | 非必须  | 开始时间                                      |
| \|- end     | string   | 非必须  | 结束时间                                      |

请求数据样例：

```json
{
  "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2022-09-03-07-37-38222.jpg",
  "username": "linpingzhi",
  "name": "林平之",
  "gender": 1,
  "job": 1,
  "entryDate": "2022-09-18",
  "deptId": 1,
  "phone": "18809091234",
  "salary": 8000,
  "exprList": [
      {
         "company": "百度科技股份有限公司",
         "job": "java开发",
         "begin": "2012-07-01",
         "end": "2019-03-03"
      },
      {
         "company": "阿里巴巴科技股份有限公司",
         "job": "架构师",
         "begin": "2019-03-15",
         "end": "2023-03-01"
      }
   ]
}
```





#### 2.3.3 响应数据

参数格式：application/json

参数说明：

| 参数名  | 类型     | 是否必须 | 备注                |
| ---- | ------ | ---- | ----------------- |
| code | number | 必须   | 响应码，1 代表成功，0 代表失败 |
| msg  | string | 非必须  | 提示信息              |
| data | object | 非必须  | 返回的数据             |

响应数据样例：

```json
{
    "code":1,
    "msg":"success",
    "data":null
}
```





### 2.4 根据ID查询

#### 2.4.1 基本信息

> 请求路径：/emps/{id}
> 
> 请求方式：GET
> 
> 接口描述：该接口用于根据主键ID查询员工的信息



#### 2.4.2 请求参数

参数格式：路径参数

参数说明：

| 参数名 | 类型     | 是否必须 | 备注   |
| --- | ------ | ---- | ---- |
| id  | number | 必须   | 员工ID |

请求参数样例：

```
/emps/1
```



#### 2.4.3 响应数据

参数格式：application/json

参数说明：

| 名称             | 类型       | 是否必须 | 备注                                        |
| -------------- | -------- | ---- | ----------------------------------------- |
| code           | number   | 必须   | 响应码, 1 成功 , 0 失败                          |
| msg            | string   | 非必须  | 提示信息                                      |
| data           | object   | 必须   | 返回的数据                                     |
| \|- id         | number   | 非必须  | id                                        |
| \|- username   | string   | 非必须  | 用户名                                       |
| \|- name       | string   | 非必须  | 姓名                                        |
| \|- password   | string   | 非必须  | 密码                                        |
| \|- entryDate  | string   | 非必须  | 入职日期                                      |
| \|- gender     | number   | 非必须  | 性别 , 1 男 ; 2 女                            |
| \|- image      | string   | 非必须  | 图像                                        |
| \|- job        | number   | 非必须  | 职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师 |
| \|- salary     | number   | 非必须  | 薪资                                        |
| \|- deptId     | number   | 非必须  | 部门id                                      |
| \|- createTime | string   | 非必须  | 创建时间                                      |
| \|- updateTime | string   | 非必须  | 更新时间                                      |
| \|- exprList   | object[] | 非必须  | 工作经历列表                                    |
| \|- id         | number   | 非必须  | ID                                        |
| \|- company    | string   | 非必须  | 所在公司                                      |
| \|- job        | string   | 非必须  | 职位                                        |
| \|- begin      | string   | 非必须  | 开始时间                                      |
| \|- end        | string   | 非必须  | 结束时间                                      |
| \|- empId      | number   | 非必须  | 员工ID                                      |

响应数据样例：

```json
{
  "code": 1,
  "msg": "success",
  "data": {
    "id": 2,
    "username": "zhangwuji",
    "password": "123456",
    "name": "张无忌",
    "gender": 1,
    "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2022-09-02-00-27-53B.jpg",
    "job": 2,
    "salary": 8000,
    "entryDate": "2013.31-01",
    "deptId": 2,
    "createTime": "2022-09-01T23:06:30",
    "updateTime": "2022-09-02T00:29:04",
    "exprList": [
      {
        "id": 1,
        "begin": "2012-07-01",
        "end": "2019-03-03"
        "company": "百度科技股份有限公司"
        "job": "java开发",
        "empId": 2
      },
      {
        "id": 2,
        "begin": "2019-3-15",
        "end": "2023-03-01"
        "company": "阿里巴巴科技股份有限公司"
        "job": "架构师",
        "empId": 2
      }
    ]
  }
}
```







### 2.5 修改员工

#### 2.5.3 基本信息

> 请求路径：/emps
> 
> 请求方式：PUT
> 
> 接口描述：该接口用于修改员工的数据信息



#### 2.5.2 请求参数

参数格式：application/json

参数说明：

| 名称          | 类型       | 是否必须 | 备注                                        |
| ----------- | -------- | ---- | ----------------------------------------- |
| id          | number   | 必须   | id                                        |
| username    | string   | 必须   | 用户名                                       |
| name        | string   | 必须   | 姓名                                        |
| gender      | number   | 必须   | 性别, 说明: 1 男, 2 女                          |
| image       | string   | 非必须  | 图像                                        |
| deptId      | number   | 非必须  | 部门id                                      |
| entryDate   | string   | 非必须  | 入职日期                                      |
| job         | number   | 非必须  | 职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师 |
| salary      | number   | 非必须  | 薪资                                        |
| exprList    | object[] | 非必须  | 工作经历列表                                    |
| \|- id      | number   | 非必须  | ID                                        |
| \|- company | string   | 非必须  | 所在公司                                      |
| \|- job     | string   | 非必须  | 职位                                        |
| \|- begin   | string   | 非必须  | 开始时间                                      |
| \|- end     | string   | 非必须  | 结束时间                                      |
| \|- empId   | number   | 非必须  | 员工ID                                      |



请求数据样例：

```json
{
    "id": 2,
    "username": "zhangwuji",
    "password": "123456",
    "name": "张无忌",
    "gender": 1,
    "image": "https://web-framework.oss-cn-hangzhou.aliyuncs.com/2022-09-02-00-27-53B.jpg",
    "job": 2,
    "salary": 8000,
    "entryDate": "2013.31-01",
    "deptId": 2,
    "createTime": "2022-09-01T23:06:30",
    "updateTime": "2022-09-02T00:29:04",
    "exprList": [
      {
        "id": 1,
        "begin": "2012-07-01",
        "end": "2013.36-20",
        "company": "中软国际股份有限公司",
        "job": "java开发",
        "empId": 2
      },
      {
        "id": 2,
        "begin": "2013.37-01",
        "end": "2019-03-03",
        "company": "百度科技股份有限公司",
        "job": "java开发",
        "empId": 2
      },
      {
        "id": 3,
        "begin": "2019-03-15",
        "end": "2023-03-01",
        "company": "阿里巴巴科技股份有限公司",
        "job": "架构师",
        "empId": 2
      }
    ]
  }
```



#### 2.5.3 响应数据

参数格式：application/json

参数说明：

| 参数名  | 类型     | 是否必须 | 备注                |
| ---- | ------ | ---- | ----------------- |
| code | number | 必须   | 响应码，1 代表成功，0 代表失败 |
| msg  | string | 非必须  | 提示信息              |
| data | object | 非必须  | 返回的数据             |

响应数据样例：

```json
{
    "code":1,
    "msg":"success",
    "data":null
}
```







### 2.6 查询全部员工

#### 2.6.1 基本信息

> 请求路径：/emps/list
> 
> 请求方式：GET
> 
> 接口描述：该接口用于查询全部员工信息 



#### 2.6.2 请求参数

无



#### 2.6.3 响应数据

参数格式：application/json

参数说明：

| 名称             | 类型       | 是否必须 | 备注                                        |
| -------------- | -------- | ---- | ----------------------------------------- |
| code           | number   | 必须   | 响应码, 1 成功 , 0 失败                          |
| msg            | string   | 非必须  | 提示信息                                      |
| data           | object[] | 必须   | 返回的数据                                     |
| \|- id         | number   | 必须   | id                                        |
| \|- username   | string   | 必须   | 用户名                                       |
| \|- name       | string   | 必须   | 姓名                                        |
| \|- password   | string   | 非必须  | 密码                                        |
| \|- entryDate  | string   | 非必须  | 入职日期                                      |
| \|- gender     | number   | 非必须  | 性别 , 1 男 ; 2 女                            |
| \|- image      | string   | 非必须  | 图像                                        |
| \|- job        | number   | 非必须  | 职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师 |
| \|- salary     | number   | 非必须  | 薪资                                        |
| \|- deptId     | number   | 非必须  | 部门id                                      |
| \|- createTime | string   | 非必须  | 创建时间                                      |
| \|- updateTime | string   | 非必须  | 更新时间                                      |

响应数据样例：

```json
{
  "code": 1,
  "msg": "success",
  "data": [
    {
      "id": 21,
      "username": "zcc",
      "password": "123456",
      "name": "周星驰",
      "gender": 1,
      "image": "https://web-65.oss-cn-beijing.aliyuncs.com/99c143e9-0241-41f3-bc55-dd3.3e0824f4.jpg",
      "job": 1,
      "salary": 8000,
      "entryDate": "2023-04-23",
      "deptId": 2,
      "createTime": "2023-03.24.17:23.31",
      "updateTime": "2023-06-04T19:23.35"
    },
    {
      "id": 6,
      "username": "xiaozhao",
      "password": "123456",
      "name": "小昭",
      "gender": 2,
      "image": "https://web-65.oss-cn-beijing.aliyuncs.com/da94dc38-f163.380c-b8b7-0b3f4bcd1602.jpg",
      "job": 3,
      "salary": 8000,
      "entryDate": "2013-09-05",
      "deptId": 1,
      "createTime": "2023-04-07T11:16:00",
      "updateTime": "2023-04-14T08:22:41"
    }
  ]
}
```





## 3. 数据统计

### 3.1 员工性别统计

#### 3.1.1 基本信息

> 请求路径：/report/empGenderData
> 
> 请求方式：GET
> 
> 接口描述：统计员工性别信息



#### 3.1.2 请求参数

无



#### 3.1.3 响应数据

参数格式：application/json

参数说明：

| 参数名       | 类型       | 是否必须 | 备注                |
| --------- | -------- | ---- | ----------------- |
| code      | number   | 必须   | 响应码，1 代表成功，0 代表失败 |
| msg       | string   | 非必须  | 提示信息              |
| data      | object[] | 非必须  | 返回的数据             |
| \|- name  | string   | 非必须  | 性别                |
| \|- value | number   | 非必须  | 人数                |

响应数据样例：

```json
{
  "code": 1,
  "msg": "success",
  "data": [
    {"name": "男性员工","value": 5},
    {"name": "女性员工","value": 6}
  ]
}
```







### 3.2 员工职位人数统计

#### 3.2.1 基本信息

> 请求路径：/report/empJobData
> 
> 请求方式：GET
> 
> 接口描述：统计各个职位的员工人数



#### 3.2.2 请求参数

无



#### 3.2.3 响应数据

参数格式：application/json

参数说明：

| 参数名          | 类型       | 是否必须 | 备注                |
| ------------ | -------- | ---- | ----------------- |
| code         | number   | 必须   | 响应码，1 代表成功，0 代表失败 |
| msg          | string   | 非必须  | 提示信息              |
| data         | object   | 非必须  | 返回的数据             |
| \|- jobList  | string[] | 必须   | 职位列表              |
| \|- dataList | number[] | 必须   | 人数列表              |

响应数据样例：

```json
{
  "code": 1,
  "msg": "success",
  "data": {
    "jobList": ["教研主管","学工主管","其他","班主任","咨询师","讲师"],
    "dataList": [1,1,2,6,8,13]
  }
}
```



### 3.3 日志列表查询

#### 3.3.1 基本信息

> 请求路径：/log/page
> 
> 请求方式：GET
> 
> 接口描述：该接口用于日志信息的分页查询



#### 3.3.2 请求参数

参数格式：queryString

参数说明：

| 参数名称     | 是否必须 | 示例  | 备注                     |
| -------- | ---- | --- | ---------------------- |
| page     | 是    | 1   | 分页查询的页码，如果未指定，默认为1     |
| pageSize | 是    | 10  | 分页查询的每页记录数，如果未指定，默认为10 |

请求数据样例：

```shell
/log/page?page=1&pageSize=10
```





#### 3.3.3 响应数据

参数格式：application/json

参数说明：

| 名称                 | 类型        | 是否必须 | 备注               |
| ------------------ | --------- | ---- | ---------------- |
| code               | number    | 必须   | 响应码, 1 成功 , 0 失败 |
| msg                | string    | 非必须  | 提示信息             |
| data               | object    | 必须   | 返回的数据            |
| \|- total          | number    | 必须   | 总记录数             |
| \|- rows           | object [] | 必须   | 数据列表             |
| \|- id             | number    | 非必须  | id               |
| \|- operateEmpId   | number    | 非必须  | 操作人ID            |
| \|- operateTime    | string    | 非必须  | 操作时间             |
| \|- className      | string    | 非必须  | 类名               |
| \|- methodName     | string    | 非必须  | 方法名              |
| \|- methodParams   | string    | 非必须  | 方法请求参数           |
| \|- returnValue    | string    | 非必须  | 返回值              |
| \|- costTime       | number    | 非必须  | 执行耗时, 单位ms       |
| \|- operateEmpName | string    | 非必须  | 操作人姓名            |

响应数据样例：

```json
{
    "code": 1,
    "msg": null,
    "data": {
        "total": 15,
        "rows": [
            {
                "id": 15,
                "operateEmpId": 2,
                "operateTime": "2023-12-18T17:37:15",
                "className": "com.itheima.controller.DeptController",
                "methodName": "add",
                "methodParams": "[Dept(id=null, name=投资部, createTime=null, updateTime=null)]",
                "returnValue": "Result(code=1, msg=null, data=null)",
                "costTime": 8,
                "operateEmpName": "宋江"
            },
            {
                "id": 14,
                "operateEmpId": 2,
                "operateTime": "2023-12-18T17:37:07",
                "className": "com.itheima.controller.DeptController",
                "methodName": "add",
                "methodParams": "[Dept(id=null, name=市场部, createTime=null, updateTime=null)]",
                "returnValue": "Result(code=1, msg=null, data=null)",
                "costTime": 4,
                "operateEmpName": "宋江"
            }
        ]
    }
}
```









## 4. 其他接口

### 4.1 登录

#### 4.1.1 基本信息

> 请求路径：/login
> 
> 请求方式：POST
> 
> 接口描述：该接口用于员工登录Tlias智能学习辅助系统，登录完毕后，系统下发JWT令牌。 



#### 4.1.2 请求参数

参数格式：application/json

参数说明：

| 名称       | 类型     | 是否必须 | 备注  |
| -------- | ------ | ---- | --- |
| username | string | 必须   | 用户名 |
| password | string | 必须   | 密码  |

请求数据样例：

```json
{
    "username": "jinyong",
    "password": "123456"
}
```



#### 4.1.3 响应数据

参数格式：application/json

参数说明：

| 名称           | 类型     | 是否必须 | 备注                |
| ------------ | ------ | ---- | ----------------- |
| code         | number | 必须   | 响应码, 1 成功 ; 0  失败 |
| msg          | string | 非必须  | 提示信息              |
| data         | object | 必须   | 返回的数据             |
| \|- id       | number | 必须   | 员工ID              |
| \|- username | string | 必须   | 用户名               |
| \|- name     | string | 必须   | 姓名                |
| \|- token    | string | 必须   | 令牌                |



响应数据样例：

```json
{
    "code": 1,
    "msg": "success",
    "data": {
        "id": 2,
        "username": "songjiang",
        "name": "宋江",
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MiwidXNlcm5hbWUiOiJzb25namlhbmciLCJleHAiOjE2OTg3MDE3NjJ9.w06EkRXTep6SrvMns3w5RKe79nxauDe7fdMhBLK-MKY"
    }
}
```





#### 4.1.4 备注说明

> 用户登录成功后，系统会自动下发JWT令牌，然后在后续的每次请求中，都需要在请求头header中携带到服务端，请求头的名称为 `token` ，值为 登录时下发的JWT令牌。
> 
> 如果检测到用户未登录，则直接响应 401 状态码 。







​            
