package com.pubmine.service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pubmine.model.Sentence;
import com.pubmine.ultility.Pagable;

@Service
public class SentenceService {

	private IndexReader reader;
	private IndexSearcher searcher;
	private Analyzer analyzer;
	private QueryParser parser;

	@Value("${pubmine.indexPath}")
	private String indexPath;

	public List<Sentence> search(String searchQuery, Pagable paging) {

		try {
			reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexPath)));
			searcher = new IndexSearcher(reader);
			analyzer = new StandardAnalyzer();

			// parser = new QueryParser("sentence", analyzer);
			parser = new MultiFieldQueryParser(new String[] { "sentence" }, analyzer);

			Query query;
			try {
				System.out.println("Query: " + searchQuery);
				System.out.println(String.format("%s %s %s", "".equals(searchQuery), ""==searchQuery, null==searchQuery));
				
				if(searchQuery.equals(""))
					query = new MatchAllDocsQuery();
				else
					query = parser.parse(searchQuery);

				TopScoreDocCollector collector = TopScoreDocCollector.create(paging.getPage() * paging.getLimit());
				searcher.search(query, collector);
				
				//ScoreDoc[] hits = collector.topDocs().scoreDocs;
				ScoreDoc[] hits = collector.topDocs(paging.getOffset(), paging.getLimit()).scoreDocs;

				System.out.println("Total results: " + collector.getTotalHits());
				List<Sentence> sentences = new ArrayList<>();

				for (int i = 0; i < hits.length; i++) {
					Document doc = searcher.doc(hits[i].doc);

					String sentence = doc.get("sentence");
					String pmid = doc.get("pmid");
					String sentenceOrder = doc.get("sentenceOrder");
					String abstractTextOrder = doc.get("abstractTextOrder");
					
					sentences.add(new Sentence(sentence, pmid, sentenceOrder, abstractTextOrder));
				}
				paging.setTotalCount(collector.getTotalHits());
				
				reader.close();
				return sentences;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
