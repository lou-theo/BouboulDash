package main;

import java.io.IOException;

import controller.ControllerFacade;
import controller.IController;
import model.IModel;
import model.ModelFacade;
import view.IView;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException 
     * @throws InterruptedException 
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
        IModel model = new ModelFacade(2);
        IView view = new ViewFacade(model);
        IController controller = new ControllerFacade(model, view);
        view.setOrderPerformer(controller.getOrderPerformer());
        
        controller.play();
    }

}
