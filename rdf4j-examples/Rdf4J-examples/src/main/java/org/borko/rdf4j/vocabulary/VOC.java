package org.borko.rdf4j.vocabulary;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

public class VOC {
	
	/**
	 * The full namespace: "http://example.org/".
	 */
	public static final String NAMESPACE = "http://example.org/";

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
	public static final IRI ARTIST = getIRI("Artist");
	
	/**
	 * The <code>ex:Artist</code> class.
	 */
	public static final IRI UNKOWN = getIRI("UNKOWN");
	
	/**
	 * The <code>ex:Painter</code> class.
	 */
	public static final IRI PAINTER = getIRI("Painter");

	/**
	 * Creates a new {@link IRI} with this vocabulary's namespace for the given local name.
	 *
	 * @param localName a local name of an IRI, e.g. 'creatorOf', 'name', 'Artist', etc.
	 * @return an IRI using the http://example.org/ namespace and the given local name.
	 */
	private static IRI getIRI(String localName) {
		return SimpleValueFactory.getInstance().createIRI(NAMESPACE, localName);
	}


}
