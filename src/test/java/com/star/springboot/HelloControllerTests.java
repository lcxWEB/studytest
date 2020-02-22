//package com.star.springboot;
//
//import com.star.springboot.entity.UUAgent;
//import com.star.springboot.mapper.UUAgentMapper;
//import com.star.springboot.utils.SqlSessionFactoryUtil;
//import org.apache.ibatis.session.RowBounds;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@WebAppConfiguration
//public class HelloControllerTests {
//
//	private MockMvc mvc;
//
//	private SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
//
//	@Before
//	public void setUp() throws Exception {
//		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
//	}
//
//	@Test
//	public void getHello() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andDo(MockMvcResultHandlers.print())
//				.andReturn();
//	}
//
//
//	@Test
//	public void testSelect() {
//		try {
//			UUAgentMapper uuAgentMapper = sqlSession.getMapper(UUAgentMapper.class);
//			int start = 0;//正确的叫法应该是offset
//			int pagesize = 3;//<span style="font-family: 'Microsoft YaHei';">正确的叫法应该是limit</span>
//			RowBounds rowBounds = new RowBounds(start,pagesize);
//			List<UUAgent> re = uuAgentMapper.listAllUUAgent(rowBounds);
//			for(UUAgent ui:re){
//				System.out.println(ui);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
