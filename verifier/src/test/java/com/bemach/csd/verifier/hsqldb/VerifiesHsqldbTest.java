package com.bemach.csd.verifier.hsqldb;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;

import org.mockito.Mockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bemach.csd.verifier.hsqldb.VerifiesHsqldb;

import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class VerifiesHsqldbTest {

	@InjectMocks
	VerifiesHsqldb subject;
	

	@Test
	public void shouldGetJdbcConnection() {
		// Arrange
		
		// Act
		Connection conn = subject.getConnection();
		
		// Assert
		assertNotNull(conn);
	}
}