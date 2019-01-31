package com.example.platform0122.controller;

import com.example.platform0122.entity.League;
import com.example.platform0122.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huanglijun on 2019/1/31
 */
@Controller
@RequestMapping(value = "/league")
public class ThymeleafTestController {

    @Autowired
    private LeagueService leagueService;

    //点击"修改"按钮跳转至修改联赛信息页面
    @GetMapping("/modifyLeague")
    public String toModifyPage(int league_id, Model model){
        /*League league=leagueRepository.getOne(league_id);*/
        League league=leagueService.getLeaugeById(league_id);
        model.addAttribute("league",league);
        return "league/modifyLeague";
    }

    //修改联赛信息
    @PostMapping("/modifyLeague")
    public String modifyLeague(League league){
        leagueService.saveLeague(league);
        return "redirect:/leagues";
    }

    @GetMapping("/optionSelector")
    public String toModify(int league_id,Model model){
        League league=leagueService.getLeaugeById(league_id);
        model.addAttribute("league",league);
        return "optionSelected";
    }
}
