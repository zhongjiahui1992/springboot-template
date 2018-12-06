package com.uhope.rl.application.web;

import com.alibaba.fastjson.JSON;
import com.uhope.rl.wechat.domain.WxGovInfo;
import com.uhope.rl.wechat.service.WxGovInfoService;
import com.zjh.redis.client.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/test")
public class WxTestController {
    @Autowired
    private WxGovInfoService wxGovInfoService;
    @Autowired
    private RedisClient redisClient;

    @GetMapping("/gov")
    public List<WxGovInfo> govInfoResult(String dbcode){
        //DBIdentifier.setProjectCode(dbcode);
        return wxGovInfoService.find();
    }

    @GetMapping("/redis")
    public String getRedisMsg(){
        redisClient.set("111","222");
        return redisClient.get("111");
    }

}
