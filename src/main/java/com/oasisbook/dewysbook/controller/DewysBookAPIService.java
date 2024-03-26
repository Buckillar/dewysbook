package com.oasisbook.dewysbook.controller;

import com.oasisbook.dewysbook.model.DewysBook;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dewysbook")
public class DewysBookAPIService
{
    DewysBook dewysBook;

    @GetMapping("{bookId}")
    public DewysBook getDewysBookDetails(String bookId)
    {
        return dewysBook;
    //  return new DewysBook("b001", "Titantic", "SomeOne", "1994");
    }
    @PostMapping
    public String createDewysBookDetails(@RequestBody DewysBook dewysBook)
    {
        this.dewysBook = dewysBook;
        return "Book added Successfully";
    }
    @PutMapping
    public String updateDewysBookDetails(@RequestBody DewysBook dewysBook)
    {
        this.dewysBook = dewysBook;
        return  "Book details Updated Successfully";
    }

    @DeleteMapping("{bookId}")
    public String deleteDewysBookDetails(String bookId)
    {
        this.dewysBook = null;
        return  "Book details deleted Successfully";
    }
}
