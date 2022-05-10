package client;
import client_gui.ConnectToServerController;
import javafx.application.Application;
import javafx.stage.Stage;
/**In this class we starting the first user screen (connecting to the server)
 * 
 *
 */
public class ClientUI extends Application {
	public static ClientController chat; //only one instance

	public static void main( String args[] ) throws Exception
	   { 
		    launch(args);  
	   } // end main
	 
	@Override
	public void start(Stage primaryStage) throws Exception {
		
	 //creating instance of ConnectToServerController then we lunch it.
		ConnectToServerController ConnectToServer=new ConnectToServerController();
		 ConnectToServer.start(primaryStage);
		 
		 
		
	}
	
	
}
