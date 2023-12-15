package com.example.song_management.controller;

import com.example.song_management.dto.SongDto;
import com.example.song_management.model.Song;
import com.example.song_management.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Song> listSong = songService.getAll();
        model.addAttribute("listSong", listSong);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreatingForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Valid SongDto songDto, BindingResult bindingResult, RedirectAttributes
            redirectAttributes) {
        Song song = new Song();
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        BeanUtils.copyProperties(songDto,song);
            songService.add(song);
            redirectAttributes.addFlashAttribute("success", "Adding successfully!");
            return "redirect:/list";
    }

    @GetMapping("/edit")
    public String showUpdateForm(int id, Model model) {
        model.addAttribute("song", songService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String update(@Validated Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            songService.add(song);
            redirectAttributes.addFlashAttribute("success", "Updating successfully!");
            return "redirect:/list";
        }
    }
}
