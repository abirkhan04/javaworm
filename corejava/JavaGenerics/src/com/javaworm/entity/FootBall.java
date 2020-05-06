package com.javaworm.entity;

import java.time.LocalDate;
import com.javaworm.generics.Game;

public class FootBall implements Game<FootBall, String> {

	private LocalDate time;
	private String venue;

	public FootBall(LocalDate time, String venue) {
		this.time = time;
		this.venue = venue;
	}

	@Override
	public void makeGame(FootBall footBall) {
		System.out.println("The game is at " + footBall.getTime() + " and the venue is " + footBall.getVenue());
	}

	@Override
	public void playGames(FootBall parameter1, String parameter2) {
		// TODO Auto-generated method stub
		System.out.println("Yet to be implemented ...");
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

}
