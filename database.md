#1、组合两个表: FirstName, LastName, City, State

表1: Person
+-------------+---------+
| PersonId    | int     | 主键
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+

表2: Address
+-------------+---------+
| AddressId   | int     | 主键
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+

select p.FirstName, p.LastName, a.City, a.State
from Person p left join Address a
on p.personId=a.personId


2、第二高的薪水
表: Employee
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
SQL返回200 作为第二高的薪水. 如果不存在第二高的薪水, 返回null
select (select distinct salary from Employee order by salary desc limit 1,1) as SecondHighestSalary

#最高

3、第N高的薪水
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
	SET N = N - 1;
	RETURN (
	 select distinct salary from Employee order by salary desc limit N,1
	);
END
select (select distinct salary from Employee order by salary desc limit 0,1) as HighestSalary

#第三高
select (select distinct salary from Employee order by salary desc limit 2,1) as ThirdHighestSalary
