package com.example.platform0122.dao.drools;

import com.example.platform0122.entity.ModelPsiVar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huanglijun on 2019/1/22
 */
public interface ModelPsiVarMapper {

    ModelPsiVar selectById(@Param(value = "id")int id);

    int deleteById(@Param(value = "id")int id);

    void updateBatch(@Param(value = "list") List<ModelPsiVar> list);
}
