import javax.swing.*;
import java.awt.*;

public class View {
    private JPanel panel1;
    private JButton skapaNyttInläggButton;
    private JButton loggaInButton;
    private JButton regristeraButton;
    private Container panel;

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JButton getSkapaNyttInläggButton() {
        return skapaNyttInläggButton;
    }

    public void setSkapaNyttInläggButton(JButton skapaNyttInläggButton) {
        this.skapaNyttInläggButton = skapaNyttInläggButton;
    }

    public JButton getLoggaInButton() {
        return loggaInButton;
    }

    public void setLoggaInButton(JButton loggaInButton) {
        this.loggaInButton = loggaInButton;
    }

    public JButton getRegristeraButton() {
        return regristeraButton;
    }

    public void setRegristeraButton(JButton regristeraButton) {
        this.regristeraButton = regristeraButton;
    }

    public Container getPanel() {
        return panel;
    }

    public void setPanel(Container panel) {
        this.panel = panel;
    }
}


