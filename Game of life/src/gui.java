import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public  class gui extends Applet implements Runnable{
	  private final int CELL_Size =10;//ÿ����ʽ�ı߳���Java����ϵ��λ��  
	  game a=new game();
	    private Thread animator;  
	    private int delay;//�ӳ�   
	    private boolean running=false;//flag����ʶ�̵߳�����״��������������runningΪtrue�����û��жϣ�runningΪfalse�� 
	    private Color cell =new Color(0,0,0);  
	    private Color space =new Color(255,255,255);   
	    public void run() {  
	    	
	        long tm = System.currentTimeMillis();  
	        while (Thread.currentThread() == animator) {  
	            if (running == true) {  
	               a. getNeighbors();  
	               a. nextWorld();  
	                repaint();  
	            }   
	            try {  
	                tm += delay;  
	                Thread.sleep(Math.max(0, 1000));  
	            } catch (InterruptedException e) {  
	                break;  
	            }  
	        }   
	    }
	    @Override public void init()  {  
	        a.settable1();
	        animator = new Thread(this);  
	        delay = 100;  
	        running = true;  
	     
	        setBackground(Color.yellow);  
	        setBackground(new Color(199,237,204));  
	    
	       
	    } 
	 
	    public void paint(Graphics g) {  
	        update(g);  
	    }  
	    public void update (Graphics g) {  
	        for (int x = 0; x < 30; x++)  
	            for (int y = 0; y < 30; y++) {  
	               g.setColor(a.gettable(x, y)?cell:space);  
	               g.fillRect(x * CELL_Size, y * CELL_Size, CELL_Size - 1, CELL_Size - 1);  
	            }  
	    } 
	    @Override public void start() {          
	        animator.start();         
	    }  
	  
	    @Override public void stop()    {  
	        animator = null;      
	    }  
	
}
