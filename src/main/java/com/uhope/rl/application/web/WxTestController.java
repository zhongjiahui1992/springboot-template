package com.uhope.rl.application.web;

import com.uhope.rl.wechat.domain.WxGovInfo;
import com.uhope.rl.wechat.service.WxGovInfoService;
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

    @GetMapping("/gov")
    public List<WxGovInfo> govInfoResult(String dbcode){
        //DBIdentifier.setProjectCode(dbcode);
        return wxGovInfoService.find();
    }


}
