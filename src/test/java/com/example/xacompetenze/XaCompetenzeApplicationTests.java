package com.example.xacompetenze;

import com.example.xacompetenze.models.Patrimonio;
import com.example.xacompetenze.repositories.PatrimonioRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class XaCompetenzeApplicationTests {
	@Mock
	private PatrimonioRepository ps;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testFindById() {
		Long id = 1L;
		Patrimonio expectedPatrimonio = new Patrimonio("Test", 1000L, 2023);
		when(ps.findById(id)).thenReturn(Optional.of(expectedPatrimonio));

		Optional<Patrimonio> actualPatrimonioOptional = ps.findById(id);

		assertTrue(actualPatrimonioOptional.isPresent()); // Check if it's present
		Patrimonio actualPatrimonio = actualPatrimonioOptional.get();
		assertEquals(expectedPatrimonio, actualPatrimonio);
	}

	@Test
	void testFindByName() {
		String name = "TestPatrimonio";
		Patrimonio expectedPatrimonio = new Patrimonio(name, 1500L, 2022);
		when(ps.findByName(name)).thenReturn(expectedPatrimonio);

		Patrimonio actualPatrimonio = ps.findByName(name);

		assertEquals(expectedPatrimonio, actualPatrimonio);
	}

	@Test
	void testFindByValue() {
		long value = 1500L;
		Patrimonio patrimonio1 = new Patrimonio("Test1", value, 2021);
		Patrimonio patrimonio2 = new Patrimonio("Test2", value, 2020);
		List<Patrimonio> expectedPatrimoni = Arrays.asList(patrimonio1, patrimonio2);
		when(ps.findByValue(value)).thenReturn(expectedPatrimoni);

		List<Patrimonio> actualPatrimoni = ps.findByValue(value);

		assertEquals(expectedPatrimoni, actualPatrimoni);
	}

	@Test
	void testFindByAnnoCreazione() {
		Integer annoCreazione = 2021;
		Patrimonio patrimonio1 = new Patrimonio("Test1", 2000L, annoCreazione);
		Patrimonio patrimonio2 = new Patrimonio("Test2", 2500L, annoCreazione);
		List<Patrimonio> expectedPatrimoni = Arrays.asList(patrimonio1, patrimonio2);
		when(ps.findByAnnoCreazione(annoCreazione)).thenReturn(expectedPatrimoni);

		List<Patrimonio> actualPatrimoni = ps.findByAnnoCreazione(annoCreazione);

		assertEquals(expectedPatrimoni, actualPatrimoni);
	}

	@Test
	void testDeleteByName() {
		String name = "TestPatrimonio";

		ps.deleteByName(name);

		verify(ps, times(1)).deleteByName(name);
	}
	@Test
	void testGetAllPatrimoni() throws Exception {

		// Mock the behavior of your service to return the expected data
		ps.findAll();
		// Perform the request and validate the response
		mockMvc.perform(MockMvcRequestBuilders.get("/patrimonio")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
