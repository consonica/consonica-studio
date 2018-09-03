/*
 * Created on March 6, 2007
 * 
 * Copyright (c) 2007 Jens Gulden
 * 
 * http://www.frinika.com
 * 
 * This file is part of Frinika.
 * 
 * Frinika is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.

 * Frinika is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with Frinika; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.frinika.sequencer.midi.groovepattern.gui;

import com.frinika.base.MessageDialogUtils;
import com.frinika.gui.AbstractDialog;
import com.frinika.sequencer.gui.ProjectFrame;
import com.frinika.sequencer.gui.selection.PartSelection;
import com.frinika.sequencer.midi.groovepattern.GroovePattern;
import com.frinika.sequencer.midi.groovepattern.GroovePatternFromSequence;
import com.frinika.sequencer.midi.groovepattern.GroovePatternManager;
import com.frinika.sequencer.model.MidiPart;
import com.frinika.sequencer.model.Part;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Groove patter manager dialog.
 *
 * (Created with NetBeans 5.5 gui-editor, see corresponding .form file.)
 *
 * @author Jens Gulden
 */
public class GroovePatternManagerDialog extends AbstractDialog {

    private static final Map<ProjectFrame, GroovePatternManagerDialog> instances = new HashMap<>();

    private ProjectFrame projectFrame;

    public static GroovePatternManagerDialog getDialog(ProjectFrame projectFrame) {
        GroovePatternManagerDialog dialog = instances.get(projectFrame);
        if (dialog == null) {
            dialog = new GroovePatternManagerDialog(projectFrame, GroovePatternManager.getInstance());
            instances.put(projectFrame, dialog);
        }
        return dialog;
    }

    public static void showDialog(ProjectFrame projectFrame) {
        getDialog(projectFrame).show();
    }

    private GroovePatternManager manager;

    public GroovePatternManagerDialog(ProjectFrame projectFrame, GroovePatternManager manager) {
        super(projectFrame.getFrame(), "Groove Patterns", true);
        this.projectFrame = projectFrame;
        this.manager = manager;
        initComponents();
        refresh();
        setSize(600, 400);
        AbstractDialog.centerOnScreen(this);
        Point p = getLocation();
        setLocation(p.x + 100, p.y + 100); // so this doesn't appear right above quantize-dialog if opened from there
    }

    @Override
    public void show() {
        refresh();
        super.show();
    }

    private void refresh() {
        refreshItemsList();
    }

    private void refreshItemsList() {
        int index = itemsList.getSelectedIndex();
        Collection<GroovePatternFromSequence> patterns = manager.getUserGroovePatterns();
        //Vector<String> names = new Vector<String>();
        Vector<GroovePattern> items = new Vector<>();
        for (GroovePattern gp : patterns) {
            //names.add(gp.getName());
            items.add(gp);
        }
        itemsList.setListData(items);
        if (index >= 0) {
            itemsList.setSelectedIndex(index);
            itemsList.ensureIndexIsVisible(index);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        itemsScrollPane = new javax.swing.JScrollPane();
        itemsList = new javax.swing.JList();
        newButton = new javax.swing.JButton();
        importButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setTitle("Groove Patterns");
        mainPanel.setLayout(new java.awt.GridBagLayout());

        itemsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemsScrollPane.setViewportView(itemsList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        mainPanel.add(itemsScrollPane, gridBagConstraints);

        newButton.setMnemonic('N');
        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        mainPanel.add(newButton, gridBagConstraints);

        importButton.setMnemonic('I');
        importButton.setText("Import...");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        mainPanel.add(importButton, gridBagConstraints);

        exportButton.setMnemonic('x');
        exportButton.setText("Export...");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        mainPanel.add(exportButton, gridBagConstraints);

        removeButton.setMnemonic('R');
        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        mainPanel.add(removeButton, gridBagConstraints);

        editButton.setMnemonic('E');
        editButton.setText("Edit...");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        mainPanel.add(editButton, gridBagConstraints);

        closeButton.setMnemonic('C');
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        mainPanel.add(closeButton, gridBagConstraints);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed

        GroovePatternFromSequence sel = (GroovePatternFromSequence) itemsList.getSelectedValue();
        if (sel != null) {
            String filename = MessageDialogUtils.promptFile(projectFrame.getFrame(), null, ProjectFrame.FILE_FILTER_MIDIFILES, true);
            if (filename != null) {
                File file = new File(filename);
                try {
                    sel.saveAsMidiFile(file);
                } catch (IOException e) {
                    MessageDialogUtils.error(projectFrame.getFrame(), e);
                }
            }
        }
    }//GEN-LAST:event_exportButtonActionPerformed

    /**
     *
     * @param project
     * @see com.frinika.sequencer.gui.menu.midi.GroovePatternCreateFromMidiPart
     */
    public static void interactionImportGroovePatternFromMidiPartSelection(ProjectFrame projectFramePar) {
        interactionImportGroovePatternFromMidiPartSelection(projectFramePar, null);
    }

    private static void interactionImportGroovePatternFromMidiPartSelection(ProjectFrame projectFrame, GroovePatternManagerDialog dialog) {
        PartSelection sel = projectFrame.getProjectContainer().getPartSelection();
        if (sel != null) {
            Collection<Part> c = sel.getSelected();
            if (!c.isEmpty()) {
                Part p = c.iterator().next(); // first
                if (p instanceof MidiPart) {
                    String name = MessageDialogUtils.prompt(projectFrame.getFrame(), "Import selected Midi part as groove pattern.\nPlease enter a name for the new groove pattern:");
                    if (name != null) {
                        try {
                            GroovePattern gp = GroovePatternManager.getInstance().importUserGroovePattern(name, (MidiPart) p);
                            if (dialog != null) {
                                dialog.refreshItemsList();
                                dialog.itemsList.setSelectedValue(gp.getName(), true);
                            }
                        } catch (IOException e) {
                            MessageDialogUtils.error(projectFrame.getFrame(), e);
                        }
                    }
                    return; // successful exit (or user-canceled)
                }
            }
        }
        MessageDialogUtils.message(projectFrame.getFrame(), "Please select a Midi part to import as groove pattern.");
    }

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        interactionImportGroovePatternFromMidiPartSelection(projectFrame, this);
    }//GEN-LAST:event_newButtonActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        String filename = MessageDialogUtils.promptFile(projectFrame.getFrame(), null, ProjectFrame.FILE_FILTER_MIDIFILES);
        if (filename != null) {
            File file = new File(filename);
            try {
                GroovePattern gp = GroovePatternManager.getInstance().importUserGroovePattern(file);
                refreshItemsList();
                itemsList.setSelectedValue(gp, true);
            } catch (IOException e) {
                MessageDialogUtils.error(projectFrame.getFrame(), e);
            }
        }
    }//GEN-LAST:event_importButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        GroovePatternFromSequence sel = (GroovePatternFromSequence) itemsList.getSelectedValue();
        if (sel != null) {
            if (MessageDialogUtils.confirm(projectFrame.getFrame(), "Really DELETE groove pattern '" + sel.getName() + "'?")) {
                try {
                    GroovePatternManager.getInstance().removeUserGroovePattern(sel);
                } catch (IOException ioe) {
                    MessageDialogUtils.error(projectFrame.getFrame(), ioe);
                }
                refreshItemsList();
                itemsList.setSelectedIndex(-1);
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        GroovePatternFromSequence sel = (GroovePatternFromSequence) itemsList.getSelectedValue();
        try {
            sel.openAsOwnProject(projectFrame);
            //this.toFront(); // we are modal, so user must first close this dialog to go on in newly opened project
            this.hide();
        } catch (Exception e) {
            MessageDialogUtils.error(projectFrame.getFrame(), e);
        }

    }//GEN-LAST:event_editButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        hide();
    }//GEN-LAST:event_closeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton importButton;
    private javax.swing.JList itemsList;
    private javax.swing.JScrollPane itemsScrollPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton newButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

}
