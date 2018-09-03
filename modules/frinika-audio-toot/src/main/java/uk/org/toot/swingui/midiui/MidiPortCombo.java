/* Generated by TooT */

package uk.org.toot.swingui.midiui;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import uk.org.toot.midi.core.MidiSystem;
import uk.org.toot.midi.core.MidiPort;

public class MidiPortCombo extends JComboBox
{
	public MidiPortCombo(MidiSystem system, boolean ins) {
		super(new MidiPortModel(system, ins));
		setPrototypeDisplayValue("#########################");
//		setMaximumSize(new Dimension(128, 100));
	}

	private static class MidiPortModel extends AbstractListModel implements ComboBoxModel
	{
		private MidiSystem system;
		private boolean inputs;
		private List<? extends MidiPort> ports;
		private MidiPort selectedPort;

		public MidiPortModel(MidiSystem system, boolean ins) {
			this.system = system;
			inputs = ins;
			updateItems();
			system.addObserver(
				new Observer() {
					public void update(Observable arg0, Object arg1) {
						updateItems();
						fireContentsChanged(MidiPortModel.this, 0, ports.size()-1);
					}
				}
			);
		}
		
		private void updateItems() {
			ports = inputs ? system.getMidiInputs() : system.getMidiOutputs();
			selectedPort = ports.get(0);
		}

		public Object getSelectedItem() {
			return selectedPort;
		}

		public void setSelectedItem(Object obj) {
			selectedPort = (MidiPort)obj;
		}

		public Object getElementAt(int arg0) {
			return ports.get(arg0);
		}

		public int getSize() {
			return ports.size();
		}

	}
}