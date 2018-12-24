package com.baizhi;

import com.baizhi.entity.Permission;
import com.baizhi.service.PersonService;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DayApplicationTests {
    @Autowired
    private PersonService personService;
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
//        Set<Role> zhaolin = userService.queryRolesByUsername("zhaolin");
//        for (Role role : zhaolin) {
//            System.out.println(role);
//        }
        Set<Permission> zhaolin = userService.queryPermissionByUsername("zhaolin");
        for (Permission permission : zhaolin) {
            System.out.println(permission);
        }
    }
}

