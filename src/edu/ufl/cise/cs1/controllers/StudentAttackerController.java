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

		Node closestPowerPill = null;

		// if powerPill is available, get location
		for (int i = 0; i < powerPills.size(); i++) {
			Node target = pacMan.getTargetNode(powerPills, true);
			closestPowerPill = target;
			break;
		}

		// if powerPill exists, head toward powerPill
		if (closestPowerPill != null) {
		// this is where the commented code that follows this method
		// would go if I could figure out how to make it work
			action = pacMan.getNextDir(closestPowerPill, true);
			return action;
		}


		// once all power pills are gone collect regular pills
		for (int i = 0; i < game.getPillList().size(); i++) {
			action = pacMan.getNextDir(pacMan.getTargetNode(game.getPillList(), true), true);
			return action;
		}


		return action;

	}

	//			if (currLocation.getPathDistance(closestPowerPill) == 1) {
//
//				int closestDefenderDistance = Integer.MAX_VALUE;
//				// check for defenders
//				for (int j = 0; j < defenders.size(); j++) {
//					int temp = defenders.get(j).getLocation().getPathDistance(currLocation);
//					if (temp < closestDefenderDistance) {
//						closestDefenderDistance = temp;
//					}
//				}
//
//				if (closestDefenderDistance > 5) {
//					action = pacMan.getReverse();
//					return action;
//				}
//				// if no defenders are near, getReverse
//				// if defenders are near, break
//			}
}