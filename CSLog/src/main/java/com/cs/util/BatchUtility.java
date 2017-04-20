package com.cs.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.cassandra.core.CassandraOperations;

import com.datastax.driver.core.BatchStatement;
import com.datastax.driver.core.SimpleStatement;

//由于cassandra 不支持事务，对于多个表的操作可以放入到一个batch里面处理，能过取到事务的目的(cassandra2.0+)
public class BatchUtility {

	@Autowired
	@Qualifier("cqlTemplate")
	private CassandraOperations cqlTemplate;

	/**
	 * 进行批量处理
	 */
	public void batch(List<SimpleStatement> statements) {
		BatchStatement batch = new BatchStatement();
		for (SimpleStatement statement : statements) {
			batch.add(statement);
		}
		cqlTemplate.execute(batch);
		System.out.println("--------------> batch <--------------");
	}
}