package com.mrpeng;

import com.mrpeng.entity.SecKill;
import com.mrpeng.servce.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlatFormPublishApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SeckillService seckillService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetSeckillList() {
		List<SecKill> list = this.seckillService.getSeckillList();
		// System.out.println(list);
		logger.info("list={}", list);
	}

}
