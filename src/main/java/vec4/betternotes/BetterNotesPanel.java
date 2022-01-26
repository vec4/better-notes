package vec4.betternotes;

import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.PluginPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BetterNotesPanel extends PluginPanel {

    private final JTextArea notesEditor = new JTextArea();

    public BetterNotesPanel() {

        getParent().setLayout(new BorderLayout());
        getParent().add(this, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel notesContainer = new JPanel();
        notesContainer.setLayout(new BorderLayout());
        notesContainer.setBackground(ColorScheme.DARKER_GRAY_COLOR);

        notesEditor.setOpaque(false);
        notesEditor.setLineWrap(true);
        notesEditor.setWrapStyleWord(true);

        notesContainer.add(notesEditor, BorderLayout.CENTER);
        notesContainer.setBorder(new EmptyBorder(10, 10, 10, 10));

        add(notesContainer, BorderLayout.CENTER);

    }

}
