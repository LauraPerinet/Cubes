package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;



/**
 * JoglTest.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Main implements GLEventListener {
    int angle=0;
    Cube cube;
    Cube moyenCube;
    static float rotationX=5, rotationY=5;
    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Main());
        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
                System.out.println("DRAG");
                System.out.println("x = "+me.getX()+"  Y = "+me.getY());
                
                System.out.println("x on screen= "+me.getXOnScreen()+"  Y on screen= "+me.getYOnScreen());
            }

            @Override
            public void mouseMoved(MouseEvent me) {
                System.out.println("MOVE");
                System.out.println("x = "+me.getX()+"  Y = "+me.getY());
                rotationX=me.getX()/150;
                rotationY=me.getY()/150;
                System.out.println("x on screen= "+me.getXOnScreen()+"  Y on screen= "+me.getYOnScreen());
                
            }
        });
        /*
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                System.out.println("x = "+me.getX()+"  Y = "+me.getY());
                System.out.println("x on screen= "+me.getXOnScreen()+"  Y on screen= "+me.getYOnScreen());
            }
            
        });*/
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        cube=new Cube();
   
        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) 
    {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glEnable(GL.GL_DEPTH_TEST);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
         
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        gl.glTranslatef(0f, 0f, -10f);
        cube.setRotation(rotationX, rotationY);
        
        cube.display(drawable);
        
        gl.glTranslatef(-1f, 0f, -5f);
        gl.glScalef(0.5f,.5f,0.5f);
        cube.display(drawable);
        
        gl.glTranslatef(-1f, 0f, -5f);
        gl.glScalef(0.5f,.5f,0.5f);
        cube.display(drawable);
        

        // Reset the current matrix to the "identity"
        //gl.glLoadIdentity();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
        

    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

