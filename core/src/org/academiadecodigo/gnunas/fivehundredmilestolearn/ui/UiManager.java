package org.academiadecodigo.gnunas.fivehundredmilestolearn.ui;

import org.academiadecodigo.gnunas.fivehundredmilestolearn.player.Player;

public class UiManager {

    private Player player;
    private UserInterface userInterface;

    public UiManager(Player player, UserInterface userInterface) {
        this.player = player;
        this.userInterface = userInterface;
    }
}
