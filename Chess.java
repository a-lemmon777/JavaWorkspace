import java.lang.Math;

/**
The class represents a chess board. 
The square a8 corresponds to a position [0][0] in the
two-dimensional array.

Notations for chess pieces (lower-case letters for white, 
upper-case letters for black):
K,k - king, Q,q - queen, R,r - rook, B,b - bishop, 
N,n - knight, P,p - pawn 
**/
public class Chess {
    public static void main(String[] args) {
	char[][] chessBoard = new char[8][8];
	initialize(chessBoard);

	printChessBoard(chessBoard);
	
	addPiece('P', 'a', '7', chessBoard);
	addPiece('r', 'h', '1', chessBoard);
	addPiece('r', 'a', '1', chessBoard);
	addPiece('R', 'a', '8', chessBoard);
	addPiece('R', 'h', '8', chessBoard);
	printChessBoard(chessBoard);

	// BishopPossibleMove by: Hunter Peterson && Aaron Lemmon
	
	
	addPiece('p', 'c', '2', chessBoard); // needed to check for intervening pieces
	
	// testing for checkIfOffBoard
	System.out.println(true == checkIfOffBoard(-8, 5, 4, 4, chessBoard));
	System.out.println(true == checkIfOffBoard(13, 5, 4, 4, chessBoard));
	System.out.println(true == checkIfOffBoard(5, -8, 4, 4, chessBoard));
	System.out.println(true == checkIfOffBoard(5, 13, 4, 4, chessBoard));
	System.out.println(true == checkIfOffBoard(5, 5, -8, 4, chessBoard));
	System.out.println(true == checkIfOffBoard(5, 5, 13, 4, chessBoard));
	System.out.println(true == checkIfOffBoard(5, 5, 4, -8, chessBoard));
	System.out.println(true == checkIfOffBoard(5, 5, 4, 13, chessBoard));
	System.out.println(false == checkIfOffBoard(5, 5, 4, 4, chessBoard));
	System.out.println();
	
	// testing for isDestinationOffDiagonal
	System.out.println(true == isDestinationOffDiagonal(7, 4, 4, 4, chessBoard));
	System.out.println(true == isDestinationOffDiagonal(1, 0, 4, 4, chessBoard));
	System.out.println(false == isDestinationOffDiagonal(5, 5, 4, 4, chessBoard));
	System.out.println(false == isDestinationOffDiagonal(6, 2, 4, 4, chessBoard));
	System.out.println();
	
	// testing for isDestinationOccupiedByOwnPiece
	System.out.println(true == isDestinationOccupiedByOwnPiece(7, 7, true, chessBoard));
	System.out.println(true == isDestinationOccupiedByOwnPiece(0, 0, false, chessBoard));
	System.out.println(false == isDestinationOccupiedByOwnPiece(0, 0, true, chessBoard));
	System.out.println(false == isDestinationOccupiedByOwnPiece(7, 7, false, chessBoard));
	System.out.println();
	
	// testing for checkIfAnyInterveningPieces
	System.out.println(true == checkIfAnyInterveningPieces(1, 7, 4, 4, chessBoard));
	System.out.println(false == checkIfAnyInterveningPieces(5, 5, 4, 4, chessBoard));
	System.out.println(false == checkIfAnyInterveningPieces(2, 6, 4, 4, chessBoard));
	System.out.println();
	
	// testing for bishopPossibleMove
	System.out.println(false == bishopPossibleMove('q', '5', 'd', '4', true, chessBoard));
	System.out.println(false == bishopPossibleMove('f', '5', 'd', '4', true, chessBoard));
	System.out.println(false == bishopPossibleMove('h', '1', 'd', '4', true, chessBoard));
	System.out.println(false == bishopPossibleMove('b', '1', 'd', '4', true, chessBoard));
	System.out.println(true == bishopPossibleMove('e', '5', 'd', '4', true, chessBoard));
	
	// Hunter Peterson && Aaron Lemmon
	// testing for pawnPossibleMove with a black pawn at d4
	
	initialize(chessBoard);
	addPiece('B', 'd', '5', chessBoard);
	addPiece('b', 'd', '3', chessBoard);
	addPiece('R', 'c', '3', chessBoard);
	addPiece('r', 'e', '3', chessBoard);
	
	for (char col = 'a'; col <= 'h'; col++) {
		for (char row = '1'; row <= '8'; row++) {
			if (pawnPossibleMove(col, row, 'd', '4', false, chessBoard)) {
			System.out.println("Can move to " + col + row);
		} else {
			System.out.println("Cannot move to " + col + row);
		}
	}
	
}
    }

    /**
       print a chess board
    **/
    public static void printChessBoard(char[][] chessBoard) {
    	    for(int row = 0; row < 8; row++) {
    	    	    for(int col = 0; col < 8; col++) {
    	    	    	    System.out.print(chessBoard[row][col]);
    	    	    }
    	    	    System.out.println();
    	    }
    	    System.out.println();
    }
       
    /**
       This method sets a chessBoard to an empty one
       (characters that do not denote a chess piece)
       White squares are indicated by spaces and
        black squares by +s
    **/
    public static void initialize(char[][] chessBoard) {
    	    for (int row = 0; row < 8; row++) {
    	    	    for (int col = 0; col < 8; col++) {
    	    	    	    chessBoard[row][col] = ((col + row) % 2 == 0) ? ' ' : '+';     
    	    	    }
    	    }
    }



    /**
       This method adds a chess piece to a chessBoard at 
       a given row and column.
    **/
    public static void addPiece(char piece, char column, char row, char[][] chessBoard) {
    	    int rowIndex = '8' - row;
    	    int colIndex = column - 'a';
    	    
    	    chessBoard[rowIndex][colIndex] = piece;
    }
    
    /*
    	Code for checking possible moves for a bishop, using 4 helper functions
    */
    public static boolean bishopPossibleMove(char destCol, char destRow, char currentCol, char currentRow, boolean isWhite, char[][] chessBoard) {
    	    int destColIndex = destCol - 'a';
    	    int destRowIndex = '8' - destRow;
    	    int currentColIndex = currentCol - 'a';
    	    int currentRowIndex = '8' - currentRow;
    	    //System.out.println(destColIndex + "," + destRowIndex + "," + currentColIndex + "," + currentRowIndex);
    	    if (checkIfOffBoard(destColIndex, destRowIndex, currentColIndex, currentRowIndex, chessBoard)) {
    	    	    return false;
    	    }
    	    if (isDestinationOffDiagonal(destColIndex, destRowIndex, currentColIndex, currentRowIndex, chessBoard)) {
    	    	    return false;	    
    	    }
    	    if (isDestinationOccupiedByOwnPiece(destColIndex, destRowIndex, isWhite, chessBoard)) {
    	    	    return false;		    
    	    }
    	    if (checkIfAnyInterveningPieces(destColIndex, destRowIndex, currentColIndex, currentRowIndex, chessBoard)) {
    	    	    return false;   
    	    }
    	    return true;
    }
    
    /*
    	Checks if either the current location or the destination is off the board
    */
    public static boolean checkIfOffBoard(int destColIndex, int destRowIndex, int currentColIndex, int currentRowIndex, char[][] chessBoard) {
    	    boolean destColNotValid = destColIndex < 0 || 7 < destColIndex;
    	    boolean destRowValid = destRowIndex < 0 || 7 < destRowIndex;
    	    boolean currentColValid = currentColIndex < 0 || 7 < currentColIndex;
    	    boolean currentRowValid = currentRowIndex < 0 || 7 < currentRowIndex;
    	    return (destColNotValid || destRowValid || currentColValid || currentRowValid);
    }
    
    /*
    	Checks if the destination is not diagonal of the current location of the bishop
    */
    public static boolean isDestinationOffDiagonal(int destColIndex, int destRowIndex, int currentColIndex, int currentRowIndex, char[][] chessBoard) {
    	    int absColDifference = Math.abs(destColIndex - currentColIndex);
    	    int absRowDifference = Math.abs(destRowIndex - currentRowIndex);
    	    return absColDifference != absRowDifference;
    }
    
    /*
    	Checks if the destination is already occupied by a piece of the same color
    */
    public static boolean isDestinationOccupiedByOwnPiece(int destColIndex, int destRowIndex, boolean isWhite, char[][] chessBoard) {
    	    char destPiece = chessBoard[destRowIndex][destColIndex];
    	    boolean isDestinationWhite = ('a' <= destPiece && destPiece <= 'z');
    	    return isWhite == isDestinationWhite;
    }
    
    /*
    	Checks if there are any intervening pieces between the bishop and its destination
    */
    public static boolean checkIfAnyInterveningPieces(int destColIndex, int destRowIndex, int currentColIndex, int currentRowIndex, char[][] chessBoard) {
    	    
    	    int colOffset = (destColIndex < currentColIndex ? -1 : 1);
    	    int rowOffset = (destRowIndex < currentRowIndex ? -1 : 1);
    	    int colChecking = currentColIndex + colOffset;
    	    int rowChecking = currentRowIndex + rowOffset;
    	    
    	    while (colChecking != destColIndex) {
    	    	 char squareChecking = chessBoard[rowChecking][colChecking];
    	    	 if (squareChecking != '+' && squareChecking != ' ') {
    	    	 	return true;		 
    	    	 }  
    	    	 colChecking += colOffset;
    	    	 rowChecking += rowOffset;
    	    }
    	    return false;
    }
    
    
    //Ryan's stuff
    
    	public static boolean pawnPossibleMove(char destCol, char destRow, char currentCol, char currentRow, boolean isWhite, char[][] chessBoard) {
		int destColIndex = destCol - 'a';
		int destRowIndex = '8' - destRow;
		int currentColIndex = currentCol - 'a';
		int currentRowIndex = '8' - currentRow;
		if (isWhite == true) {
			if (destColIndex - currentColIndex == 0 && destRowIndex - currentRowIndex == -1 && pawnDestEmpty(chessBoard, destColIndex, destRowIndex) == true){
				return true;
			} else if (Math.abs(currentColIndex - destColIndex) == 1 && destRowIndex - currentRowIndex == -1 && pawnCanCapture(chessBoard, destColIndex, destRowIndex, isWhite) == true) {
				return true;
			} else {
				return false;
			}
		} else {
			if (destColIndex - currentColIndex == 0 && destRowIndex - currentRowIndex == 1 && pawnDestEmpty(chessBoard, destColIndex, destRowIndex) == true){
				return true;
			} else if (Math.abs(currentColIndex - destColIndex) == 1 && destRowIndex - currentRowIndex == 1 && pawnCanCapture(chessBoard, destColIndex, destRowIndex, isWhite) == true) {
				return true;
			} else {
				return false;
			}
		}
	}
	public static boolean pawnDestEmpty(char[][] chessBoard, int destColIndex, int destRowIndex){
		if (chessBoard[destRowIndex][destColIndex] > 65 && chessBoard[destRowIndex][destColIndex] <90 || chessBoard[destRowIndex][destColIndex] > 97 && chessBoard[destRowIndex][destColIndex] <122){
			return false;
		} else {
			return true;
		}
	}
	public static boolean pawnCanCapture(char[][] chessBoard, int destColIndex, int destRowIndex, boolean isWhite) {
		if (isWhite == true) {
			if (chessBoard[destRowIndex][destColIndex] > 65 && chessBoard[destRowIndex][destColIndex] <90){
				return true;
			} else {
				return false;
			}
		} else {
			if (chessBoard[destRowIndex][destColIndex] > 97 && chessBoard[destRowIndex][destColIndex] <122){
				return true;
			} else {
				return false;
			}
		}
	}

}