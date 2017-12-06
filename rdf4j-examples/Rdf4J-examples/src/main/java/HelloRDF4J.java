import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.vocabulary.DC;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.sail.memory.MemoryStore;



public class HelloRDF4J {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repository rep = new SailRepository(new MemoryStore());  // rep instance
		rep.initialize(); // init local repository
		
		ValueFactory vf = SimpleValueFactory.getInstance();
		ModelBuilder builder = new ModelBuilder();
		
		
				String ex = "http://example.org/";

	
				IRI picasso = vf.createIRI(ex, "Picasso");
				IRI ozzy = vf.createIRI(ex, "Osbourne");
				
		
				IRI artist = vf.createIRI(ex, "Artist");
				IRI musician = vf.createIRI(ex, "Musician");
				

				// Create a new, empty Model object.
				Model model = builder
						.setNamespace("ex",ex)
						
						.subject("ex:Picasso")
						.add(RDF.TYPE, artist)
						.add(FOAF.FIRST_NAME,vf.createLiteral("Pablo"))
						
						.subject("ex:Osbourne")
						.add(RDF.TYPE, musician)
						.add(FOAF.FIRST_NAME,vf.createLiteral("Ozzy"))
						
						.build();

				
				
//				Model modelNew = builder
//					    .setNamespace("ex", "http://example.org/")
//					    .subject("ex:PotatoEaters")
//						// In English, this painting is called "The Potato Eaters"
//						.add(DC.TITLE, vf.createLiteral("The Potato Eaters", "en"))
//						// In Dutch, it's called "De Aardappeleters"
//						.add(DC.TITLE,  vf.createLiteral("De Aardappeleters", "nl"))
//					    .build();

			
				for (Statement statement: model) {
					
					Rio.write(statement, System.out, RDFFormat.TURTLE);
					
				}
			
		}
	}




