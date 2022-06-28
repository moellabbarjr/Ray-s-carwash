package microsoft.azure.cosmos.controller;

import java.util.List;
import java.util.UUID;
import lombok.NonNull;
import microsoft.azure.cosmos.dao.TodoDao;
import microsoft.azure.cosmos.dao.TodoDaoFactory;
import microsoft.azure.cosmos.model.TodoItem;

public class TodoItemController {
    public static TodoItemController getInstance() {
        if (todoItemController == null) {
            todoItemController = new TodoItemController(TodoDaoFactory.getDao());
        }
        return todoItemController;
    }

    private static TodoItemController todoItemController;

    private final TodoDao todoDao;

    TodoItemController(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public TodoItem createTodoItem(@NonNull String name, @NonNull String category, @NonNull String date, boolean isComplete) {
        TodoItem todoItem = new TodoItem();

        todoItem.setName(name);
        todoItem.setCategory(category);
        todoItem.setdate(date);
        todoItem.setComplete(isComplete);
        todoItem.setId(UUID.randomUUID().toString());

        return todoDao.createTodoItem(todoItem);
    }

    public boolean deleteTodoItem(@NonNull String id) {
        return todoDao.deleteTodoItem(id);
    }

    public TodoItem getTodoItemById(@NonNull String id) {
        return todoDao.readTodoItem(id);
    }

    public List<TodoItem> getTodoItems() {
        return todoDao.readTodoItems();
    }

    public TodoItem updateTodoItem(@NonNull String id, boolean isComplete) {
        return todoDao.updateTodoItem(id, isComplete);
    }
}