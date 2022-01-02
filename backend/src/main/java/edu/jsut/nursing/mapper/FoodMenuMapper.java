package edu.jsut.nursing.mapper;

import edu.jsut.nursing.model.FoodMenu;
import java.util.List;

public interface FoodMenuMapper {
    int deleteByPrimaryKey(Integer menuId);

    int insert(FoodMenu record);

    FoodMenu selectByPrimaryKey(Integer menuId);

    List<FoodMenu> selectAll();

    int updateByPrimaryKey(FoodMenu record);

    List<FoodMenu> selectByUserId(FoodMenu foodMenu);
}