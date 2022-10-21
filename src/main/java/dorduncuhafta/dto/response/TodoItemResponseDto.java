package dorduncuhafta.dto.response;


import lombok.Data;

@Data
public class TodoItemResponseDto {
    private String day;
    private int start;
    private int end;
    private String description;
    private boolean isComplete;



}
