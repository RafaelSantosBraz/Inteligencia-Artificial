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

    //<editor-fold defaultstate="collapsed" desc="SINGLETON">
    private static CSimilarityResult instance;

    public static CSimilarityResult getInstance() {
        if (instance == null) {
            instance = new CSimilarityResult();
        }
        return instance;
    }
    //</editor-fold>

    private SimilarityResult form;

    public CSimilarityResult() {
        form = new SimilarityResult(this);        
    }
    
    private void setCollumsData(){
        
    }
    
    public void createForm() {
        setCollumsData();
        form.setVisible(true);
    }
    
    public void renewForm() {
        form.dispose();
        form = new SimilarityResult(this);
        setCollumsData();
        form.setVisible(true);
    }
    
    public void showForm() {
        form.setVisible(true);
    }
    
    public void goBack() {
        form.setVisible(false);
        CDataCollector.getInstance().showForm();
    }
}
