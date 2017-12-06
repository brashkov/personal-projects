package org.borko.spring.edu.rdf4j;

import org.borko.spring.edu.dao.PersonDAO;
import org.borko.spring.edu.memory.RDFMemory;

public class TestRdfGraph {
	public static void main(String[] args) {

		RDFMemory testMEM = new RDFMemory();
		System.out.println("Starting to delete the database...");
		testMEM.clearDB();
		System.out.println("Done !");
		
	}
}
