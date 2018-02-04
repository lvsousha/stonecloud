package com.webapp.hibernate;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.cfg.NamingStrategy;


@SuppressWarnings("serial")
public class CustNamingStrategy extends ImprovedNamingStrategy implements
    NamingStrategy {

    @Override
    public String columnName(String columnName) {
        return addUnderscores(columnName).toUpperCase();
    }

    @Override
    public String tableName(String tableName) {
        return addUnderscores(tableName).toUpperCase();
    }

    @Override
    public String classToTableName(String className) {
//        return "T_" + tableName(className);
    	return tableName(className);
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        return addUnderscores(propertyName).toUpperCase();
    }
}
