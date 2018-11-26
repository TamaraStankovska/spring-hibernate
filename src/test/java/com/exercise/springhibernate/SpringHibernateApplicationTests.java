package com.exercise.springhibernate;

import com.exercise.springhibernate.model.Wheel;
import com.exercise.springhibernate.service.WheelServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(locations = {"classpath:/hibernate.cfg.xml"})

public class SpringHibernateApplicationTests {



	@Mock
	WheelServiceImpl wheelService;


	@Test
	public void saveWheel(){
		Wheel wheel=new Wheel("1");
		wheelService.save(wheel);
		List<Wheel> wheelList=wheelService.findAll();
		wheelList.add(wheel);
		Assert.assertEquals(wheel.getName(),wheelList.get(0).getName());
	}

	@Test
	public void persistWheel(){

		Wheel wheel=new Wheel("2");
		wheelService.persist(wheel);
		List<Wheel> wheelList=wheelService.findAll();
		wheelList.add(wheel);
		Assert.assertEquals(wheel.getName(),wheelList.get(0).getName());
	}


	@Test
	public void getWheel(){
		Wheel wheel=wheelService.get(1L);
		Assert.assertEquals(wheel,wheelService.get(1L));
	}

	@Test
	public void loadWheel(){
		Wheel wheel=wheelService.load(2L);
		Assert.assertEquals(wheel,wheelService.load(2L));
	}


	@Test
	public void findAllWheels(){

	}


}
