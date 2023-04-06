import javax.swing.*;

public class Controller {
    private Model m;
    private View v;

    public Controller(Model m, View v) {
        this.m = m;
        this.v = v;
        JFrame frame = new JFrame("Forum");
        frame.setContentPane(v.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void forum(){
        m.forum();
        m.printarrays();
        String msg = m.printarrays();

    }

    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller c =  new Controller(m,v);
        c.forum();

    }
}
