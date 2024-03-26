package com.oasisbook.dewysbook.controller;

import com.oasisbook.dewysbook.model.DewysBook;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dewysbook")
public class DewysBookAPIService
{
    private Map<String, DewysBook> booksMap = new HashMap<>();

    // Constructor to add some example books
    public DewysBookAPIService() {
        // Add some example books
        addExampleBooks();
    }

    private void addExampleBooks() {
        DewysBook book1 = new DewysBook("b001", "To Kill a Mockingbird", "Harper Lee", "1960");
        DewysBook book2 = new DewysBook("b002", "The Great Gatsby", "F. Scott Fitzgerald", "1925");
        DewysBook book3 = new DewysBook("b003", "1984", "George Orwell", "1949");
        DewysBook book4 = new DewysBook("b004", "Pride and Prejudice", "Jane Austen", "1813");
        DewysBook book5 = new DewysBook("b005", "The Catcher in the Rye", "J.D. Salinger", "1951");
        DewysBook book6 = new DewysBook("b006", "To the Lighthouse", "Virginia Woolf", "1927");
        DewysBook book7 = new DewysBook("b007", "The Lord of the Rings", "J.R.R. Tolkien", "1954");
        DewysBook book8 = new DewysBook("b008", "Moby-Dick", "Herman Melville", "1851");
        DewysBook book9 = new DewysBook("b009", "One Hundred Years of Solitude", "Gabriel García Márquez", "1967");
        DewysBook book10 = new DewysBook("b010", "Frankenstein", "Mary Shelley", "1818");

        booksMap.put(book1.getBookId(), book1);
        booksMap.put(book2.getBookId(), book2);
        booksMap.put(book3.getBookId(), book3);
        booksMap.put(book4.getBookId(), book4);
        booksMap.put(book5.getBookId(), book5);
        booksMap.put(book6.getBookId(), book6);
        booksMap.put(book7.getBookId(), book7);
        booksMap.put(book8.getBookId(), book8);
        booksMap.put(book9.getBookId(), book9);
        booksMap.put(book10.getBookId(), book10);

    }


    @GetMapping("/{bookId}")
    public DewysBook getDewysBookDetails(@PathVariable String bookId) {
        return booksMap.get(bookId);
    }

    @PostMapping
    public String createDewysBookDetails(@RequestBody DewysBook dewysBook) {
        booksMap.put(dewysBook.getBookId(), dewysBook);
        return "Book added Successfully";
    }

    @PutMapping("/{bookId}")
    public String updateDewysBookDetails(@PathVariable String bookId, @RequestBody DewysBook dewysBook) {
        if (booksMap.containsKey(bookId)) {
            booksMap.put(bookId, dewysBook);
            return "Book details Updated Successfully";
        } else {
            return "Book not found";
        }
    }

    @DeleteMapping("/{bookId}")
    public String deleteDewysBookDetails(@PathVariable String bookId) {
        if (booksMap.containsKey(bookId)) {
            booksMap.remove(bookId);
            return "Book details deleted Successfully";
        } else {
            return "Book not found";
        }
    }

    @GetMapping
    public List<DewysBook> getAllBooks() {
        return new ArrayList<>(booksMap.values());
    }
}