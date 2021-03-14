package csc131.junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class GiftCardTest {

	@Test
	void testGetIssuingStore() {
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.0;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
	}
	
	@Test
	void getBalance() {
		double balance;
		int issuingStore = 1337;
		balance = 100.0;
		GiftCard card = new GiftCard(issuingStore, balance);
		double tolerance = 0.001;
		
		assertEquals("getBalance()", balance, card.getBalance(), tolerance);
	}
	
	@Test
	void deduct_RemainingBalance() {
		double balance = 100.0;
		int issuingStore = 1337;
		GiftCard card = new GiftCard(issuingStore, balance);
		String expected = "Remaining Balance: " + String.format("%6.2f", 85.0);
		
		assertEquals("deduct(15.0)", expected, card.deduct(15.0));
		
	}
	@Test
	void deduct_AmountLessZero() {
		double balance = 100.0;
		int issuingStore = 1337;
		GiftCard card = new GiftCard(issuingStore, balance);
		String expected = "Invalid Transaction";
		
		assertEquals("deduct(-15.0)", expected, card.deduct(-15.0));
		
	}
	@Test
	void deduct_BalanceLessZero() {
		double balance = 100.0;
		int issuingStore = 1337;
		GiftCard card = new GiftCard(issuingStore, balance);
		String expected = "Amount Due: " + String.format("%6.2f", 750.0);
		
		assertEquals("deduct(850.0)", expected, card.deduct(850.0));
		
	}
	@Test
	void throwTest()throws IllegalArgumentException {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.0);});
	}
	@Test
	void constructor_IncorrectID_Low() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(-1,100.0);});
	}
	@Test
	void constructor_IncorrectID_High() {
		assertThrows(IllegalArgumentException.class, () -> {new GiftCard(10000, 100.0);});
	}
	

}
