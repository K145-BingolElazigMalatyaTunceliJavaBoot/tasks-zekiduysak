package dorduncuhafta.service;



import dorduncuhafta.converter.TodoConverter;
import dorduncuhafta.dto.request.TodoItemRequestDto;
import dorduncuhafta.dto.response.TodoItemResponseDto;
import dorduncuhafta.model.TodoItem;
import dorduncuhafta.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class TodoService  {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    TodoConverter todoConverter;

    public void save(TodoItemRequestDto todoItemRequestDto) {

        TodoItem todoItem=todoConverter.convertTodoItemDtoToTodoItemRequestDto(todoItemRequestDto);
        todoRepository.save(todoItem);
    }

    public List<TodoItemRequestDto> getDaily(String day) {

        List<TodoItem> daily=todoRepository.findByDay(day);
        List<TodoItemResponseDto> dtos=new ArrayList<>();

        /*daily.forEach(s->  {
            dto.add(s);
        }
        );
         */
        for (TodoItem item : daily ) {

            dtos.add(todoConverter.convertTodoItemToTodoItemResponseDto(item));
        }
        return dtos;
    }

    public List<TodoItemResponseDto> getWeekly() {
        //kullanıcı bir hafta için yapacaklarını bir listede tutmak istiyor
        //haftalık seçim yapıldığında ise 7 gunun de verileri gelmeli
        List<TodoItem> todoItems=todoRepository.findAll();
        List<TodoItemResponseDto> dtos=new ArrayList<>();
        for (TodoItem item : todoItems) {
            dtos.add(todoConverter.convertTodoItemToTodoItemResponseDto(item));
        }
        return dtos;
    }

    public void delete(String day,int start,int end,boolean isComplete) {
        TodoItem item=todoRepository.findByFirstByDAyIgnoreCaseAndStartNotNullAndEndNotNullAndDescriptionNotNullAndIsCompleteNotNull(day);
        if (Objects.isNull(item)) {
            throw new RuntimeException("hata");
        }
        todoRepository.deleteById(item.getId());
    }

    public void updateAsCompleOrNotComplete(TodoItemRequestDto todoItemRequestDto) {
       TodoItem item=todoRepository.findByFirstByDAyIgnoreCaseAndStartNotNullAndEndNotNullAndDescriptionNotNullAndIsCompleteNotNull(todoItemRequestDto.getDay());
        if (Objects.isNull(item)) {
           throw new RuntimeException("hata");
        }
        item.setStart(todoItemRequestDto.getStart());
        item.setEnd(todoItemRequestDto.getEnd());
        item.setComplete(todoItemRequestDto.isComplete());
        item.setDescription(todoItemRequestDto.getDescription());

        todoRepository.saveAndFlush(item);
    }



}