package com.uhope.rl.application;

import com.github.pagehelper.PageInfo;
import com.uhope.rl.system.domain.SmAuthority;
import com.uhope.rl.system.service.SmAuthorityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RlApplicationTemplateApplicationTests {
    @Autowired
    private SmAuthorityService authorityService;

    @Test
    public void contextLoads() {
        PageInfo<SmAuthority> pageInfo = authorityService.find(10, 0);
    }

}
