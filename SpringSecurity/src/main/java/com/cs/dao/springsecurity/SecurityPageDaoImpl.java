package com.cs.dao.springsecurity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cs.model.springsecurity.SecurityPage;
import com.cs.util.JqgridResponse;

@Repository
public class SecurityPageDaoImpl {
	    
	private static final Logger	LOG	= LoggerFactory.getLogger(SecurityPageDaoImpl.class);
	
	@PersistenceContext(unitName="appPU")
	@Qualifier(value = "entityManagerFactory")
	private EntityManager		entityManager;
	
	public List<SecurityPage> findByPageSwitch(int pageSwitch){
		String SQL = "select p from SecurityPage p where p.pageSwitch = :pageSwitch order by p.type asc, p.sort asc";
		return this.entityManager.createQuery(SQL, SecurityPage.class).setParameter("pageSwitch", pageSwitch).getResultList();
	}
	

	@SuppressWarnings("unchecked")
	public List<SecurityPage> findByPageInPageIdList(String pageId){
		String SQL = " select * from security_page p where p.page_id in ("+pageId+") order by p.type asc, p.sort asc ";
		return entityManager.createNativeQuery(SQL , SecurityPage.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public JqgridResponse<SecurityPage> findByQuery(int page, int rows, String sidx, String sord){
		
		StringBuilder nativeQuerySql = new StringBuilder( " select * from security_page  " );
		String NativeQueryCount = " select count(*) from security_page   ";
		
		if(sidx!=null && !"".equals( sidx )){
			if(sord!=null && !"".equals( sord )){
				nativeQuerySql.append(" order by "+sidx+" "+sord);
			}
		}
		
		int count = this.searchGridCountNativeQuery(NativeQueryCount);
		Query query = this.entityManager.createNativeQuery(nativeQuerySql.toString(), SecurityPage.class);
		if (page > 0) { query.setFirstResult((page - 1) * rows); }
		if (rows > 0) { query.setMaxResults(rows); }
		

		List<SecurityPage> securityPageList = query.getResultList(); //查詢的資料
		
		JqgridResponse<SecurityPage> jqgridResponse = new JqgridResponse<>();
		jqgridResponse.setRows(securityPageList);//放入資料
		jqgridResponse.setPage(String.valueOf(page));//設定查詢的頁面
		int totalPages = (count % rows == 0)? count / rows : count / rows + 1; //設定總頁數
		jqgridResponse.setTotal(String.valueOf(totalPages)); //總頁數
		jqgridResponse.setRecords(String.valueOf(count)); //總筆數
		
		return jqgridResponse;		
	}
	
	
	public int searchGridCountNativeQuery(String nativeQuerySql){
		Query query_count = this.entityManager.createNativeQuery(nativeQuerySql);
		int count = ((java.math.BigInteger)query_count.getSingleResult()).intValue(); //查詢總筆數
		return count;		
	}

}
