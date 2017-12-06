package org.borko.spring.edu.memory;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.springframework.stereotype.Component;
import org.borko.spring.edu.dao.PersonDAO;
import org.borko.spring.edu.rdf4j.RdfGraph;
import org.borko.spring.edu.vocabulary.VOC;

@Component
public class RDFMemory {
	
	private static RepositoryConnection CONNECTION = RdfGraph.getConnection(); // Initializing the connection
	
	private static String NAMESPACE = "http://workproject/";

	private static IRI context = VOC.customIRI(NAMESPACE, "person");
	
	
	/**
	 * 
	 * @param person is of type PersonDAO
	 * @return true or false / if the operation was successful or not 
	 */
	public boolean add(PersonDAO person) {
		boolean indicator = false;
		Resource f_name = VOC.customIRI(NAMESPACE, person.getFirst_name()); // subject
		Resource l_name = VOC.customIRI(NAMESPACE, person.getLast_name()); //object
		
		if(isDuplicate(f_name, FOAF.LAST_NAME, l_name)){
			CONNECTION.add(f_name,FOAF.LAST_NAME,l_name,context);
			System.err.println("Added "+person.toString());
			indicator=true;
		}else {
			System.out.println("Person already exist");
		}
		
		return indicator;
	}
	
	/**
	 * 
	 * @param subject : the subject
	 * @param predicate : the predicate
	 * @param object : the object
	 * @return true or false whether the specific RDF is already in the db
	 */
	private boolean isDuplicate(Resource subject,IRI predicate ,Resource object ) {
		
		return !CONNECTION.getStatements(subject, predicate, object, context).hasNext();
	 
		
	}
	/**
	 * 
	 * @return true or false whether it cleared the whole database
	 */
	public boolean clearDB() {
		
		RepositoryResult<Statement> st = CONNECTION.getStatements(null, null, null, context);
		while (st.hasNext()) {
			Statement tmp = st.next();
			System.err.println("Deleting "+tmp+"...");
			CONNECTION.remove(tmp, context);
		}
		
		
		return true;
	}
}
