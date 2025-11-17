package edu.icet.model.dto;

import javafx.collections.ObservableList;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TwoOBsavelLists <T>{
    private ObservableList<T> list1;
    private ObservableList<T> list2;
}
