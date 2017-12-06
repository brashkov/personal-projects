/**
 * 
 */
package org.borko.search.manager.memory;


import org.borko.search.manager.connection.RDFConnection;
import org.borko.search.manager.dao.FileRepDAO;
import org.borko.search.manager.vocabulary.IRIVocabulary;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.springframework.stereotype.Component;


/**
 * @author borissr
 *
 */

@Component
public class RDFMemory extends MemroyOperations{
	
	
	public static boolean add(FileRepDAO file) {
		Resource file_name = IRIVocabulary.customIRI(NAMESPACE, file.fileName());
		Resource file_type = IRIVocabulary.customIRI(NAMESPACE, file.getTYPE());
		Resource file_format=IRIVocabulary.customIRI(NAMESPACE, file.getFILE_FORMAT());
		Resource file_date = IRIVocabulary.customIRI(NAMESPACE, file.getCreationDate());
		
		if(!isDuplicate(file_name, RDF.TYPE, file_type)) {
			CONNECTION.add(file_name, RDF.TYPE, file_type, context); //Category
			CONNECTION.add(file_name, IRIVocabulary.FILE_FORMAT, file_format, context); //File_format
			CONNECTION.add(file_name, IRIVocabulary.CREATION_DATE, file_date, context); // Date Creation
		
			System.out.println("Added "+file.fileName());
		}else {
			System.out.println(file.fileName() + " already exists !");
		}
		return true;
	}
	
	public static RepositoryResult<Statement> getByCategory(String category) {
		Resource object = IRIVocabulary.customIRI(NAMESPACE, category);
		RepositoryResult<Statement> statements = CONNECTION.getStatements(null, RDF.TYPE, object, context);
		return statements;
	}
	
	/**
	 * 
	 * @return true or false whether it cleared the whole database
	 */
	public static boolean clearDB() {
		
		RepositoryResult<Statement> st = CONNECTION.getStatements(null, null, null, context);
		while (st.hasNext()) {
			Statement tmp = st.next();
			System.err.println("Deleting "+tmp+"...");
			CONNECTION.remove(tmp, context);
		}
		
		
		return true;
	}
}
