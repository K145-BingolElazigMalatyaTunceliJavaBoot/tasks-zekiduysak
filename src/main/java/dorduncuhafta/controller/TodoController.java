package dorduncuhafta.controller;



import dorduncuhafta.dto.TodoItemDto;
import dorduncuhafta.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<Void> save(@RequestBody TodoItemDto todoItemDto) {

        todoService.save(todoItemDto);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    
    @GetMapping("/getDaily")
    public ResponseEntity<List<TodoItemDto>> getDaily(@RequestParam String day) {

        List<TodoItemDto> daily = todoService.getDaily(day);

        return new ResponseEntity<>(daily,HttpStatus.OK);

    }


    @GetMapping("/getWeekly")
    public ResponseEntity<List<TodoItemDto>> getWeekly() {
        List<TodoItemDto> weekly = todoService.getWeekly();
        return new ResponseEntity<>(weekly,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateAsCompleteOrNotComplete(@RequestBody TodoItemDto todoItemDto) {
        todoService.updateAsCompleOrNotComplete(todoItemDto);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam String day,@RequestParam int start,@RequestParam int end,@RequestParam boolean isComplete) {
        todoService.delete(day,start,end,isComplete);
        return new ResponseEntity<>(HttpStatus.OK);

    }



}
