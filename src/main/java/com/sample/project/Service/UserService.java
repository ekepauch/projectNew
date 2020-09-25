package com.sample.project.Service;

import com.sample.project.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface UserService extends JpaRepository<User,Long> {

   // private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    User findById(long id);
    User findByName(String name);
    User findByNameAndLastName(String name, String lastName);
    List<User> findByLastName(String lastName);

    User findByLastNameAndName(String lastName,String name);






}
