package parachute.scripts.pthiever.main;

import java.awt.Graphics;
import java.util.ArrayList;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import parachute.scripts.pthiever.strategies.StealEvent;

@ScriptManifest(author = "parachute", category = Category.THIEVING, description = "Steals from the masterfarmer", name = "pThiever", servers = { "Ikov" }, version = 1.0)
public class Boot extends Script implements Paintable {
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	
	@Override
	public boolean onExecute() {
		strategies.add(new StealEvent());
		provide(strategies);
		return true;
	}

	@Override
	public void paint(Graphics g) {
		//Eventueel in een aparte class om het to ordenen.
	}
}
