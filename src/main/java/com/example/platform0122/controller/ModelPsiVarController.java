package com.example.platform0122.controller;

import com.example.platform0122.service.ModelPsiVarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huanglijun on 2019/1/22
 */
@RestController
public class ModelPsiVarController {

    @Autowired
    private ModelPsiVarService modelPsiVarService;

    @GetMapping(value = "/model")
    public Object queryPushData(){
        return modelPsiVarService.queryPushData();
    }
}
