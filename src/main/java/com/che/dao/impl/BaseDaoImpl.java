package com.che.dao.impl;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl extends SqlSessionDaoSupport implements SqlSession {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public <T> T selectOne(String s) {
        return getSqlSession().selectOne(s);
    }

    @Override
    public <T> T selectOne(String s, Object o) {
        return getSqlSession().selectOne(s, o);
    }

    @Override
    public <E> List<E> selectList(String s) {
        return getSqlSession().selectList(s);
    }

    @Override
    public <E> List<E> selectList(String s, Object o) {
        return getSqlSession().selectList(s, o);
    }

    @Override
    public <E> List<E> selectList(String s, Object o, RowBounds rowBounds) {
        return getSqlSession().selectList(s, o, rowBounds);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String s, String s1) {
        return getSqlSession().selectMap(s, s1);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String s, Object o, String s1) {
        return getSqlSession().selectMap(s, o , s1);
    }

    @Override
    public <K, V> Map<K, V> selectMap(String s, Object o, String s1, RowBounds rowBounds) {
        return getSqlSession().selectMap(s, o, s1, rowBounds);
    }

    @Override
    public <T> Cursor<T> selectCursor(String s) {
        return getSqlSession().selectCursor(s);
    }

    @Override
    public <T> Cursor<T> selectCursor(String s, Object o) {
        return getSqlSession().selectCursor(s, o);
    }

    @Override
    public <T> Cursor<T> selectCursor(String s, Object o, RowBounds rowBounds) {
        return getSqlSession().selectCursor(s, o, rowBounds);
    }

    @Override
    public void select(String s, Object o, ResultHandler resultHandler) {
        getSqlSession().select(s, o, resultHandler);
    }

    @Override
    public void select(String s, ResultHandler resultHandler) {
        select(s, resultHandler);
    }

    @Override
    public void select(String s, Object o, RowBounds rowBounds, ResultHandler resultHandler) {
        getSqlSession().select(s, o, rowBounds, resultHandler);
    }

    @Override
    public int insert(String s) {
        return getSqlSession().insert(s);
    }

    @Override
    public int insert(String s, Object o) {
        return getSqlSession().insert(s, o);
    }

    @Override
    public int update(String s) {
        return getSqlSession().update(s);
    }

    @Override
    public int update(String s, Object o) {
        return getSqlSession().update(s, o);
    }

    @Override
    public int delete(String s) {
        return getSqlSession().delete(s);
    }

    @Override
    public int delete(String s, Object o) {
        return getSqlSession().delete(s, o);
    }

    @Override
    public void commit() {
        getSqlSession().commit();
    }

    @Override
    public void commit(boolean b) {
        getSqlSession().commit(b);
    }

    @Override
    public void rollback() {
        getSqlSession().rollback();
    }

    @Override
    public void rollback(boolean b) {
        getSqlSession().rollback(b);
    }

    @Override
    public List<BatchResult> flushStatements() {
        return getSqlSession().flushStatements();
    }

    @Override
    public void close() {
        getSqlSession().close();
    }

    @Override
    public void clearCache() {
        getSqlSession().clearCache();
    }

    @Override
    public Configuration getConfiguration() {
        return getSqlSession().getConfiguration();
    }

    @Override
    public <T> T getMapper(Class<T> aClass) {
        return getSqlSession().getMapper(aClass);
    }

    @Override
    public Connection getConnection() {
        return getSqlSession().getConnection();
    }

    Map<String, Object> newCond(String key, Object value) {

        return ImmutableMap.of(key, value);
    }

    Map<String, Object> newCond(String key1, Object value1, String key2, Object value2) {

        return ImmutableMap.of(key1, value1, key2, value2);
    }

    <E> E one(List<E> list){

        if (CollectionUtils.isNotEmpty(list)) {

            return list.get(0);
        }

        return null;
    }
}
