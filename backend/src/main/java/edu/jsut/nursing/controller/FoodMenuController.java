package edu.jsut.nursing.controller;

import edu.jsut.nursing.mapper.FoodMenuMapper;
import edu.jsut.nursing.model.FoodMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("foodMenu")
public class FoodMenuController {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private FoodMenuMapper foodMenuMapper;

    @RequestMapping("list")
    public List<FoodMenu> getFoodMenuList() {
        return foodMenuMapper.selectAll();
    }

    @RequestMapping("insert")
    public boolean insertFoodMenu(@RequestBody FoodMenu foodMenu) {
        logger.info("user: " + foodMenu.getUser());
        return foodMenuMapper.insert(foodMenu) == 1;
    }

    @RequestMapping("delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        return foodMenuMapper.deleteByPrimaryKey(id) == 1;
    }

    @RequestMapping("update")
    public boolean update(@RequestBody FoodMenu foodMenu) {
        return foodMenuMapper.updateByPrimaryKey(foodMenu) == 1;
    }

    @RequestMapping("get/{id}")
    public FoodMenu getFoodMenu(@PathVariable Integer id) {
        return this.foodMenuMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("query")
    public List<FoodMenu> query(@RequestBody FoodMenu foodMenu) {
        return foodMenuMapper.selectByUserId(foodMenu);
    }
}
