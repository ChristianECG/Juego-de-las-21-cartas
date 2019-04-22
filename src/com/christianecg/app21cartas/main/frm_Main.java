/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.christianecg.app21cartas.main;

import com.christianecg.app21cartas.clases.Imagen;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author ecg12
 */
public class frm_Main extends javax.swing.JFrame {

    /**
     * Creates new form frm_Main
     */
    public frm_Main() {
        initComponents();
        llenar(inicial);
    }

    private int[][] inicial = new int[][]{{1, 4, 7, 10, 13, 16, 19}, {2, 5, 8, 11, 14, 17, 20}, {3, 6, 9, 12, 15, 18, 21}};

    private void llenar(int images[][]) {

        pnl_1.removeAll();
        pnl_2.removeAll();
        pnl_3.removeAll();
        pnl_4.removeAll();
        pnl_5.removeAll();
        pnl_6.removeAll();
        pnl_7.removeAll();
        pnl_8.removeAll();
        pnl_9.removeAll();
        pnl_10.removeAll();
        pnl_11.removeAll();
        pnl_12.removeAll();
        pnl_13.removeAll();
        pnl_14.removeAll();
        pnl_15.removeAll();
        pnl_16.removeAll();
        pnl_17.removeAll();
        pnl_18.removeAll();
        pnl_19.removeAll();
        pnl_20.removeAll();
        pnl_21.removeAll();

        Imagen img = new Imagen(String.valueOf(images[0][0]));
        pnl_1.add(img);
        pnl_1.repaint();

        img = new Imagen(String.valueOf(images[0][1]));
        pnl_2.add(img);
        pnl_2.repaint();

        img = new Imagen(String.valueOf(images[0][2]));
        pnl_3.add(img);
        pnl_3.repaint();

        img = new Imagen(String.valueOf(images[0][3]));
        pnl_4.add(img);
        pnl_4.repaint();

        img = new Imagen(String.valueOf(images[0][4]));
        pnl_5.add(img);
        pnl_5.repaint();

        img = new Imagen(String.valueOf(images[0][5]));
        pnl_6.add(img);
        pnl_6.repaint();

        img = new Imagen(String.valueOf(images[0][6]));
        pnl_7.add(img);
        pnl_7.repaint();

        img = new Imagen(String.valueOf(images[1][0]));
        pnl_8.add(img);
        pnl_8.repaint();

        img = new Imagen(String.valueOf(images[1][1]));
        pnl_9.add(img);
        pnl_9.repaint();

        img = new Imagen(String.valueOf(images[1][2]));
        pnl_10.add(img);
        pnl_10.repaint();

        img = new Imagen(String.valueOf(images[1][3]));
        pnl_11.add(img);
        pnl_11.repaint();

        img = new Imagen(String.valueOf(images[1][4]));
        pnl_12.add(img);
        pnl_12.repaint();

        img = new Imagen(String.valueOf(images[1][5]));
        pnl_13.add(img);
        pnl_13.repaint();

        img = new Imagen(String.valueOf(images[1][6]));
        pnl_14.add(img);
        pnl_14.repaint();

        img = new Imagen(String.valueOf(images[2][0]));
        pnl_15.add(img);
        pnl_15.repaint();

        img = new Imagen(String.valueOf(images[2][1]));
        pnl_16.add(img);
        pnl_16.repaint();

        img = new Imagen(String.valueOf(images[2][2]));
        pnl_17.add(img);
        pnl_17.repaint();

        img = new Imagen(String.valueOf(images[2][3]));
        pnl_18.add(img);
        pnl_18.repaint();

        img = new Imagen(String.valueOf(images[2][4]));
        pnl_19.add(img);
        pnl_19.repaint();

        img = new Imagen(String.valueOf(images[2][5]));
        pnl_20.add(img);
        pnl_20.repaint();

        img = new Imagen(String.valueOf(images[2][6]));
        pnl_21.add(img);
        pnl_21.repaint();

    }

    private int getSelected() {
        if (rbt_Fila1.isSelected()) {
            return 1;
        } else if (rbt_Fila2.isSelected()) {
            return 2;
        } else {
            return 3;
        }
    }

    private void realizar_vuelta() {
        num_vuelta++;
        int select = getSelected();
        int[][] ordena = new int[3][7];
        for (int i = 0; i < 3; i++) {
            int k = 0;
            for (int j = 6; j >= 0; j--) {
                ordena[i][k] = inicial[i][j];
                k++;
            }
        }
        if (select == 1) {
            inicial[0] = ordena[1];
            inicial[1] = ordena[0];
            inicial[2] = ordena[2];
        } else if (select == 2) {
            inicial[0] = ordena[2];
            inicial[1] = ordena[1];
            inicial[2] = ordena[0];
        } else if (select == 3) {
            inicial[0] = ordena[1];
            inicial[1] = ordena[2];
            inicial[2] = ordena[0];
        }

        int[] cartas_barajeadas = new int[27];
        int guia = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                cartas_barajeadas[guia] = inicial[i][j];
                guia++;
            }
        }

        guia = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                inicial[j][i] = cartas_barajeadas[guia];
                guia++;
            }
        }

        llenar(inicial);
        if (num_vuelta == 3) {
            frm_ImagenElegida.main(new String[]{String.valueOf(cartas_barajeadas[10])});
            //disable();
            inicial = new int[][]{{1, 4, 7, 10, 13, 16, 19}, {2, 5, 8, 11, 14, 17, 20}, {3, 6, 9, 12, 15, 18, 21}};
            num_vuelta=0;
            llenar(inicial);
        }
    }

    private int num_vuelta = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_principal = new javax.swing.JPanel();
        pnl_fila1 = new javax.swing.JPanel();
        pnl_1 = new javax.swing.JPanel();
        pnl_2 = new javax.swing.JPanel();
        pnl_3 = new javax.swing.JPanel();
        pnl_4 = new javax.swing.JPanel();
        pnl_5 = new javax.swing.JPanel();
        pnl_6 = new javax.swing.JPanel();
        pnl_7 = new javax.swing.JPanel();
        pnl_fila2 = new javax.swing.JPanel();
        pnl_8 = new javax.swing.JPanel();
        pnl_9 = new javax.swing.JPanel();
        pnl_10 = new javax.swing.JPanel();
        pnl_11 = new javax.swing.JPanel();
        pnl_12 = new javax.swing.JPanel();
        pnl_13 = new javax.swing.JPanel();
        pnl_14 = new javax.swing.JPanel();
        pnl_fila3 = new javax.swing.JPanel();
        pnl_15 = new javax.swing.JPanel();
        pnl_16 = new javax.swing.JPanel();
        pnl_17 = new javax.swing.JPanel();
        pnl_18 = new javax.swing.JPanel();
        pnl_19 = new javax.swing.JPanel();
        pnl_20 = new javax.swing.JPanel();
        pnl_21 = new javax.swing.JPanel();
        pnl_Opciones = new javax.swing.JPanel();
        rbt_Fila1 = new javax.swing.JRadioButton();
        rbt_Fila2 = new javax.swing.JRadioButton();
        rbt_Fila3 = new javax.swing.JRadioButton();
        btn_Aceptar = new javax.swing.JButton();
        btn_Cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        pnl_principal.setBackground(new java.awt.Color(224, 224, 224));

        pnl_fila1.setBackground(new java.awt.Color(204, 0, 0));

        pnl_1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_1Layout = new javax.swing.GroupLayout(pnl_1);
        pnl_1.setLayout(pnl_1Layout);
        pnl_1Layout.setHorizontalGroup(
            pnl_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_1Layout.setVerticalGroup(
            pnl_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_2Layout = new javax.swing.GroupLayout(pnl_2);
        pnl_2.setLayout(pnl_2Layout);
        pnl_2Layout.setHorizontalGroup(
            pnl_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_2Layout.setVerticalGroup(
            pnl_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_3Layout = new javax.swing.GroupLayout(pnl_3);
        pnl_3.setLayout(pnl_3Layout);
        pnl_3Layout.setHorizontalGroup(
            pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_3Layout.setVerticalGroup(
            pnl_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_4Layout = new javax.swing.GroupLayout(pnl_4);
        pnl_4.setLayout(pnl_4Layout);
        pnl_4Layout.setHorizontalGroup(
            pnl_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_4Layout.setVerticalGroup(
            pnl_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_5Layout = new javax.swing.GroupLayout(pnl_5);
        pnl_5.setLayout(pnl_5Layout);
        pnl_5Layout.setHorizontalGroup(
            pnl_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_5Layout.setVerticalGroup(
            pnl_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_6Layout = new javax.swing.GroupLayout(pnl_6);
        pnl_6.setLayout(pnl_6Layout);
        pnl_6Layout.setHorizontalGroup(
            pnl_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_6Layout.setVerticalGroup(
            pnl_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_7Layout = new javax.swing.GroupLayout(pnl_7);
        pnl_7.setLayout(pnl_7Layout);
        pnl_7Layout.setHorizontalGroup(
            pnl_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_7Layout.setVerticalGroup(
            pnl_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_fila1Layout = new javax.swing.GroupLayout(pnl_fila1);
        pnl_fila1.setLayout(pnl_fila1Layout);
        pnl_fila1Layout.setHorizontalGroup(
            pnl_fila1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fila1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_fila1Layout.setVerticalGroup(
            pnl_fila1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fila1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_fila1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_fila2.setBackground(new java.awt.Color(0, 204, 51));

        pnl_8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_8Layout = new javax.swing.GroupLayout(pnl_8);
        pnl_8.setLayout(pnl_8Layout);
        pnl_8Layout.setHorizontalGroup(
            pnl_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_8Layout.setVerticalGroup(
            pnl_8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_9Layout = new javax.swing.GroupLayout(pnl_9);
        pnl_9.setLayout(pnl_9Layout);
        pnl_9Layout.setHorizontalGroup(
            pnl_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_9Layout.setVerticalGroup(
            pnl_9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_10Layout = new javax.swing.GroupLayout(pnl_10);
        pnl_10.setLayout(pnl_10Layout);
        pnl_10Layout.setHorizontalGroup(
            pnl_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_10Layout.setVerticalGroup(
            pnl_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_11Layout = new javax.swing.GroupLayout(pnl_11);
        pnl_11.setLayout(pnl_11Layout);
        pnl_11Layout.setHorizontalGroup(
            pnl_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_11Layout.setVerticalGroup(
            pnl_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_12Layout = new javax.swing.GroupLayout(pnl_12);
        pnl_12.setLayout(pnl_12Layout);
        pnl_12Layout.setHorizontalGroup(
            pnl_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_12Layout.setVerticalGroup(
            pnl_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_13.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_13Layout = new javax.swing.GroupLayout(pnl_13);
        pnl_13.setLayout(pnl_13Layout);
        pnl_13Layout.setHorizontalGroup(
            pnl_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_13Layout.setVerticalGroup(
            pnl_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_14.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_14Layout = new javax.swing.GroupLayout(pnl_14);
        pnl_14.setLayout(pnl_14Layout);
        pnl_14Layout.setHorizontalGroup(
            pnl_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_14Layout.setVerticalGroup(
            pnl_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_fila2Layout = new javax.swing.GroupLayout(pnl_fila2);
        pnl_fila2.setLayout(pnl_fila2Layout);
        pnl_fila2Layout.setHorizontalGroup(
            pnl_fila2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fila2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_fila2Layout.setVerticalGroup(
            pnl_fila2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fila2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_fila2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_fila3.setBackground(new java.awt.Color(0, 102, 255));

        pnl_15.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_15Layout = new javax.swing.GroupLayout(pnl_15);
        pnl_15.setLayout(pnl_15Layout);
        pnl_15Layout.setHorizontalGroup(
            pnl_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_15Layout.setVerticalGroup(
            pnl_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_16.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_16Layout = new javax.swing.GroupLayout(pnl_16);
        pnl_16.setLayout(pnl_16Layout);
        pnl_16Layout.setHorizontalGroup(
            pnl_16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_16Layout.setVerticalGroup(
            pnl_16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_17.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_17Layout = new javax.swing.GroupLayout(pnl_17);
        pnl_17.setLayout(pnl_17Layout);
        pnl_17Layout.setHorizontalGroup(
            pnl_17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_17Layout.setVerticalGroup(
            pnl_17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_18.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_18Layout = new javax.swing.GroupLayout(pnl_18);
        pnl_18.setLayout(pnl_18Layout);
        pnl_18Layout.setHorizontalGroup(
            pnl_18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_18Layout.setVerticalGroup(
            pnl_18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_19.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_19Layout = new javax.swing.GroupLayout(pnl_19);
        pnl_19.setLayout(pnl_19Layout);
        pnl_19Layout.setHorizontalGroup(
            pnl_19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_19Layout.setVerticalGroup(
            pnl_19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_20.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_20Layout = new javax.swing.GroupLayout(pnl_20);
        pnl_20.setLayout(pnl_20Layout);
        pnl_20Layout.setHorizontalGroup(
            pnl_20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_20Layout.setVerticalGroup(
            pnl_20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnl_21.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_21Layout = new javax.swing.GroupLayout(pnl_21);
        pnl_21.setLayout(pnl_21Layout);
        pnl_21Layout.setHorizontalGroup(
            pnl_21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );
        pnl_21Layout.setVerticalGroup(
            pnl_21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_fila3Layout = new javax.swing.GroupLayout(pnl_fila3);
        pnl_fila3.setLayout(pnl_fila3Layout);
        pnl_fila3Layout.setHorizontalGroup(
            pnl_fila3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fila3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_fila3Layout.setVerticalGroup(
            pnl_fila3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fila3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_fila3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_Opciones.setBackground(new java.awt.Color(224, 224, 224));
        pnl_Opciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        rbt_Fila1.setBackground(new java.awt.Color(204, 0, 0));
        rbt_Fila1.setForeground(new java.awt.Color(255, 255, 255));
        rbt_Fila1.setText("Fila 1");
        rbt_Fila1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_Fila1ActionPerformed(evt);
            }
        });

        rbt_Fila2.setBackground(new java.awt.Color(51, 204, 0));
        rbt_Fila2.setText("Fila 2");
        rbt_Fila2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_Fila2ActionPerformed(evt);
            }
        });

        rbt_Fila3.setBackground(new java.awt.Color(51, 153, 255));
        rbt_Fila3.setText("Fila 3");
        rbt_Fila3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_Fila3ActionPerformed(evt);
            }
        });

        btn_Aceptar.setBackground(new java.awt.Color(51, 255, 0));
        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });

        btn_Cerrar.setBackground(new java.awt.Color(255, 63, 0));
        btn_Cerrar.setText("Cerrar");
        btn_Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_OpcionesLayout = new javax.swing.GroupLayout(pnl_Opciones);
        pnl_Opciones.setLayout(pnl_OpcionesLayout);
        pnl_OpcionesLayout.setHorizontalGroup(
            pnl_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_OpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbt_Fila3)
                    .addComponent(rbt_Fila1)
                    .addComponent(rbt_Fila2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(pnl_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(btn_Cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_OpcionesLayout.setVerticalGroup(
            pnl_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_OpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbt_Fila1)
                    .addGroup(pnl_OpcionesLayout.createSequentialGroup()
                        .addComponent(btn_Aceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbt_Fila2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_OpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbt_Fila3)
                    .addComponent(btn_Cerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_principalLayout = new javax.swing.GroupLayout(pnl_principal);
        pnl_principal.setLayout(pnl_principalLayout);
        pnl_principalLayout.setHorizontalGroup(
            pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_fila2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnl_principalLayout.createSequentialGroup()
                .addGroup(pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_fila1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_fila3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnl_principalLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(pnl_Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_principalLayout.setVerticalGroup(
            pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_principalLayout.createSequentialGroup()
                .addComponent(pnl_fila1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_fila2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_fila3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbt_Fila1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_Fila1ActionPerformed
        rbt_Fila2.setSelected(false);
        rbt_Fila3.setSelected(false);
    }//GEN-LAST:event_rbt_Fila1ActionPerformed

    private void rbt_Fila2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_Fila2ActionPerformed
        rbt_Fila1.setSelected(false);
        rbt_Fila3.setSelected(false);
    }//GEN-LAST:event_rbt_Fila2ActionPerformed

    private void rbt_Fila3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_Fila3ActionPerformed
        rbt_Fila2.setSelected(false);
        rbt_Fila1.setSelected(false);
    }//GEN-LAST:event_rbt_Fila3ActionPerformed

    private void btn_CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CerrarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "¿Seguro de que deseas salir?", "¿Salir?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
            dispose();
        }
    }//GEN-LAST:event_btn_CerrarActionPerformed

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        realizar_vuelta();
    }//GEN-LAST:event_btn_AceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_Cerrar;
    private javax.swing.JPanel pnl_1;
    private javax.swing.JPanel pnl_10;
    private javax.swing.JPanel pnl_11;
    private javax.swing.JPanel pnl_12;
    private javax.swing.JPanel pnl_13;
    private javax.swing.JPanel pnl_14;
    private javax.swing.JPanel pnl_15;
    private javax.swing.JPanel pnl_16;
    private javax.swing.JPanel pnl_17;
    private javax.swing.JPanel pnl_18;
    private javax.swing.JPanel pnl_19;
    private javax.swing.JPanel pnl_2;
    private javax.swing.JPanel pnl_20;
    private javax.swing.JPanel pnl_21;
    private javax.swing.JPanel pnl_3;
    private javax.swing.JPanel pnl_4;
    private javax.swing.JPanel pnl_5;
    private javax.swing.JPanel pnl_6;
    private javax.swing.JPanel pnl_7;
    private javax.swing.JPanel pnl_8;
    private javax.swing.JPanel pnl_9;
    private javax.swing.JPanel pnl_Opciones;
    private javax.swing.JPanel pnl_fila1;
    private javax.swing.JPanel pnl_fila2;
    private javax.swing.JPanel pnl_fila3;
    private javax.swing.JPanel pnl_principal;
    private javax.swing.JRadioButton rbt_Fila1;
    private javax.swing.JRadioButton rbt_Fila2;
    private javax.swing.JRadioButton rbt_Fila3;
    // End of variables declaration//GEN-END:variables
}
