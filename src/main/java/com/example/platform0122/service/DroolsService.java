package com.example.platform0122.service;

import com.alibaba.fastjson.JSONObject;
import com.example.platform0122.entity.DroolsVersionRecord;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.command.Command;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.command.CommandFactory;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hljdrools.hljTest.HljDemo;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by huanglijun on 2019/1/31
 */
@Service
public class DroolsService extends KieService{

    @Autowired
    private DroolsVersionRecordService droolsVersionRecordService;

    private final Logger logger = LoggerFactory.getLogger(DroolsService.class);

    private String getDrl(int type){
        String drlVersion = "";
        DroolsVersionRecord droolsVersionRecord = droolsVersionRecordService.selectOneByType(type);
        if (droolsVersionRecord != null){
            drlVersion = droolsVersionRecord.getDrlVersion();
        }
        return drlVersion;
    }

    public void singleDoHljTestDrools(){

        HljDemo hljDemo = new HljDemo();
        hljDemo.setUsername("hlj");
        hljDemo.setUserId(1111);
        hljDemo.setSex(false);
        hljDemo.setAge(90);

//        logger.info("hlj-test-1.0.0.1 请求入参：" + JSONObject.toJSONString(hljDemo));

        KieSession kieSession = super.getAppTestKSession();
        kieSession.insert(hljDemo);
        kieSession.fireAllRules();

        logger.info("singleDoHljTestDrools hlj-test-1.0.0.1 返回出参：" + JSONObject.toJSONString(hljDemo));
    }


    public void singleReadOutTest() throws UnsupportedEncodingException {
        KieSession kieSession = test();
        HljDemo hljDemo = new HljDemo();
        hljDemo.setUsername("hlj");
        hljDemo.setUserId(1111);
        hljDemo.setSex(false);
        hljDemo.setAge(90);
        kieSession.insert(hljDemo);
        kieSession.fireAllRules();
        logger.info("singleReadOut hlj-test-1.0.0.1 返回出参：" + JSONObject.toJSONString(hljDemo));
    }



    public void singleReadOut() throws UnsupportedEncodingException {
        KnowledgeBuilder kbuilder  = KnowledgeBuilderFactory.newKnowledgeBuilder();

        String filePath = "D:\\IntelliJIDEA_workspace\\git_pisk\\job\\platform0122\\upload\\hlj-test-1.0.0.1.drl";
        File file = new File(URLDecoder.decode(filePath,"utf-8"));
        kbuilder.add(ResourceFactory.newFileResource(file), ResourceType.DRL);
        InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        Collection<KiePackage> ss = kbuilder.getKnowledgePackages();
        kbase.addPackages(ss);
        StatelessKieSession ksession = kbase.newStatelessKieSession();
        HljDemo hljDemo = new HljDemo();
        hljDemo.setUsername("hlj");
        hljDemo.setUserId(1111);
        hljDemo.setSex(false);
        hljDemo.setAge(90);
//        logger.info("hlj-test-1.0.0.1 请求入参：" + JSONObject.toJSONString(hljDemo));

        ksession.execute(hljDemo);



        logger.info("singleReadOut hlj-test-1.0.0.1 返回出参：" + JSONObject.toJSONString(hljDemo));
    }


    public void moreReadOut(int type) throws UnsupportedEncodingException {
        StatelessKieSession ksession = getOutAppTestKSession(getDrl(type));
        int n = 10;
        List<Command> list = new ArrayList<>();
        for (int i = 0 ; i < n ; i++){
            HljDemo hljDemo = new HljDemo();
            hljDemo.setUsername("hlj");
            hljDemo.setUserId(2222);
            hljDemo.setSex(false);
            hljDemo.setAge(90);
            list.add(CommandFactory.newInsert(hljDemo,i+""));
        }

        ExecutionResults results = ksession.execute(CommandFactory.newBatchExecution(list));
        List<HljDemo> out = new ArrayList<>();
        for (int j = 0 ; j < n; j++){
            Object obj = results.getValue(j+"");
            if (obj != null){
                try {
                    HljDemo hljDemo = (HljDemo)obj;
                    out.add(hljDemo);
                }catch (Exception e){}
            }
        }

        logger.info("hlj-test-1.0.0.1 返回出参：" + JSONObject.toJSONString(out));

    }

}
