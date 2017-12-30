package pwr.edu.tp.chinesecheckers;

public class BoardAssembler {
	public Board getBoard(BoardBodyBuilder builder) {
		Board board = new Board();
		builder.generate();
		board.setBoardBody(builder.getBoardBody());
		return board;
	}
}