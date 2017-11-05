package com.jack.springboot19test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jack.springboot19test.dao.PersonRepository;
import com.jack.springboot19test.entity.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

//14.版本之前用的是SpringJUnit4ClassRunner.class
@RunWith(SpringRunner.class)
//1.4版本之前用的是//@SpringApplicationConfiguration(classes = Application.class)
@SpringBootTest(classes = Springboot19testApplication.class)
@WebAppConfiguration
@Transactional
public class Springboot19testApplicationTests {

	@Autowired
	private PersonRepository personRepository;

	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	String expectedJson;

	/*@Test
	public void contextLoads() {
	}*/
	@Before
	public void setUp()throws JsonProcessingException{
		/*Person p1 = new Person();
		p1.setName("jack6");
		Person p2 = new Person();
		p2.setName("jack7");
		personRepository.save(p1);
		personRepository.save(p2);*/
		expectedJson = Obj2Json(personRepository.findAll());
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	public String Obj2Json(Object obj)throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

	@Test
	public void testPersonController()throws Exception{
		String uri="/person/findall";
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		System.out.println("content : "+content);
		Assert.assertEquals("错误，正确的返回值为200",200,status);
		Assert.assertEquals("错误，返回值和预期返回值不一致",expectedJson,content);
	}


}
