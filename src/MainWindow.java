import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.EventQueue;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

	static JPanel contentPane;
	public static int mouseXClick = -1;
	public static int mouseYClick = -1;

	//Launch the application
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Create the frame:
	public MainWindow() throws LineUnavailableException {
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		setTitle("Tim Andrew's Screensaver");
		setMinimumSize(new Dimension(232, 148));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		//Custom JPanel:
		AnimationScreen animationScreen = new AnimationScreen();
		animationScreen.setBackground(Color.black);
		animationScreen.setToolTipText("<html><body>Left Click = Add Shape<BR><BR>Right Click = Toggle Background<BR><BR>Middle Click = Reset Shapes</html></body>"
				+ "");
		animationScreen.addMouseListener(new MouseAdapter() {
			@Override
			//adds another shape when clicked:
			public void mouseClicked(MouseEvent e) {
				mouseXClick = e.getX();
				mouseYClick = e.getY();
				if (SwingUtilities.isRightMouseButton(e))
				{
					if (animationScreen.getBackground() == Color.black)
					{
						animationScreen.setBackground(Color.white);
					}
					else
					{
						animationScreen.setBackground(Color.black);
					}
				}
				else if (SwingUtilities.isMiddleMouseButton(e))
				{
				        AnimationScreen.shapesArray.clear();
				}
				else
				{
					AnimationScreen.addShape();

				}
				mouseXClick = -1;
				mouseYClick = -1;
			}
		});
		contentPane.add(animationScreen, "name_188603560227855");

		//A block of code to play background music in the background.
		//from: https://www.loc.gov/item/ihas.100010429/
		AudioInputStream bgMusic;
		try
		{
			bgMusic = AudioSystem.getAudioInputStream(MainWindow.class.getResource("/wav/CommonMan.wav"));
			Clip music = AudioSystem.getClip();
			music.open(bgMusic);
			music.loop(999);
		}
		catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
