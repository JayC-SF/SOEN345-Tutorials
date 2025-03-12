package com.concordia.soen345.mocking;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoteDB {
	
	public RemoteDB(String remoteUrl) {
		super();
		this.remoteUrl = remoteUrl;
	}
	private final String remoteUrl;
    private Iterator<String> remoteRecordIterator;
    
    private void connect() {
        // NOTE: Assume this connects to the remote DB and initializes
        // an iterator to get the list of records stored in the remote machine
    }
    
    // NOTE: This method exists only for the purposes of testing, which is why
    // it has default access, i.e. can only be accessed by other classes in
    // same package. Test classes for this class will be in the same package
    // as the class itself
    void setTestIterator(Iterator<String> testIterator) {
        this.remoteRecordIterator = testIterator;
    }
    
    public String getNextRecord() {
        if (remoteRecordIterator.hasNext()) {

            String record = remoteRecordIterator.next();

            Matcher m = Pattern
                    .compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+")
                    .matcher(record);

            if (m.find()) {
                return m.group();
            }

            return remoteRecordIterator.next();
        }

        return null;
    }
}
