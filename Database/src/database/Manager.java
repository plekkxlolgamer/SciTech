/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Manager {
	private static StorageManager SM;
	private question[] questions= new question[500];
	private int numQuestions;
	public int points;
	private question currentQuestion;
        private Random r = new Random();
        public int point = 0;
        public int ap;
	
	public static int getRandom(int iMin, int iMax) {
		int iRand=0;
		iRand =(int)Math.round(Math.random()*(iMax-iMin))+iMax;
		return iRand;
	}
	public Manager(String fileName) throws ClassNotFoundException, SQLException {
		SM = new StorageManager(fileName);
		points=10;
		populateQuestions();
	}
	public static StorageManager getSM() {
		return SM;
	}
	
	public void addQuestion (String Questions, int questionID) throws SQLException {
		questions[numQuestions]= new question(Questions, questionID);
		numQuestions++;
        }
	
	public int getPoint() {
		return point;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public void populateQuestions() throws SQLException {
		numQuestions=10;
		String SQL="SELECT questionID, Question FROM Questions WHERE points="+points;
		ResultSet result= SM.query(SQL);
		while(result.next()) {
			int questionID=result.getInt("questionID");
			String Questions=result.getString("Question");
			addQuestion(Questions, questionID);
		}
	}
	public void increaseLevel() throws SQLException {
		points++;
		populateQuestions();
	}
        
	public String getQuestion(){
		currentQuestion=questions[getRandom(0, numQuestions-1)];
            return currentQuestion.toString();
	}
	public boolean answer(char answer) throws SQLException {
		if (currentQuestion.isCorrect(answer)) {
                      point = point+=10;
                        populateQuestions();
			System.out.println(ap);
                        return true;
			
		}else {
                    
			return false;
		}
	}
}
