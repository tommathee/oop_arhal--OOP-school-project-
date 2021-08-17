package app.controller;

//subject je rozhranie ktore urcuje kam pripojit observers
public interface Subject {

	/**
	 * odstranenie observerov
	 */
	public abstract void delObservers();

	/**
	 * pridanie observeru
	 */
	public abstract void pridajObserver();

	/**
	 * upozornenie na zmenu stavu
	 */
	public abstract void notifyZamestnanci();

}