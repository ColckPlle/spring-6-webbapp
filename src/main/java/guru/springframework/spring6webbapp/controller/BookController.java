package guru.springframework.spring6webbapp.controller;

import guru.springframework.spring6webbapp.services.BookService;
import guru.springframework.spring6webbapp.services.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
     private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookService.findAll());

        return "books";
    }

}
