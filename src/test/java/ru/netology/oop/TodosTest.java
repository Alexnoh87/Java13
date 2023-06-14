package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.oop.manager.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Приготовить обед");

        String[] subtasks = { "Сметана", "Творог", "Батон" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = todos.search("Приготовить обед");
        Task[] actual = {simpleTask};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchEpic() {
        SimpleTask simpleTask = new SimpleTask(5, "Приготовить обед");

        String[] subtasks = { "Сметана", "Творог", "Батон" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = todos.search("Творог");
        Task[] actual = {epic};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchMeeting() {
        SimpleTask simpleTask = new SimpleTask(5, "Приготовить обед");

        String[] subtasks = { "Сметана", "Творог", "Батон" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = todos.search("Приложение НетоБанка");
        Task[] actual = {meeting};

        Assertions.assertArrayEquals(expected, actual);

    }
}
