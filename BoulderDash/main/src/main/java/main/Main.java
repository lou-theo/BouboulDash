package main;

import java.io.IOException;
import java.sql.SQLException;

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
     * @throws SQLException 
     */
    public static void main(final String[] args) throws IOException, InterruptedException, SQLException {
        new Menu();
    }

}
