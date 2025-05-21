/**
 * @name        Simple Java Calculator
 * @package     ph.calculator
 * @file        UI.java
 * @author      SORIA Pierre-Henry
 * @email       pierrehs@hotmail.com
 * @link        http://github.com/pH-7
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 * @create      2012-03-30
 *
 * @modifiedby  Achintha Gunasekara
 * @modifiedby  Kydon Chantzaridis
 * @modweb      http://www.achinthagunasekara.com
 * @modemail    contact@achinthagunasekara.com
 * @modemail    kchantza@csd.auth.gr
 */

package simplejavacalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;

import java.awt.Image;
import java.io.*;
import java.util.Map;

public class UI implements ActionListener {
   
   private final JFrame frame;
   
   private final JPanel panel;
   private final JPanel panelSub1;
   private final JPanel panelSub2;
   private final JPanel panelSub3;
   private final JPanel panelSub4;
   private final JPanel panelSub5;
   private final JPanel panelSub6;
   private final JPanel panelSub7;
   private final JPanel panelSub8;
   
   private final JTextArea text;
   
   private final JButton but[], butAdd, butMinus, butMultiply, butDivide,
      butEqual, butCancel, butSquareRoot, butSquare, butOneDividedBy,
      butCos, butSin, butTan, butxpowerofy, butlog, butrate, butabs, butBinary, butln;
   private final Calculator calc;
   
   private final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6",
      "7", "8", "9"};
   

   private final Font font;
   private final Font textFont;
   private ImageIcon image;
   private BufferedImageCustom imageReturn;
   
   public UI() throws IOException {
      frame = new JFrame("Calculator PH");
      
      imageReturn = new BufferedImageCustom();
      image = new ImageIcon(imageReturn.imageReturn());      
      
      panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panelSub1 = new JPanel(new FlowLayout());
      panelSub2 = new JPanel(new FlowLayout());
      panelSub3 = new JPanel(new FlowLayout());
      panelSub4 = new JPanel(new FlowLayout());
      panelSub5 = new JPanel(new FlowLayout());
      panelSub6 = new JPanel(new FlowLayout());
      panelSub7 = new JPanel(new FlowLayout());
      panelSub8 = new JPanel(new FlowLayout());
      
      font = new Font("Consolas",Font.PLAIN, 18);
      
      text = new JTextArea(1, 30);
      
      textFont = new Font("Consolas",Font.BOLD, 24);
      
      but = new JButton[10];      
      for (int i = 0; i < 10; i++) {
    		 but[i] = new JButton(String.valueOf(i));
      }      
      butAdd = new JButton("+");      
      butMinus = new JButton("-");      
      butMultiply = new JButton("*");      
      butDivide = new JButton("/");      
      butEqual = new JButton("=");      
      butSquareRoot = new JButton("sqrt");      
      butSquare = new JButton("x*x");      
      butOneDividedBy = new JButton("1/x");      
      butCos = new JButton("Cos");      
      butSin = new JButton("Sin");      
      butTan = new JButton("Tan");      
      butln = new JButton("ln");     
      butxpowerofy = new JButton("x^y");      
      butlog = new JButton("log10(x)");      
      butrate = new JButton("x%");      
      butabs = new JButton("abs(x)");      
      butCancel = new JButton("C");      
      butBinary = new JButton("Bin");      
      
      calc = new Calculator();
      
   }
   
   public void init() {      
      frame.setSize(450, 450);
      frame.setLocationRelativeTo(null); 
      frame.setResizable(false);
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setIconImage(image.getImage());
      
      text.setFont(textFont);
      text.setEditable(false);
      
      for (int i = 0; i < 10; i++) {
         but[i].setFont(font);
      }      
      butAdd.setFont(font);
      butMinus.setFont(font);
      butMultiply.setFont(font);
      butDivide.setFont(font);
      butEqual.setFont(font);
      butSquareRoot.setFont(font);
      butSquare.setFont(font);
      butOneDividedBy.setFont(font);
      butCos.setFont(font);
      butSin.setFont(font);
      butTan.setFont(font);
      butln.setFont(font); 
      butxpowerofy.setFont(font);
      butlog.setFont(font);
      butrate.setFont(font);
      butabs.setFont(font);
      butCancel.setFont(font);
      butBinary.setFont(font); 
      
      panel.add(Box.createHorizontalStrut(100));
      panelSub1.add(text);
      panel.add(panelSub1);
      
      panelSub2.add(but[1]);
      panelSub2.add(but[2]);
      panelSub2.add(but[3]);
      panelSub2.add(Box.createHorizontalStrut(15));
      panelSub2.add(butAdd);
      panelSub2.add(butMinus);
      panel.add(panelSub2);
      
      panelSub3.add(but[4]);
      panelSub3.add(but[5]);
      panelSub3.add(but[6]);
      panelSub3.add(Box.createHorizontalStrut(15));
      panelSub3.add(butMultiply);
      panelSub3.add(butDivide);      
      panel.add(panelSub3);
      
      panelSub4.add(but[7]);
      panelSub4.add(but[8]);
      panelSub4.add(but[9]);
      panelSub4.add(Box.createHorizontalStrut(15));
      panelSub4.add(butEqual);
      panelSub4.add(butCancel);
      panel.add(panelSub4);
      
      panelSub5.add(Box.createHorizontalStrut(92));
      panelSub5.add(but[0]);
      panelSub5.add(butln); 
      panelSub5.add(Box.createHorizontalStrut(210));
      panel.add(panelSub5);
      
      panelSub6.add(butSquare);
      panelSub6.add(butSquareRoot);
      panelSub6.add(butOneDividedBy);
      panelSub6.add(butxpowerofy);
      panel.add(panelSub6);
      
      panelSub7.add(butCos);
      panelSub7.add(butSin);
      panelSub7.add(butTan);
      panel.add(panelSub7);
      
      panelSub8.add(butlog);
      panelSub8.add(butrate);
      panelSub8.add(butabs);
      panelSub8.add(butBinary);
      panel.add(panelSub8);
      
      for (int i = 0; i < 10; i++) {
         but[i].addActionListener(this);
      }      
      butAdd.addActionListener(this);
      butMinus.addActionListener(this);
      butMultiply.addActionListener(this);
      butDivide.addActionListener(this);
      butSquare.addActionListener(this);
      butSquareRoot.addActionListener(this);
      butOneDividedBy.addActionListener(this);
      butCos.addActionListener(this);
      butSin.addActionListener(this);
      butTan.addActionListener(this);
      butln.addActionListener(this); 
      butxpowerofy.addActionListener(this);
      butlog.addActionListener(this);
      butrate.addActionListener(this);
      butabs.addActionListener(this);
      butBinary.addActionListener(this);
      
      butEqual.addActionListener(this);
      butCancel.addActionListener(this);
      
      frame.add(panel);
      frame.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      Object src = e.getSource();

      /* ------------------------------------------------ 1. digits */
      for (int i = 0; i < 10; i++) {                 // +1 complexity
         if (src == but[i]) {                       // +1
            text.replaceSelection(buttonValue[i]);
            text.selectAll();
            return;
         }
      }

      /* ------------------------------------------------ 2. parse current number (if any) */
      Double value = null;
      try {
         value = Double.parseDouble(text.getText());   // +1 (try)
      } catch (NumberFormatException ignored) { }

      if (value == null && src != butCancel) {          // +1
         return;                                       // nothing to do
      }

      /* ------------------------------------------------ 3. operations table */
      Map<Object, Runnable> ops = Map.ofEntries(
              /* binary */
              Map.entry(butAdd,       () -> writer(calc.calculateBi(Calculator.BiOperatorModes.ADD,       reader()))),
              Map.entry(butMinus,     () -> writer(calc.calculateBi(Calculator.BiOperatorModes.MINUS,     reader()))),
              Map.entry(butMultiply,  () -> writer(calc.calculateBi(Calculator.BiOperatorModes.MULTIPLY,  reader()))),
              Map.entry(butDivide,    () -> writer(calc.calculateBi(Calculator.BiOperatorModes.DIVIDE,    reader()))),
              Map.entry(butxpowerofy, () -> writer(calc.calculateBi(Calculator.BiOperatorModes.XPOWEROFY, reader()))),

              /* unary */
              Map.entry(butSquare,       () -> writer(calc.calculateMono(Calculator.MonoOperatorModes.SQUARE,       reader()))),
              Map.entry(butSquareRoot,   () -> writer(calc.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT,   reader()))),
              Map.entry(butOneDividedBy, () -> writer(calc.calculateMono(Calculator.MonoOperatorModes.ONEDIVIDEDBY, reader()))),
              Map.entry(butCos,          () -> writer(calc.calculateMono(Calculator.MonoOperatorModes.COS,          reader()))),
              Map.entry(butSin,          () -> writer(calc.calculateMono(Calculator.MonoOperatorModes.SIN,          reader()))),
              Map.entry(butTan,          () -> writer(calc.calculateMono(Calculator.MonoOperatorModes.TAN,          reader()))),
              Map.entry(butlog,          () -> writer(calc.calculateMono(Calculator.MonoOperatorModes.LOG,          reader()))),
              Map.entry(butln,           () -> writer(calc.calculateMono(Calculator.MonoOperatorModes.LN,           reader()))),
              Map.entry(butrate,         () -> writer(calc.calculateMono(Calculator.MonoOperatorModes.RATE,         reader()))),
              Map.entry(butabs,          () -> writer(calc.calculateMono(Calculator.MonoOperatorModes.ABS,          reader()))),

              /* misc */
              Map.entry(butEqual,   () -> writer(calc.calculateEqual(reader()))),
              Map.entry(butCancel,  () -> writer(calc.reset())),
              Map.entry(butBinary,  this::parsetoBinary)    // existing method
      );

      /* ------------------------------------------------ 4. run the matching action */
      Runnable task = ops.get(src);                     // +1
      if (task != null) {                               // +1
         task.run();
         text.selectAll();
      }
   }


   private void parsetoBinary() {
      try {
         text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
      } catch (NumberFormatException ex) {
         System.err.println("Error while parse to binary." + ex.toString());
      }
   }
   
   public Double reader() {
      Double num;
      String str;
      str = text.getText();
      num = Double.valueOf(str);
      
      return num;
   }
   
   public void writer(final Double num) {
      if (Double.isNaN(num)) {
         text.setText("");
      } else {
         text.setText(Double.toString(num));
      }
   }
}
