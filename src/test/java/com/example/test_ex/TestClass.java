package com.example.test_ex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class TestClass {
    @Autowired private BoardService bs;

    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("test")
    public void Test(){
    BoardDTO boardDTO =  new BoardDTO("testTitle","testWriter","testContents");
        Long id =   bs.save(boardDTO);
        BoardDTO boardDTO1 =bs.findById(id);
        String testWriter= boardDTO1.getTestWriter();
        assertThat(testWriter).isEqualTo(boardDTO1.getTestWriter());
        System.out.println(id);
    }


}
