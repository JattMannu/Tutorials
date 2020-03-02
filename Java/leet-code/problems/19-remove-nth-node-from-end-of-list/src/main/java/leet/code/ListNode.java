package leet.code;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
//TODO: Make this class iterable @Manpreet
public class ListNode {

    private Integer val;
    private ListNode next;

    public boolean hasNext(){
        return  next != null;
    }
}
