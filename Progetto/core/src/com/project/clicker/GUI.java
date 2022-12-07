package com.project.clicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GUI extends JFrame implements ActionListener{
    private JButton Fanteb;
    private JButton Spadaccinob;
    private JButton Cavaliereb;
    private JButton Arciereb;
    private JButton Magob;
    private JButton Catapultab;
    private JButton Cannoneb;
    private JButton Incendiariab;
    private JButton Giganteb;
    private JButton Dragob;
    private JTextField Guadagno;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public GUI(){
        super("Battaglia");
        Guadagno=new JTextField("0");
        Fanteb=new JButton("Fante");
        Spadaccinob=new JButton("Spadaccino");
        Cavaliereb=new JButton("Cavaliere");
        Arciereb=new JButton("Arciere");
        Magob=new JButton("Mago");
        Catapultab=new JButton("Catapulta");
        Cannoneb=new JButton("Cannone");
        Incendiariab=new JButton("Incendiaria");
        Giganteb=new JButton("Gigante");
        Dragob=new JButton("Drago");

        Fanteb.addActionListener(this);
        Spadaccinob.addActionListener(this);
        Cavaliereb.addActionListener(this);
        Arciereb.addActionListener(this);
        Magob.addActionListener(this);
        Catapultab.addActionListener(this);
        Cannoneb.addActionListener(this);
        Incendiariab.addActionListener(this);
        Giganteb.addActionListener(this);
        Dragob.addActionListener(this);

        JPanel p1=new JPanel(new GridLayout(5,2));
        p1.add(Fanteb); p1.add(Catapultab);
        p1.add(Spadaccinob); p1.add(Cannoneb);
        p1.add(Cavaliereb); p1.add(Incendiariab);
        p1.add(Arciereb); p1.add(Giganteb);
        p1.add(Magob); p1.add(Dragob);
        JPanel p2=new JPanel(new BorderLayout());
        p2.add(Guadagno,BorderLayout.NORTH); p2.add(p1,BorderLayout.SOUTH);

        setContentPane(p2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setVisible(true);


    }

    public void CalcolaGuadagno(Database db){
        String optime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String cltime = db.getTime();
        Date date1 = new Date();
        Date date2 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            date1 = format.parse(optime);
            date2 = format.parse(cltime);
        } catch (ParseException p){
            p.printStackTrace();
        }
        long difference = date2.getTime() - date1.getTime();
        System.out.println(difference);

    }


}
