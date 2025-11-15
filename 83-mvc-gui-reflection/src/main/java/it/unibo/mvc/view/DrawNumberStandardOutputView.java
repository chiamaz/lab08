package it.unibo.mvc.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Graphical {@link DrawNumberView} implementation, output only.
 */
public class DrawNumberStandardOutputView implements DrawNumberView{
    
    private static final String FRAME_NAME = "Draw Number App";
    private static final String QUIT = "Quit";
    private static final String RESET = "Reset";
    private static final String GO = "Go";
    private static final String NEW_GAME = ": a new game starts!";

    private DrawNumberController controller;
    private final JFrame frame = new JFrame(FRAME_NAME);

    public DrawNumberStandardOutputView(){
        frame.getContentPane().add(new JPanel(new BorderLayout()));
        
    }


    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription());
    }

    @Override
    public void setController(DrawNumberController observer) {
        observer.addView(this);
    }

    @Override
    public void start() {
        
    }
}