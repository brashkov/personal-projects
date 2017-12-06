package org.borko.search.manager.memory;

import org.borko.search.manager.connection.RDFConnection;
import org.borko.search.manager.dao.FileRepDAO;
import org.borko.search.manager.vocabulary.IRIVocabulary;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.RepositoryConnection;

public class MemroyOperations {
	
	protected static RepositoryConnection CONNECTION = RDFConnection.getConnection();
	
	protected static String NAMESPACE = "http://seacrh-manager/";

	protected static IRI context = IRIVocabulary.customIRI(NAMESPACE, "file");
	
	/**
	 * 
	 * @param subject : the subject
	 * @param predicate : the predicate
	 * @param object : the object
	 * @return true or false whether the specific RDF is already in the db
	 */
	protected static boolean isDuplicate(Resource subject,IRI predicate ,Resource object ) {
		
		return CONNECTION.getStatements(subject, predicate, object, context).hasNext(); 
		
	}

}
