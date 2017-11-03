package com.zhou.pdftoword;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfToWord {

	public static void main(String[] args) {

		try {
			PDDocument doc = PDDocument.load(new FileInputStream("合同打印.pdf"));
			int pagenumber = doc.getNumberOfPages();
			System.out.println("pagenumber:" + pagenumber);
			FileOutputStream fos = new FileOutputStream("合同打印.txt");

			Writer writer = new OutputStreamWriter(fos, "UTF-8");
			PDFTextStripper stripper = new PDFTextStripper();

			stripper.setSortByPosition(true);// 排序
			stripper.setWordSeparator("");//pdfbox对中文默认是用空格分隔每一个字，通过这个语句消除空格
			stripper.setStartPage(0);// 设置转换的开始页
			stripper.setEndPage(pagenumber);// 设置转换的结束页
			
			String content = stripper.getText(doc);
            System.out.println(content); 
			
			stripper.writeText(doc, writer);
			writer.close();
			doc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
