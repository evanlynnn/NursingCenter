package edu.jsut.nursing.mapper;

import edu.jsut.nursing.model.Food;

import java.util.List;

public interface FoodMapper {
    int deleteByPrimaryKey(Integer foodId);

    int insert(Food record);

    Food selectByPrimaryKey(Integer foodId);

    List<Food> selectAll();

    int updateByPrimaryKey(Food record);

    List<Food> query(Food food);
}