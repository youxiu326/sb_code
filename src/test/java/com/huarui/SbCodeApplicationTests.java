package com.huarui;

import com.huarui.inter.Context;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbCodeApplicationTests {

	@Test
	public void contextLoads() throws Exception {

		Context context = new Context();
		BigDecimal bigDecimal = context.calRecharge(1,500);
		System.out.println(bigDecimal);

	}

}
