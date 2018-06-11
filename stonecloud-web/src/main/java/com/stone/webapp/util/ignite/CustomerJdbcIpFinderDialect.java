package com.stone.webapp.util.ignite;

import org.apache.ignite.spi.discovery.tcp.ipfinder.jdbc.JdbcIpFinderDialect;

public class CustomerJdbcIpFinderDialect  implements JdbcIpFinderDialect{

	private String tableName;
	
	public CustomerJdbcIpFinderDialect(String tableName){
		this.tableName = tableName;
	}
	
	@Override
	public String tableName() {
		// TODO Auto-generated method stub
		return tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
