package com.company.lab6.calculator.window;

import com.company.lab6.calculator.*;
import com.company.lab6.calculator.datatypes.complex.ComplexValueParser;
import com.company.lab6.calculator.datatypes.integer.IntegerValueParser;
import com.company.lab6.calculator.datatypes.real.RealValueParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program
{
    private final AbstractValueParser[] valueParsers;
    private final Calculator calc;


    JLabel chooseCalcTypeLabel;
    JComboBox calcTypeComboBox;
    JLabel numberLabel1;
    JTextField numberField1;
    JLabel operationLabel;
    JComboBox operationComboBox;
    JLabel numberLabel2;
    JTextField numberField2;
    JButton operateButton;
    JTextField result;
    JButton saveButton;

    JPanel windowContent;
    JFrame frame;

    CalculatorEngine engine = new CalculatorEngine();

    public Program()
    {
        valueParsers = new AbstractValueParser[] {
                new IntegerValueParser(),
                new RealValueParser(),
                new ComplexValueParser()
        };

        calc = new Calculator(valueParsers[0]); // Îòêğûòèå íà öåëî÷èñëåííîì êàëüêóëÿòîğå

        windowContent = new JPanel();

        GridLayout gl = new GridLayout(6,2);
        windowContent.setLayout(gl);

        // Ñîäåğæèìîå âûïàäàşùèõ ïëàøåê
        String[] items = {
                "ÖÅËÛÅ",
                "ÄÅÉÑÒÂÈÒÅËÜÍÛÅ",
                "ÊÎÌÏËÅÊÑÍÛÅ"
        };

        String[] operations = {
                "+",
                "-",
                "*",
                "/"
        };


        chooseCalcTypeLabel = new JLabel("ÂÛÁÅĞÈÒÅ, ÊÀÊÈÅ ×ÈÑËÀ ÑÊËÀÄÛÂÀÒÜ");
        chooseCalcTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        windowContent.add(chooseCalcTypeLabel);

        calcTypeComboBox = new JComboBox(items);
        chooseCalcTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        windowContent.add(calcTypeComboBox);

        numberLabel1 = new JLabel("ÏÅĞÂÎÅ ×ÈÑËÎ:");
        numberLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        windowContent.add(numberLabel1);

        numberField1 = new JTextField(10);
        numberField1.setHorizontalAlignment(SwingConstants.CENTER);
        windowContent.add(numberField1);

        operationLabel = new JLabel("ÎÏÅĞÀÖÈß:");
        operationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        windowContent.add(operationLabel);

        operationComboBox = new JComboBox(operations);
        windowContent.add(operationComboBox);

        numberLabel2 = new JLabel("ÂÒÎĞÎÅ ×ÈÑËÎ:");
        numberLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        windowContent.add(numberLabel2);

        numberField2 = new JTextField(10);
        numberField2.setHorizontalAlignment(SwingConstants.CENTER);
        windowContent.add(numberField2);

        operateButton = new JButton("ÏÎÑ×ÈÒÀÒÜ");
        operateButton.addActionListener(engine);
        operateButton.setHorizontalAlignment(SwingConstants.CENTER);
        windowContent.add(operateButton);

        result = new JTextField(10);
        result.setHorizontalAlignment(SwingConstants.CENTER);
        windowContent.add(result);

        saveButton = new JButton("ÂÛÂÎÄ Â ÔÀÉË");
        saveButton.addActionListener(new ExMenuInitiator());
        saveButton.setHorizontalAlignment(SwingConstants.CENTER);
        windowContent.add(saveButton);
    }

    public static void main(String[] args)
    {
        Program program = new Program();
        program.frame = new JFrame("ÊÀËÜÊÓËßÒÎĞ");
        program.frame.setContentPane(program.windowContent);
        program.frame.setSize(1280,720);
        program.frame.setVisible(true);
    }

    private class CalculatorEngine implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            calc.setValueParser(valueParsers[calcTypeComboBox.getSelectedIndex()]);

            try
            {
                String answer = calc.calculate(
                        numberField1.getText(),
                        (String) operationComboBox.getSelectedItem(),
                        numberField2.getText()
                );

                result.setText(answer);

            } catch (DivisionByZeroException | ParseValueException | OperationNotSupportedException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    private class ExMenuInitiator implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            StringBuilder text = new StringBuilder();
            text.append(numberField1.getText());
            text.append(" ");
            text.append((String) operationComboBox.getSelectedItem());
            text.append(" ");
            text.append(numberField2.getText());
            text.append(" = ");
            text.append(result.getText());

            ExMenu exMenu = new ExMenu(text.toString());
            exMenu.go();
        }
    }
}
