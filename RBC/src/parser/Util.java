/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 * FACADE?
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
}
