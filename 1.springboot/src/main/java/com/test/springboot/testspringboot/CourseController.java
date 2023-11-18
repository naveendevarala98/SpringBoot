package com.test.springboot.testspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1,"learn aws","abc"),
                new Course(2,"learn azure","xyz"),
                new Course(3,"learn gcp","vvv")

        );
    }
}
