package edu.jsut.nursing.mapper;

import edu.jsut.nursing.model.Admin;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(String adminRname);

    int insert(Admin record);

    Admin selectByPrimaryKey(String adminRname);

    Admin query(Admin admin);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);
}