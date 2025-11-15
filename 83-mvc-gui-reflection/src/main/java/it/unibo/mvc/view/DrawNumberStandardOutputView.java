package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

/**
 * Graphical {@link DrawNumberView} implementation, output only.
 */
public class DrawNumberStandardOutputView implements DrawNumberView{

    private DrawNumberController controller;

    public DrawNumberStandardOutputView() {

    }
    
    @Override
    public void result(final DrawResult res) {
        System.out.println(res.getDescription());
    }

    @Override
    public void setController(final DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start() {
        System.out.println("DrawNumberStandardOutputView started");
    }
}