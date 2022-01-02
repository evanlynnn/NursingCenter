package edu.jsut.nursing.controller;

import edu.jsut.nursing.mapper.NursingRecordMapper;
import edu.jsut.nursing.model.NursingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nursingrecord")
public class NursingRecordController {
    @Autowired
    private NursingRecordMapper nursingRecordMapper;

    @RequestMapping("queryById/{id}")
    public NursingRecord queryById(@PathVariable Integer id) {
        return nursingRecordMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("edit")
    public String edit(NursingRecord nursingRecord) {
        nursingRecordMapper.updateByPrimaryKey(nursingRecord);
        return "success";
    }

    @RequestMapping("add")
    public String add(NursingRecord nursingRecord) {
        nursingRecordMapper.insert(nursingRecord);
        return "success";
    }

    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id) {
        nursingRecordMapper.deleteByPrimaryKey(id);
        return "success";
    }
}
