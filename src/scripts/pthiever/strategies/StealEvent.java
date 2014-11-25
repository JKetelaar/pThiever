package parachute.scripts.pthiever.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.wrappers.Npc;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;

public class StealEvent implements Strategy {
	int farmerid = 2234;

	@Override
	public boolean activate() {
		Npc[] masterfarmer = Npcs.getNearest(farmerid);
			if (Players.getMyPlayer().getHealth() > 4 && masterfarmer[0] != null) {
				System.out.println("1");
				return true;
			
		}
		return false;
	}

	@Override
	public void execute() {
		System.out.println("3");
		Npc[] masterfarmer = Npcs.getNearest(farmerid);
		if(masterfarmer[0] != null){
			if (masterfarmer[0].getLocation().isReachable()) {
				System.out.println("2");
				masterfarmer[0].interact(225);
				Time.sleep(300);
			}
		}

			while (Players.getMyPlayer().getAnimation() != -1) {
				Time.sleep(100);
			}
		}
	

}
