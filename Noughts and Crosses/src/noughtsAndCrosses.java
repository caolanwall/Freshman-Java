import java.util.Scanner;

public class noughtsAndCrosses {

	public static final char NOUGHT = 'O';
	public static final char CROSS = 'X';
	static int A1 = 0;
	static int A2 = 0;
	static int A3 = 0;
	static int B1 = 0;
	static int B2 = 0;
	static int B3 = 0;
	static int C1 = 0;
	static int C2 = 0;
	static int C3 = 0;
	static int count = 2;

	public static void main(String[] args) {
		char[][] board = new char[6][6];
		int[][] position = new int[3][3];
		boolean playing = true;
		int currentPiece = 0;
		printBoard(board, currentPiece);
		while (playing == true) {
			if (count % 2 == 0) {
				currentPiece = 1;
			} else {
				currentPiece = 2;
			}
			System.out.println("Please enter a coorindate (eg. A1)");
			Scanner inputScanner = new Scanner(System.in);
			if (inputScanner.hasNext("A1")) {
				if (canMakeMove(A1, currentPiece) == true) {
					makeMove(A1);
					A1 = currentPiece;
				}
			} else if (inputScanner.hasNext("A2")) {
				if (canMakeMove(A2, currentPiece) == true) {
					makeMove(A2);
					A2 = currentPiece;
				}
			} else if (inputScanner.hasNext("A3")) {
				if (canMakeMove(A3, currentPiece) == true) {
					makeMove(A3);
					A3 = currentPiece;
				}
			} else if (inputScanner.hasNext("B1")) {
				if (canMakeMove(B1, currentPiece) == true) {
					makeMove(B1);
					B1 = currentPiece;
				}
			} else if (inputScanner.hasNext("B2")) {
				if (canMakeMove(B2, currentPiece) == true) {
					makeMove(B2);
					B2 = currentPiece;
				}
			} else if (inputScanner.hasNext("B3")) {
				if (canMakeMove(B3, currentPiece) == true) {
					makeMove(B3);
					B3 = currentPiece;
				}
			} else if (inputScanner.hasNext("C1")) {
				if (canMakeMove(C1, currentPiece) == true) {
					makeMove(C1);
					C1 = currentPiece;
				}
			} else if (inputScanner.hasNext("C2")) {
				if (canMakeMove(C2, currentPiece) == true) {
					makeMove(C2);
					C2 = currentPiece;
				}
			} else if (inputScanner.hasNext("C3")) {
				if (canMakeMove(C3, currentPiece) == true) {
					makeMove(C3);
					C3 = currentPiece;
				}
			} else {
				System.out.println("Please enter a valid move!");
			}
			isBoardFull(count, board);
			printBoard(board, currentPiece);
			winner(position, playing);
			if (inputScanner.hasNext("r")) {
				playing = true;
				clearBoard(board);
				printBoard(board, currentPiece);
				count = 2;

			}
		}

	}

	public static void clearBoard(char[][] board) {
		A1 = 0;
		A2 = 0;
		A3 = 0;
		B1 = 0;
		B2 = 0;
		B3 = 0;
		C1 = 0;
		C2 = 0;
		C3 = 0;
		System.out.println("Board Cleared");
	}

	public static boolean isBoardFull(int count, char[][] board) {
		if (count == 11) {
			System.out.println("No one has won!");
			clearBoard(board);
			return true;
		} else {
			return false;
		}
	}

	public static boolean canMakeMove(int move, int currentPiece) {
		boolean canMakeMove = false;
		if (move == 0) {
			count++;
			return true;

		} else {
			System.out.println("There is already a character in this position, please choose another!");
			return false;
		}
	}

	public static int makeMove(int move) {
		return move;
	}

	public static boolean winner(int[][] position, boolean playing) {
		if (A1 == 1) {
			position[0][0] = 1;
		} else if (A1 == 2) {
			position[0][0] = 4;
		}
		if (A2 == 1) {
			position[0][1] = 1;
		} else if (A2 == 2) {
			position[0][1] = 4;
		}
		if (A3 == 1) {
			position[0][2] = 1;
		} else if (A3 == 2) {
			position[0][2] = 4;
		}
		if (B1 == 1) {
			position[1][0] = 1;
		} else if (B1 == 2) {
			position[1][0] = 4;
		}
		if (B2 == 1) {
			position[1][1] = 1;
		} else if (B2 == 2) {
			position[1][1] = 4;
		}
		if (B3 == 1) {
			position[1][2] = 1;
		} else if (B3 == 2) {
			position[1][2] = 4;
		}
		if (C1 == 1) {
			position[2][0] = 1;
		} else if (C1 == 2) {
			position[2][0] = 4;
		}
		if (C2 == 1) {
			position[2][1] = 1;
		} else if (C2 == 2) {
			position[2][1] = 4;
		}
		if (C3 == 1) {
			position[2][2] = 1;
		} else if (C3 == 2) {
			position[2][2] = 4;
		}
		for (int column = 0; column <= 2; column++) {
			int total = 0;
			for (int row = 0; row <= 2; row++) {
				total = total + position[row][column];
				if (total == 3) {
					System.out.println("X is the winner!!\nType r to reset");
					playing = false;
				}
				if (total == 12) {
					System.out.println("O is the winner!!\nType r to reset");
					playing = false;
				}
			}

		}
		for (int row = 0; row <= 2; row++) {
			int total = 0;
			for (int column = 0; column <= 2; column++) {
				total = total + position[row][column];
				if (total == 3) {
					System.out.println("X is the winner!!\nType r to reset");
					playing = false;
				}
				if (total == 12) {
					System.out.println("O is the winner!!\nType r to reset");
					playing = false;
				}
			}

		}
		if (position[0][0] + position[1][1] + position[2][2] == 3) {
			System.out.println("X is the winner!!\nType r to reset");
			playing = false;
		}
		if (position[0][0] + position[1][1] + position[2][2] == 12) {
			System.out.println("O is the winner!!\nType r to reset");
			playing = false;
		}
		if (position[2][0] + position[1][1] + position[2][0] == 3) {
			System.out.println("X is the winner!!\nType r to reset");
			playing = false;
		}
		if (position[2][0] + position[1][1] + position[2][0] == 12) {
			System.out.println("O is the winner!!\nType r to reset");
			playing = false;
		}
		return playing;
	}

	public static void printBoard(char[][] board, int currentPiece) {
		for (int row = 0; row <= 5; row++) {
			if (row == 0 || row == 2 || row == 4) {
				for (int column = 0; column <= 5; column++) {
					switch (column) {
					case 0:
						if (row == 0) {
							board[row][column] = ('A');
						}
						if (row == 2) {
							board[row][column] = ('B');
						}
						if (row == 4) {
							board[row][column] = ('C');
						}
						break;
					case 1:
						if (A1 != 0 || B1 != 0 || C1 != 0) {
							if (A1 == 1 && row == 0) {
								board[0][1] = (CROSS);
							} else if (B1 == 1 && row == 2) {
								board[2][1] = (CROSS);
							} else if (C1 == 1 && row == 4) {
								board[4][1] = (CROSS);
							} else if (A1 == 2 && row == 0) {
								board[0][1] = (NOUGHT);
							} else if (B1 == 2 && row == 2) {
								board[2][1] = (NOUGHT);
							} else if (C1 == 2 && row == 4) {
								board[4][1] = (NOUGHT);
							}
						} else {
							board[row][column] = ('9');
						}
						break;
					case 2:
						board[row][column] = ('|');
						break;
					case 3:
						if (A2 != 0 || B2 != 0 || C2 != 0) {
							if (A2 == 1 && row == 0) {
								board[0][3] = (CROSS);
							} else if (B2 == 1 && row == 2) {
								board[2][3] = (CROSS);
							} else if (C2 == 1 && row == 4) {
								board[4][3] = (CROSS);
							} else if (A2 == 2 && row == 0) {
								board[0][3] = (NOUGHT);
							} else if (B2 == 2 && row == 2) {
								board[2][3] = (NOUGHT);
							} else if (C2 == 2 && row == 4) {
								board[4][3] = (NOUGHT);
							}
						} else {
							board[row][column] = ('9');
						}
						break;
					case 4:
						board[row][column] = ('|');
						break;
					case 5:
						if (A3 != 0 || B3 != 0 || C3 != 0) {
							if (A3 == 1 && row == 0) {
								board[0][5] = (CROSS);
							} else if (B3 == 1 && row == 2) {
								board[2][5] = (CROSS);
							} else if (C3 == 1 && row == 4) {
								board[4][5] = (CROSS);
							} else if (A3 == 2 && row == 0) {
								board[0][5] = (NOUGHT);
							} else if (B3 == 2 && row == 2) {
								board[2][5] = (NOUGHT);
							} else if (C3 == 2 && row == 4) {
								board[4][5] = (NOUGHT);
							}
						} else {
							board[row][column] = ('9');
						}
						break;
					default:
						board[row][column] = ('	');
						break;
					}
				}
			}
			if (row == 1 || row == 3) {
				for (int column = 0; column <= 5; column++) {
					switch (column) {
					case 0:
						board[row][column] = (' ');
						break;
					case 2:
						board[row][column] = ('|');
						break;
					case 4:
						board[row][column] = ('|');
						break;
					default:
						board[row][column] = ('-');
						break;
					}
				}
			}
			if (row == 5) {
				for (int column = 0; column <= 5; column++) {
					switch (column) {
					case 1:
						board[row][column] = ('1');
						break;
					case 3:
						board[row][column] = ('2');
						break;
					case 5:
						board[row][column] = ('3');
						break;
					default:
						board[row][column] = (' ');
						break;
					}
				}
			}
		}
		for (int row = 0; row <= 5; row++) {
			for (int column = 0; column <= 5; column++) {
				if (board[row][column] == '-') {
					System.out.print("---");
				} else if (board[row][column] == ' ') {
					System.out.print(" ");
				} else if (board[row][column] == '9') {
					System.out.print("   ");
				} else if (board[row][column] == 'X') {
					System.out.print(" X ");
				} else if (board[row][4] == 'X') {
					System.out.print(" X ");
				} else if (board[row][column] == 'O') {
					System.out.print(" O ");
				} else if (board[row][4] == 'O') {
					System.out.print(" O ");
				} else if (board[row][column] == '1' || board[row][column] == '2' || board[row][column] == '3') {
					System.out.print(" " + board[row][column] + " ");
				} else {
					System.out.print(board[row][column]);

				}
			}
			System.out.print("\n");
		}

	}
}
