package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testCustomer() {
		//expected
		//load class
		//get actual
		//assets
		fail("Not yet implemented");
	}

	@Test
	public void testReset() {
		//expected
		ArrayList<Dish> expOrders = new ArrayList<Dish>();
		int expBill = 0;
		//load class
		Customer cus = new Customer();
		//get actual
		cus.reset();
		ArrayList<Dish> orders = cus.getOrders();
		int bill = cus.getBill();
		//assets
		assertEquals(expOrders, orders);
		assertEquals(expBill, bill);
		//fail("Not yet implemented");
	}

	@Test
	public void testRemoveDish() {
		ArrayList<Dish> expOrders = new ArrayList<Dish>();
		Customer cus = new Customer();
		Dish dish = new Dish();
		dish.setName("a");
		dish.setCost(3);
		dish.setPrice(4);
		dish.setId(1);
		dish.setAvailable(0);
		cus.addDish(dish);
		cus.removeDish(0);
		ArrayList<Dish> orders = cus.getOrders();
		assertEquals(expOrders, orders);
		//fail("Not yet implemented");
	}

	@Test
	public void testAddDish() {
		Customer cus = new Customer();
		Dish dish = new Dish();
		dish.setName("a");
		dish.setCost(3);
		dish.setPrice(4);
		dish.setId(1);
		dish.setAvailable(0);
		cus.addDish(dish);
		Dish expDish = dish;
		ArrayList<Dish> orders = cus.getOrders();
		assertEquals(expDish, orders.get(0));
		//fail("Not yet implemented");
	}

	@Test
	public void testGetBill() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPhone() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPhone() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCity() {
		fail("Not yet implemented");
	}

}
