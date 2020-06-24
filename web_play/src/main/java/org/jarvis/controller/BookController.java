package org.jarvis.controller;

import org.jarvis.dto.Book;
import org.jarvis.vo.Books;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


/**
 * author:tennyson date:2020/6/23
 **/
@Controller
public class BookController {
    @GetMapping(value = "v1/book")
    public ModelAndView books() {
        Books books = new Books();
        books.setAuthor("罗贯中");
        books.setName("三国演义");
        books.setId(1);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("book");
        mv.addObject("books", books);
        return mv;
    }

    @GetMapping(value = "v2/book")
    @ResponseBody
    public Book book() {
        Book book = new Book();
        book.setAuthor("吴承恩");
        book.setName("西游记");
        book.setPrice(39.49f);
        book.setPublishDate(new Date());
        return book;
    }
}
