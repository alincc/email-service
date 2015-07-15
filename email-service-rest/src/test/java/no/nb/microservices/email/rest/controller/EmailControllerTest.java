package no.nb.microservices.email.rest.controller;

import no.nb.microservices.delivery.metadata.model.ItemMetadata;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class EmailControllerTest {

    private MockMvc mockMvc;

    private EmailController emailController;

    @Before
    public void setup() {
        emailController = new EmailController();
        mockMvc = MockMvcBuilders.standaloneSetup(emailController).build();
    }

    @Test
    public void helloWorldTest() throws Exception{
        mockMvc.perform(post("/delivery/send")
        .requestAttr("itemMetadata", new ItemMetadata()))
                .andExpect(status().isOk());
    }

}
