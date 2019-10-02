package restTest;

import br.com.teste.tecnico.sasdesafio.SasDesafioApplication;
import br.com.teste.tecnico.sasdesafio.api.repositorio.RepositorioAluno;
import br.com.teste.tecnico.sasdesafio.model.Aluno;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SasDesafioApplication.class)
@AutoConfigureMockMvc
public class AlunoTest {

	@Autowired
	public WebApplicationContext context;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAlunos() throws Exception {
		String url = "/alunos";
		this.mockMvc.perform(get(url))
				.andExpect(status().isOk());
	}

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}



}
