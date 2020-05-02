import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class weatherGUI implements ActionListener {
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JButton button;
	private JTextField textInput;
	private String inputString;
	private boolean bool = false;

	// constructor for GUI
	public weatherGUI() {
		frame = new JFrame(); // First create this object
		panel = new JPanel(); // panel goes inside the frame
		textInput = new JTextField(10);
		button = new JButton("Find Weather");
		//label = new JLabel("Get Weather");
		panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 0, 150));
		panel.setLayout(new GridLayout(2, 2));
		panel.add(button);
		panel.add(label);
		panel.add(textInput);
		
		/////////////////////////////////////////
		frame.add(panel, BorderLayout.CENTER); // here we add the panel in the frame with border as Center.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Weather GUI");
		frame.pack();
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						inputString = textInput.getText();
					}
				});
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.inputString = textInput.getText();
		trigger();
	}

	public String getInput() {
		return inputString;
	}

	public boolean trigger() {
		bool = true;
		return bool;
	}
}
