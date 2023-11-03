
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	
	
public class StopWatch {


	    //For design
	    JFrame frame;
	    JLabel lbl1;
	    JLabel lbl2;
	    JLabel lbl3;
	    JLabel lbl4;
	    JLabel colon1;
	    JLabel colon2;
	    JLabel colon3;
	    JButton btnStart;
	    JButton btnStop;
	    JButton btnReset;

	    //For Working
	    static int milliseconds=0;
	    static int seconds=0;
	    static int minutes=0;
	    static int hours=0;

	    static boolean state = true;
	    public StopWatch(){
	        initComponents();
	    }

	    public void initComponents(){
	        frame = new JFrame("Stop Watch");
	        frame.setVisible(true);
	        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setBounds(300,200,500,200);

	        Container c = frame.getContentPane();
	        c.setLayout(null);

	        lbl1 = new JLabel("00");
	        lbl2 = new JLabel("00");
	        lbl3 = new JLabel("00");
	        lbl4 = new JLabel("00");
	        colon1 = new JLabel(":");
	        colon2 = new JLabel(":");
	        colon3 = new JLabel(":");
	        btnStart = new JButton("Start");
	        btnStop = new JButton("Stop");
	        btnReset = new JButton("Reset");

	        Font f1 = new Font("Arial",Font.BOLD,40);

	        lbl1.setBounds(48,20,50,40);
	        lbl1.setFont(f1);

	        btnStart.setBounds(30,90,80,30);
	        btnStart.setFont(new Font("Arial",Font.BOLD,20));

	        colon1.setBounds(125,20,20,40);
	        colon1.setFont(f1);

	        btnStop.setBounds(155,90,80,30);
	        btnStop.setFont(new Font("Arial",Font.BOLD,20));

	        lbl2.setBounds(175,20,50,40);
	        lbl2.setFont(f1);

	        colon2.setBounds(250,20,20,40);
	        colon2.setFont(f1);

	        btnReset.setBounds(278,90,90,30);
	        btnReset.setFont(new Font("Arial",Font.BOLD,20));

	        lbl3.setBounds(300,20,50,40);
	        lbl3.setFont(f1);

	        colon3.setBounds(380,20,20,40);
	        colon3.setFont(f1);

	        lbl4.setBounds(420,30,50,30);
	        lbl4.setFont(new Font("Arial",Font.BOLD,25));

	        c.add(lbl1);
	        c.add(btnStart);
	        c.add(colon1);
	        c.add(btnStop);
	        c.add(lbl2);
	        c.add(colon2);
	        c.add(btnReset);
	        c.add(lbl3);
	        c.add(colon3);
	        c.add(lbl4);

	        btnStart.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent evt){
	                btnStartActionPerformed(evt);
	            }
	        });
	        btnStop.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent evt){
	                btnStopActionPerformed(evt);
	            }
	        });
	        btnReset.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent evt){
	                btnResetActionPerformed(evt);
	            }
	        });
	    }

	//
	    private void btnStartActionPerformed(ActionEvent evt){
	        state = true;
	        Thread t = new Thread(){
	            public void run(){
	                for(;;){
	                    if(state==true){
	                        try{
	                            sleep(1);
	                            if(milliseconds>1000){
	                                milliseconds=0;
	                                seconds++;
	                            }
	                            if(seconds>60){
	                                milliseconds=0;
	                                seconds=0;
	                                minutes++;
	                            }
	                            if(minutes>60){
	                                milliseconds=0;
	                                seconds=0;
	                                minutes=0;
	                                hours++;
	                            }
	                            lbl4.setText(String.valueOf(milliseconds));
	                            milliseconds++;
	                            lbl3.setText(String.valueOf(seconds));
	                            lbl2.setText(String.valueOf(minutes));
	                            lbl1.setText(String.valueOf(hours));
	                        }
	                        catch(InterruptedException e){

	                        }
	                    }
	                    else{
	                        break;
	                    }
	                }
	            }
	        };
	        t.start();
	    }
	    private void btnStopActionPerformed(ActionEvent evt){
	        state=false;
	    }
	    private void btnResetActionPerformed(ActionEvent evt){
	        state=false;
	        hours=0;
	        minutes=0;
	        seconds=0;
	        milliseconds=0;

	        lbl1.setText("00");
	        lbl2.setText("00");
	        lbl3.setText("00");
	        lbl4.setText("00");
	    }


	    public static void main(String args[])
	    {
	        new StopWatch();
	    }
	}


