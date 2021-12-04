package edu.ufl.cise.cs1.controllers;
import game.controllers.AttackerController;
import game.models.*;

import java.util.List;

public final class StudentAttackerController implements AttackerController
{
	public void init(Game game) { }

	public void shutdown(Game game) { }

	public int update(Game game,long timeDue)
	{

		/*

		// HIS WORK
		// keep variable, but take out the 10
		int action = 10;
		// ^^ default action



		// if a defender is vulnerable, go after it
		for (Defender d: game.getDefenders()) {
			if(d.isVulnerable()) {
				Node defenderLocation = d.getLocation();
				action = game.getAttacker().getNextDir(defenderLocation, true);
			}
		}


		// to stay in one spot!!!
		// go for location of every power pill, if there is a power pill enter the loop
		for(Node n: game.getPowerPillList()) {
			action = game.getAttacker().getNextDir(n,true);
			return action;
		}
		// collect all pills going from the upper right hand corner out
		for(Node n: game.getPillList()) {
			action = game.getAttacker().getNextDir(n,true);
			return action;
		}

		// after eating all the power pills, remain still
		if (action == 10) {
			action = game.getAttacker().getReverse();
		}


		 */




		// MINE
		// MY WORK

		Attacker pacMan = game.getAttacker();// gets the user's gator attacker object
		int action = 10; // default action
		List<Defender> defenders = game.getDefenders();
		List<Node> powerPills = game.getPowerPillList();


		// find the closest defender and if vulnerable attack it

		for (int i = 1; i < defenders.size(); i++) {
			Defender closestDefender = defenders.get(0);
			Node defenderLocation = closestDefender.getLocation();

			if (defenders.get(i).getLocation().getPathDistance(defenderLocation) < defenders.get(i-1).getLocation().getPathDistance(defenderLocation)) {
				closestDefender = defenders.get(i);
				defenderLocation = closestDefender.getLocation();
			}

			if (closestDefender.isVulnerable() && defenderLocation.getPathDistance(defenderLocation) < 10) {
				action = pacMan.getNextDir(defenderLocation, true);
				return action;
			}
		}

		for (int i = 0; i < powerPills.size(); i++) {
			Node target = pacMan.getTargetNode(powerPills, true);
			// if the distance to powerPill is 1, check if the defender is outside
			// a certain range, then stay in same spot until defender is within range

			action = pacMan.getNextDir(target, true);
			return action;
		}

		for (int i = 0; i < game.getPillList().size(); i++) {
			action = pacMan.getNextDir(pacMan.getTargetNode(game.getPillList(), true), true);
			return action;
		}


		// attacker stays in one spot
		// action = pacMan.getReverse();


		return action;




// example
//Examples
//		//An example (which should NOT be in your final submission) of some syntax that randomly chooses a direction for the attacker to move
//		List<Integer> possibleDirs = game.getAttacker().getPossibleDirs(true);  // EXAMPLE OF GETTING DATA
//		if (possibleDirs.size() != 0)
//			action = possibleDirs.get(Game.rng.nextInt(possibleDirs.size()));
//		else
//			action = -1;
//
//		//An example (which should NOT be in your final submission) of some syntax to use the visual debugging method, addPathTo, to the top left power pill.
//		List<Node> powerPills = game.getPowerPillList();
//		if (powerPills.size() != 0) {
//			game.getAttacker().addPathTo(game, Color.BLUE, powerPills.get(0));
//		}
//		// Default Code
//		// ends





		// my other work that doesn't work
//		action = Game.Direction.DOWN; // if you return actor, it returns 2
//		Attacker pacMan = game.getAttacker();// gets the user's gator attacker object
//		List<Integer> possibleDirs = game.getAttacker().getPossibleDirs(true); // gets possible directions
//		List<Defender> defenders = game.getDefenders();
//		Game thisGame = game;
//		// get location of attacker
//		pacMan.getLocation();
//
//		Maze maze = game.getCurMaze();
//		List<Node> pills = maze.getPillNodes();
//		List<Node> powerPills = maze.getPowerPillNodes();
//		int test = maze.getNumberPowerPills();
//
//		// takes pacMan to upper right hand corner power pill
//		if (thisGame.checkPowerPill(powerPills.get(0))) {
//			pacMan.getPathTo(powerPills.get(0));
//			action = pacMan.getNextDir(powerPills.get(0), true);
//			return action;
//		}
//
//		else if (thisGame.checkPowerPill(powerPills.get(1))) {
//			pacMan.getPathTo(powerPills.get(1));
//			action = pacMan.getNextDir(powerPills.get(1),true );
//			return action;
//		}
//
//		return action;




		// other work
		// my work

//		if (defenders.get(0).isVulnerable()) {
//			action = pacMan.getNextDir(defenders.get(0).getPossibleLocations().get(0), true);
//			return action;
//		}
//
//		return action;

//		if (possibleDirs.size() == 2) {
//			// check if there are any ghosts in either direction
//			action = pacMan.getReverse();
//			// check which direction has more pills
//			return action;
//		}


		// go forward

		// if ahead is a wall
			// decide which way to turn
			// turn
		//else if to the side is open
			// decide whether to turn

		// get data
			// use node, game or maze interfaces
		// analyze data
			// use if/else statements or for loops
		// make decision
			// maybe use if/else to perform different strategies



	}
}