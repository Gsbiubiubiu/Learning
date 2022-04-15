package com.gs.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CRUD<T> {
    int insert(T t);
    List<T> select(Map<String, Object> params);
    T selectById(@Param("id") Long id);
    void update(Map<String, Object> params);
    void delete(@Param("id") Long id);
}
