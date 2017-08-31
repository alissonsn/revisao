package br.jus.tjrn.esb.scheduled.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.jus.tjrn.esb.scheduled.gui.Systray;

import java.io.IOException;

/**
 * Launches the application GUI.
 *
 * @author Paul Campbell
 */
@Component
public class Runner implements CommandLineRunner {
    private final Systray frame;

    @Autowired
    public Runner(Systray frame) {
        this.frame = frame;
    }


    @Override
    public void run(String... args) throws Exception {
        java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
	                frame.init();
	              } catch (IOException e) {
	                e.printStackTrace();
	              }
			}
		});
    }

}
