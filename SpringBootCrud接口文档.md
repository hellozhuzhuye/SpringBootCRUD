
## 登录接口

#### 接口URL
> 127.0.0.1:9999/login

#### 请求方式
> POST

#### Content-Type
> form-data






#### 请求Body参数

| 参数        | 示例值   | 是否必填   |  参数描述  |
| :--------   | :-----  | :-----  | :----  |
| username     | admin |  必填 | 用户名 |
| password     | 123 |  必填 | 密码 |

#### 成功响应示例
```javascript
{
	"msg": "登陆成功！",
	"userData": {
		"id": 3,
		"username": "admin",
		"enabled": true,
		"roles": [
			{
				"id": 1,
				"name": "ROLE_admin",
				"nameZh": "管理员"
			},
			{
				"id": 2,
				"name": "ROLE_user",
				"nameZh": "系统用户"
			},
			{
				"id": 3,
				"name": "ROLE_emp",
				"nameZh": "员工"
			}
		],
		"authorities": [
			{
				"authority": "ROLE_admin"
			},
			{
				"authority": "ROLE_user"
			},
			{
				"authority": "ROLE_emp"
			}
		],
		"accountNonExpired": true,
		"accountNonLocked": true,
		"credentialsNonExpired": true
	},
	"status": 200
}
```

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| msg     | 登陆成功！ | 登录结果 |
| userData     | - | 用户信息 |
| userData.id     | 3 | 用户id |
| userData.username     | admin | 用户名 |
| userData.enabled     | true | 用户是否可用 |
| userData.roles     | - | 用户所拥有的角色 |
| userData.roles.id     | 1 | 角色id |
| userData.roles.name     | ROLE_admin | ROLE前缀角色名 |
| userData.roles.nameZh     | 管理员 | 中文角色名 |
| userData.authorities     | - | 用户权限角色 |
| userData.authorities.authority     | ROLE_admin | 用户所拥有权限角色 |
| userData.accountNonExpired     | true | 用户是否未过期 |
| userData.accountNonLocked     | true | 用户是否未锁定 |
| userData.credentialsNonExpired     | true | 凭证是否未过期 |
| status     | 200 | 响应状态码 |

#### 错误响应示例
```javascript
{
	"msg": "Bad credentials",
	"status": 403
}
```

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| msg     | Bad credentials | 登录结果 |
| status     | 403 | 响应状态码 |

## 获取所有员工接口

#### 接口URL
> 127.0.0.1:9999/emp/emps

#### 请求方式
> GET

#### Content-Type
> form-data







#### 成功响应示例
```javascript
[
	{
		"id": 1,
		"gender": "M",
		"name": "张三",
		"email": "12345678@qq.com"
	},
	{
		"id": 2,
		"gender": "F",
		"name": "李四",
		"email": "12345679@qq.com"
	},
	{
		"id": 3,
		"gender": "M",
		"name": "王五",
		"email": "11111111@qq.com"
	},
	{
		"id": 7,
		"gender": "F",
		"name": "edit2",
		"email": "826076402@qq.com"
	}
]
```

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| id     | 1 | 员工id |
| gender     | M | 性别 |
| name     | 张三 | 姓名 |
| email     | 12345678@qq.com | 邮箱 |


## 获取指定员工接口

#### 接口URL
> 127.0.0.1:9999/emp/:uid

#### 请求方式
> GET

#### Content-Type
> form-data



#### 路径参数

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| uid     | 99 | 用户id |



#### 请求Body参数

| 参数        | 示例值   | 是否必填   |  参数描述  |
| :--------   | :-----  | :-----  | :----  |
| gender     | F |  必填 | 性别，M为男，F为女 |
| name     | testadd |  必填 | 姓名 |
| email     | testadd@163.com |  必填 | 邮箱 |

#### 成功响应示例
```javascript
{
	"id": 2,
	"gender": "F",
	"name": "李四",
	"email": "12345679@qq.com"
}
```

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| id     | 2 | 员工id |
| gender     | F | 性别 |
| name     | 李四 | 姓名 |
| email     | 12345679@qq.com | 邮箱 |

#### 错误响应示例
```javascript
{
	"msg": "查询的用户不存在！"
}
```

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| msg     | 查询的用户不存在！ | 查询结果 |

## 新增员工接口

#### 接口URL
> 127.0.0.1:9999/emp

#### 请求方式
> POST

#### Content-Type
> form-data






#### 请求Body参数

| 参数        | 示例值   | 是否必填   |  参数描述  |
| :--------   | :-----  | :-----  | :----  |
| gender     | M |  必填 | 性别，M为男，F为女 |
| name     | testAddName |  必填 | 姓名 |
| email     | test@163.com |  必填 | 邮箱 |

#### 成功响应示例
```javascript
{
	"msg": "新增员工成功",
	"addEmpData": {
		"id": 12,
		"gender": "M",
		"name": "testAddName",
		"email": "test@163.com"
	}
}
```

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| msg     | add emp success | 添加结果 |
| addEmpData     | - | 添加的员工信息 |
| addEmpData.id     | 12 | 员工id |
| addEmpData.gender     | M | 性别 |
| addEmpData.name     | testAddName | 姓名 |
| addEmpData.email     | test@163.com | 邮箱 |

#### 错误响应示例
```javascript
{
	"msg": "新增用户失败，用户名已存在！"
}
```

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| msg     | 新增用户失败，用户名已存在！ | 添加结果 |

## 删除员工接口

#### 接口URL
> 127.0.0.1:9999/emp/:uid

#### 请求方式
> DELETE

#### Content-Type
> form-data



#### 路径参数

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| uid     | 99 | 用户id |



#### 请求Body参数

| 参数        | 示例值   | 是否必填   |  参数描述  |
| :--------   | :-----  | :-----  | :----  |
| id     | 9 |  必填 | 用户id |

#### 成功响应示例
```javascript
{
	"msg": "删除员工成功",
	"delEmpData": {
		"id": 12,
		"gender": "M",
		"name": "testAddName",
		"email": "test@163.com"
	}
}
```

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| msg     | 删除员工成功 | 删除结果 |
| delEmpData     | - | 删除的员工信息 |
| delEmpData.id     | 12 | 员工id |
| delEmpData.gender     | M | 性别 |
| delEmpData.name     | testAddName | 姓名 |
| delEmpData.email     | test@163.com | 邮箱 |

#### 错误响应示例
```javascript
{
	"msg": "删除员工失败，员工信息不存在"
}
```

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| msg     | 删除员工失败，员工信息不存在 | 删除结果 |

## 修改员工接口

#### 接口URL
> 127.0.0.1:9999/emp/:uid

#### 请求方式
> PUT

#### Content-Type
> form-data



#### 路径参数

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| uid     | 7 | 用户id |



#### 请求Body参数

| 参数        | 示例值   | 是否必填   |  参数描述  |
| :--------   | :-----  | :-----  | :----  |
| gender     | F |  必填 | 性别，M为男，F为女 |
| name     | editTestName |  必填 | 姓名 |
| email     | edit@163.com |  必填 | 邮箱 |

#### 成功响应示例
```javascript
{
	"msg": "修改员工成功",
	"beforeEditEmp": {
		"id": 7,
		"gender": "F",
		"name": "edit2",
		"email": "826076402@qq.com"
	},
	"afterEditEmp": {
		"id": 7,
		"gender": "F",
		"name": "editTestName",
		"email": "edit@163.com"
	}
}
```

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| msg     | 修改员工成功 | 登录结果 |
| beforeEditEmp     | - | 修改之前的员工信息 |
| beforeEditEmp.id     | 7 | 员工id |
| beforeEditEmp.gender     | F | 性别 |
| beforeEditEmp.name     | edit2 | 姓名 |
| beforeEditEmp.email     | 826076402@qq.com | 邮箱 |
| afterEditEmp     | - | 修改之后的员工信息 |
| afterEditEmp.id     | 7 | 员工id |
| afterEditEmp.gender     | F | 性别 |
| afterEditEmp.name     | editTestName | 姓名 |
| afterEditEmp.email     | edit@163.com | 邮箱 |

#### 错误响应示例
```javascript
{
	"msg": "修改员工失败，员工信息不存在或姓名已存在！"
}
```

| 参数        | 示例值   |  参数描述  |
| :--------   | :-----  | :----  |
| msg     | 修改员工失败，员工信息不存在或姓名已存在！ | 修改结果 |
