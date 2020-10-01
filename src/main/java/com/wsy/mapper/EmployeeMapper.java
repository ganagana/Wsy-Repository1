package com.wsy.mapper;

import com.wsy.entity.Employee;

import java.util.List;

/**
 * @author: wsy
 * Date: 2020/9/29
 * Time: 20:15
 * Description: No Description
 */
public interface EmployeeMapper {

    public List<Employee> getAll();

    public void add(Employee employee);

    public void update(Employee employee);

    public void deleteById(Integer id);

    Employee getById(Integer id);
}
