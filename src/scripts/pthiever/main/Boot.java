package parachute.scripts.pthiever.main;

import java.awt.Graphics;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.Loader;
import org.rev317.min.accessors.Client;

import parachute.scripts.pthiever.strategies.StealEvent;

@ScriptManifest(author = "parachute", category = Category.THIEVING, description = "Steals from the masterfarmer", name = "pThiever", servers = { "Ikov" }, version = 1.0)
public class Boot extends Script implements Paintable {
	private final ArrayList<Strategy> strategies = new ArrayList<Strategy>();
    private Field field;
    private Field field2;
    private Client client;
	
    private void getFocusFields() {
        try {
        	System.out.println("Getting focus fields ..");
            client = Loader.getClient();
            field = client.getClass().getSuperclass().getDeclaredField("x");
            field.setAccessible(true);
            field2 = client.getClass().getSuperclass().getDeclaredField("w");
            field2.setAccessible(true);
            
            System.out.println("Found fields: " + field + ", " + field2);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    private void setFocusField(){
        try {
            field.set(client, true);
            field2.set(client, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

	@Override
	public boolean onExecute() {
        this.getFocusFields();
		strategies.add(new StealEvent());
		provide(strategies);
		return true;
	}

	@Override
	public void paint(Graphics g) {
        setFocusField();
	}
}
