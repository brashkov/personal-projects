package org.borko.search.manager.func;

import java.io.File;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInputFileProcces {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"app-config.xml");
		
		FileProcess test = (FileProcess)context.getBean("fileProcess");
		test.printShit();
		
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Multiple file and directory selection:");
		jfc.setMultiSelectionEnabled(true);
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File[] files = jfc.getSelectedFiles();
			System.out.println("Directories found\n");
			Arrays.asList(files).forEach(x -> {
				if (x.isDirectory()) {
					System.out.println(x.getName());
				}
			});
			System.out.println("\n- - - - - - - - - - -\n");
			System.out.println("Files Found\n");
			Arrays.asList(files).forEach(x -> {
				if (x.isFile()) {
					test.getType(x);
					System.out.println(x.getName());
				}
			});
		}

	}

}
