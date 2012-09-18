package com.melchor.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bean.Producto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/melchor/service/applicationTest.xml" })
public class MelchorServiceTest {

	@Autowired
	private MelchorService instance = null;

	@Test
	public void testObtenerListaProductos() {
		System.out.println("decirHola");

		ArrayList<Producto> lista = instance.ObtenerListaProductos("01",
				"2012", "", "", "03", "01");

		System.out.println(lista.get(0).getIN01DESLAR());

		assertNotNull(lista);
	}
}
