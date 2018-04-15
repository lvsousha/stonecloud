package com.stone.webapp.dao;

import java.util.List;

import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.stone.webapp.model.User;

@Repository
@SuppressWarnings("unchecked")
public class UserDao extends AbstractDAO<User>{

	public User findByNickName(String nickName){
		return (User) getCriteria()
				.add(Restrictions.like("nickName", nickName))
				.uniqueResult();
	}
	
	public List<User> testCriteria(){
		List<User> data = getCriteria()
//				.add(Restrictions.like("nickName", "joejim"))
				
//				.setProjection(Projections.projectionList() 
//						  .add(Projections.rowCount(),"num") 
//						  .add(Projections.avg("weight")) 
//						  .add(Projections.max("weight")) 
//						  .add(Projections.groupProperty("userName"),"userName") 
//						) 
				
				.addOrder(Order.desc("userName"))
				
//				.createAlias("userDetail", "c", JoinType.LEFT_OUTER_JOIN, Restrictions.eq("age", 41))
//					.setFetchMode("userDetail", FetchMode.SELECT)
				
//				.createCriteria("userDetail", "b")		//创建连接
//					.add(Restrictions.like("sex", "男"))
//					.add(Restrictions.disjunction(
//							Restrictions.eq("age", 26),
//							Restrictions.eq("age", 12),
//							Restrictions.eq("age", 41))
//						)
//					.add(Restrictions.sqlRestriction("b1_.blood_type='A'"))		//直接使用sql进行查询
//					.addOrder(Order.desc("age"))
				
				
				.setMaxResults(Integer.MAX_VALUE)
				.setResultTransformer(CriteriaSpecification.ROOT_ENTITY)
				.list();
		
		return data;
		
	}
	
}
