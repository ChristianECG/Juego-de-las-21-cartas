/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.christianecg.app21cartas.clases;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author ecg12
 */
public class Imagen_Elegida extends JPanel{
        String image;

    public Imagen_Elegida(String img) {
        this.setSize(160, 200);
        image = img;
    }

    public void paint(Graphics g) {
        Dimension height = getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/christianecg/app21cartas/images/" + image + ".jpg"));
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(160, 200, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        g.drawImage(icon.getImage(), 0, 0, height.width, height.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
