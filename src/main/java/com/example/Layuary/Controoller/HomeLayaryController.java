package com.example.Layuary.Controoller;

import com.example.Layuary.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Layuary.repository.BooksRepository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class HomeLayaryController {
    @Resource(name = "booksRepository")
    public BooksRepository booksRepository;

   @GetMapping("/")
    public String greeting(Map<String, Object> model){
        return "greeting";

    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Books> namebooks = (List<Books>) booksRepository.findAll();
        model.addAttribute("namebooks", namebooks);
        return "home";
    }

    @PostMapping("/home")
    public String add(@RequestParam(name = "namebooks") String namebooks, @RequestParam(name = "genre") String genre, Map<String, Object> model) {
        Books books1 = new Books(namebooks, genre);
        booksRepository.save(books1);
        List<Books> namebooks2 = (List<Books>) booksRepository.findAll();
        model.put("namebooks", namebooks2);

        return "/home";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable <Books> books;
        if (filter != null && !filter.isEmpty()){
            books = booksRepository.findByNamebooks(filter);
        }
        else {
            books = booksRepository.findAll();
        }
        model.put("namebooks", books);
        return "home";
    }
}
