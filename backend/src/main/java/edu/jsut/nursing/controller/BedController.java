package edu.jsut.nursing.controller;


import edu.jsut.nursing.mapper.BedMapper;
import edu.jsut.nursing.model.Bed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bed")

public class BedController {
    @Autowired
    private BedMapper bedMapper;

    @RequestMapping("selAll")
    public List<Bed> selAll() {
        return bedMapper.selectAll();
    }

    @RequestMapping("list")
    public List<Bed> list(@RequestBody Bed bed) {
        return bedMapper.queryAll(bed);
    }

    @RequestMapping("sel/{id}")
    public Bed sel(@PathVariable Integer id) {
        return bedMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("delete/{id}")
    public int delete(@PathVariable Integer id) {
        return bedMapper.deleteByPrimaryKey(id);
    }

    // RequestBody 请求的格式为JSON
    @RequestMapping("add")
    public String add(@RequestBody Bed bed) {
        bedMapper.insert(bed);
        return "success";
    }

    @RequestMapping("update")
    public String update(@RequestBody Bed bed) {
        bedMapper.updateByPrimaryKey(bed);
        return "success";
    }
}

