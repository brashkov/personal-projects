package org.borko.search.manager.dao;

import javax.xml.crypto.Data;

public class FileRepDAO {
	
	private  String TYPE ;
	private  String creationDate;
	private  String FILE_FORMAT ;
	private  String FILE_NAME ;
	
	private FileRepDAO (){
		// Private constructor
	}
	
	//Builder contructor
	public FileRepDAO(String TYPE, String creationDate, String FILE_FORMAT , String FILE_NAME) {
		this.TYPE = TYPE;
		this.creationDate = creationDate;
		this.FILE_FORMAT = FILE_FORMAT;
		this.FILE_NAME = FILE_NAME;
	}

	public String getTYPE() {
		return TYPE;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getFILE_FORMAT() {
		return FILE_FORMAT;
	}
	
	public String fileName() {
		return FILE_NAME;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s.%s was created on %s",FILE_NAME,FILE_FORMAT,creationDate);
	}
}
