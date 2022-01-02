package edu.jsut.nursing.mapper;

import edu.jsut.nursing.model.Nursing;

import java.util.List;

public interface NursingMapper {
    int deleteByPrimaryKey(Integer nursingId);

    int insert(Nursing record);

    Nursing selectByPrimaryKey(Integer nursingId);

    List<Nursing> selectAll();

    int updateByPrimaryKey(Nursing record);
}