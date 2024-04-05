package org.generation.aphrodite;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.generation.aphrodite.model.Producto;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.hamcrest.Matchers.containsString;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc

class AphroditeApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	private final String token="Bearer: "

	@Test
	@DisplayName("Se prueba el endpoint http://localhost:8080/api/productos/1")
	void pruebaGET() throws Exception {
		this.mockMvc.perform( get("/api/productos/1") )
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("")));
	}//pruebaGet

	@Test
	//@Disabled("Probado la primera vez, desabilidado") //solo se puede agregar una vez
	@DisplayName("Se prueba borrar el producto con id 2 http://localhost:8080/api/productos/2")
	void pruebaDELETE() throws Exception {
		this.mockMvc.perform( delete("/api/productos/2").header("Authorization", token) )
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(""))
						);
	}//pruebaDelete
	
	@Test
	//@Disabled("Probado la primera vez, desabilidado")
	@DisplayName("Se prueba crear un producto nuevo")
	void pruebaPOST() throws Exception{
		Producto p = new Producto();
		p.setNombre("");
		p.setDescripcion("");
		p.setURL_imagen("");
		p.setPrecio();
		p.setCategoria("");
		this.mockMvc.perform( post("/api/productos/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization", token) )
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(""))
						);
	}//pruebaPost
	
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString
	
	@Test
	@DisplayName("Se prueba editar un producto")
	void pruebaPUT() throws Exception{
		Producto p = new Producto();
		p.setNombre("");
		p.setDescripcion("");
		p.setURL_imagen("");
		p.setPrecio();
		p.setCategoria("");
		this.mockMvc.perform( put("/api/productos/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization", token) )
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(""))
						);
	}//pruebaPut
}
