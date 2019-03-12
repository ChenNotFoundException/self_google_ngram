import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Created by JFormDesigner on Tue Feb 12 15:53:54 CST 2019
 */



/**
 * @author cc
 */
public class Ngrams extends JFrame {
    public static void main(String[] args) {
        Ngrams ngrams = new Ngrams();
        ngrams.setVisible(true);
        ngrams.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public Ngrams() {
        initComponents();
    }

    private void get(String pars,String smooth, String start,String end,Boolean caseInsensitive) {
        Process proc;
        System.out.println("====start====");
        String startYear = "-startYear=" +start+" ";
        String endYear = "-endYear="+end+" ";
        if (caseInsensitive == true) {
            pars = pars + " " + startYear + endYear + "-smoothing=" + smooth + " -caseInsensitive";
        } else {
            pars = pars + " " + startYear + endYear + "-smoothing=" + smooth;
        }
        textField6.setText("查询条件："+pars);
        String[] arg = new String[]{"D:\\Anaconda3\\python", "D:\\get.py",pars};
        //  String[] strings = {"Albert Einstein"};
        try {
            proc = Runtime.getRuntime().exec(arg);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                textField4.setText(textField4.getText()+"\r\n"+line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "失败！", "失败！",JOptionPane.ERROR_MESSAGE);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "失败！", "失败！",JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("====end====");
        textField4.setText(textField4.getText()+"\r\n"+"====如有数据 则表示成功====");
    }

    private void button1ActionPerformed(ActionEvent e) {
        Boolean caseInsensitive = checkBox1.isSelected();
        get(textField1.getText(), textField5.getText(), textField2.getText(), textField3.getText(), caseInsensitive);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textField4 = new JTextArea();
        label4 = new JLabel();
        textField5 = new JTextField();
        label5 = new JLabel();
        checkBox1 = new JCheckBox();
        textField6 = new JTextField();

        //======== this ========
        setTitle("NgramsToCsv");
        setVisible(true);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8bf7\u8f93\u5165\u67e5\u627e\u5173\u952e\u8bcd\uff0c\u4ee5\u9017\u53f7\u5212\u5206\uff1a\uff08\u82f1\u6587\u72b6\u6001\uff09");

        //---- label2 ----
        label2.setText("\u8bf7\u8f93\u5165\u5f00\u59cb\u5e74\u9650\uff1a");

        //---- label3 ----
        label3.setText("\u8bf7\u8f93\u5165\u7ed3\u675f\u5e74\u9650\uff1a");

        //---- button1 ----
        button1.setText("\u751f\u6210\uff01");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textField4);
        }

        //---- label4 ----
        label4.setText("smooth\u53c2\u6570:");

        //---- label5 ----
        label5.setText("caseInsensitive");

        //---- textField6 ----
        textField6.setEditable(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .add(GroupLayout.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                        .add(textField6)
                        .add(scrollPane1)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(contentPaneLayout.createParallelGroup()
                                .add(label1)
                                .add(textField1))
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(label2)
                                    .addPreferredGap(LayoutStyle.RELATED)
                                    .add(textField2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(label3)
                                    .addPreferredGap(LayoutStyle.RELATED)
                                    .add(textField3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(contentPaneLayout.createParallelGroup()
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(label4)
                                    .add(4, 4, 4)
                                    .add(textField5, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                .add(contentPaneLayout.createSequentialGroup()
                                    .add(label5)
                                    .addPreferredGap(LayoutStyle.RELATED)
                                    .add(checkBox1)))
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(button1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                    .add(37, 37, 37))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .add(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(contentPaneLayout.createParallelGroup(GroupLayout.TRAILING)
                        .add(contentPaneLayout.createSequentialGroup()
                            .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                                .add(label1)
                                .add(label2)
                                .add(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .add(label4)
                                .add(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.RELATED)
                            .add(contentPaneLayout.createParallelGroup(GroupLayout.BASELINE)
                                .add(label3)
                                .add(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .add(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .add(label5)
                                .add(checkBox1)))
                        .add(button1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.RELATED)
                    .add(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(scrollPane1, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textField4;
    private JLabel label4;
    private JTextField textField5;
    private JLabel label5;
    private JCheckBox checkBox1;
    private JTextField textField6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
