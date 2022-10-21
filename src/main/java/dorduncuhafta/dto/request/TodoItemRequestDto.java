package dorduncuhafta.dto.request;

import lombok.Data;

@Data
public class TodoItemRequestDto {
    private String day;
    private int start;
    private int end;
    private String description;
    private boolean isComplete;



}
