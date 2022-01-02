package edu.jsut.nursing.controller;

import edu.jsut.nursing.mapper.FoodMapper;
import edu.jsut.nursing.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodMapper foodMapper;

    @RequestMapping("add")
    public boolean addFood(@RequestBody Food food) {
        return foodMapper.insert(food) == 1;
    }

    @RequestMapping("list")
    public List<Food> getFoodList() {
        return foodMapper.selectAll();
    }

    @RequestMapping("delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        return foodMapper.deleteByPrimaryKey(id) == 1;
    }

    @RequestMapping("get/{id}")
    public Food getFood(@PathVariable Integer id) {
        return foodMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("query")
    public List<Food> query(@RequestBody Food food) {
        return foodMapper.query(food);
    }

    @RequestMapping("update")
    public boolean update(@RequestBody Food food) {
        return foodMapper.updateByPrimaryKey(food) == 1;
    }
}
