package com.kodilla.testing.collection;

import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers){
        int a = numbers.size();
        for (int i = a-1; i >= 0; i--){
            if (numbers.get(i) % 2 != 0){
                numbers.remove(i);
            }
        }
        return numbers;
    }

}
