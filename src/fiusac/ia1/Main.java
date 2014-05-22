/**
 * 
 */
package fiusac.ia1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * @author david
 *
 */
public class Main extends JFrame {
	private Canvas canvas;
	private JLabel jlScoreBoard;
	public static final ImageCache ic;
	static {
		ic = new ImageCache();
	}
	private String currentSelectedPiece;
	/**
	 * 
	 */
	public Main() {
		super("Retro-Tetris");
		setBounds(0,0,1050,825);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		
		jlScoreBoard = new JLabel("00");
		jlScoreBoard.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
		jlScoreBoard.setHorizontalAlignment(JLabel.RIGHT);
		jlScoreBoard.setBounds(840, 370, 150, 40);
		jlScoreBoard.setOpaque(true);
		jlScoreBoard.setBackground(Color.GRAY);
		
		add(jlScoreBoard);
		
		add(canvas = new Canvas(jlScoreBoard));
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5, 3, 2, 2));
		jp.setBounds(840, 10, 180, 300);
		
		bg = new ButtonGroup();
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				currentSelectedPiece = ((JToggleButton)actionEvent.getSource()).getName(); // obtener el id de pieza
			}
		};
		JToggleButton tb1 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_01.png")));
		tb1.setName("1");
		JToggleButton tb2 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_02.png")));
		tb2.setName("2");
		JToggleButton tb3 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_03.png")));
		tb3.setName("3");
		JToggleButton tb4 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_04.png")));
		tb4.setName("4");
		JToggleButton tb5 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_05.png")));
		tb5.setName("5");
		JToggleButton tb6 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_06.png")));
		tb6.setName("6");
		JToggleButton tb7 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_07.png")));
		tb7.setName("7");
		JToggleButton tb8 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_08.png")));
		tb8.setName("8");
		JToggleButton tb9 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_09.png")));
		tb9.setName("9");
		JToggleButton tb10 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_10.png")));
		tb10.setName("10");
		JToggleButton tb11 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_11.png")));
		tb11.setName("11");
		JToggleButton tb12 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_12.png")));
		tb12.setName("12");
		JToggleButton tb13 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_13.png")));
		tb13.setName("13");
		JToggleButton tb14 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_14.png")));
		tb14.setName("14");
		JToggleButton tb15 = new JToggleButton(new ImageIcon(getClass().getClassLoader().getResource("img/figura_15.png")));
		tb15.setName("15");
		
		tb1.addActionListener(al);
		tb2.addActionListener(al);
		tb3.addActionListener(al);
		tb4.addActionListener(al);
		tb5.addActionListener(al);
		tb6.addActionListener(al);
		tb7.addActionListener(al);
		tb8.addActionListener(al);
		tb9.addActionListener(al);
		tb10.addActionListener(al);
		tb11.addActionListener(al);
		tb12.addActionListener(al);
		tb13.addActionListener(al);
		tb14.addActionListener(al);
		tb15.addActionListener(al);
		
		bg.add(tb1);
		bg.add(tb2);
		bg.add(tb3);
		bg.add(tb4);
		bg.add(tb5);
		bg.add(tb6);
		bg.add(tb7);
		bg.add(tb8);
		bg.add(tb9);
		bg.add(tb10);
		bg.add(tb11);
		bg.add(tb12);
		bg.add(tb13);
		bg.add(tb14);
		bg.add(tb15);
		
		jp.add(tb1);
		jp.add(tb2);
		jp.add(tb3);
		jp.add(tb4);
		jp.add(tb5);
		jp.add(tb6);
		jp.add(tb7);
		jp.add(tb8);
		jp.add(tb9);
		jp.add(tb10);
		jp.add(tb11);
		jp.add(tb12);
		jp.add(tb13);
		jp.add(tb14);
		jp.add(tb15);
		add(jp);
		JButton jb = new JButton("Confirmar");
		jb.setBounds(840, 320, 150, 40);
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentSelectedPiece == null){
					System.out.println("no ha seleccionado ni rosca");
				} else {
					canvas.newMove(currentSelectedPiece);
					bg.clearSelection();
					currentSelectedPiece = null;
				}
			}
		});
		add(jb);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main().setVisible(true);
	}
	private ButtonGroup bg;
}
