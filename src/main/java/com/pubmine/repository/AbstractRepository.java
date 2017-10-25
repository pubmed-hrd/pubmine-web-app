package com.pubmine.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.pubmine.model.Abstract;

@Repository
public interface AbstractRepository {

	@Select("SELECT A.value as text,"
			+ " A.medcit_art_abstract_abstracttext_order as textOrder,"
			+ " A.pmid,"
			+ "	A.label"
			+ " FROM medcit_art_abstract_abstracttext A"
			+ " WHERE A.pmid=#{pmid} order by A.medcit_art_abstract_abstracttext_order")
	List<Abstract> findOne(Integer pmid);
	
}
