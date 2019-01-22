package com.example.platform0122.service;

import com.example.platform0122.dao.drools.ModelPsiVarMapper;
import com.example.platform0122.entity.ModelPsiVar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huanglijun on 2019/1/22
 */
@Service
public class ModelPsiVarService {

    @Autowired
    private ModelPsiVarMapper modelPsiVarMapper;

    public ModelPsiVar queryPushData(){
        return modelPsiVarMapper.queryPushData();
    }
}
