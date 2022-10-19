package dorduncuhafta.service;



import dorduncuhafta.converter.TodoConverter;
import dorduncuhafta.dto.TodoItemDto;
import dorduncuhafta.model.TodoItem;
import dorduncuhafta.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TodoService  {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    TodoConverter todoConverter;


    public void save(TodoItemDto todoItemDto) {

        TodoItem todoItem=todoConverter.convertTodoItemDtoToTodoItem(todoItemDto);
        todoRepository.save(todoItem);

    }

    public List<TodoItemDto> getDaily(String day) {

        List<TodoItem> daily=todoRepository.findByDay(day);
        List<TodoItemDto> dto=new ArrayList<>();

        /*daily.forEach(s->  {
            dto.add(s);
        }
        );

         */

        for (TodoItem item : daily ) {
            TodoItemDto dto1=new TodoItemDto();
            dto1.setComplete(item.isComplete());
            dto1.setDay(item.getDay());
            dto1.setStart(item.getStart());
            dto1.setEnd(item.getEnd());
            dto.add(dto1);
        }


        return dto;
    }

    public List<TodoItemDto> getWeekly() {


        //kullanıcı bir hafta için yapacaklarını bir listede tutmak istiyor
        //haftalık seçim yapıldığında ise 7 gunun de verileri gelmeli
        List<TodoItem> todoItems=todoRepository.findAll();
        List<TodoItemDto> dtos=new ArrayList<>();

        for (TodoItem item : todoItems) {
            TodoItemDto dto=new TodoItemDto();
            dto.setDescription(item.getDescription());
            dto.setStart(item.getStart());
            dto.setEnd(item.getEnd());
            dto.setComplete(item.isComplete());
            dtos.add(dto);
        }

        return dtos;

    }

    public void delete(String day,int start,int end,boolean isComplete) {

        TodoItem item=new TodoItem();
        item.setComplete(isComplete);
        item.setDay(day);
        item.setStart(start);
        item.setEnd(end);
        todoRepository.delete(item);


    }


    public void updateAsCompleOrNotComplete(TodoItemDto todoItemDto) {
        TodoItem item=new TodoItem();
        item.setStart(todoItemDto.getStart());
        item.setEnd(todoItemDto.getEnd());
        item.setComplete(todoItemDto.isComplete());
        item.setDescription(todoItemDto.getDescription());
        todoRepository.saveAndFlush(item);
    }



}