package com.example.test_ex;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberService memberService;


    public Long save(BoardDTO boardDTO) {

       MemberEntity memberEntity = memberService.findById(boardDTO.getMember_id());
       BoardEntity boardEntity = BoardEntity.save(boardDTO,memberEntity);
      return  boardRepository.save(boardEntity).getBoard_id();
    }

    public BoardDTO findById(Long board_id) {
       BoardEntity boardEntity = boardRepository.findById(board_id).get();
     return BoardDTO.findById(boardEntity);
    }

    public List<BoardDTO> findAll() {

      List<BoardEntity> boardEntityList =  boardRepository.findAll();
      List<BoardDTO>  boardDTOList = new ArrayList<>();
        for (BoardEntity boardEntity: boardEntityList
             ) {
           BoardDTO boardDTO= BoardDTO.findById(boardEntity);
            boardDTOList.add(boardDTO);

        }
        return boardDTOList;
    }
//    public Long TestSave(TestDTO testDTO){
//       TestEntity testEntity= TestEntity.save(testDTO);
//
//        return ts.save(testEntity).getTestId();
//    }
//    public TestDTO testFindById(Long board_id) {
//        TestEntity testEntity = ts.findById(board_id).get();
//        return TestDTO.findById(testEntity);
//    }
}
