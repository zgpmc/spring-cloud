package com.example.cloud1.server;

import com.example.cloud1.model.LDCODE;

import java.util.List;

/**
 * 创建时间:2019/04/15
 * 创建人:pmc
 * 描述:
 */
public interface ILdCode
{
    int add(LDCODE ldcode);

    List<LDCODE> selectByCodeAndCodenameAndCodetype(LDCODE ldcode);
}
