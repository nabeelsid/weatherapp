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
	private static JButton button;
	private static JLabel label;
	private static JLabel currentTempLabel;
	private static JLabel todaysMin;
	private static JLabel todaysMax;
	private static JLabel feelsLike;
	private static JLabel currentCity;
	private static weather w = new weather();
	
	public static void main(String[] args) {

		frame = new JFrame();
		panel = new JPanel();
		
		userText = new JTextField(20);
		userText.setBounds(100, 40, 165, 25); //x,y,width,height
		panel.add(userText);
		
		label = new JLabel("City");
		label.setBounds(20, 40, 80,25);//x,y,width,height.
		panel.add(label);
		
		button = new JButton("Go");
		button.setBounds(120, 140, 50, 25);
		button.addActionListener(new root());
		panel.add(button);
		
		currentCity = new JLabel();
		currentCity.setBounds(20, 10, 250, 25);
		panel.add(currentCity);
		
		currentTempLabel = new JLabel("");
		currentTempLabel.setBounds(20,70,200,25);
		panel.add(currentTempLabel);
		
		feelsLike = new JLabel();
		feelsLike.setBounds(20, 100, 130, 25);
		panel.add(feelsLike);
		
		todaysMin = new JLabel();
		todaysMin.setBounds(200, 70, 70, 25);
		panel.add(todaysMin);
		
		todaysMax = new JLabel();
		todaysMax.setBounds(200, 100, 70, 25);
		panel.add(todaysMax);
		
		frame.setTitle("Weather");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		panel.setLayout(null);		
		
		w.setCity("toronto");
		w.fetchWeather();
		currentTempLabel.setText("Current : "+w.getCurrentWeather()+" C");
		feelsLike.setText("Feels Like: "+ w.getFeelsLike() + " C");
		todaysMin.setText("Min: "+ w.getTodaysMin() + " C");
		todaysMax.setText("Max: "+ w.getTodaysMax() + " C");
		currentCity.setText("Today's forecast for: " + w.getCity());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String city = userText.getText();
		w.setCity(city);
		w.fetchWeather();
		currentTempLabel.setText("Current : "+w.getCurrentWeather()+" C");
		feelsLike.setText("Feels Like: "+ w.getFeelsLike() + " C");
		todaysMin.setText("Min: "+ w.getTodaysMin() + " C");
		todaysMax.setText("Max: "+ w.getTodaysMax() + " C");
		currentCity.setText("Today's forecast for: "+w.getCity());
	}
}
