package com.example.platform0122.service;

import com.example.platform0122.dao.drools.ModelPsiVarMapper;
import com.example.platform0122.entity.ModelPsiVar;
import com.example.platform0122.entity.ModelPsiVarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Integer updateBatch(String ids){
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
        return modelPsiVarMapper.updateBatch(list);
    }


    public int updateByIds(){
        int[] arr = new int[4];
        arr[0] = 26;
        arr[1] = 27;
        arr[2] = 28;
        arr[3] = 29;
        return modelPsiVarMapper.updateByIds(arr);
    }

    public Integer insertModelPsiVar(ModelPsiVarModel modelPsiVarModel){
        ModelPsiVar modelPsiVar = new ModelPsiVar();
        if (modelPsiVar == null){
            return 0;
        }
        modelPsiVar.setType(modelPsiVarModel.getType());
        modelPsiVar.setVar(modelPsiVarModel.getVar());

        return modelPsiVarMapper.insertModelPsiVar(modelPsiVar);
    }

    public Integer insertBatch(int size){
        List<ModelPsiVar> list = new ArrayList<>();
        for (int i = 0 ; i < size ; i++){
            ModelPsiVar modelPsiVar = new ModelPsiVar();
            modelPsiVar.setType(i);
            modelPsiVar.setVar("{\"value\":\"value_1\",\"key\":\"key_1\"}");
            list.add(modelPsiVar);
        }
        return modelPsiVarMapper.insertBatch(list);
    }

    public Integer addAndGetId(ModelPsiVarModel modelPsiVarModel){
        if (modelPsiVarModel == null){
            return 0;
        }
        ModelPsiVar modelPsiVar = new ModelPsiVar();
        modelPsiVar.setType(modelPsiVarModel.getType());
        modelPsiVar.setVar(modelPsiVarModel.getVar());
        Integer size = modelPsiVarMapper.addAndGetId(modelPsiVar);
        if (size == 1){
            return modelPsiVar.getId();
        }else {
            return 0;
        }
    }
}
