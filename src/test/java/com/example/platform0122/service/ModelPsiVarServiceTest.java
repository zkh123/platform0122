package com.example.platform0122.service;

import com.alibaba.fastjson.JSONObject;
import com.example.platform0122.Platform0122ApplicationTests;
import com.example.platform0122.entity.ModelPsiVar;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huanglijun on 2019/1/29
 */
public class ModelPsiVarServiceTest extends Platform0122ApplicationTests {

    @Autowired
    private ModelPsiVarService modelPsiVarService;

    @Test
    public void selectById(){
        ModelPsiVar modelPsiVar = modelPsiVarService.selectById(26);
        System.out.println(JSONObject.toJSONString(modelPsiVar));
    }
}
