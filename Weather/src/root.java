import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class root implements ActionListener{
	
	private static JFrame frame;
	private static JPanel panel;
	private static JTextField userText;
	private static JLabel label;
	private static JButton button;
	private static JLabel currentTempLabel;
	private static String cityName;
	private static weather w = new weather();
	
	public static void main(String[] args) {

		frame = new JFrame();
		panel = new JPanel();
		
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25); //x,y,width,height
		panel.add(userText);
		
		label = new JLabel("City");
		label.setBounds(20,20,80,25);//x,y,width,height
		panel.add(label);
		
		button = new JButton("Go");
		button.setBounds(100, 100, 80, 25);
		button.addActionListener(new root());
		panel.add(button);
		
		currentTempLabel = new JLabel("");
		currentTempLabel.setBounds(20,60,200,25);
		panel.add(currentTempLabel);
		
		frame.setTitle("Weather");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.setLayout(null);		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String city = userText.getText();
		w.setCity(city);
		w.fetchWeather();
		currentTempLabel.setText("Current temp: "+w.getCurrentWeather()+ " C");
	}
}
