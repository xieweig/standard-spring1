package org.anyway.manager;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.xpath;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.anyway.controller.MvcController;
import org.apache.http.HttpResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.Response;

import net.bytebuddy.asm.Advice.This;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServletTest  {
	@Resource
	private MvcController controller;
	@Mock
	HttpServletRequest request ;
	// = mock(HttpServletRequest.class);
	@Mock
	HttpServletResponse response ;
	// = mock(HttpServletResponse.class);

	
	@Test
	public void test01() throws FileNotFoundException, UnsupportedEncodingException, IOException {
		MockitoAnnotations.initMocks(this.getClass());
		when(request.getParameter("first")).thenReturn("1st");
		when(request.getParameter("second")).thenReturn("2nd");
		when(request.getParameter("third")).thenReturn("3rd");
		
		Path target = Paths.get("/home/xieweig/Documents/MockTest.txt");
		if (Files.notExists(target)) {
			Files.createFile(target);
		}
		
		when(response.getWriter()).thenReturn(new PrintWriter(target.toFile(),"utf-8"));
		
		/*core use;*/
		ModelAndView modelAndView =controller.show2(request, response);
		
		Object object =modelAndView.getModel().get("list");
		((List<String>)object).stream().map(x -> x+":this is lambda style stream").filter( x -> !(x.contains("nd"))).forEach(System.out::println);
		
		
		verify(request,times(3)).getParameter(anyString());
		verify(response,times(2)).getWriter();
		
		
	}
}
