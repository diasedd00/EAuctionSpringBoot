package com.dia.eauction.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.dia.eauction.utils.Utilities;

public class UtilitiesTest {

	@Test
	public void verifybeforeDate() {
		assertEquals(-1,Utilities.compareDates(LocalDate.of(2017, 3, 29), LocalDate.of(2018, 3, 10)));
	}
	
	@Test
	public void verifyafterDate() {
		assertEquals(1,Utilities.compareDates(LocalDate.of(2018, 3, 29), LocalDate.of(2017, 3, 10)));
	}
}
