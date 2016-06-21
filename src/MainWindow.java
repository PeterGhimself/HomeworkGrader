import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame implements ActionListener{
	
	public JLabel mistakeLabel, questionLabel, blankLabel, result;
	public JTextArea mistakes, questions, blanks;
	public JButton calculate;
	public String[] grades = {"1","1+","2-","2","2+","3-","3","3+","4-","4","4+","5-","5","5+"};
	
	
	//Constructor of the Window
	public MainWindow(){
		super("HW Grader");
		
		//Flow Layout will add components one after the other till run out of space then go to next line
		setLayout(new FlowLayout());
		
		mistakeLabel = new JLabel("Mistakes: ");
		questionLabel = new JLabel("Questions: ");
		blankLabel = new JLabel("Blanks: ");
		result = new JLabel("Result");
		
		calculate = new JButton("Calculate");
		
		//Lets button clicks be handled by method: void actionPerformed(ActionEvent)
		calculate.addActionListener(this);
		
		mistakes = new JTextArea();
		blanks = new JTextArea();
		questions = new JTextArea();
		
		JPanel mistakePanel = new JPanel();
		JPanel blankPanel = new JPanel();
		JPanel questionPanel = new JPanel();
		JPanel resultPanel = new JPanel();
		
		//GridLayout(Rows,Columns)
		mistakePanel.setLayout(new GridLayout(1,2));
		questionPanel.setLayout(new GridLayout(1,2));
		blankPanel.setLayout(new GridLayout(1,2));
		resultPanel.setLayout(new GridLayout(1,2));
		
		//Adds components to panels
		mistakePanel.add(mistakeLabel);
		mistakePanel.add(mistakes);
		
		questionPanel.add(questionLabel);
		questionPanel.add(questions);
		blankPanel.add(blankLabel);
		blankPanel.add(blanks);
		
		resultPanel.add(calculate);
		resultPanel.add(result);
		
		//adds panels to Frame following flow layout (see line ~21)
		add(mistakePanel);
		add(questionPanel);
		add(blankPanel);
		add(resultPanel);
		
	}
	//Main Methods creates an instance of MainWindow
	public static void main(String[] args){
		
		MainWindow window = new MainWindow();
		
		//Here you can use setSize for custom size, or pack() for minimum size
		//window.setSize(500,500);
		window.pack();
		
		window.setVisible(true);
		
		//not needed in this case
		//window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	//Gets run every time an action occurs
	public void actionPerformed(ActionEvent event) {
		
		//make sure it is the calculate button that triggered this method
		if(event.getActionCommand() == "Calculate"){
			
			//get values from the text boxes
			int mistakesBox = Integer.parseInt(mistakes.getText());
			int blanksBox = Integer.parseInt(blanks.getText());
			int questionsBox = Math.round(Integer.parseInt(questions.getText()));
			
			//calculate total mistakes based on box values
			int totalMistakes = (int) Math.round(mistakesBox+(questionsBox/5.)*questionsBox*blanksBox);
			
			//Manipulate/Use totalMistakes to figure out the letter grade, store the letter grade as a string,
			//then put that string into the brackets of result.setText()
			
			//update text of result label
			//result.setText(totalMistakes+""); 
			
			//to facilitate potential updating
			System.out.println("mistakes: "+mistakesBox+", questions: "+questionsBox+", blanks: "+blanksBox+", total mistakes: "+
			totalMistakes);
			
			result.setText(grades[13-((int) Math.ceil(totalMistakes/((questionsBox/5.)*questionsBox)))]);

			System.out.println("grades["+(13-((int) Math.ceil(totalMistakes/((questionsBox/5.)*questionsBox))))+
					"], result: "+grades[(13-((int) Math.ceil(totalMistakes/((questionsBox/5.)*questionsBox))))]);
					
			
		}
		
		
	}
}
