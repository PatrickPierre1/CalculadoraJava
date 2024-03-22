package exerciciote;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class Calculadora extends JFrame {
    private JTextField campoValor1;
    private JTextField campoValor2;
    private JButton buttonSomar;

    public Calculadora(){
        setTitle("Calculadora que só soma");
        setSize(400,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);

        var labelValor1 = new JLabel("Campo 1");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painel.add(labelValor1, constraints);

        campoValor1 = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        painel.add(campoValor1, constraints);

        var labelValor2 = new JLabel("Campo 2");
        constraints.gridx = 2;
        constraints.gridy = 0;
        painel.add(labelValor2, constraints);

        campoValor2 = new JTextField(10);
        constraints.gridx = 3;
        constraints.gridy = 0;
        painel.add(campoValor2, constraints);

        buttonSomar = new JButton("Somar");
        buttonSomar.addActionListener(e-> somar());
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 4;
        painel.add(buttonSomar,constraints);

        add(painel);
        setLocationRelativeTo(null);
    }
    private void validarNumero()throws NumberFormatException{
        if(campoValor1.getText().isEmpty() && campoValor2.getText().isEmpty()) throw new RuntimeException("Os campos devem ser preenchidos!");
        if(campoValor1.getText().isEmpty()) throw new RuntimeException("Campo 1 não pode ser vazio");
        if(campoValor2.getText().isEmpty()) throw new RuntimeException("Campo 2 não pode ser vazio");

    }
    private void somar(){

        try{
            validarNumero();
            var valor1 = Integer.parseInt(campoValor1.getText());
            var valor2 = Integer.parseInt(campoValor2.getText());
            var total = valor1 + valor2;

            showMessageDialog(this, "Resultado: "+ total);
        }catch (NumberFormatException e) {
            showMessageDialog(this, "Apenas Números");

        }catch (RuntimeException re) {
            showMessageDialog(this, re.getMessage());
        }

    }
}
