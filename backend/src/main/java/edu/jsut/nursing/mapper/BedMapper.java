package edu.jsut.nursing.mapper;

import edu.jsut.nursing.model.Bed;

import java.util.List;

public interface BedMapper {
    int deleteByPrimaryKey(Integer bedId);

    int insert(Bed record);

    Bed selectByPrimaryKey(Integer bedId);

    List<Bed> selectAll();

    int updateByPrimaryKey(Bed record);
}