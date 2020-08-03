package rest.projet.apirest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rest.projet.apirest.controller.EmployeeController;
import rest.projet.apirest.model.Employee;
import rest.projet.apirest.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApirestApplicationTests {

    @Autowired
    private EmployeeController employeeController;

    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void insertEmployeesAndExpectOk() throws Exception {
        List<Employee> employees = Arrays.asList(new Employee(), new Employee());
        mvc.perform(MockMvcRequestBuilders
                .post("/api/employee/insert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(employees))
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void insertEmployeesAndExpectKo() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("/api/employee/insert")
                .contentType(MediaType.APPLICATION_JSON)
                .content("bad json")
        )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    @Test
    public void search() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/api/employee/list?criteria=nom&value=ach")
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nom").value("ach"));

    }

}
