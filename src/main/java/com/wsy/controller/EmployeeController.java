package com.wsy.controller;

import com.wsy.entity.Employee;
import com.wsy.service.EmployeeService;
import com.wsy.util.Msg;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: wsy
 * Date: 2020/9/29
 * Time: 20:32
 * Description: No Description
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    Logger logger=Logger.getLogger(EmployeeController.class);

    @RequestMapping("/add")
    public Msg add(Employee employee) {
        logger.info("员工信息："+employee);
        Msg msg = employeeService.add(employee);
        return msg;

    }

    @RequestMapping("/getall")
    public Msg getAll() {
        List<Employee> employees = employeeService.getAll();
        return Msg.ok(null,employees);
    }

    @RequestMapping("/get")
    public Msg getById(Integer id) {
        Employee employee = employeeService.getById(id);
        return Msg.ok(null,employee);
    }

    @RequestMapping("/delete")
    public Msg delete(Integer id) {
        employeeService.deleteById(id);
        return Msg.ok(null,"/");
    }
    @RequestMapping("/update")
    public Msg update(Employee employee) {
        Msg msg = employeeService.update(employee);
        return msg;

    }
}
