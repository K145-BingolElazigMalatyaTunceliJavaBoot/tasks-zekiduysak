package dorduncuhafta.dto;

import lombok.Data;

@Data
public class TodoItemDto {
    private String day;
    private int start;
    private int end;
    private String description;
    private boolean isComplete;



}
