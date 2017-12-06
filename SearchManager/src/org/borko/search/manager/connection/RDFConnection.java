package org.borko.search.manager.connection;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

public class RDFConnection {
	
	private static String SERVER = "http://localhost:7200";
	private static String REPO = "manage_system";


	private static RepositoryConnection con = null;
	
	private static Repository repo = null;

	static {
		repo = new HTTPRepository(SERVER, REPO);
		repo.initialize();
		connInit();
	}

	public static void open() {
		if (con.isOpen()) {
			// do smth...
		} else {
			openConnection();
		}
	}
	
	public static void closeConnection() {
		if (con.isOpen()) {
			ensureClosing();
		} else {
			// do smth..
		}
	}

	private static void ensureClosing() {
		if (con.isOpen()) {
			try {
				con.close();
				System.out.println("Connection closed");
			} catch (RepositoryException e) {
				System.err.println("Having troubles closing the connection...");
			}
		}
	}

	private static void openConnection() {
		try {
			con = repo.getConnection();
			System.out.println("Connection Re-opened");
		} catch (RepositoryException e) {
			System.err.println("Printing Exception :\n" + e);
		}
	}
	
	private static void connInit() {
		if(con == null) {
			try {
				con = repo.getConnection();
				System.out.println("Initializing the connection");
			} catch (RepositoryException e) {
				System.err.println("Having problems init the connection \n" + e);
			}
		}else {
			return ;
		}
	}
	
	public static RepositoryConnection getConnection() {
		if (con!=null && con.isOpen()) {
			return con;
		}
		throw new RepositoryException("Problems with getting the connection");
	}

}
