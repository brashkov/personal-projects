package org.borko.search.manager.formats.image;

import org.borko.search.manager.interfaces.ABSTRACT_IMAGES;
import org.borko.search.manager.interfaces.IMAGE_IMP;
import org.springframework.stereotype.Component;

@Component
public class IMAGE_JPG extends ABSTRACT_IMAGES /*implements IMAGE_IMP*/{

	private static String FILE_FORMAT = "JPEG";
	
	
	private IMAGE_JPG(){
		super(FILE_FORMAT);
	}
	/**
	 * @return returns file format in lower case
	 */
	@Override
	public String fileFormat() {
		// TODO Auto-generated method stub
		return FILE_FORMAT.toLowerCase();
	}
}
