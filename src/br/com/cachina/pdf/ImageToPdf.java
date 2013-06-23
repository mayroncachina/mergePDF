package br.com.cachina.pdf;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.PDFBox;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDCcitt;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.util.PDFImageWriter;

public class ImageToPdf {

	public static void imageToPdf(){
		
		 PDDocument doc = null;
	        try
	        {
	            doc = new PDDocument();

	            PDPage page = new PDPage();
	            doc.addPage( page );

	            PDXObjectImage ximage = null;
	            if( image.toLowerCase().endsWith( ".jpg" ) )
	            {
	                ximage = new PDJpeg(doc, new FileInputStream( image ) );
	            }
	            else if (image.toLowerCase().endsWith(".tif") || image.toLowerCase().endsWith(".tiff"))
	            {
	                ximage = new PDCcitt(doc, new RandomAccessFile(new File(image),"r"));
	            }
	            else
	            {
	                //BufferedImage awtImage = ImageIO.read( new File( image ) );
	                //ximage = new PDPixelMap(doc, awtImage);
	                throw new IOException( "Image type not supported:" + image );
	            }
	            PDPageContentStream contentStream = new PDPageContentStream(doc, page);

	            contentStream.drawImage( ximage, 20, 20 );

	            contentStream.close();
	            doc.save( file );
	        }
	        finally
	        {
	            if( doc != null )
	            {
	                doc.close();
	            }
	        }
		
	}
	
}
