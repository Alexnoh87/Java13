package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.oop.manager.*;

public class TasksTest {

    @Test
    public void testMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Приготовить обед");

        boolean actual = simpleTask.matches("Суп");
        boolean expected  = false;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testMatchesEpic() {
        String[] subtasks = { "Сметана", "Творог", "Батон" };
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Сметана");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Во вторник после обеда");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }



}
