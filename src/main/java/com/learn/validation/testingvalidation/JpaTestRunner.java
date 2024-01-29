package com.learn.validation.testingvalidation;

import com.learn.validation.testingvalidation.model.Book;
import com.learn.validation.testingvalidation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JpaTestRunner implements CommandLineRunner {

    private BookRepository repository;

    public JpaTestRunner(BookRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

//        Book book1 = new Book("FirstBook", "Sohail", "First Book written by Sohail");
//        Book book2 = repository.save(book1);
//
//        System.out.println(repository.findById(book2.getId() + 1));
//        System.out.println(repository.findByName("FirstBook"));
//        System.out.println(repository.findBookByAuthor("Sohail"));
//        System.out.println(repository.findBookByAuthorAfter("Sohal"));
//
//        book2.setDescription("This is the new description of the book");
//
//        repository.save(book2);
//
//        System.out.println(repository.findById(book2.getId()));
//        System.out.println(repository.findBookByNameAndAuthor("FirstBook", "Sohail"));

    }
}
