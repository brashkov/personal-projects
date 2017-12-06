package org.borko.search.manager.interfaces;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.borko.search.manager.dao.FileRepDAO;

public abstract class ABSTRACT_IMAGES implements IMAGE_IMP{
	
	private String FILE_NAME;
	private String creationDate;
	private String FILE_FORMAT;
	
	protected ABSTRACT_IMAGES(String FILE_FORMAT) {
		this.FILE_FORMAT = FILE_FORMAT;
	}
	
	
//	@Override
//	public String getCategory() {
//		return CATEGORY;
//	}
//	
//	@Override
//	public String fileName() {
//		// TODO Auto-generated method stub
//		return FILE_NAME;
//	}
//	
	
	
	/*-----B-U-I-L-D-E-R---M-E-T-H-O-D-S-*/
	
	@Override
	public ABSTRACT_IMAGES creationDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		creationDate = dateFormat.format(date);
		return this;
		
	}
	@Override
	public ABSTRACT_IMAGES name(String name) {
		FILE_NAME = name;
		return this;
		
	}
	
	@Override
	public FileRepDAO build() {
		return new FileRepDAO(CATEGORY, creationDate, FILE_FORMAT,FILE_NAME);
	}

}
