package dorduncuhafta.converter;

import dorduncuhafta.dto.TodoItemDto;
import dorduncuhafta.model.TodoItem;
import org.springframework.stereotype.Component;

@Component
public class TodoConverter {
    public TodoItem convertTodoItemDtoToTodoItem(TodoItemDto todoItemDto) {
        TodoItem todoItem=new TodoItem();
        todoItem.setDescription(todoItemDto.getDescription());
        todoItem.setDay(todoItemDto.getDay());
        todoItem.setStart(todoItem.getStart());
        todoItem.setEnd(todoItemDto.getEnd());
        todoItem.setComplete(false);
        return todoItem;

    }



}