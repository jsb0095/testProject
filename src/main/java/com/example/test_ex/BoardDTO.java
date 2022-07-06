package com.example.test_ex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long board_id;
    private String board_email;
    private String board_password;
    private String board_contents;
    private LocalDateTime board_create_time;
    private Long member_id;
    private String testTitle;
    private String testWriter;
    private String testContents;

    public BoardDTO(String testTitle, String testWriter, String testContents) {

        this.testTitle = testTitle;
        this.testWriter = testWriter;
        this.testContents = testContents;
    }


    public static BoardDTO findById(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoard_id(boardEntity.getBoard_id());
        boardDTO.setBoard_email(boardEntity.getBoard_email());
        boardDTO.setBoard_password(boardEntity.getBoard_password());
        boardDTO.setBoard_contents(boardEntity.getBoard_contents());
        boardDTO.setBoard_create_time(boardEntity.getBoard_create_time());
        boardDTO.setMember_id(boardEntity.getMember_id());


        return boardDTO;

    }

}
