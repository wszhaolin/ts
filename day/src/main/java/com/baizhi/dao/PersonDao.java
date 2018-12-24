package com.baizhi.dao;

import com.baizhi.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonDao {
    public List<Person> queryAll(@Param(value="name")String name,@Param(value="startPos") Integer startPos,@Param(value="pageSize") Integer pageSize);
    public void insert(Person person);
    public void update(Person person);
    public void delete(String id);
    public Person findOne(String id);
    public int findTotalCounts();
}
