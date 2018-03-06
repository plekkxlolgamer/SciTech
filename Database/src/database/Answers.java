/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author DCC3
 */
public class Answers {
	private String answer;
	private boolean correct;
	public Answers(String answe, boolean correct) {
		this.answer = answer;
		this.correct = correct;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answers) {
		this.answer = answers;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public String toString(char letter) {
		return letter+": "+answer;
	}
	
}

