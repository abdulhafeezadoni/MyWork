package com.fosiness.batch; 

import org.junit.Ignore;

import com.fosiness.batch.ExampleItemReader;

import junit.framework.TestCase;
@Ignore
public class ExampleItemReaderTests extends TestCase {

	private ExampleItemReader reader = new ExampleItemReader();
	
	public void testReadOnce() throws Exception {
		assertEquals("Hello world!", reader.read());
	}

	public void testReadTwice() throws Exception {
		reader.read();
		assertEquals(null, reader.read());
	}

}
