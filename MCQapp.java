import javax.swing.*;
import java.awt.event.*;
public class MCQapp extends JFrame implements ActionListener
{
    JLabel q;
    JRadioButton a,b,c,d;
    ButtonGroup bg;
    JButton next;

    int i = 0;
    int Score = 0;
    String ques[] =  
    {
        "1. java is a ?",
        "2. AWT stands for ?",
        "3. Full Form of JVM ?",
        "4. Wchich package is used for Swing ?",
        "5.Which method starts a thread ?"
    };
    String op[][] =
    {
        {"Programming Language", "Animal", "car", "food"},
        {"Apple web Toolkit", "Advanced Window Tool", "Abstract window Toolkit","None"},
        {"Java Virtual Machine", "Java variable method", "Joint virtual Machine", "None"},
        {"Java.awt","Javax.Swing","Java.io","Java.net"},
        {"run()", "Stop()","Main()","Start()"}
    };

    char ans[] = {'A','C','A','B','D'};
    MCQapp()
    {
        setTitle("MCQ App");
        setSize(500,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        q = new JLabel();
        q.setBounds(50,50,400,30);
        add(q);

        a = new JRadioButton();
        a.setBounds(70,100,300,30);
        add(a);

        b = new JRadioButton();
        b.setBounds(70,140,300,30);
        add(b);

        c = new JRadioButton();
        c.setBounds(70,180,300,30);
        add(c);

        d = new JRadioButton();
        d.setBounds(70,220,300,30);
        add(d);

        bg = new ButtonGroup();

        bg.add(a);
        bg.add(b);
        bg.add(c);
        bg.add(d);

        next = new JButton("Next");
        next.setBounds(180,290,120,35);
        next.addActionListener(this);
        add(next);

        loadQuestion();

        setVisible(true);
    }

    void loadQuestion()
    {
        q.setText(ques[i]);

        a.setText(op[i][0]);
        b.setText(op[i][1]);
        c.setText(op[i][2]);
        d.setText(op[i][3]);

        bg.clearSelection();

        if (i == 4) 
        {
            next.setText("Submit");
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        char user = ' ';

        if(a.isSelected())
        {
            user = 'A';
        }
        else if (b.isSelected()) 
        {
            user = 'B';
        }
        else if (c.isSelected())
        {
            user = 'c';
        }
        else if (d.isSelected()) 
        {
            user = 'D';
        }
        if (user == ans[i]) 
        {
            Score++;
        }
        i++;

        if (i < 5) 
        {
            loadQuestion();
        }
        else
        {
            JOptionPane.showMessageDialog
            (
                this,
                "Your Score = " + Score + "/5"
            );
        }
    }
    public static void main(String[] args) 
    {
        new MCQapp();
    }
}
