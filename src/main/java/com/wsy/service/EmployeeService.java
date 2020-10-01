package com.wsy.service;

import com.wsy.entity.Employee;
import com.wsy.util.Msg;

import java.util.List;

/**
 * @author: wsy
 * Date: 2020/9/29
 * Time: 20:30
 * Description: No Description
 */
public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getById(Integer id);

    public Msg add(Employee employee);

    public Msg update(Employee employee);

    public void deleteById(Integer id);
}
