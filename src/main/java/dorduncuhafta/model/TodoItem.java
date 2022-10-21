package dorduncuhafta.model;



import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data

public class TodoItem {

    //     * ORnek PAzartesi gunu saat 1 3 arası okula gidilecek gibi.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column
    private String day;

    @NotNull
    @Column
    private int start;

    @NotNull
    @Column
    private int end;

    @NotNull
    @Column
    private String description;

    @Column
    private boolean isComplete;





}
