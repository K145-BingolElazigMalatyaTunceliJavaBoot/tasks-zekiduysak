package dorduncuhafta.repository;


import dorduncuhafta.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoItem,Long> {


    public List<TodoItem> findByDay(String day);

    //findFirstByEmailContainsIgnoreCaseAndField1NotNullAndField2NotNullAndField3NotNullAndField4NotNullAndField5NotNullAndField6NotNull
    //https://github.com/daggerok/spring-data-examples/blob/master/shadov/src/main/java/daggerok/ShadovApplication.java
    //https://stackoverflow.com/questions/53315452/how-to-change-method-names-from-jpa-repository
    public void findFirstByDayContainsIgonerCaseAndStartNotNullAndEndNotNullAndDescriptionNotNullAndIsCompleteNotNull(String day);
}
