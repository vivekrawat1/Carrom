package main;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.ArrayList;

import processing.core.PApplet;

/**Represents a player of Carrom
 * 
 * @author Ayush
 *
 */
public class Player implements Serializable{
	private Striker striker;
	private Rectangle2D.Double hitarea;
	private ArrayList<GenericGamePiece> myPieces;
	
	private static final long serialVersionUID = 1L;
	/**Instantiates a player with a striker it will use and a hit area
	 * 
	 * @param striker The striker the player will use
	 * @param hitarea A 2D Rectangle representing where the striker will be confined to.
	 */
	public Player(Striker striker, Rectangle2D.Double hitarea) {
		super();
		this.striker = striker;
		this.hitarea = hitarea;
		this.myPieces = new ArrayList<GenericGamePiece>();
	}
	public Striker getStriker() {
		return striker;
	}
	public void setStriker(Striker striker) {
		this.striker = striker;
	}
	public Rectangle2D.Double getHitarea() {
		return hitarea;
	}
	public void setHitarea(Rectangle2D.Double hitarea) {
		this.hitarea = hitarea;
	}
	
	/**Add a coin into the player's sunk pieces
	 * 
	 * @param piece the piece to add
	 */
	public void addCoin(GenericGamePiece piece) {
		myPieces.add(piece);
	}
	/**Finds the coin of greatest value which the player has pocketed and returns it.
	 * 
	 * @return Coin of greatest value pocketed. If no coins have been pocketed, returns null.
	 */
	public GenericGamePiece removeCoin() {
		for(int i = 0;i<myPieces.size();i++) {
			GenericGamePiece piece = myPieces.get(i);
			if(piece.getValue() == 50) {
				myPieces.remove(i);
				return piece;
			}
			
		}
		for(int i = 0;i<myPieces.size();i++) {
			GenericGamePiece piece = myPieces.get(i);
			if(piece.getValue() == 20) {
				myPieces.remove(i);
				return piece;
			}
		}
		
		for(int i = 0;i<myPieces.size();i++) {
			GenericGamePiece piece = myPieces.get(i);
			if(piece.getValue() == 10) {
				myPieces.remove(i);
				return piece;
			}
		}
		return null;
	}
	/**Returns the player's score according to coins pocketed
	 * 
	 * @return player's score
	 */
	public int getScore() {
		int sum = 0;
		for(GenericGamePiece p : myPieces) {
			sum += p.getValue();
		}
		return sum;
	}
	
	public ArrayList<GenericGamePiece> getPieces(){
		return myPieces;
	}
	/**Returns the last piece sunk by the player. If the player has not sunk any pieces, returns null.
	 * 
	 * @return last piece or null.
	 */
	public GenericGamePiece getLastPiece() {
		if(myPieces.size()==0) {
			return null;
		}
		return myPieces.get(myPieces.size()-1);
	}
	/**Draws the striker of the player.
	 * 
	 * @param p non-null PApplet to draw in
	 */
	public void draw(PApplet p) {
		//striker.setLoc(hitarea.getX()+hitarea.getWidth()/2, hitarea.getY()+hitarea.getHeight()/2, hitarea.getMinX(),hitarea.getMinY(),hitarea.getMaxX(),hitarea.getMaxY());
		striker.draw(p);
	}
	
}
