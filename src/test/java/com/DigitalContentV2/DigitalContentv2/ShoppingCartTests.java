package com.DigitalContentV2.DigitalContentv2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.DigitalContentV2.DigitalContentv2.modelo.Car_items;
import com.DigitalContentV2.DigitalContentv2.modelo.Producto;
import com.DigitalContentV2.DigitalContentv2.modelo.Usuario;
import com.DigitalContentV2.DigitalContentv2.repository.CarRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ShoppingCartTests {

	@Autowired
	private CarRepository carRepo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testAddCarItem() {
		Producto producto = entityManager.find(Producto.class, 2);
		Usuario usuario = entityManager.find(Usuario.class, 2);

		Car_items newItem = new Car_items();
		newItem.setCliente(usuario);
		newItem.setProduct(producto);
		newItem.setCantidad(2);

		 Car_items saveCarItems = carRepo.save(newItem);
		 
		 assertTrue(saveCarItems.getId() > 0);
		 
	}
	
	@Test
	public void testFindCarItemsByUser() {
		Usuario cliente = new Usuario();
		cliente.setIdUsuario(1);
		
		List<Car_items> caritems = carRepo.findByCliente(cliente);
		
		assertEquals(1, caritems.size());
	}
	
	
}
