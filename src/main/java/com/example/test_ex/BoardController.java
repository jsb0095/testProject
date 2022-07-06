package com.example.test_ex;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;

@RequestMapping("board")
@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService bs;

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO ){
        bs.save(boardDTO);
        return "/board";
    }
    @GetMapping("/{id}")
    public String findById(@PathVariable Long board_id, Model model){
      BoardDTO boardDTO =  bs.findById(board_id);
        model.addAttribute("boardDTO",boardDTO);
        return "detail";

    }
    @GetMapping("/findAll")
    public String findAll(){
        bs.findAll();
        return "index";
    }
}
