package ohtu;

public class TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            playerOneScore += 1;
        } else {
            playerTwoScore += 1;
        }
    }

    private boolean atLeastAnotherScoreIsAtLeastFour() {
        return (playerOneScore >= 4 || playerTwoScore >= 4) ? true : false;
    }
    
    private boolean bothHaveSameScore() {
        return (playerOneScore == playerTwoScore) ? true : false;
    }
   
    private boolean differenceBetweenScoresIsAtLeastTwo() {
        return (Math.abs(playerOneScore - playerTwoScore) > 1) ? true : false;
    }

    private boolean differenceBetweenScoresIsExactlyOne() {
        return (Math.abs(playerOneScore - playerTwoScore) == 1) ? true : false;
    }

    private boolean hasAdvantage() {
        return (atLeastAnotherScoreIsAtLeastFour() && differenceBetweenScoresIsExactlyOne()) ? true : false;
    }
    
    private boolean hasWinner() {
        return (atLeastAnotherScoreIsAtLeastFour() && differenceBetweenScoresIsAtLeastTwo()) ? true : false;
    }
   
    private String translateScore(int score) {
        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
	return scores[score];
    }

    public String getScore() {
        
        if (bothHaveSameScore())
            return (playerOneScore < 4) ? translateScore(playerOneScore) + "-All" : "Deuce";
        
        if (hasWinner())
            return (playerOneScore > playerTwoScore) ? "Win for player1" : "Win for player2";
        
        if (hasAdvantage())
            return (playerOneScore > playerTwoScore) ? "Advantage player1" : "Advantage player2";
        
        return translateScore(playerOneScore) + "-" + translateScore(playerTwoScore);
    }
}
