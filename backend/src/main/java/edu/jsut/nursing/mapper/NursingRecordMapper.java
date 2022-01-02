package edu.jsut.nursing.mapper;

import edu.jsut.nursing.model.NursingRecord;

import java.util.List;

public interface NursingRecordMapper {
    int deleteByPrimaryKey(Integer recordId);

    int insert(NursingRecord record);

    NursingRecord selectByPrimaryKey(Integer recordId);

    List<NursingRecord> selectAll();

    int updateByPrimaryKey(NursingRecord record);
}
