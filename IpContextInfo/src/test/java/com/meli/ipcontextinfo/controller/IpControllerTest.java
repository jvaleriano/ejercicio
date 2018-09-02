package com.meli.ipcontextinfo.controller;

import static org.hamcrest.Matchers.containsString;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 *
 * @author valer
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IpControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    public IpControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of trace method, of class IpController.
     * @throws java.lang.Exception
     */
    @Test
    public void testTrace_ok() throws Exception {
        this.mockMvc.perform(get("/ip/trace?ip=5.6.7.8")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.ip").value(containsString("5.6.7.8")));
    }
    
    /**
     * Test of trace method, of class IpController.
     * @throws java.lang.Exception
     */
    @Test
    public void testTrace_ko() throws Exception {
        this.mockMvc.perform(get("/ip/trace?ip=lala")).andDo(print()).andExpect(status().isNotFound());
    }

}
