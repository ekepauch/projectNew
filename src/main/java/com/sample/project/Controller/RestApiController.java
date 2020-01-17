package com.sample.project.Controller;



import com.sample.project.Model.User;
import com.sample.project.Service.ServiceClass;
import com.sample.project.Service.UserService;
import com.sample.project.Utils.CustomResponseCode;
import com.sample.project.Utils.Response;
import com.sample.project.exceptions.BadRequestException;
import com.sample.project.exceptions.ConflictException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")

public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    UserService userService;
    @Autowired
    ServiceClass serviceClass;

    //---------------------- List All users -------------------------------

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List getUsers() {
        return (List) userService.findAll();
    }

// ------------------------------------- FIND USER BY ID --------------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") long id)
    {
        HttpStatus httpCode;
        Response resp = new Response();
        User user = userService.findById(id);
        if (user == null )
        {
            throw new ConflictException(CustomResponseCode.CONFLICT_EXCEPTION, "user does not exist");
        }
        return user;
    }

    // -----------------------------FIND USER BY USER NAME -----------------------------------------------
    @RequestMapping(value = "/findUser/{name}", method = RequestMethod.GET)
    public User findByname(@PathVariable("name") String name)
    {
        User user = userService.findByName(name);
        if (user == null )
        {
            throw new ConflictException(CustomResponseCode.CONFLICT_EXCEPTION, "user does not exist");
        }
        return user;
    }


    //--------------------------Find by last name using post ----------------------------

//    @RequestMapping(value = "/findByLastName", method = RequestMethod.POST)
//    public List<User> search(@RequestBody Map<String, String> body){
//        String searchTerm = body.get("lastName");
//        return userService.findByLastName(searchTerm);
//    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public User search(@RequestBody User  body )
    {
        if(body.getName()==null || body.getName().isEmpty())
        {
            throw new ConflictException(CustomResponseCode.CONFLICT_EXCEPTION, "user does not exist");
        }
        if(body.getLastName()==null || body.getLastName().isEmpty())
        {
            throw new ConflictException(CustomResponseCode.CONFLICT_EXCEPTION, "user does not exist");
        }
            String lastName= body.getLastName();
            String name = body.getName();
            return userService.findByLastNameAndName(lastName,name);
    }




    // -------------------Create a User-------------------------------------------

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)

    @ResponseStatus(value = HttpStatus.CREATED)

    public ResponseEntity<Response> createUser(@RequestBody @Validated User user, HttpServletRequest request)
    {
        HttpStatus httpCode;
        Response resp = new Response();
        User userExist = userService.findByNameAndLastName(user.getName(),user.getLastName());
        if (userExist != null)
        {
            throw new ConflictException(CustomResponseCode.CONFLICT_EXCEPTION,"User already exist");
        }else
            {
            userService.save(user);

            resp.setCode(CustomResponseCode.SUCCESS);

            resp.setDescription("Successful");

            httpCode = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(resp, httpCode);
    }


    @PostMapping("/users/save")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Response> saveUsers(@RequestBody List<User> users)
    {
        HttpStatus httpCode;
        Response resp = new Response();

        serviceClass.saveUsers(users);
        resp.setCode(CustomResponseCode.SUCCESS);
        resp.setDescription("Successful");
        resp.setData(users);
        httpCode = HttpStatus.CREATED;
        return new ResponseEntity<>(resp, httpCode);
    }

    // ------------------- Update a User ------------------------------------------------

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Response> updateUser(@RequestBody @Validated User user, HttpServletRequest request)
    {

        HttpStatus httpCode;
        Response resp = new Response();

        if (user.getId()== null)
            throw new BadRequestException(CustomResponseCode.INVALID_REQUEST, "id cannot be empty");

        User userExist = userService.findByNameAndLastName(user.getName(),user.getLastName());
        if (userExist == null) {
            throw new ConflictException(CustomResponseCode.CONFLICT_EXCEPTION,"User user does not exist");
        }else {
            userService.save(user);
            resp.setCode(CustomResponseCode.SUCCESS);
            resp.setDescription("Update Successful");
            httpCode = HttpStatus.OK;
        }
        return new ResponseEntity<>(resp, httpCode);
    }


    // ------------------- Delete a User-----------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Response> deleteUser(@PathVariable("id") long id) {
        HttpStatus httpCode;
        Response resp = new Response();

        User user = userService.findById(id);
        if (user == null) {
            throw new ConflictException(CustomResponseCode.CONFLICT_EXCEPTION, "user does not exist");
        }else {
            userService.deleteById(id);
            resp.setCode(CustomResponseCode.SUCCESS);
            resp.setDescription("Delete Successful");
            httpCode = HttpStatus.OK;
        }
        return new ResponseEntity<>(resp, httpCode);
    }

    // ------------------- Delete All Users-----------------------------

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Response> deleteAllUsers() {
        HttpStatus httpCode;
        Response resp = new Response();

        userService.deleteAll();
        resp.setCode(CustomResponseCode.SUCCESS);
        resp.setDescription("Delete Successful");
        httpCode = HttpStatus.OK;

        return new ResponseEntity<>(resp, httpCode);
    }



}
