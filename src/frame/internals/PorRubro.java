package frame.internals;

import entitys.Producto;
import static frame.Menu.listaProductos;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author julan
 */
public class PorRubro extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo1 = new DefaultTableModel() {
        public boolean esCeldaEditable1(int f, int c) {
            return false;
        }
    };

    /**
     * Creates new form PorRubro
     */
    public PorRubro() {
        initComponents();
        armarCabecera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbRubro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaRubro = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        jLabel1.setText("Lista de Productos por Rubro");

        jLabel2.setText("Rubro:");

        jcbRubro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COMESTIBLE", "LIMPIEZA", "PERFUMERIA" }));
        jcbRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbRubroActionPerformed(evt);
            }
        });
        jcbRubro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcbRubroKeyReleased(evt);
            }
        });

        jtTablaRubro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtTablaRubro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jcbRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Busca en la tabla y a la vez elimina filas al cambiar rubro
    private void jcbRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbRubroActionPerformed
        borrarFilas();
        String rubroSelect = (String) jcbRubro.getSelectedItem();
        for (Producto it : listaProductos) {
            if (it.getRubro().toString().equals(rubroSelect)) {
                modelo1.addRow(new Object[]{it.getCodigo(), it.getDescripcion(), it.getPrecio(), it.getStock()});
            }
        }
    }//GEN-LAST:event_jcbRubroActionPerformed

    private void jcbRubroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbRubroKeyReleased

    }//GEN-LAST:event_jcbRubroKeyReleased
    //Arma filas y columnas de la tabla
    private void armarCabecera() {
        modelo1.addColumn("Código");
        modelo1.addColumn("Descripcion");
        modelo1.addColumn("Precio");
        modelo1.addColumn("Stock");
        jtTablaRubro.setModel(modelo1);
    }

    //Borra las filas de productos en la tabla cambiando el rubro
    private void borrarFilas() {
        int f = jtTablaRubro.getRowCount() - 1; //cuenta las filas -1
        for (; f >= 0; f--) { //inicializa f arriba
            modelo1.removeRow(f);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbRubro;
    private javax.swing.JTable jtTablaRubro;
    // End of variables declaration//GEN-END:variables
}
