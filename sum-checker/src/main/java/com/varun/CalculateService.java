package com.varun;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class CalculateService {

	public String calculateSum(String msg, QuestionService qService) {
		
		ArrayList<Integer> numList = new ArrayList<Integer>();
		ArrayList<Integer> qList = qService.numbers;
		int sentAns,orgAns, j = 0;
		
		String[] tempArr = msg.replaceAll("[^0-9]", " ").replaceAll("\\s+", " ").split(" ");
		
		for(String str : tempArr)
		{
			if(!str.equals(""))
			{
				numList.add(Integer.parseInt(str));
			}
		}
		
		for(Integer i : qList)
		{
			
			if(i != numList.get(j))
				return "Response Numbers Changed";
			j++;
		}
		
		sentAns = numList.get(j);
		orgAns = 0;
		for(Integer i : qList)
		{
			orgAns += i;
		}
		
		if(orgAns == sentAns)
			return "VerifiedSum";
		else
			return "WrongSum";
    }
}
