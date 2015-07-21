package no.nb.microservices.email.rest.controller;

import no.nb.microservices.delivery.metadata.model.ItemMetadata;
import no.nb.microservices.email.service.EmailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class EmailControllerTest {

    @InjectMocks
    EmailController emailController;

    @Mock
    EmailService emailService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(emailController).build();
    }

    @Test
    public void helloWorldTest() throws Exception{
        mockMvc.perform(post("/delivery/send")
        .requestAttr("itemMetadata", new ItemMetadata()))
                .andExpect(status().is4xxClientError());
    }

}
