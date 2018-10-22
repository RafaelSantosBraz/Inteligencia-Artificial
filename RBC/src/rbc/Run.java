/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rbc;

import controller.CDataCollector;
import java.io.IOException;
import parser.*;

/**
 *
 * @author rafael
 */
public class Run {

    public static void main(String[] args) throws IOException {
        Util.readBaseFile("base.ia", Boolean.FALSE);
        CDataCollector c = new CDataCollector();
    }

}
