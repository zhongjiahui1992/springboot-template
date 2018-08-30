package com.uhope.rl.application.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import cn.binarywang.wx.miniapp.message.WxMaMessageRouter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhongjiahui.
 * @date Created on 2018/4/27.
 */
@Configuration
public class WxMaConfig {
    /**
     * 设置微信小程序的appid
     */
    @Value("${wechat.miniapp.appid}")
    private String appid;

    /**
     * 设置微信小程序的Secret
     */
    @Value("${wechat.miniapp.secret}")
    private String secret;

    /**
     * 设置微信小程序的token
     */
    @Value("${wechat.miniapp.token}")
    private String token;

    /**
     * 设置微信小程序的EncodingAESKey
     */
    @Value("${wechat.miniapp.aesKey}")
    private String aesKey;

    /**
     * 消息格式，XML或者JSON
     */
    @Value("${wechat.miniapp.msgDataFormat}")
    private String msgDataFormat;

    @Bean
    @ConditionalOnMissingBean
    public WxMaInMemoryConfig wxMaInMemoryConfig(){
        WxMaInMemoryConfig config = new WxMaInMemoryConfig();
        config.setAppid(appid);
        config.setSecret(secret);
        config.setToken(token);
        config.setAesKey(aesKey);
        config.setMsgDataFormat(msgDataFormat);

        return config;
    }

    @Bean
    @ConditionalOnMissingBean
    public WxMaService wxMaService(WxMaInMemoryConfig config){
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(config);
        return service;
    }

    @Bean
    @ConditionalOnMissingBean
    public WxMaMessageRouter wxMaMessageRouter(WxMaService wxMaService){
        return new WxMaMessageRouter(wxMaService);
    }
}
