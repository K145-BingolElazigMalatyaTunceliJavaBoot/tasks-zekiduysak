package dorduncuhafta.controller;



import dorduncuhafta.dto.request.TodoItemRequestDto;

import dorduncuhafta.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("todo islemleri")
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @ApiOperation(value = "yeni todo ekleme")
    @PostMapping("/create")
    public ResponseEntity<Void> save(@RequestBody TodoItemRequestDto todoItemRequestDto) {
        todoService.save(todoItemRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @ApiOperation(value = "günlük parametreye göre o gün yapilacaklarin listesini döner")
    @GetMapping("/getDaily")
    public ResponseEntity<List<TodoItemRequestDto>> getDaily(@RequestParam String day) {

        List<TodoItemRequestDto> daily = todoService.getDaily(day);

        return new ResponseEntity<>(daily,HttpStatus.OK);

    }


    @ApiOperation(value = "haftalık yapılacaklarin listesini döner")
    @GetMapping("/getWeekly")
    public ResponseEntity<List<TodoItemRequestDto>> getWeekly() {
        List<TodoItemRequestDto> weekly = todoService.getWeekly();
        return new ResponseEntity<>(weekly,HttpStatus.OK);
    }

    @ApiOperation(value = "yapılacak bir işi yapıldı/tamamlandı ya da yapılmadı/tamamlanmadı şeklinde değiştirir")
    @PutMapping("/update")
    public ResponseEntity<Void> updateAsCompleteOrNotComplete(@RequestBody TodoItemRequestDto todoItemRequestDto) {
        todoService.updateAsCompleOrNotComplete(todoItemRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @ApiOperation(value = "yapılacak/yapılan bir işi siler")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }



}
