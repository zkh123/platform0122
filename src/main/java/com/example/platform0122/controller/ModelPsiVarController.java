package com.example.platform0122.controller;

import com.example.platform0122.service.ModelPsiVarService;
import com.example.platform0122.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huanglijun on 2019/1/22
 */
@RestController
@RequestMapping(value = "modelPsiVar")
public class ModelPsiVarController {

    private static final Logger logger = LoggerFactory.getLogger(ModelPsiVarController.class);

    @Autowired
    private ModelPsiVarService modelPsiVarService;

    @GetMapping(value = "/selectById")
    public Object selectById(@RequestParam(value = "id")int id){
        return ResultUtil.success(modelPsiVarService.selectById(id));
    }

    @GetMapping(value = "deleteById")
    public Object deleteById(@RequestParam(value = "id")int id){
        return ResultUtil.success(modelPsiVarService.deleteById(id));
    }

    @GetMapping(value = "updateBatch")
    public Object updateBatch(@RequestParam(value = "ids") String ids){
        logger.info(ids);
        modelPsiVarService.updateBatch(ids);
        return ResultUtil.success();
    }
}
