### 目标： 计算个人获得新冠的概率和地区的危险系数 ###

person: 体征 储存行程 更新

每个人的危险系数

person 对象
- 姓名: String last/first
- 所在地: String location
- 状态： 隔离/乱飞: bool isQuarantined 
  - 近5天有没有做核酸: bool testResult
- 过去14天行程: ArrayList<Address> trip
- 生理特征（BMI && 年龄 ...）
- 根据行程--> 给出特定的颜色状态

- 给出相应的医学建议
- 查询可以做的事情
