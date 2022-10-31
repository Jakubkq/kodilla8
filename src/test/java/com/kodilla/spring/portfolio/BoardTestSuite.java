package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.addToToDoList("malowanie paznokci");
        board.addToInProgressList("gotowanie");
        board.addToDoneList("pranie");
        //Then
        Assert.assertEquals("malowanie paznokci", board.getToDoList().getTasks().get(0));
        Assert.assertEquals("gotowanie", board.getInProgressList().getTasks().get(0));
        Assert.assertEquals("pranie", board.getDoneList().getTasks().get(0));

    }
}