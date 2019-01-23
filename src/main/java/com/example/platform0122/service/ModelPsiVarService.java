package com.example.platform0122.service;

import com.alibaba.fastjson.JSONArray;
import com.example.platform0122.dao.drools.ModelPsiVarMapper;
import com.example.platform0122.entity.ModelPsiVar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huanglijun on 2019/1/22
 */
@Service
public class ModelPsiVarService {

    @Autowired
    private ModelPsiVarMapper modelPsiVarMapper;

    public ModelPsiVar selectById(int id){
        return modelPsiVarMapper.selectById(id);
    }

    public int deleteById(int id){
        return modelPsiVarMapper.deleteById(id);
    }

    public void updateBatch(String ids){
        String[] str = ids.split(",");
        List<ModelPsiVar> list = new ArrayList<ModelPsiVar>();
        int length = str.length;
        for (int i = 0 ; i < length ; i++){
            ModelPsiVar modelPsiVar = new ModelPsiVar();
            if (i == 0){
                modelPsiVar.setId(Integer.valueOf(str[i].split("\\[")[1]));
            }else if (i == length-1){
                modelPsiVar.setId(Integer.valueOf(str[i].split("\\]")[0]));
            }else {
                modelPsiVar.setId(Integer.valueOf(str[i]));
            }
            list.add(modelPsiVar);
        }
        modelPsiVarMapper.updateBatch(list);
    }
}
