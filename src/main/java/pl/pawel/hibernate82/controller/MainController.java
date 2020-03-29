package pl.pawel.hibernate82.controller;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pawel.hibernate82.jpa.NoteRepo;
import pl.pawel.hibernate82.model.Note;

@Controller
@RequestMapping("/")
public class MainController {

    NoteRepo noteRepo;

    @Autowired
    public MainController(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
        Note note = new Note("Notatka 1", "tresc 2");
        Note note2 = new Note("Notatka 2", "Tresc 2");
        Note note3 = new Note("Todo", "fryzjer");
        Note note4 = new Note("Gdzie pojechac", "trzeba odwiedzic rodzicow");
        Note note5 = new Note("Co kupic", "alkohol i papierosy");
        noteRepo.save(note);
        noteRepo.save(note2);
        noteRepo.save(note3);
        noteRepo.save(note4);
        noteRepo.save(note5);
    }

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("notes", noteRepo.findAll());
        model.addAttribute("editNote", new Note());
        return "home";
    }

    @PostMapping("/edit-note")
    public String editNote(@ModelAttribute Note note) {
        noteRepo.save(note);
        return "redirect:/";
    }

    @PostMapping("/add-note")
    public String addNote(@ModelAttribute Note note) {
        noteRepo.save(note);
        return "redirect:/";
    }


}
