import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements KeyListener{
	
	private JTextArea area;
	private JTextField field;
	private JLabel label;

	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate program when x is clicked
		setSize(800, 650); 
		setLocationRelativeTo(null); // center the window on the screen
		setTitle("Estate Escape");
		setLayout(new BorderLayout());
		
		area = new JTextArea();//"You have been sent on a mission to a mansion. Your goal is to recollect and return the missing skeleton parts of the houses owner and return them to the tomb. It is said that his skeleton has been scattered around the property. Once you entered through the front gate it appears to have slammed shut, so if you want to make it out of here you better complete what you came here to do. You proceed to enter the front door of the house.");

		//area = new JTextArea(Game.getCurrentRoom().getDesc()); use in Game Class
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		//area.setSize(600, 400);
		area.setForeground(Color.BLACK);
		area.setFont(new Font(null, Font.PLAIN, 26));
		area.setColumns(25);
		area.setRows(25);
		area.setEditable(false);
		
		DefaultCaret caret = (DefaultCaret) area.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scroll = new JScrollPane(area);
		add(scroll, BorderLayout.CENTER);
		
		JPanel panel = new JPanel(new BorderLayout());
		
		field = new JTextField();
		field.setFont(new Font(null, Font.PLAIN, 30));
		field.addKeyListener(this);
		//add(field, BorderLayout.SOUTH);
		
		label = new JLabel("What do you want to do?");
		label.setFont(new Font(null,Font.PLAIN, 35));
		//add(label, BorderLayout.SOUTH);
		
		panel.add(label, BorderLayout.CENTER);
		panel.add(field, BorderLayout.SOUTH);
		add(panel, BorderLayout.SOUTH);
		
		setVisible(true); // allow window to appear
	}
	
	public void print(String s) {
		area.append(s+"\n\n");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == '\n'){	
			if(Game.talking != null) {
				Game.talking.response(Integer.parseInt(field.getText()));
				Game.talking = null;
			} else {
				Game.processCommand(field.getText());
			}
				field.setText("");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
