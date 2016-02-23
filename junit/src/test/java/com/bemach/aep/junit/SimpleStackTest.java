package com.bemach.aep.junit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith; 
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class SimpleStackTest {
 
	private static final String HELLO_AMERICA = "Hello, America!";
	private static final String HELLO_WORLD = "Hello, world!";
	private SimpleStack<Object> target = null;
	private Object[] objectList;

	@Test
	public void shouldBeEmptyWhenCreated() {

		// Assert
		assertThat(target.size(), equalTo(0));
	}

	@Before
	public void setUp() {
		target = new SimpleStack<Object>();
	}

	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void shouldThrowExceptionWhenPopOnEmpty() {
		// Act
		target.pop();
	}
	
	@Parameters
	public static Collection<Object[][]> getTestParameters() {
	  return Arrays.asList(new Object[][][] { 
		    {{HELLO_WORLD}}, 
		    {{HELLO_WORLD, HELLO_AMERICA}}  
		  }); 
	  }
	
	  public SimpleStackTest(Object[] objectList) {
	    this.objectList = objectList;
	  }
	   
	  @Test
	  public void shouldPushItemsOntoStack() {
		  // Act
		  for (Object object: objectList) {
			  target.push(object);
		  }
		  
		  // Assert
		  assertThat(target.size(), equalTo(objectList.length));
	  }
	  
	  @Test
	  public void shouldPopItemsOffTheStack() {
		  // Arrange
		  for (Object object: objectList) {
			  target.push(object);
		  } 
		  
		  // Act
		  Object actual = null;
		  for (int i = 0; i < objectList.length; i++) {
			  actual = target.pop();
		  }
		  
		  // Assert
		  assertThat(actual, equalTo(objectList[0]));
	  }

}
