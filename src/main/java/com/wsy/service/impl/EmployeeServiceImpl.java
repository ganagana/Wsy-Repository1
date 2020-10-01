package com.wsy.service.impl;

import com.wsy.entity.Employee;
import com.wsy.mapper.EmployeeMapper;
import com.wsy.service.EmployeeService;
import com.wsy.util.BaseUtil;
import com.wsy.util.Msg;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wsy
 * Date: 2020/9/29
 * Time: 20:31
 * Description: No Description
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

    @Override
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeMapper.getById(id);
    }

    @Override
    public Msg add(Employee employee) {
        logger.info(employee);

        String name = employee.getName().trim();
        String password = employee.getPassword().trim();
        String phone = employee.getPhone().trim();
        String sex = employee.getSex().trim();
        String address = employee.getAddress().trim();
        Integer age = employee.getAge();
        if (name.length() == 0 || password.length() == 0 || phone.length() == 0 || sex.length() == 0 || address.length() == 0) {
            return Msg.error("file can't empty");
        }
        if (age <= 0) {
            return Msg.error("age is Illegal");
        }
        if (!BaseUtil.isChinaPhoneLegal(phone)) {
            return Msg.error("phone is Illegal");
        }
        employeeMapper.add(employee);
        return Msg.ok();
    }

    @Override
    public Msg update(Employee employee) {
        String name = employee.getName().trim();
        String password = employee.getPassword().trim();
        String phone = employee.getPhone().trim();
        String sex = employee.getSex().trim();
        String address = employee.getAddress().trim();
        Integer age = employee.getAge();
        if (name.length() == 0 || password.length() == 0 || phone.length() == 0 || sex.length() == 0 || address.length() == 0) {
            return Msg.error("file can't empty");
        }
        if (age <= 0) {
            return Msg.error("age is Illegal");
        }
        if (!BaseUtil.isChinaPhoneLegal(phone)) {
            return Msg.error("phone is Illegal");
        }
        if (BaseUtil.isContainChinese(password)) {
            return Msg.error("password is Illegal");
        }
        employeeMapper.add(employee);
        return Msg.ok();
    }

    @Override
    public void deleteById(Integer id) {
        employeeMapper.deleteById(id);
    }
}
