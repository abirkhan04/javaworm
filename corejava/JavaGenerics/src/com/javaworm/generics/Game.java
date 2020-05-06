package com.javaworm.generics;

public interface Game<T,S> {
	public void makeGame(T parameter);
	public void playGames(T parameter1, S parameter2);
}
