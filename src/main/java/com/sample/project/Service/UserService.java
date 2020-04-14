package com.sample.project.Service;

import com.sample.project.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Repository
public interface UserService extends JpaRepository<User,Long> {


    User findById(long id);
    User findByName(String name);
    User findByNameAndLastName(String name, String lastName);
    List<User> findByLastName(String lastName);

    User findByLastNameAndName(String lastName,String name);

    //List<User> findByLastNameAndName(String searchTerm);




}
