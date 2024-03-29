package restTest;

import br.com.teste.tecnico.sasdesafio.SasDesafioApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SasDesafioApplication.class)
public class ClassificacaoTest {

	@Autowired
	public WebApplicationContext context;

	private MockMvc mvc;

	@Test
	public void restClassificacaoTest() throws Exception {
		String url = "/classificacoes";
		this.mvc.perform(get(url))
				.andExpect(status().isOk());
	}

	@Before
	public void setup(){
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}



}
