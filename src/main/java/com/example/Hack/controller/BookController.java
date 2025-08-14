package com.example.Hack.controller;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List; // ✅ Added

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // ✅ Added
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Hack.model.Book;
import com.example.Hack.repo.BookRepository;

@Controller
@RequestMapping("/api/bookings")
public class BookController { // ✅ Fixed class name

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/create")
    public String createBooking(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String registerNumber,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate bookingDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime returnTime) {

        Book book = new Book();
        book.setName(name);
        book.setEmail(email);
        book.setRegisterNumber(registerNumber);
        book.setBookingDate(bookingDate);
        book.setStartTime(startTime);
        book.setReturnTime(returnTime);

        bookRepository.save(book);

        return "redirect:/api/bookings/admin";
    }

    @GetMapping("/admin")
    public String viewBookings(Model model) {
        List<Book> bookings = bookRepository.findAll();
        model.addAttribute("bookings", bookings);
        return "admin-dashboard"; // This is the Thymeleaf HTML page
    }
}