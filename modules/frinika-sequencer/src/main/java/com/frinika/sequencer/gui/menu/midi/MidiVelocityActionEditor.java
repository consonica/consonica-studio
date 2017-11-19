/*
 * Created on February 8, 2007
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
package com.frinika.sequencer.gui.menu.midi;

import javax.swing.JPanel;

/**
 * GUI-component for setting options of a MidiVelocityAction.
 *
 * (Created with NetBeans 5.5 gui-editor, see corresponding .form file.)
 *
 * @see MidiVelocityAction
 * @author Jens Gulden
 */
class MidiVelocityActionEditor extends JPanel {

    private MidiVelocityAction action;

    /**
     * Creates new form MidiVelocityActionEditor
     */
    public MidiVelocityActionEditor(MidiVelocityAction action) {
        this.action = action;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        startSpinner = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        endSpinner = new javax.swing.JSpinner();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Set velocity from");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jLabel1, gridBagConstraints);

        startSpinner.setModel(new javax.swing.SpinnerNumberModel(action.startVelocity, 0, 127, 1));
        startSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                startSpinnerStateChanged(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(startSpinner, gridBagConstraints);

        jLabel2.setText("to");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(jLabel2, gridBagConstraints);

        endSpinner.setModel(new javax.swing.SpinnerNumberModel(action.endVelocity, 0, 127, 1));
        endSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                endSpinnerStateChanged(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(endSpinner, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    private void startSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_startSpinnerStateChanged
        action.startVelocity = (Integer) startSpinner.getValue();
    }//GEN-LAST:event_startSpinnerStateChanged

    private void endSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_endSpinnerStateChanged
        action.endVelocity = (Integer) endSpinner.getValue();
    }//GEN-LAST:event_endSpinnerStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner endSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSpinner startSpinner;
    // End of variables declaration//GEN-END:variables

}
