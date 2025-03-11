package com.concordia.soen345.mocking;

import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoteDBTest {
	private Iterator<String> iteratorMock;
	
	@BeforeEach
    public void setupMocks() {
        //Here you need to mock the iterator class
		//TODO:
		//Ensure that you return the records specified in the 
		//instructions when calling iteratorMock.next()
		//TODO:
       
    }
    @AfterEach
    public void releaseMocks() {
        iteratorMock = null;
    }
    
    @Test
    public void testRemoteDBGetNextFile() {

        //Instantiate a new object of RemoteDB
    	//TODO:
        
    	//Set the test iterator
    	//TODO:

        //Mock iteratorMock.hasNext() to return true
    	//TODO:
        
    	//test that you receive the first record in the DB. e.g. Paul McCartney
    	//TODO:

        //continue testing with the remaining 3 records
    	//TODO:

        // NOTE: Test that the last return value will continue to be returned for
        // the remaining invocations to getNextRecord()
    	//TODO:
        
        //Now mock iteratorMock.hasNext() to return false (we have returned all records)
    	//TODO:
        //test that you get null when calling getNextFile
    	//TODO:
    }

}
