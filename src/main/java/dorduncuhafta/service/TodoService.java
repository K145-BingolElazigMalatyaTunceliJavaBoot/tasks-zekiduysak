package dorduncuhafta.service;



import dorduncuhafta.converter.TodoConverter;
import dorduncuhafta.dto.request.TodoItemAsCompleteNotCompleteDto;
import dorduncuhafta.dto.request.TodoItemRequestDto;
import dorduncuhafta.dto.response.TodoItemResponseDto;
import dorduncuhafta.exception.UndefinedException;
import dorduncuhafta.model.TodoItem;
import dorduncuhafta.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class TodoService  {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    TodoConverter todoConverter;

    public void save(TodoItemRequestDto todoItemRequestDto) {

        TodoItem todoItem=todoConverter.convertTodoItemRequestDtoToTodoItem(todoItemRequestDto);
        todoRepository.save(todoItem);
    }

    public List<TodoItemRequestDto> getDaily(String day) {

        List<TodoItem> daily=todoRepository.findByDay(day);
        List<TodoItemRequestDto> dtos=new ArrayList<>();

        /*daily.forEach(s->  {
            dto.add(todoConverter.convertTodoItemToTodoItemRequestDto(s));
        }
        );
         */
        for (TodoItem item : daily ) {
            dtos.add(todoConverter.convertTodoItemToTodoItemRequestDto(item));
        }
        return dtos;
    }

    public List<TodoItemRequestDto> getWeekly() {
        //kullanıcı bir hafta için yapacaklarını bir listede tutmak istiyor
        //haftalık seçim yapıldığında ise 7 gunun de verileri gelmeli
        List<TodoItem> todoItems=todoRepository.findAll();
        List<TodoItemRequestDto> dtos=new ArrayList<>();

        /*
        todoItems.forEach(s-> {
            dtos.add(todoConverter.convertTodoItemToTodoItemResponseDto(s);
        });
         */
        for (TodoItem item : todoItems) {
            dtos.add(todoConverter.convertTodoItemToTodoItemRequestDto(item));
        }
        return dtos;
    }

    public void delete(long id) {

        /*
        Optional<TodoItem> temp=todoRepository.findById(id);
        if (temp.isEmpty()) {
            throw new UndefinedException("hata olustu");
        }
        todoRepository.deleteById(temp.get().getId());
        */

        TodoItem item=todoRepository.findById(id).orElseThrow(()->{ throw new UndefinedException("hata olustu");});
        todoRepository.deleteById(item.getId());
    }

    public void updateAsCompleOrNotComplete(TodoItemAsCompleteNotCompleteDto todoItemAsCompleteNotCompleteDto) {
        TodoItem item=todoRepository.findById(todoItemAsCompleteNotCompleteDto.getId()).orElseThrow(() -> {
            throw new UndefinedException("hata olustu")
        });
        item.setComplete(todoItemAsCompleteNotCompleteDto.isComplete());

        todoRepository.saveAndFlush();
    }



}