package com.concordia.soen345.mocking;

import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Juan-Carlos Sreng-Flores
 * @ID 40101813
 */
public class RemoteDBTest {
    private Iterator<String> iteratorMock;

    // remove warning from generics of iterator class
    @SuppressWarnings("unchecked")
    @BeforeEach
    public void setupMocks() {
        // Here you need to mock the iterator class
        iteratorMock = mock(Iterator.class);
        // Ensure that you return the records specified in the
        // instructions when calling iteratorMock.next()
        when(iteratorMock.next()).thenReturn(
                "Paul McCartney, paul@concordia.ca, 1942",
                "Ringo Starr, ringo@concordia.ca, 1940",
                "George Harrison, george@concordia.ca, 1943",
                "John Lennon, john@concordia.ca, 1940");
    }

    @AfterEach
    public void releaseMocks() {
        iteratorMock = null;
    }

    @Test
    public void testRemoteDBGetNextFile() {

        // Instantiate a new object of RemoteDB
        var remoteDB = new RemoteDB("");

        // Set the test iterator
        remoteDB.setTestIterator(iteratorMock);

        // Mock iteratorMock.hasNext() to return true
        // mocking all the next returns for hasNext() function
        when(iteratorMock.hasNext()).thenReturn(true);

        // test that you receive the first record in the DB. e.g. Paul McCartney
        String paul = remoteDB.getNextRecord();
        assertEquals("paul@concordia.ca", paul);
        
        // continue testing with the remaining 3 records
        String ringo = remoteDB.getNextRecord();
        assertEquals("ringo@concordia.ca", ringo);
        
        String george = remoteDB.getNextRecord();
        assertEquals("george@concordia.ca", george);
        
        String john = remoteDB.getNextRecord();
        assertEquals("john@concordia.ca", john);

        // NOTE: Test that the last return value will continue to be returned for
        // the remaining invocations to getNextRecord()
        String extra = remoteDB.getNextRecord();
        assertEquals("john@concordia.ca", extra);
        
        // Now mock iteratorMock.hasNext() to return false (we have returned all
        // records)
        when(iteratorMock.hasNext()).thenReturn(false);

        // test that you get null when calling getNextFile
        String nullString = remoteDB.getNextRecord();
        assertNull(nullString);
    }
}
