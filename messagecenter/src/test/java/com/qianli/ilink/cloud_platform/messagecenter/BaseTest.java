package com.qianli.ilink.cloud_platform.messagecenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
//@Transactional(rollbackFor = Exception.class)
public class BaseTest {

	@Test
	public void contextLoads() {
	}

}
