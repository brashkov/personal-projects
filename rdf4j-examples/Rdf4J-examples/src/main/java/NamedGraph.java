import java.io.File;
import java.util.Scanner;

import org.borko.rdf4j.vocabulary.VOC;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Resource;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.util.Models;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.repository.util.Repositories;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.sail.config.SailRegistry;
import org.eclipse.rdf4j.sail.memory.MemoryStore;


public class NamedGraph {

	public static void main(String[] args) {
		
		/**
		 * Repository + file locationt 
		 */
		File fileDir = new File("/home/borissr/Documents/rdf_file");
		MemoryStore memStore = new MemoryStore(fileDir);
		memStore.setSyncDelay(1000L);
		SailRepository repo = new SailRepository(memStore);
		repo.initialize();
		
		// We'll use a ModelBuilder to create two named graphs, one containing data about
		ModelBuilder builder = new ModelBuilder();
		builder.setNamespace("ex", "http://example.org/");

		// In named graph 1, we add info about Picasso
		builder.namedGraph("ex:Painters")
				.subject("ex:Picasso")
					.add(RDF.TYPE, VOC.PAINTER)
					.add(FOAF.FIRST_NAME, "Pablo")
					
					.subject("ex:Picasso2")
					.add(RDF.TYPE, VOC.PAINTER)
					.add(FOAF.FIRST_NAME, "Pablo2");

		// In named graph 2, we add info about Van Gogh.
		builder.namedGraph("ex:Artists")
			.subject("ex:VanGogh")
				.add(RDF.TYPE, VOC.ARTIST)
				.add(FOAF.FIRST_NAME, "Vincent")
				
				.subject("ex:VanGogh2")
				.add(RDF.TYPE, VOC.ARTIST)
				.add(FOAF.FIRST_NAME, "Vincent2");


		Model model = builder.build();
		RepositoryConnection conn = null;
		try 
		{
			conn = repo.getConnection();
			for (Resource sub: model.subjects()) {
				
				System.out.println("THIS IS "+sub);
				
				Model name = model.filter(sub, FOAF.FIRST_NAME, null);
				Model type = model.filter(sub,RDF.TYPE,null);
				
				
				String firstName = Models.objectString(name).orElse("(unknow)"); // getting the subject
				String typeOf = Models.objectIRI(type).orElse(VOC.UNKOWN).getLocalName(); // getting the object of RDF.TYPE
				
				System.out.println("About : "+firstName+ " -- "+typeOf);
				
				Rio.write(name, System.out, RDFFormat.NTRIPLES);
				System.out.println();
			}
		}
		finally {
			conn.close();
		}
		

		for (Resource context: model.contexts()) {
			System.out.println("Named graph " + context + " contains: ");
			
			
			Rio.write(model.filter(null, null, null,context), System.out, RDFFormat.NTRIPLES);
			System.out.println();
		}
	
	}

}
