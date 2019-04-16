package com.example.cloud1.dao;

import com.example.cloud1.model.LDCODE;

import java.util.List;

public interface LDCODEMapper {
    int insert(LDCODE record);

    int insertSelective(LDCODE record);

    List<LDCODE> selectCodeAndCodetypeAndCodename(LDCODE ldcode);
}