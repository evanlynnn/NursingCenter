package edu.jsut.nursing.controller;

import edu.jsut.nursing.mapper.AdminMapper;
import edu.jsut.nursing.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AdminController
 * @Author Lnino
 * @Date 2021/12/29 15:13
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminMapper adminMapper;
    @RequestMapping("login")
    String query(@RequestBody Admin admin){
        Admin admin1= adminMapper.query(admin);
        if (admin1==null){
            return "failed";}
        return "success";
    }

}
