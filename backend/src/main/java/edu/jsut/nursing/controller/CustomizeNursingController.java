package edu.jsut.nursing.controller;

import edu.jsut.nursing.mapper.NursingMapper;
import edu.jsut.nursing.model.Nursing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nursing")
public class CustomizeNursingController {
    @Autowired
    private NursingMapper nursingMapper;

    /**
     * 新增
     */
    //@RequestBody： 接受提交的数据是JSON格式
    @RequestMapping("add")
    public String add(@RequestBody Nursing nursing) {
        nursingMapper.insert(nursing);
        return "success";
    }

    /**
     * 查询所有
     */
    @RequestMapping("selAll")
    public List<Nursing> selAll() {
        return nursingMapper.selectAll();
    }

    /**
     * 条件查询所有数据
     */
    @RequestMapping("queryById/{id}")
    public Nursing queryById(@PathVariable Integer id) {
        return nursingMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除
     */
    @RequestMapping("del/{id}")
    public String del(@PathVariable Integer id) {
        nursingMapper.deleteByPrimaryKey(id);
        return "success";
    }

    /*编辑*/
    @RequestMapping("edit")
    public String edit(@RequestBody Nursing nursing) {
        nursingMapper.updateByPrimaryKey(nursing);
        return "success";
    }

}
