package com.lylastudio.learn.controller;

import com.lylastudio.learn.bean.Person;
import com.lylastudio.learn.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class First {

    @Autowired
    Person person;

    @Autowired
    Person person1;

    @GetMapping("/test")
    public HashMap<String,String> test(){

        HashMap<String, String> data = new HashMap<>();
        data.put("Name", "Azka");
        data.put("Address", "Sayuran");
        data.put("hobby", "swiming");

        return data;
    }

    @GetMapping("getStudent")
    public Student getStudent(){
        Student student = new Student();
        student.setName("Elfathan");
        student.setAddress("Dayeuh Kolot");
        student.setBod("01-01-2022");

        return student;
    }

    @GetMapping("getStudents")
    public ArrayList<Student> getStudents(){
        Student student1 = new Student();
        student1.setName("Elfathan");
        student1.setAddress("Dayeuh Kolot");
        student1.setBod("01-01-2022");

        Student student2= new Student();
        student2.setName("Azka");
        student2.setAddress("Sayuran");
        student2.setBod("01-01-2015");

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        return students;
    }



    @GetMapping("getPerson")
    public List<Person> getPerson(){
        person.setName("Elfathan Danish Jibran");
        person.setGender("Male");
        person.setRelationStatus("Single");

        person1.setName("Azka Daukas Syatihiri");
        person1.setGender("Male");
        person1.setRelationStatus("Merried");

        Person person2 = getOnePerson();
        person2.setName("Ila");
        person2.setGender("Female");
        person2.setRelationStatus("Merried");

        Person person3 = getOnePerson();
        person3.setName("Syukur");
        person3.setGender("Male");
        person3.setRelationStatus("Merried");

        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);

        list.add(person2);
        list.add(person3);

        return list;
    }

    @Bean
    private Person getOnePerson(){
        return new Person();
    }

    @GetMapping("/getBook")
    public Book getBook(){
        return new Book("Atomic Habits","James Clear");
    }

    @GetMapping("/getBooks")
    public List<Book> getBooks(){
        List<Book> listBook = new ArrayList<>();

        listBook.add( new Book("Atomic Habits","James Clear") );
        listBook.add( new Book("Clean Code","Robert C. Martin Series") );

        return listBook;
    }


    record Book( String tittle, String writer ){}

    record Personal(
            String name,
            int saving,
            boolean single
    ){}

    record GreetingResponse(
           String greet,
           List<String> pavProgrammingLanguage,
           Personal personal
    ){}


    @GetMapping("greeting")
    public GreetingResponse greeting(){
        return new GreetingResponse(
                "Hai",
                List.of("Java", "Golang", "Phyton"),
                new Personal(
                        "Syukur",
                        1_000_000_000,
                        false
                )
        );
    }

}
