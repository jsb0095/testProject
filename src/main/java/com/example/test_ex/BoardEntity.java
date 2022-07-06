package com.example.test_ex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;

@Entity
@Getter@Setter
@Table(name = "board_test_table")
public class BoardEntity {
    @Id
    @Column(name = "board_id")
    private Long board_id;
    @Column(name = "board_email",length = 30,unique = true)
    private String board_email;
    @Column(name = "board_password",length = 50, nullable = true)
    private String board_password;
    @Column(name = "board_contents",length = 500)
    private String board_contents;
    @Column(name = "board_hits")
    private int board_hits;
    @Column(name = "board_created_time")
    private LocalDateTime board_create_time;
    @Column(name = "member_id")
    private Long member_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    public static BoardEntity save(BoardDTO boardDTO, MemberEntity memberEntity) {
        BoardEntity boardEntity= new BoardEntity();
        boardEntity.setBoard_email(boardDTO.getBoard_email());
        boardEntity.setBoard_password(boardDTO.getBoard_password());
        boardEntity.setBoard_contents(boardDTO.getBoard_contents());
        boardEntity.setBoard_hits(0);
        boardEntity.setMemberEntity(memberEntity);
       return boardEntity;
    }
}
