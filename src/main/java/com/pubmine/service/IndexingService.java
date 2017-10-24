package com.pubmine.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IndexingService {

	private Analyzer analyzer;
	
	@Value("${pubmine.indexPath}")
	private String indexPath;
	
	@Value("${pubmine.isAppend}")
	private boolean isAppend;
	
	@Value("${pubmine.filePath}")
	private String filePath;
	
	public boolean readAndIndex() {
		try {
			analyzer = new StandardAnalyzer();

			Directory dir = FSDirectory.open(Paths.get(indexPath));
			IndexWriterConfig config = new IndexWriterConfig(analyzer);

			if (!isAppend) {
				config.setOpenMode(OpenMode.CREATE);
			} else {
				config.setOpenMode(OpenMode.CREATE_OR_APPEND);
			}			
			IndexWriter writer = new IndexWriter(dir, config);
			
			//TODO: read from file
			File files = new File(filePath);
			File[] listOfFiles = files.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				String path = listOfFiles[i].getAbsolutePath();
				
				System.out.println(String.format("-> Executing file: %s", listOfFiles[i].getAbsolutePath()));
				
				try (BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
					String readLine = "";
					while ((readLine = b.readLine()) != null) {
						String[] sTexts = readLine.split("\t", 4);

						String pmid = sTexts[0];
						String abstractTextOrder = sTexts[1];
						String sentenceOrder = sTexts[2];
						String sentence = sTexts[3];
						
						//TODO: Indexing 
						Document doc = new Document();
						if (sentence != null) {
							doc.add(new StringField("pmid", pmid, Field.Store.YES));
							doc.add(new StringField("abstractTextOrder", abstractTextOrder, Field.Store.YES));
							doc.add(new StringField("sentenceOrder", sentenceOrder, Field.Store.YES));
							doc.add(new TextField("sentence", sentence, Field.Store.YES));
							writer.addDocument(doc);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
