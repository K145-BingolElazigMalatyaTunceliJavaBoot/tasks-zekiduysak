package dorduncuhafta.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoItemAsCompleteNotCompleteDto {
   private long id;
   private boolean isComplete;
}
