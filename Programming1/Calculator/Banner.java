import java.awt.*;
import java.applet.*;

public class Banner
  extends Applet
  implements Runnable 
{
  String msg;
  Thread t = null;
  int state;
  boolean stopFlag;

  Banner(String m){
    msg = m;
  }

  //public void init(){
    //setBackground(Color.YELLOW);
  //}

  public void start(){
    //msg = " how to pass this in?"
    if (msg == null) msg = "some kind of default message";
    msg = " " + msg;
    t = new Thread(this);
    stopFlag = false;
    t.start();
  }

  public void run(){
    char ch;

    for ( ; ; ){
      try {
	repaint();
        Thread.sleep(250);
	ch = msg.charAt(0);
	msg = msg.substring(1, msg.length());
	msg += ch;
        if(stopFlag){
	 break;
        }
      } catch (InterruptedException e) {
        // nothing to do, really
      }
      
    }
  }

  public void stop() {
    stopFlag = true;
    t = null;
  }

  public void paint(Graphics g) {
    g.drawString(msg, 50, 30);
  }  
}
