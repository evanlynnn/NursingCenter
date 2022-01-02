package edu.jsut.nursing.mapper;

import edu.jsut.nursing.model.Checkin;

import java.util.List;

public interface CheckinMapper {
    int deleteByPrimaryKey(Integer checkinId);

    int insert(Checkin record);

    Checkin selectByPrimaryKey(Integer checkinId);

    List<Checkin> selectAll();

    List<Checkin> queryByDate(Checkin checkin);

    int updateByPrimaryKey(Checkin record);
}