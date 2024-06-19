package org.coretechies.ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.coretechies.logic.GeneratePassword.noticeCaseAndGenerate;

public class PasswordGeneratorUi {


    protected JFrame mainFrame;
    String passwordGenerate;
    JTextField randomPassword;
    public static JSlider textCount;
    public static JCheckBox capitolLatter, number, specialChar;
    protected JLabel includeCap, includeNum, includeSpe;
    JButton copyButton;

    public void frame() {
        mainFrame = new JFrame("Random Password Generator");
        mainFrame.setSize(290, 300);
        mainFrame.setLocation(10, 10);
        mainFrame.setLayout(null); // Use absolute positioning
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showRandomPassword() {
        randomPassword = new JTextField(20);
        randomPassword.setEditable(false);
        randomPassword.setBounds(10, 10, 255, 370);
        randomPassword.setSize(240, 50);
        mainFrame.add(randomPassword);

        copyButton = new JButton("copy");
        copyButton.setBounds(248, 20, 300, 20);
        copyButton.setSize(40,35);
        mainFrame.add(copyButton);
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the text area
                String text = randomPassword.getText();
                // Copy the text to the clipboard
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Clipboard clipboard = toolkit.getSystemClipboard();
                StringSelection stringSelection = new StringSelection(text);
                clipboard.setContents(stringSelection, null);
            }
        });


    }

    public void slider() {
        textCount = new JSlider();
        textCount.setMinimum(4);
        textCount.setMaximum(12);
        textCount.setBounds(50, 80, 400, 300);
        textCount.setSize(200, 20);
        mainFrame.add(textCount);
        textCount.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                passwordGenerate= noticeCaseAndGenerate();
                randomPassword.setText(passwordGenerate);

            }
        });
    }


    public void selectChoice() {
        capitolLatter = new JCheckBox();
        includeCap = new JLabel();
        includeCap.setText("Include Capitol Latter");
        includeCap.setBounds(70, 120, 170, 20);
        capitolLatter.setBounds(40, 120, 190, 20);

        capitolLatter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordGenerate= noticeCaseAndGenerate();
                randomPassword.setText(passwordGenerate);
            }
        });

        number = new JCheckBox();
        includeNum = new JLabel();
        includeNum.setText("Include Numbers");
        includeNum.setBounds(70, 150, 170, 20);
        number.setBounds(40, 150, 140, 20);
        number.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordGenerate= noticeCaseAndGenerate();
                randomPassword.setText(passwordGenerate);
            }
        });

        specialChar = new JCheckBox();
        includeSpe = new JLabel("Include Special Corrector");
        includeSpe.setBounds(70, 180, 170, 20);
        specialChar.setBounds(40, 180, 190, 20);
        specialChar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                passwordGenerate= noticeCaseAndGenerate();
                randomPassword.setText(passwordGenerate);
            }
        });

        mainFrame.add(capitolLatter);
        mainFrame.add(includeCap);
        mainFrame.add(number);
        mainFrame.add(includeNum);
        mainFrame.add(specialChar);
        mainFrame.add(includeSpe);

    }


    public void printFrame() {
        frame();
        showRandomPassword();
        slider();
        selectChoice();
        mainFrame.setVisible(true);

    }


}
