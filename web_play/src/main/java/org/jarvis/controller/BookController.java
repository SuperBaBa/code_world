package org.jarvis.controller;

import org.jarvis.vo.Books;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * author:tennyson date:2020/6/23
 **/
@Controller
public class BookController {
    @GetMapping(value = "/books")
    public ModelAndView books() {
        Books books = new Books();
        books.setAuthor("罗贯中");
        books.setName("三国演义");
        books.setId(1);
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books);
        return mv;
    }
}
