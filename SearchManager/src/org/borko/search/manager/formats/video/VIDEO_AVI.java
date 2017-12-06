package org.borko.search.manager.formats.video;

import java.lang.reflect.Constructor;

import org.borko.search.manager.dao.FileRepDAO;
import org.borko.search.manager.interfaces.ABSTRACT_IMAGES;
import org.borko.search.manager.interfaces.ABSTRACT_VIDEOS;
import org.borko.search.manager.interfaces.VIDEO_IMPL;
import org.springframework.stereotype.Component;

@Component
public class VIDEO_AVI extends ABSTRACT_VIDEOS /*implements VIDEO_IMPL*/ {
	
	private static String FILE_FORMAT = "AVI";
	
	private VIDEO_AVI(){
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
