package com.baizhi.service;

import com.baizhi.dao.PersonDao;
import com.baizhi.entity.Person;
import com.baizhi.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PersonServiceImp implements PersonService{
    @Autowired
    private PersonDao personDao;

    @Override
    public void showUsersByPage(HttpServletRequest request, Model model, Person person) {
        String pageNow = request.getParameter("pageNow");
        Page page = null;
        List<Person> list=new ArrayList<>();
        int totalCounts = personDao.findTotalCounts();
        if (pageNow != null) {
            page = new Page(totalCounts, Integer.parseInt(pageNow));
            list = this.personDao.queryAll(person.getName(),
                    page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCounts, 1);
            list = this.personDao.queryAll(person.getName(),
                    page.getStartPos(), page.getPageSize());
        }
        model.addAttribute("list", list);
        model.addAttribute("page", page);
    }

    @Override
    public void insertP(Person person) {
        person.setId(UUID.randomUUID().toString());
        personDao.insert(person);
    }

    @Override
    public void updateP(Person person) {
        personDao.update(person);
    }

    @Override
    public void deleteP(String id) {
        personDao.delete(id);
    }

    @Override
    public Person findOne(String id) {
        return personDao.findOne(id);
    }

    @Override
    public int findTotalCounts() {
        return personDao.findTotalCounts();
    }
}
