package com.example.platform0122.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * Created by huanglijun on 2019/2/2
 */
public class SysConf {
    public int batchSize = 10000;

    public List<Job> jobs;

    public static SysConf load(String fileName) throws IOException {
        Yaml y = new Yaml();
        File f = new File(fileName);
        InputStream is = null;
        if (f.exists()) {
            System.out.println("Using file " + f.getName());
            is = new FileInputStream(fileName);
        } else {
            URL r = ClassLoader.getSystemResource(fileName);
            if (r != null)
                System.out.println(r);
            is = ClassLoader.getSystemResourceAsStream(fileName);
        }
        return y.loadAs(is, SysConf.class);
    }

    public static class Job {
        public String jobName;
        public String inputClazz;
        public String inputFolder;
        public String inputFileNamePattern;
        public String droolsJarName;
        public List<String> drlFiles;
        public String outputFile;
        public String inFormat = "json";
        public String outFormat = "csv";
    }


    public static void main(String[] args) {
        try {
            SysConf sysConf = SysConf.load("conf/conf.yaml");
            System.out.println(sysConf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
