package com.baizhi.service;

import com.baizhi.entity.Person;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface PersonService {
    public void showUsersByPage(HttpServletRequest request, Model model, Person person);
    public void insertP(Person person);
    public void updateP(Person person);
    public void deleteP(String id);
    public Person findOne(String id);
    public int findTotalCounts();
}
