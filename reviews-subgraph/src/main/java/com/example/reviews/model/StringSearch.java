package com.example.reviews.model;

import java.util.ArrayList;
import java.util.List;

public class StringSearch<I, O> implements Searchable<I, O>{
  @Override
  public List<O> search(I input) throws ImplementationNotAvailableException {
    if (input instanceof Character){
      ArrayList<O> list = new ArrayList<>();
        list.add((O)input);
      return list;
    }
    throw new ImplementationNotAvailableException("Implementation not available exception...");
  }

  public static void main(String[] args) {
    Searchable<Character, String> obj1 = new StringSearch<>();
    List<String> list1 = obj1.search('a');
    System.out.println(list1.toString());

    Searchable<Integer, String> obj2 = new StringSearch<>();
    List<String> list2 = obj2.search(1);
    System.out.println(list2.toString());
  }


}
