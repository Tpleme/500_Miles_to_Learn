package org.academiadecodigo.gnunas.fivehundredmilestolearn.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.MainClass;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                // Resizable application, uses available space in browser
                //return new GwtApplicationConfiguration(true);
                // Fixed size application:
                return new GwtApplicationConfiguration(800, 600);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new MainClass();
        }
}