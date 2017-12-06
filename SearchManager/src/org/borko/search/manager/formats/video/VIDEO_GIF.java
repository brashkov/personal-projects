package org.borko.search.manager.formats.video;

import org.borko.search.manager.interfaces.ABSTRACT_VIDEOS;
import org.springframework.stereotype.Component;

@Component
public class VIDEO_GIF extends ABSTRACT_VIDEOS /*implements VIDEO_IMPL*/ {
	
private static String FILE_FORMAT = "GIF";
	
	private VIDEO_GIF(){
		super(FILE_FORMAT);
	}
	
//	/**
//	 * 
//	 * @param FILE_NAME Name of the file
//	 * @param creationDate date of creation 
//	 */
//	public VIDEO_AVI(String FILE_NAME, String creationDate) {
//		super(FILE_NAME,creationDate);
//	}

	/**
	 * @return returns file format in lower case
	 */
	@Override
	public String fileFormat() {
		// TODO Auto-generated method stub
		return FILE_FORMAT.toLowerCase();
	}
	

}
