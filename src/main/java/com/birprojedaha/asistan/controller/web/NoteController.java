package com.birprojedaha.asistan.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    @GetMapping("/notes")
    public String notesIndex(ModelAndView model) {

        return "notes/index";

    }

    @GetMapping("/notes/labels")
    public String labels(ModelAndView model) {

        return "notes/labels";

    }
}
