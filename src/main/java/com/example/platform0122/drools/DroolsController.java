package com.example.platform0122.drools;

import com.example.platform0122.service.DroolsService;
import com.example.platform0122.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

/**
 * Created by huanglijun on 2019/1/31
 */
@Controller
@RequestMapping(value = "/execute/drools")
public class DroolsController {

    private final Logger logger = LoggerFactory.getLogger(DroolsService.class);

    @Autowired
    private DroolsService droolsService;

    /**
     * http://localhost:8080/execute/drools/hljTest
     * @return
     */
    @GetMapping(value = "/hljTest")
    @ResponseBody
    public Object doHljTestDrools(){
        long start = System.currentTimeMillis();
        for (int m = 0 ; m < 10000; m++){
            droolsService.singleDoHljTestDrools();
        }
        long end = System.currentTimeMillis();
        logger.info("doHljTestDrools time: " + (end-start));  //doHljTestDrools time: 1364
        return ResultUtil.success();
    }


    /**
     * http://localhost:8080/execute/drools/outTest
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping(value = "/outTest")
    @ResponseBody
    public Object readOutTest() throws UnsupportedEncodingException {
        long start = System.currentTimeMillis();
        for (int i = 0 ; i < 10000; i++){
            droolsService.singleReadOutTest();
        }
        long end = System.currentTimeMillis();
        logger.info("readOutTest time: " + (end-start));  //readOutTest time: 636
        return ResultUtil.success();
    }


    /**
     * http://localhost:8080/execute/drools/out
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping(value = "/out")
    @ResponseBody
    public Object readOut() throws UnsupportedEncodingException {
        long start = System.currentTimeMillis();
        for (int i = 0 ; i < 10000; i++){
            droolsService.singleReadOut();
        }
        long end = System.currentTimeMillis();
        logger.info("readOut time: " + (end-start));
        return ResultUtil.success();
    }


    /**
     * http://localhost:8080/execute/drools/outMore?type=1
     * @return
     * @throws UnsupportedEncodingException
     * @throws InterruptedException
     */
    @GetMapping(value = "/outMore")
    @ResponseBody
    public Object outMore(@RequestParam(value = "type") int type) throws UnsupportedEncodingException, InterruptedException {
        long start = System.currentTimeMillis();
        for (int j = 0 ; j < 10000 ; j++){
            droolsService.moreReadOut(type);
//            Thread.sleep(100);
        }
        long end = System.currentTimeMillis();
        logger.info("outMore time: " + (end-start));
        return ResultUtil.success();
    }

}