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


        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Приготовить обед");

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

        Task[] expected = {epic};
        Task[] actual = todos.search("Творог");

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

        Task[] expected = {meeting};
        Task[] actual = todos.search("Приложение НетоБанка");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testNoSearch() {
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

        Task[] expected = {};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchSeveral() {
        SimpleTask simpleTask = new SimpleTask(5, "Приложение НетоБанка");

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

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("Приложение НетоБанка");

        Assertions.assertArrayEquals(expected, actual);

    }
}
