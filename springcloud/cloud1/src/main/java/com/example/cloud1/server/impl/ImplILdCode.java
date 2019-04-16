package com.example.cloud1.server.impl;

import com.example.cloud1.dao.LDCODEMapper;
import com.example.cloud1.model.LDCODE;
import com.example.cloud1.server.ILdCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创建时间:2019/04/15
 * 创建人:pmc
 * 描述:
 */
@Service
public class ImplILdCode implements ILdCode
{
    @Autowired
    private LDCODEMapper ldcodeMapper;

    @Override
    public int add(LDCODE ldcode)
    {
        return ldcodeMapper.insert(ldcode);
    }

    @Override
    public List<LDCODE> selectByCodeAndCodenameAndCodetype(LDCODE ldcode)
    {
        return ldcodeMapper.selectCodeAndCodetypeAndCodename(ldcode);
    }
}
