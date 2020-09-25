package com.sample.project.Service;

import com.sample.project.Model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClass {

    @Resource
    private UserService userService;

    @Transactional

//    public void saveUsers(List<User> users) {
//        int size = users.size();
//        int counter = 0;
//        List<User> temp = new ArrayList<>();
//        for (User user : users) {
//            temp.add(user);
//            if ((counter + 1) % 500 == 0 || (counter + 1) == size) {
//                userService.saveAll(temp);
//                temp.clear();
//            }
//            counter++;
//        }
//    }


    public List<User> saveUsers(List<User> users) {
        List<User> user = new ArrayList<>();

        users.forEach(posReq->{
            userService.save(posReq);
            user.add(posReq);

        });
        return user;
    }




}
