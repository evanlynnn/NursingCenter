package edu.jsut.nursing.controller;

import edu.jsut.nursing.mapper.CheckinMapper;
import edu.jsut.nursing.model.Checkin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CheckinController
 * @Author Lnino
 * @Date 2021/12/29 16:06
 */
@RestController
@RequestMapping("/checkin")
public class CheckinController {

    @Autowired
    private CheckinMapper checkinMapper;

    @RequestMapping("selAll")
    public List<Checkin> selAll(){
        return checkinMapper.selectAll();
    }


    @RequestMapping("queryByDate")
    public List<Checkin> queryByDate(@RequestBody Checkin checkin){
        return checkinMapper.queryByDate(checkin);
    }

    @RequestMapping("sel/{id}")
    public Checkin sel(@PathVariable Integer id){
        return checkinMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("del/{id}")
    public String delete(@PathVariable Integer id){
        checkinMapper.deleteByPrimaryKey(id);
        return "success";
    }

    @RequestMapping("update")
    public String update(@RequestBody Checkin checkin){
        checkinMapper.updateByPrimaryKey(checkin);
        return "success";
    }


    @RequestMapping("Add")
    public String add(@RequestBody Checkin checkin){
        checkin.setCheckinDate(new Date());
        checkinMapper.insert(checkin);
        return "success";
    }

}
