package it.unibo.mvc.view;

import java.util.logging.Logger;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

/**
 * Graphical {@link DrawNumberView} implementation, output only.
 */
public final class DrawNumberStandardOutputView implements DrawNumberView {

    @Override
    public void result(final DrawResult res) {
        final Logger log = Logger.getLogger(DrawNumberStandardOutputView.class.getName());
        log.fine(res.getDescription());
    }

    @Override
    public void setController(final DrawNumberController observer) {
        //not used
    }

    @Override
    public void start() {
        final Logger log = Logger.getLogger(DrawNumberStandardOutputView.class.getName());
        log.fine("DrawNumberStandardOutputView started");
    }
}
