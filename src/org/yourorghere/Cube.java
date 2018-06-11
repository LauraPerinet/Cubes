/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

/**
 *
 * @author licence
 */
public class Cube {
    int angle=0;
    float x=5,y=5;
    public Cube() {
    }
    public void display(GLAutoDrawable drawable){
    
        GL gl=drawable.getGL();
        gl.glRotatef(10f+angle, x, y, 0f);
        
        
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(0.8f, 0.8f, 0.8f);
             gl.glVertex3f( -1.0f,-1.0f,-1.0f);
             gl.glVertex3f(1.0f,-1.0f,-1.0f);
             gl.glVertex3f(1.0f,1.0f,-1.0f);
             gl.glVertex3f(-1.0f,1.0f,-1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(0.5f, 1f, 0.5f);
             gl.glVertex3f( -1.0f,1.0f,1.0f);
             gl.glVertex3f(1.0f,1.0f,1.0f);
             gl.glVertex3f(1.0f,1.0f,-1.0f);
             gl.glVertex3f(-1.0f,1.0f,-1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(1f, 0.5f, 0.5f);
             gl.glVertex3f( -1.0f,-1.0f,1.0f);
             gl.glVertex3f(1.0f,-1.0f,1.0f);
             gl.glVertex3f(1.0f,-1.0f,-1.0f);
             gl.glVertex3f(-1.0f,-1.0f,-1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(0.5f, 0.5f, 0.5f);
             gl.glVertex3f( -1.0f,-1.0f,1.0f);
             gl.glVertex3f(-1.0f,-1.0f,-1.0f);
             gl.glVertex3f(-1.0f,1.0f,-1.0f);
             gl.glVertex3f(-1.0f,1.0f,1.0f);
        
        gl.glEnd();
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(0.5f, 0.5f, 0.5f);
             gl.glVertex3f( 1.0f,-1.0f,1.0f);
             gl.glVertex3f(1.0f,-1.0f,-1.0f);
             gl.glVertex3f(1.0f,1.0f,-1.0f);
             gl.glVertex3f(1.0f,1.0f,1.0f);
        
        gl.glEnd();
        gl.glBegin(GL.GL_QUADS);
            gl.glColor3f(0.7f, 0.7f, 0.7f);
             gl.glVertex3f( -1.0f,-1.0f,1.0f);
             gl.glVertex3f(1.0f,-1.0f,1.0f);
             gl.glVertex3f(1.0f,1.0f,1.0f);
             gl.glVertex3f(-1.0f,1.0f,1.0f);
        gl.glEnd();
        
        angle++;
    }
    public void setRotation(float x, float y){ this.x=x; this.y=y;}
    
}
