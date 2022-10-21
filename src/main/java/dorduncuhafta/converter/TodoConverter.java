package dorduncuhafta.converter;

import dorduncuhafta.dto.request.TodoItemRequestDto;
import dorduncuhafta.dto.response.TodoItemResponseDto;
import dorduncuhafta.model.TodoItem;
import org.springframework.stereotype.Component;

@Component
public class TodoConverter {
    public TodoItem convertTodoItemDtoToTodoItemRequestDto (TodoItemRequestDto item) {
        TodoItem todoItem = new TodoItem();
        todoItem.setDescription(item.getDescription());
        todoItem.setDay(item.getDay());
        todoItem.setStart(item.getStart());
        todoItem.setEnd(item.getEnd());
        todoItem.setComplete(item.isComplete());
        return todoItem;
    }



        public TodoItemResponseDto convertTodoItemToTodoItemResponseDto(TodoItem item) {
            TodoItemResponseDto dto=new TodoItemResponseDto();
            dto.setComplete(item.isComplete());
            dto.setDescription(item.getDescription());
            dto.setStart(item.getStart());
            dto.setEnd(item.getEnd());
            dto.setDay(item.getDay());
            return dto;
        }

}