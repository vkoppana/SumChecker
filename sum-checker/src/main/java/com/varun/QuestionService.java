package com.varun;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {

	String question;
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	
	public String setNewQuestion() {
		
		numbers.clear();
		
		Random rn1 = new Random();
		Random rn2 = new Random();
		String tempQuestion = "Here you go, solve the question: “Please sum the numbers ";
		int limit = rn1.nextInt(2)+1;
		
		for(int i=0;i<=limit;i++)
		{
			Integer ranNum = rn2.nextInt(9) +1;
			numbers.add(ranNum);
			tempQuestion = tempQuestion.concat(ranNum.toString()+",");			
		}
		
		question = tempQuestion.substring(0, tempQuestion.length()-1);
		question = question.concat("\".");
		
		return question;
		
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public ArrayList<Integer> getNumList(){
		return this.numbers;
	}
}
