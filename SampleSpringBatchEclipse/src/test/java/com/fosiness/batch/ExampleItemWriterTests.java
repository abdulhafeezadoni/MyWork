package com.fosiness.batch;

import org.junit.Ignore;

import com.fosiness.batch.ExampleItemWriter;

import junit.framework.TestCase;
@Ignore
public class ExampleItemWriterTests extends TestCase {

	private ExampleItemWriter writer = new ExampleItemWriter();
	
	public void testWrite() throws Exception {
		writer.write(null); // nothing bad happens
	}

}
