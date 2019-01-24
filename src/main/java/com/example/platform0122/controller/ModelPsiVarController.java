package com.example.platform0122.controller;

import com.example.platform0122.entity.ModelPsiVarModel;
import com.example.platform0122.service.ModelPsiVarService;
import com.example.platform0122.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return ResultUtil.success(modelPsiVarService.updateBatch(ids));
    }

    @GetMapping(value = "updateByIds")
    public Object updateByIds(){
        return ResultUtil.success(modelPsiVarService.updateByIds());
    }

    /**
     * {
     * 	"type": 1,
     * 	"var": "{\"value\":\"value_1\",\"key\":\"key_1\"}"
     * }
     * @param modelPsiVarModel
     * @return
     */
    @PostMapping(value = "insertModelPsiVar")
    public Object insertModelPsiVar(@RequestBody ModelPsiVarModel modelPsiVarModel){
        return ResultUtil.success(modelPsiVarService.insertModelPsiVar(modelPsiVarModel));
    }


    @PostMapping(value = "insertBatch")
    public Object insertBatch(@RequestParam(value = "size") int size){
        return ResultUtil.success(modelPsiVarService.insertBatch(size));
    }

    @PostMapping(value = "addAndGetId")
    public Object addAndGetId(@RequestBody ModelPsiVarModel modelPsiVarModel){
        return ResultUtil.success(modelPsiVarService.addAndGetId(modelPsiVarModel));
    }
}
