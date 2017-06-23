package model;

public interface ITimer {

	int getTime();

	void timeGo();

	boolean isTimeAway();

	void setGameFinished(boolean gameFinished);
}