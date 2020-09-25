package com.sample.project;


import com.sample.project.Controller.RestApiController;
import com.sample.project.Model.User;
import com.sample.project.Service.UserService;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class MockitoControllerTest extends ProjectApplicationTests{




    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }



    @Test
    public void getUsers() throws Exception {
        mockMvc.perform(get("/api/user/4")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("sam")).andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.lastName").value("mba")).andExpect(jsonPath("$.age").value("23"));

    }


//    @Test
//    public void createUser() throws Exception {
//        User user = new User();
//                mockMvc.perform(post("/api/newuser")).andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"))
//                .andExpect(jsonPath("$.name", Matchers.is("mats")))
//                .andExpect(jsonPath("$.lastame", Matchers.is("base")))
//                .andExpect(jsonPath("$.age", Matchers.is("10")));
//
//    }

//    @InjectMocks
//    private RestApiController restApiController;
//
//    @Mock
//    private UserService userService;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }

//
//    @Test
//    public void testGetUserById() {
//        User u = new User();
//        u.setId(1l);
//        when(userService.findById(1l)).thenReturn(u);
//        User user = restApiController.getUser(1L);
//        verify(userService).findById(1l);
//        assertEquals(1l, user.getId().longValue());
//    }
//
//
//    @Test
//    public void testGetUserByName(){
//        User u = new User();
//        u.setName("sam");
//        when(userService.findByName("sam")).thenReturn(u);
//        User user = restApiController.findByname("sam");
//        verify(userService).findByName("sam");
//        assertEquals("sam",user.getName());
//    }


}
