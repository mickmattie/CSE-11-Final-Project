import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import javafx.scene.control.Button;

public class GridTryTwo extends Application {
	protected GridPane pane;
	protected int[][] mapOne = {{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,
                    18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34},
                    {0,20,34},{0,20,34},{0,5,20,34},
                    {0,5,20,34},{0,5,34},{0,5,34},
                    {0,4,5,34},{0,34},{0,16,34},{0,8,16,34},{0,8,16,34},
                    {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,
                    18,19,20,21,22,23,24,34},{0,8,16,34},{0,8,16,34},{0,16,34},{0,34},
                    {0,4,5,34},{0,5,34},{0,5,34},
                    {0,5,34},{0,5,20,34},{0,20,34},
                    {0,20,34},{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
                    16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34}};
	int width = 25;
	int length = 35;
	int[][] mapOneGoal = {{},{},{},{},{},{},{},{},{},{33},{33},{33},{33},{33},
                        {33},{33}};
	// loading in all the images for the given map
	Image grid = new Image("grid.png");

	// Image playerOne = new Image("playerOne.png");
	Image verWall = new Image("verWall.png");
	Image goalWall = new Image("goalWall.png");

	@Override
	public void start(Stage primaryStage) {
		// these are the cordinates for the points which contain walls on the map,
		// each array represents an array of the colum number where each wall,
		// should go for each row

		// these are the cordinates for the points where goal wals go

		// width and length costruct the size of the map, this info can be
		// gotten off of the array for the map but requireds a loop that takes
		// a while to run so this is a bit quicker

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(5, 5, 5, 5));

		// constructing the default map, based off of the size given in,
		// length and width of all 'grid' images
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				pane.add(new ImageView(grid), i, j);
			}
		}
		// placing all the walls based off of the mapOne array
		for (int k = 0; k < mapOne.length; k++) {
			for (int l = 0; l < mapOne[k].length; l++) {
				pane.add(new ImageView(verWall), mapOne[k][l], k);
			}
		}
		// placing all the goal walls based off of the goal mapOneGoal array
		for (int m = 0; m < mapOneGoal.length; m++) {
			for (int n = 0; n < mapOneGoal[m].length; n++) {
				pane.add(new ImageView(goalWall), mapOneGoal[m][n], m);
			}
		}

		Scene scene = new Scene(pane);
		primaryStage.setTitle("Code of Mocha");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void updates(Stage secondaryStage, GridPane panes) {
		Scene scene = new Scene(pane);
		secondaryStage.setTitle("Code of Mocha");
		secondaryStage.setScene(scene);
		secondaryStage.show();
	}


	public static void main(String[] args) {
		//Image player1 = new Image("playerOne.png");
		//Character player = new PlayerOne(15, 15, player1);

		launch(args);

	}
/*
	class MoveUpHandler implements EventHandler<KeyEvent> {
		@Override
		public void handle(KeyEvent e) {
			System.out.println("okay you hit the key gud job.");
		}
	}*/
}
