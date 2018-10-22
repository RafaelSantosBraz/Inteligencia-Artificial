/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.SimilarityResult;

/**
 *
 * @author rafael
 */
public class CSimilarityResult {
    private SimilarityResult form;
    
    public CSimilarityResult(){
        form = new SimilarityResult(this);
        
        form.setVisible(true);
    }
    
    public void goBack(){
        form.setVisible(false);
        
    }
}
