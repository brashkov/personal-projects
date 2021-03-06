package org.borko.spring.edu.vocabulary;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

public class VOC {
	
	/**
	 * The full namespace: "http://localhost:8080/person/".
	 */
	public static final String NAMESPACE = "http://localhost:8080/person/";

	/**
	 * The prefix usually used for this vocabulary: 'ex'.
	 */
	public static final String PREFIX = "ex";

	/**
	 * The <code>ex:creatorOf</code> property.
	 */
	public static final IRI CREATOR_OF = getIRI("creatorOf");

	/**
	 * The <code>ex:Artist</code> class.
	 */
	public static final IRI PERSON = getIRI("Person");
	
	/**
	 * The <code>ex:Artist</code> class.
	 */
	public static final IRI UNKOWN = getIRI("UNKOWN");
	
	
	/**
	 * Creates a new {@link IRI} with this vocabulary's namespace for the given local name.
	 *
	 * @param localName a local name of an IRI, e.g. 'creatorOf', 'name', 'Artist', etc.
	 * @return an IRI using the http://example.org/ namespace and the given local name.
	 */
	private static IRI getIRI(String localName) {
		return SimpleValueFactory.getInstance().createIRI(NAMESPACE, localName);
	}

	/**
	 * Create a custom IRI with a namespace by your choice
	 * 
	 * @param local_namespace the namespace you'll want to use
	 * @param localName a local name of an IRI, e.g. 'creatorOf', 'name', 'Artist', etc.
	 * 
	 * @return an IRI using the namespace and the given local name.
	 */
	public static IRI customIRI(String local_namespace,String localName) {
		return SimpleValueFactory.getInstance().createIRI(local_namespace, localName);
	}

}
