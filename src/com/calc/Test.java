package com.calc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: yest
 * @copyright: taofen8.com
 *
 * Created on: 2019/12/16
 */
public class Test {


  public static void main(String[] args) {

    HashMap<String, List<String>> map = new HashMap<>();

    List<String> list = new ArrayList<>();
    list.add("B");

    map.put("A", list);

    list = new ArrayList<>();
    list.add("C");

    map.put("B", list);

    list = new ArrayList<>();
    list.add("D");

    map.put("C", list);

    System.out.println(getOrder(map));

  }

  public static String getOrder(HashMap<String, List<String>> taskGroup) {
    StringBuffer result = new StringBuffer();
    Set<String> set = new HashSet<String>();
    int count = 0;
    String lastKey = null;
    for (Map.Entry<String, List<String>> entry : taskGroup.entrySet()) {
      String key = entry.getKey();
      String value = (String) ((List) entry.getValue()).get(0);
      lastKey = value;
      break;
    }

    while (lastKey != null) {
      List<String> list = taskGroup.get(lastKey);
      if (list != null && !list.isEmpty()) {
        lastKey = list.get(0);
      }
      result.append(lastKey);
    }
    return result.toString();
  }
}
