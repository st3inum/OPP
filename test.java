/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newThread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jacksparrow
 */
public class test {
    public static int count=0;
    public static synchronized void cnt()
    {
        test.count++;
    }
    public static void main(String[] args) {
        Thread a=new Thread(new Runnable(){
            @Override
            public void run() 
            {
                for(int i=0;i<10;i++)
                cnt();
            }
            
        });
        Thread b=new Thread(new Runnable(){
            @Override
            public void run() 
            {
                for(int i=0;i<100;i++)
                cnt();
            }
        });
        
        a.start();
        b.start();
        
        try {
            a.join();
            b.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("total count = "+count);
    }
}
