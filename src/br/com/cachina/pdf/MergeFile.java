package br.com.cachina.pdf;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

public class MergeFile {

	public final static String DIRETORIO = "/Users/mayron/Public/PDF/";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		PDFMergerUtility merge = new PDFMergerUtility();
		
		Collection<File> files = FileUtils.listFiles(new File(DIRETORIO),
				new RegexFileFilter("^(.*?)"), DirectoryFileFilter.DIRECTORY);

		for (File file : files) {
			if(!file.getName().equals(".DS_Store")){
				merge.addSource(file);
			}
		}

		try {

			merge.setDestinationFileName(DIRETORIO + "#OUTPUT.pdf");

			merge.mergeDocuments();

		} catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
