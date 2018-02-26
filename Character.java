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
//import javafx.scene.control.skin.TextInputControlSkin.Direction;

import java.awt.*;
import java.util.Random;

public class Character extends GridTryTwo {
	protected int HP, DEFENSE, ATTACK = 1;
	protected int row = 0;
	protected int column = 0;
	private boolean battle = false;
	private int numberOfPlayers;
	int[] location = new int[] { row, column };// Used to store a location
	int coordX, coordY;
	private Image player;
	private Image grid = new Image("grid.png");

	// Image grid = new Image(grid);
//	public Character() {

//	}

	public Character(int row, int column, Image avatar) {
		HP = 5;
		DEFENSE = 1;
		ATTACK = 1;
		player = avatar;
	//	String name = getName();
		setCharacterLocation(row, column);
		//updateMap(0, 0, row, column);
	}

	public int getHeight() {
		return width;
	}

	public int getWidth() {
		return length;
	}

	public static enum Direction {
		UP, DOWN, LEFT, RIGHT
	};

	// Gets Player's name
	// Is based upon number of players in the game

	public String getName() {
		return "Player" + numberOfPlayers;
	}

	// Gets the color of player
	// Unsure of how to differentiate between images or colors
	public Color getColor() {
		return Color.BLACK;
	}

	// Gets and Set Player's HP
	public int getHP() {
		return HP;
	}

	public void setHP(int remainingHP) {
		HP = remainingHP;
	}

	// Get and Set Player's Attack Points
	public int getATKPTS() {
		return ATTACK;
	}

	public void setATKPTS(int updatedATKPTS) {
		ATTACK = ATTACK + updatedATKPTS;
	}

	// Get and Set Player's Defense Points
	public int getDEFPTS() {
		return DEFENSE;
	}

	public void setDEFPTS(int updatedDEFPTS) {
		DEFENSE = DEFENSE + updatedDEFPTS;
	}

	// First Column is to store the players/ bots
	// Second column is to store coordinates

	public int[] getCharacterLocation() {
		return location;
	} // int [][]

	public void setCharacterLocation(int coordX, int coordY) {
		this.location = new int[] { coordX, coordY };
		updateMap(0, 0, coordX, coordY);
	} // int [][]

	// Attack method. Returns true if neither player has died yet.
	public boolean attack(Character opponent) {
		opponent.setHP(opponent.getHP() - ATTACK);
		battle = true;

		if (opponent.getHP() <= 0) {
			death(opponent);
		}
		return battle;
	}

	// This method updates the Player location based on their key input.
	// It will call upon Superclass Character's setLocation method, to update
	// the Player's icon on the game map.
	public void move(Direction direction) {
		coordX = getCharacterLocation()[0];
		coordY = getCharacterLocation()[1];
		if (battle == false) {
			switch (direction) {
			case UP:
				if (coordX > 0) {
					// updateMap(coordX, coordY);
					setCharacterLocation(coordX - 1, coordY);
					updateMap(coordX, coordY, coordX - 1, coordY);
					break;
				}
			case DOWN:
				if (coordX < getHeight()) {
					setCharacterLocation(coordX + 1, coordY);
					updateMap(coordX, coordY, coordX + 1, coordY);
					break;
				}
			case RIGHT:
				if (coordY > 0) {
					setCharacterLocation(coordX, coordY - 1);
					updateMap(coordX, coordY, coordX, coordY - 1);
					break;
				}
			case LEFT:
				if (coordY > 0) {
					setCharacterLocation(coordX, coordY + 1);
					updateMap(coordX, coordY, coordX, coordY + 1);
					break;
				}

			default: {
				System.out.print("Cannot move in that direction");
				break;
			}
			}
		} else
			System.out.print("Cannot move, still in a fight");

	}

	// This method updates the game map
	public void updateMap(int coordX, int coordY, int coordX2, int coordY2) {
		pane.add(new ImageView(grid), coordX, coordY);
		pane.add(new ImageView(player), coordX2, coordY2);

		super.updates(null, pane);
	}

	// This method first checks to see if there's already a block or an item at
	// the designated location. It sends an error message if there are, else
	// it calls upon the Superclass Character's setBlockLocation method, where it
	// updates the game map with the block.
	/*
	 * public void setBlock(int x, int y) { if (getObject(x, y) == true) {
	 * System.out.print("Please pick another point to set your block."); }
	 *
	 * else { super.setBlockLocation(x, y); } }
	 */
	public void death(Character character) {
		pane.add(new ImageView(grid), column, row);
		battle = false;
	} // Calls upon this method when a character loses a fight; removes them from the
		// game

}
