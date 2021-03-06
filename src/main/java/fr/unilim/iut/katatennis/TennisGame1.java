package fr.unilim.iut.katatennis;

public class TennisGame1 implements TennisGame {

	private int scorePlayer1 = 0;
	private int scorePlayer2 = 0;
	private String player1Name;
	private String player2Name;
	private static String[] possibleScores = { "Love","Fifteen","Thirty","Forty"};

	public TennisGame1(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (playerName == this.player1Name)
			scorePlayer1++;
		else
			scorePlayer2++;
	}

	public String getScore() {
		String score = "";
		if (scorePlayer1 == scorePlayer2) {
			score = getScoreEquality();
		} else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
			score = getScoreEndGame();
		} else {
			score = getScoreStandard();
		}
		return score;
	}

	private String getScoreStandard() {
		String score;
		score = possibleScores[scorePlayer1] + "-" + possibleScores[scorePlayer2];
		return score;
	}

	private String getScoreEndGame() {
		String score;
		int minusResult = scorePlayer1 - scorePlayer2;
		if (minusResult == 1)
			score = "Advantage" + player1Name;
		else if (minusResult == -1)
			score = "Advantage" + player2Name;
		else if (minusResult >= 2)
			score = "Win for" + player1Name;
		else
			score = "Win for" + player2Name;
		return score;
	}

	private String getScoreEquality() {
		String score;
		if(scorePlayer1<=2) {
		score = possibleScores[scorePlayer1]+"-All";
		}
		else {
			score = "Deuce";
		}
		/*switch (scorePlayer1) {
		case 0:
			score = "Love-All";
			break;
		case 1:
			score = "Fifteen-All";
			break;
		case 2:
			score = "Thirty-All";
			break;
		default:
			score = "Deuce";
			break;

		}*/
		return score;
	}
}