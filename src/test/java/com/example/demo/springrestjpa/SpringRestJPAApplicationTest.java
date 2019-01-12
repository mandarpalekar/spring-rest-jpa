package com.example.demo.springrestjpa;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SpringRestJPAApplicationTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() throws JSONException {
		String response = this.testRestTemplate.getForObject("/api/customer", String.class);
		JSONAssert.assertEquals("[{id:1},{id:2}]", response, false);

		String responseSingle = this.testRestTemplate.getForObject("/api/customer/1", String.class);
		JSONAssert.assertEquals("{name:{firstName:'Mandar',middleName:'Suresh',lastName:'Palekar'}}", responseSingle, false);
	}

}

