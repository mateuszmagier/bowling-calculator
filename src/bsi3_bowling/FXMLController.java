/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsi3_bowling;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField f1t1;
    @FXML
    private TextField f1t2;
    @FXML
    private TextField f2t1;
    @FXML
    private TextField f2t2;
    @FXML
    private TextField f3t1;
    @FXML
    private TextField f3t2;
    @FXML
    private TextField f4t1;
    @FXML
    private TextField f4t2;
    @FXML
    private TextField f5t1;
    @FXML
    private TextField f5t2;
    @FXML
    private TextField f6t1;
    @FXML
    private TextField f6t2;
    @FXML
    private TextField f7t1;
    @FXML
    private TextField f7t2;
    @FXML
    private TextField f8t1;
    @FXML
    private TextField f8t2;
    @FXML
    private TextField f9t1;
    @FXML
    private TextField f9t2;
    @FXML
    private TextField f10t1;
    @FXML
    private TextField f10t2;
    @FXML
    private TextField bonus1;
    @FXML
    private TextField bonus2;
    @FXML
    private Label bonusLabel;
    @FXML
    private Label resultLabel;
    
    boolean lastStrike, lastSpare;
    List<Frame> frames;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lastStrike = false;
        lastSpare = false;
        f10t1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                int t1 = 0, t2 = 0;
                try {
                    if(f10t2.getText() != "")
                        t2 = Integer.parseInt(f10t2.getText());
                }
                catch(Exception ex) {}
                try {
                    t1 = Integer.parseInt(f10t1.getText());
                }
                catch(Exception ex) {}
                if(t1 == 10) {
                    lastStrike = true;
                    lastSpare = false;
                    bonusLabel.setVisible(true);
                    bonus1.setVisible(true);
                    bonus2.setVisible(true);
                }
                else if(t1+t2 == 10) {
                    lastSpare = true;
                    lastStrike = false;
                    bonusLabel.setVisible(true);
                    bonus1.setVisible(true);
                    bonus2.setVisible(false);
                }
               
                else {
                    lastStrike = false;
                    lastSpare = false;
                    bonusLabel.setVisible(false);
                    bonus1.setVisible(false);
                    bonus2.setVisible(false);
                }
                
            }
        });
        
        f10t2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {
                int t1 = 0, t2 = 0;
                try {
                    if(f10t2.getText() != "")
                        t2 = Integer.parseInt(f10t2.getText());
                }
                catch(Exception ex) {}
                try {
                    t1 = Integer.parseInt(f10t1.getText());
                }
                catch(Exception ex) {}
                if(t1 == 10) {
                    lastStrike = true;
                    lastSpare = false;
                    bonusLabel.setVisible(true);
                    bonus1.setVisible(true);
                    bonus2.setVisible(true);
                }
                else if(t1+t2 == 10) {
                    lastStrike = false;
                    lastSpare = true;
                    bonusLabel.setVisible(true);
                    bonus1.setVisible(true);
                    bonus2.setVisible(false);
                }
               
                else {
                    lastStrike = false;
                    lastSpare = false;
                    bonusLabel.setVisible(false);
                    bonus1.setVisible(false);
                    bonus2.setVisible(false);
                }
                
            }
        });
    }    

    @FXML
    private void calculateResultAction(ActionEvent event) throws Exception {
        frames = getFrames();
        Bowling b = new Bowling(frames);
        int result = b.calculateResult();
        resultLabel.setText(result+"");
    }
    
    private List<Frame> getFrames() throws Exception {
        List<Frame> frames = new ArrayList<>();
        Frame f1 = getFrame(f1t1, f1t2);
        Frame f2 = getFrame(f2t1, f2t2);
        Frame f3 = getFrame(f3t1, f3t2);
        Frame f4 = getFrame(f4t1, f4t2);
        Frame f5 = getFrame(f5t1, f5t2);
        Frame f6 = getFrame(f6t1, f6t2);
        Frame f7= getFrame(f7t1, f7t2);
        Frame f8 = getFrame(f8t1, f8t2);
        Frame f9 = getFrame(f9t1, f9t2);
        Frame f10 = getFrame(f10t1, f10t2);
        frames.add(f1);
        frames.add(f2);
        frames.add(f3);
        frames.add(f4);
        frames.add(f5);
        frames.add(f6);
        frames.add(f7);
        frames.add(f8);
        frames.add(f9);
        frames.add(f10);
        if(lastStrike) {
            int bonusThrow1 = Integer.parseInt(bonus1.getText());
            int bonusThrow2 = Integer.parseInt(bonus2.getText());
            frames.add(new Frame(bonusThrow1, 0));
            frames.add(new Frame(bonusThrow2, 0));
        } else if(lastSpare) {
            int bonusThrow1 = Integer.parseInt(bonus1.getText());
            frames.add(new Frame(bonusThrow1, 0));
        }
        return frames;
    }
    
    private Frame getFrame(TextField t1, TextField t2) throws Exception {
        int throw1 = Integer.parseInt(t1.getText());
        int throw2 = Integer.parseInt(t2.getText());
        return new Frame(throw1, throw2);
    }
    
    private void setTextFields(int[] _throws) {
        int size = _throws.length;
        f1t1.setText(_throws[0]+"");
        f1t2.setText(_throws[1]+"");
        f2t1.setText(_throws[2]+"");
        f2t2.setText(_throws[3]+"");
        f3t1.setText(_throws[4]+"");
        f3t2.setText(_throws[5]+"");
        f4t1.setText(_throws[6]+"");
        f4t2.setText(_throws[7]+"");
        f5t1.setText(_throws[8]+"");
        f5t2.setText(_throws[9]+"");
        f6t1.setText(_throws[10]+"");
        f6t2.setText(_throws[11]+"");
        f7t1.setText(_throws[12]+"");
        f7t2.setText(_throws[13]+"");
        f8t1.setText(_throws[14]+"");
        f8t2.setText(_throws[15]+"");
        f9t1.setText(_throws[16]+"");
        f9t2.setText(_throws[17]+"");
        f10t1.setText(_throws[18]+"");
        f10t2.setText(_throws[19]+"");
        if(size == 22)
            bonus1.setText(_throws[20]+"");
        if(size == 24) {
            bonus1.setText(_throws[20]+"");
            bonus2.setText(_throws[22]+"");
        }
    }

    @FXML
    private void FramesWithoutAnyExceptionsActions(ActionEvent event) {
        int[] _throws = {3,6, 2,7, 1,5, 4,4, 9,0, 0,7, 1,6, 2,2, 7,1, 4,3};
        setTextFields(_throws);
    }

    @FXML
    private void ThreeStrikesAction(ActionEvent event) {
        int[] _throws = {10,0, 2,7, 1,5, 4,4, 10,0, 0,7, 10,0, 2,2, 7,1, 4,3};
        setTextFields(_throws);
    }

    @FXML
    private void TenStrikesAndNonStrikesBonusFramesAction(ActionEvent event) {
        int[] _throws = {10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 5,0, 3,0};
        setTextFields(_throws);
    }

    @FXML
    private void TenStrikesPlusBonusStrikesAction(ActionEvent event) {
        int[] _throws = {10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0};
        setTextFields(_throws);
    }

    @FXML
    private void LastFrameIsStrikeAction(ActionEvent event) {
        int[] _throws = {5,3, 9,0, 4,4, 1,7, 1,5, 3,4, 6,2, 2,0, 3,6, 10,0, 5,0, 3,0};
        setTextFields(_throws);
    }

    @FXML
    private void ThreeSparesAction(ActionEvent event) {
        int[] _throws = {5,5, 9,0, 4,1, 3,7, 1,5, 3,4, 6,4, 2,0, 3,6, 3,6};
        setTextFields(_throws);
    }

    @FXML
    private void LastFrameIsSpareAction(ActionEvent event) {
        int[] _throws = {5,4, 9,0, 4,1, 2,7, 1,5, 3,4, 2,4, 2,0, 3,6, 3,7, 9,0};
        setTextFields(_throws);
    }

    @FXML
    private void TwoStrikesFourSparesAction(ActionEvent event) {
        int[] _throws = {10,0, 9,1, 4,1, 10,0, 1,5, 3,7, 2,8, 2,0, 3,6, 3,7, 9,0};
        setTextFields(_throws);
    }

    @FXML
    private void TenSparesAction(ActionEvent event) {
        int[] _throws = {7,3, 9,1, 9,1, 2,8, 5,5, 3,7, 2,8, 4,6, 4,6, 3,7, 7,0};
        setTextFields(_throws);
    }
    
}
