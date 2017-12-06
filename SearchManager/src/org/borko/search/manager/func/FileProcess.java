package org.borko.search.manager.func;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.borko.search.manager.dao.FileRepDAO;
import org.borko.search.manager.interfaces.FILE_IMPL;
import org.borko.search.manager.memory.RDFMemory;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileProcess {
	
	
	/* M A P   ------> File class to file formats*/
	private Map<String, FILE_IMPL> fileFormats;
	
	@Autowired
	public void FileProcess(Collection<FILE_IMPL> commands){
		System.out.println("Starting up all beans...");
		Stream<FILE_IMPL> fileStream;
		List<FILE_IMPL> tmpC = new ArrayList<FILE_IMPL>();
		
		for (FILE_IMPL tmp : commands) {
			System.out.println("Bean :"+tmp.getClass().getSimpleName());
			tmpC.add(tmp);
		}
		fileStream = tmpC.stream();
		fileFormats = fileStream.collect(Collectors.toMap(FILE_IMPL::fileFormat, Function.identity()));
		System.out.println("Done !");
	}
	
	public void printShit(){
		System.out.println(fileFormats.size());
	}
	
	public void getType(File currentFile ){
		String file_name=currentFile.getName().split("\\.")[0];
		String format = currentFile.getAbsolutePath().split("\\.")[1];
		
		if(fileFormats.containsKey(format.toLowerCase())){
			FILE_IMPL toReturn = fileFormats.get(format.toLowerCase());
			FileRepDAO newFile = toReturn
					.name(file_name)
					.creationDate()
					.build();
			System.out.println(newFile.toString());
		}else{
			
		}
	}

}
