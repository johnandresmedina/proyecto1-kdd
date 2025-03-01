package GUI;

import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class Visualizador extends javax.swing.JFrame {

    String arregloPreguntas[][];
    JComboBox comboBoxPreguntas;

    public Visualizador() {
        super("Colmovil");
        initComponents();
        this.setLocationRelativeTo(null);
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        panelOpciones.setLayout(layout);

        //Inicializamos y asignamos las Preguntas
        comboBoxPreguntas = this.setPreguntas();
        comboBoxPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preguntasActionPerformed(evt);
            }
        });
        panelPreguntas.add(comboBoxPreguntas);
    }

    private JComboBox setPreguntas() {

        comboBoxPreguntas = new JComboBox();
        //columna #0 = Pregunta
        arregloPreguntas = new String[10][1];
        arregloPreguntas[0][0] = "Escoger una Opción";
        arregloPreguntas[1][0] = "Perfil de usuarios que abandonan a COLMOVIL";
        arregloPreguntas[2][0] = "Franjas de mayor uso de la red";
        arregloPreguntas[3][0] = "Planes más escogidos";
        arregloPreguntas[4][0] = "Perfil de usuarios de planes pre-pago";
        arregloPreguntas[5][0] = "Perfil de usuarios de planes post-pago";
        arregloPreguntas[6][0] = "Perfil de usuarios que contratan plan de datos";
        arregloPreguntas[7][0] = "Perfil de usuarios de servicio de roamming";
        arregloPreguntas[8][0] = "Operadores nacionales más frecuentemente utilizados";
        arregloPreguntas[9][0] = "Tendencia de consumo de servicios de voz";

        for (int i = 0; i < arregloPreguntas.length; i++) {
            comboBoxPreguntas.addItem(arregloPreguntas[i][0]);
        }

        return comboBoxPreguntas;
    }

    private void asignarComponentes(int codigoDePregunta) {
        //según la pregunta que se elija asignamos unos componentes a la interfaz
        if (codigoDePregunta == 1 || codigoDePregunta == 2 || codigoDePregunta == 3 || codigoDePregunta == 4 || codigoDePregunta == 5 || codigoDePregunta == 6 || codigoDePregunta == 7 || codigoDePregunta == 9 || codigoDePregunta == 8) {

            if (codigoDePregunta == 1) {
                UiPerfilUsuarioAbandonaColmovil abandono = new UiPerfilUsuarioAbandonaColmovil();
                asignaComponentes(abandono);

            } else if (codigoDePregunta == 2) {
                UiFranjasUsoRed franjasUsoRed = new UiFranjasUsoRed();
                asignaComponentesFranjas(franjasUsoRed);

            } else if (codigoDePregunta == 3) {
                UiPlanesMasEscogidos planesMasEscogidos = new UiPlanesMasEscogidos();
                asignaComponentesPlanes(planesMasEscogidos);

            } else if (codigoDePregunta == 4) {
                UiPerfilUsuarioPlanPrepago planesPrepago = new UiPerfilUsuarioPlanPrepago();
                asignaComponentes(planesPrepago);

            } else if (codigoDePregunta == 5) {
                UiPerfilUsuarioPlanPospago planesPospago = new UiPerfilUsuarioPlanPospago();
                asignaComponentes(planesPospago);

            } else if (codigoDePregunta == 6) {
                UiPerfilUsuarioContrataPlanDatos UsuarioPlanDatos = new UiPerfilUsuarioContrataPlanDatos();
                asignaComponentes(UsuarioPlanDatos);

            } else if (codigoDePregunta == 7) {
                UiPerfilUsuarioServicioRoamming UsuarioServicioRoamming = new UiPerfilUsuarioServicioRoamming();
                asignaComponentes(UsuarioServicioRoamming);
            } else if (codigoDePregunta == 8) {
                UiOperadoresMasFrecuentes operadoresMasFrecuentes = new UiOperadoresMasFrecuentes();
                asignaComponentesOperadores(operadoresMasFrecuentes);
            } else if (codigoDePregunta == 9) {
                UiPerfilUsuarioTendenciaPlanVoz tendenciaPLanVoz = new UiPerfilUsuarioTendenciaPlanVoz();
                asignaComponentesTendencia(tendenciaPLanVoz);

            } else {
                panelOpciones.removeAll();
                panelOpciones.updateUI();
            }

        } else {
            //por ahora eliminamos los componentes de la interfaz
            panelOpciones.removeAll();
            panelOpciones.updateUI();
        }
    }

    private void asignaComponentes(UiPerfil perfil) {

        panelOpciones.removeAll();
        panelOpciones.add(perfil.getLabelSexo());
        panelOpciones.add(perfil.getLabelVacia());
        panelOpciones.add(perfil.getCheckBoxSexoFemenino());
        panelOpciones.add(perfil.getCheckBoxSexoMasculino());
        panelOpciones.add(perfil.getLabelEstadoCivil());
        panelOpciones.add(perfil.getEstadoCivil());
        panelOpciones.add(perfil.getLabelInicioEstrato());
        panelOpciones.add(perfil.getInicioEstrato());
        panelOpciones.add(perfil.getLabelFinEstrato());
        panelOpciones.add(perfil.getFinEstrato());
        panelOpciones.add(perfil.getPieRadio());
        panelOpciones.add(perfil.getBarRadio());
        panelOpciones.add(perfil.getLineRadio());
        panelOpciones.add(perfil.getConsultar());
        panelOpciones.updateUI();
    }

    private void asignaComponentesFranjas(UiPerfil perfil) {

        panelOpciones.removeAll();
        panelOpciones.add(perfil.getLabelOperador());
        panelOpciones.add(perfil.getLabelVacia());
        panelOpciones.add(perfil.getComboBoxOperador());
        panelOpciones.add(perfil.getPieRadio());
        panelOpciones.add(perfil.getBarRadio());
        panelOpciones.add(perfil.getLineRadio());
        panelOpciones.add(perfil.getConsultar());
        panelOpciones.updateUI();
    }

    private void asignaComponentesOperadores(UiPerfil perfil) {

        panelOpciones.removeAll();
        panelOpciones.add(perfil.getLabelMeses());
        panelOpciones.add(perfil.getComboBoxMeses());
        panelOpciones.add(perfil.getPieRadio());
        panelOpciones.add(perfil.getBarRadio());
        panelOpciones.add(perfil.getLineRadio());
        panelOpciones.add(perfil.getConsultar());
        panelOpciones.updateUI();
    }

    private void asignaComponentesPlanes(UiPerfil perfil) {

        panelOpciones.removeAll();
        panelOpciones.add(perfil.getLabelPlanDeDatos());
        panelOpciones.add(perfil.getCheckBoxDatos());
        panelOpciones.add(perfil.getLabelPlanDeVoz());
        panelOpciones.add(perfil.getCheckBoxPrepagoVoz());
        panelOpciones.add(perfil.getCheckBoxPostpagoVoz());
        panelOpciones.add(perfil.getCheckBoxCorporativo());
        panelOpciones.add(perfil.getPieRadio());
        panelOpciones.add(perfil.getBarRadio());
        panelOpciones.add(perfil.getLineRadio());
        panelOpciones.add(perfil.getConsultar());
        panelOpciones.updateUI();
    }

    private void asignaComponentesTendencia(UiPerfil perfil) {

        panelOpciones.removeAll();
        panelOpciones.add(perfil.getLabelAnioInicio());
        panelOpciones.add(perfil.getLabelVacia());
        panelOpciones.add(perfil.getComboBoxInicioAnios());
        panelOpciones.add(perfil.getPieRadio());
        panelOpciones.add(perfil.getBarRadio());
        panelOpciones.add(perfil.getLineRadio());
        panelOpciones.add(perfil.getConsultar());
        panelOpciones.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu3 = new javax.swing.JMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelOpciones = new javax.swing.JPanel();
        panelPreguntas = new javax.swing.JPanel();
        panelPestanas = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        salir = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));

        panelOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));
        panelOpciones.setMinimumSize(new java.awt.Dimension(150, 0));
        panelOpciones.setLayout(new java.awt.GridLayout(1, 0));

        panelPreguntas.setBorder(javax.swing.BorderFactory.createTitledBorder("Preguntas"));
        panelPreguntas.setMinimumSize(new java.awt.Dimension(150, 0));
        panelPreguntas.setLayout(new javax.swing.BoxLayout(panelPreguntas, javax.swing.BoxLayout.LINE_AXIS));

        panelPestanas.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(179, 179, 179), 1, true), null));

        salir.setText("Archivo");
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Salir...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        salir.add(jMenuItem1);

        jMenuBar1.add(salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelPreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelPestanas, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(panelPestanas)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void preguntasActionPerformed(java.awt.event.ActionEvent evt) {
        String preguntaSeleccionada = "" + comboBoxPreguntas.getSelectedItem();
        int codigoDePregunta = 0;

        for (int i = 0; i <= arregloPreguntas.length; i++) {

            if (arregloPreguntas[i][0].equals(preguntaSeleccionada)) {
                codigoDePregunta = i;
                break;
            }
        }

        System.out.println(comboBoxPreguntas.getSelectedItem() + " - Código de la pregunta: " + codigoDePregunta);
        asignarComponentes(codigoDePregunta);
    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Visualizador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visualizador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPanel panelOpciones;
    public static javax.swing.JTabbedPane panelPestanas;
    private javax.swing.JPanel panelPreguntas;
    private javax.swing.JMenu salir;
    // End of variables declaration//GEN-END:variables
}
