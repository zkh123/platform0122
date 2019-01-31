package com.example.platform0122.service;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collection;

/**
 * Created by huanglijun on 2019/1/31
 */
@Component
public class KieService {
    public KieSession apptest_kSession = null;//测试使用
    public KieSession out_apptest_kSession = null;//读取外界drl文件测试使用
    public StatelessKieSession out_other_apptest_kSession = null;//读取外界drl文件测试使用

    public KieSession getAppTestKSession(){
        if(apptest_kSession == null){
            KieServices kieServices = KieServices.Factory.get();
            KieContainer kieContainer = kieServices.getKieClasspathContainer();
            apptest_kSession = kieContainer.newKieSession("ksession-hljtest");
        }
        return apptest_kSession;
    }

    public StatelessKieSession getOutAppTestKSession() throws UnsupportedEncodingException {
        KnowledgeBuilder kbuilder  = KnowledgeBuilderFactory.newKnowledgeBuilder();
        String filePath = "D:\\IntelliJIDEA_workspace\\git_pisk\\job\\platform0122\\upload\\hlj-test-1.0.0.1.drl";
        File file = new File(URLDecoder.decode(filePath,"utf-8"));
        kbuilder.add(ResourceFactory.newFileResource(file), ResourceType.DRL);
        InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        Collection<KiePackage> ss = kbuilder.getKnowledgePackages();
        kbase.addPackages(ss);
        out_other_apptest_kSession = kbase.newStatelessKieSession();
        return out_other_apptest_kSession;
    }

    public KieSession test() throws UnsupportedEncodingException {
        if (out_apptest_kSession == null){
            KnowledgeBuilder kbuilder  = KnowledgeBuilderFactory.newKnowledgeBuilder();
            String filePath = "D:\\IntelliJIDEA_workspace\\git_pisk\\job\\platform0122\\upload\\hlj-test-1.0.0.1.drl";
            File file = new File(URLDecoder.decode(filePath,"utf-8"));
            kbuilder.add(ResourceFactory.newFileResource(file), ResourceType.DRL);
            InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
            Collection<KiePackage> ss = kbuilder.getKnowledgePackages();
            kbase.addPackages(ss);
            out_apptest_kSession = kbase.newKieSession();
        }
        return out_apptest_kSession;
    }
}