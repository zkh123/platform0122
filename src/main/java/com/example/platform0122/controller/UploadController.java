package com.example.platform0122.controller;

import com.example.platform0122.service.DroolsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static String UPLOADED_FOLDER = "D:\\IntelliJIDEA_workspace\\git_pisk\\job\\platform0122\\upload\\";

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

            if (new File(pathRoot).exists()){
                logger.info("文件已经存在：" + file.getOriginalFilename());
                redirectAttributes.addFlashAttribute("message","Your file is exist: '" + file.getOriginalFilename() + "'");
                return "redirect:/file/uploadStatus";
            }
            Files.write(path,bytes);
            redirectAttributes.addFlashAttribute("message","You successfully uploaded '" + file.getOriginalFilename() + "'");
        }catch (IOException e){
            e.printStackTrace();
        }

        return "redirect:/file/uploadStatus";
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
