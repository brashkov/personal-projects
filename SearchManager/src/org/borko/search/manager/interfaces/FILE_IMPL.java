package org.borko.search.manager.interfaces;

import java.util.Date;

import org.borko.search.manager.dao.FileRepDAO;

public interface FILE_IMPL {
	/**
	 * This is a Marker Interface
	 * 
	 * Need to finish documentation
	 */
	
//	public String getCategory();
//	
//	public String fileName();
//	
	public String fileFormat();

	/*-----B-U-I-L-D-E-R---M-E-T-H-O-D-S-*/
	public FILE_IMPL creationDate();
	public FILE_IMPL name(String name);
	public FileRepDAO build();
	
}
