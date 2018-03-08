/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class question {
	private String question;
	private int questionID;
	private Answers[] answers= new Answers[4];
	private int numAnswers=0;
	
	public question(String question, int questionID) throws SQLException {
		this.question = question;
		this.questionID = questionID;
		String SQL = "SELECT * FROM Answers WHERE questionfk="+this.questionID;
		ResultSet result = Manager.getSM().query(SQL);
		while(result.next()) {
			String answer=result.getString("answer");
			boolean correct=result.getBoolean("correct");
			answers[numAnswers]=new Answers(answer, correct);
			numAnswers++;
		}
	}

	@Override
	public String toString() {
		
		String display="";
		String letters="ABCD";
		for( int i =0; i < numAnswers; i++) {
			display=answers[i].toString(letters.charAt(i))+"\n";
			
		}
		return question+"\n\n"+display;
	}
	public boolean isCorrect(char letter) {
		String letters="ABCD";
		int pos=letters.indexOf(letter+"");
		return answers[pos].isCorrect();
	}
	
	
}
