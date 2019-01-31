package com.example.platform0122.service;

import com.alibaba.fastjson.JSONObject;
import com.example.platform0122.entity.League;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by huanglijun on 2019/1/31
 */
@Service
public class LeagueService {
    private final Logger logger = LoggerFactory.getLogger(LeagueService.class);

    public League getLeaugeById(int league_id) {
        logger.info("LeagueService getLeaugeById league_id : " + league_id);

        League league = new League();
        league.setLeague_id(1);
        league.setLeagueName("nba职业联赛");
        league.setShorterName("NBA");
        league.setStartDate("2019-01-31 00:00:00");
        league.setEndDate("2019-02-14 00:00:00");
        league.setSponsor("上海篮协");
        league.setConstitution("没有任何赛事章程");
        league.setLevel("业余专业组");
        league.setGender("男");
        league.setNumber(10);
        league.setHalfTime("45");
        league.setHalfRelaxTime("15");
        league.setAbstentionScore("无人弃权");
        return league;
    }

    public void saveLeague(League league) {
        logger.info("LeagueService saveLeague success!!!" + JSONObject.toJSONString(league));
        return;
    }
}
