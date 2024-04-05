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
	private final String token="Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsdXBpc0BnbWFpbC5jb20iLCJyb2xlIjoidXN1YXJpbyIsImlhdCI6MTcxMjI4NjYzOSwiZXhwIjoxNzEyMzU4NjM5fQ.QefzVShKOk5HYOkFrqEI2uVd5FejF6SQTQ0M_8UUjtw";

	@Test
	@DisplayName("Se prueba el endpoint http://localhost:8080/api/productos/1")
	void pruebaGET() throws Exception {
		this.mockMvc.perform( get("/api/productos/1") )
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("tinte.jpg")));
	}//pruebaGet

	@Test
	//@Disabled("Probado la primera vez, desabilidado") //solo se puede agregar una vez
	@DisplayName("Se prueba borrar el producto con id 5 http://localhost:8080/api/productos/5")
	void pruebaDELETE() throws Exception {
		this.mockMvc.perform( delete("/api/productos/5").header("Authorization", token) )
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Kit de Rutina Diaria"))
						
						);
	}//pruebaDelete
	
	@Test
	@Disabled("Probado la primera vez, desabilidado")
	@DisplayName("Se prueba crear un producto nuevo")
	void pruebaPOST() throws Exception{
		Producto p = new Producto();
		p.setNombre("Kit de Rutina Diaria");
		p.setCategoria("piel");
		p.setDescripcion("Kit de tres piezas para rutina diaria de skin care. El limpiador Squalane elimina el maquillaje. Hyaluronic Acid 2% + B5 favorece la hidratación de múltiples capas de la superficie de la piel");
		p.setPrecio(450.0);
		p.setURL_imagen("kit.jpg");
		
		
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
		p.setCategoria("");
		p.setDescripcion("");
		p.setPrecio(400.0);
		p.setURL_imagen("");
		this.mockMvc.perform( put("/api/productos/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization", token) )
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("400.0"))
						);
	}//pruebaPut
}
