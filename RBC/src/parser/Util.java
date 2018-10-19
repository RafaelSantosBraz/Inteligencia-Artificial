/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;

/**
 *
 *
 * @author rafael
 */
public class Util {

    public static Number stringNumberConvertion(String n) {
        try {
            return Integer.parseInt(n);
        } catch (NumberFormatException e) {
            try {
                return Double.parseDouble(n);
            } catch (NumberFormatException f) {
                return null;
            }
        }
    }

    public static Integer findInList(ArrayList<Object> list, Object comp) {
        for (Object t : list) {
            if (t.equals(comp)) {
                return list.indexOf(t);
            }
        }
        return null;
    }

    public static Integer DistanceInList(ArrayList<Object> list, Object first, Object last) {
        ArrayList<Object> newList = concatenateList(list);
        Integer posFF = newList.indexOf(first);
        Integer posFL = newList.lastIndexOf(first);
        Integer posLF = newList.indexOf(last);
        Integer distance1 = posFF - posLF;
        Integer distance2 = posFL - posLF;
        if (distance1 < distance2){
            return distance1;
        }
        return distance2;
    }
    
    public static ArrayList<Object> concatenateList (ArrayList<Object> list){
        ArrayList<Object> result = (ArrayList<Object>) list.clone();
        list.forEach((t) -> {
            result.add(t);
        });
        return result;
    }
}
