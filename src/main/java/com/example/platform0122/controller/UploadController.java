package com.example.platform0122.controller;

import com.example.platform0122.entity.DroolsVersionRecord;
import com.example.platform0122.service.DroolsService;
import com.example.platform0122.service.DroolsVersionRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by huanglijun on 2019/1/31
 * 文件上传
 */
@Controller
@RequestMapping(value = "/file")
public class UploadController {
    private final Logger logger = LoggerFactory.getLogger(DroolsService.class);

    private static String UPLOADED_FOLDER = "D:\\IntelliJIDEA_workspace\\git_pisk\\job\\drools-platform0122\\upload\\";

    @Autowired
    private DroolsVersionRecordService droolsVersionRecordService;

    /**
     * http://localhost:8080/file/one
     * @return
     */
    @GetMapping(value = "/one")
    public String one(){
        return "upload";
    }

    @GetMapping(value = "/more")
    public String more(){
        return "uploadMore";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    /**
     * http://localhost:8080/file/upload
     * 上传单个文件
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping(value = "/upload")
    public String singleFileUpload(@RequestParam(value = "file") MultipartFile file,
                                   RedirectAttributes redirectAttributes){
        if (file.isEmpty()){
            redirectAttributes.addFlashAttribute("message","Please select a file to upload");
            return "redirect:/file/uploadStatus";
        }
        try {
            byte[] bytes = file.getBytes();
            String pathRoot = UPLOADED_FOLDER + file.getOriginalFilename();
            Path path = Paths.get(pathRoot);
            //判断文件是否存在
            if (new File(pathRoot).exists()){
                logger.info("文件已经存在：" + file.getOriginalFilename());
                redirectAttributes.addFlashAttribute("message","Your file is exist: '" + file.getOriginalFilename() + "'");
                return "redirect:/file/uploadStatus";
            }
            //将上传文件写到一个地方
            Files.write(path,bytes);

            //往drools记录表中插一条数据
            DroolsVersionRecord droolsVersionRecord = new DroolsVersionRecord();
            droolsVersionRecord.setUserId(1);
            droolsVersionRecord.setUsername("huanglijun");  //用户名 从登陆用户的session中获取

            droolsVersionRecord.setType(1);  //上传规则属于哪个业务线
            droolsVersionRecord.setDrlVersion(file.getOriginalFilename());  //上传规则的文件名
            droolsVersionRecordService.insertOne(droolsVersionRecord);
            redirectAttributes.addFlashAttribute("message","You successfully uploaded '" + file.getOriginalFilename() + "'");
            return "redirect:/file/uploadStatus";
        }catch (IOException e){
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message","You successfully uploaded '" + file.getOriginalFilename() + "'" + " ,error: " + e.toString());
            return "redirect:/file/uploadStatus";
        }
    }

    /**
     * 上传多个文件
     * @param files
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/uploadMore")
    public String moreFileUpload(@RequestParam(value = "file")MultipartFile[] files,
                                 RedirectAttributes redirectAttributes){
        if (files.length == 0){
            redirectAttributes.addFlashAttribute("message","Please select a file to upload");
            return "redirect:/file/uploadStatus";
        }

        for (MultipartFile file: files){
            try {
                byte[] bytes = file.getBytes();
                if (bytes.length == 0){
                    continue;
                }
                Path path = Paths.get(UPLOADED_FOLDER+file.getOriginalFilename());
                Files.write(path,bytes);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        redirectAttributes.addFlashAttribute("message","You successfully uploaded all");
        return "redirect:/file/uploadStatus";
    }
}
