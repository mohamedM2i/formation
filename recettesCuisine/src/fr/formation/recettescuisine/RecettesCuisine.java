/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.formation.recettescuisine;

import fr.formation.recettescuisine.connection.ConnectionBDD;
import fr.formation.recettescuisine.dao.AperitifsDAO;
import fr.formation.recettescuisine.dao.DessertsDAO;
import fr.formation.recettescuisine.dao.EntreesDAO;
import fr.formation.recettescuisine.dao.PlatsDAO;
import fr.formation.recettescuisine.dao.RecettesDAO;
import fr.formation.recettescuisine.pojo.AperitifsPOJO;
import fr.formation.recettescuisine.pojo.DessertsPOJO;
import fr.formation.recettescuisine.pojo.EntreesPOJO;
import fr.formation.recettescuisine.pojo.PlatsPOJO;
import fr.formation.recettescuisine.pojo.RecettesPOJO;
import java.awt.Dialog;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class RecettesCuisine extends javax.swing.JFrame {

    private Connection connection;

    private RecettesDAO recettesDAO;

    private AperitifsDAO aperitifsDAO;

    private EntreesDAO entreesDAO;

    private DessertsDAO dessertsDAO;

    private PlatsDAO platsDAO;

    private InsertRecette insertrecettes;

    // variable qui indique le type de recette sélectionnée par 
    // jComboBoxTypeRecette
    // idTypeRecetteSelected = 1 --> apéritifs
    // idTypeRecetteSelected = 2 --> entrées
    // idTypeRecetteSelected = 3 --> plats
    // idTypeRecetteSelected = 4 --> desserts
    private int idTypeRecetteSelected;

    /**
     * Creates new form RecettesCuisine
     */
    public RecettesCuisine() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        afficheListeIngredients = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonajouter = new javax.swing.JButton();
        jComboBoxTypeRecette = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        affichageIngredients = new javax.swing.JTextPane();
        jComboBoxNomRecette = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        afficheListeIngredients.setText("Liste des Ingrédients");

        jLabel1.setText("Types des recettes");

        jButtonajouter.setText("Ajouter");
        jButtonajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonajouterActionPerformed(evt);
            }
        });

        jComboBoxTypeRecette.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jComboBoxTypeRecette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTypeRecetteActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(affichageIngredients);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 95, Short.MAX_VALUE))
        );

        jComboBoxNomRecette.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jComboBoxNomRecette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNomRecetteActionPerformed(evt);
            }
        });

        jLabel3.setText("Recettes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(afficheListeIngredients))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTypeRecette, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxNomRecette, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(afficheListeIngredients)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxTypeRecette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxNomRecette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonajouter)
                        .addGap(134, 134, 134))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTypeRecetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTypeRecetteActionPerformed

        // initialisation de la liste des noms de recette    
        List<String> nomsRecettesList = new ArrayList<String>();
        jComboBoxNomRecette.removeAllItems();

        // récupération du type de recette
        String typeRecettesSelected = jComboBoxTypeRecette.getSelectedItem().toString();
        int idRecette = recettesDAO.getIdFromNomRecettes(typeRecettesSelected);

        // test si type selectionné = apérifis
        if (typeRecettesSelected.equals("apéritifs")) {
            idTypeRecetteSelected = 1;
            List<AperitifsPOJO> aperitifsList = aperitifsDAO.findByRecette(idRecette);

            for (AperitifsPOJO apero : aperitifsList) {
                nomsRecettesList.add(apero.getNomAperitifs());

            }

        } else if (typeRecettesSelected.equals("entrées")) {
            idTypeRecetteSelected = 2;
            List<EntreesPOJO> entreesList = entreesDAO.findByEntreesPOJOs(idRecette);
            for (EntreesPOJO entrees : entreesList) {
                nomsRecettesList.add(entrees.getNomEntrees());
            }

        } else if (typeRecettesSelected.equals("desserts")) {
            idTypeRecetteSelected = 4;
            List<DessertsPOJO> dessertsList = dessertsDAO.findByDessertsPOJO(idRecette);
            for (DessertsPOJO dessertsPOJO : dessertsList) {
                nomsRecettesList.add(dessertsPOJO.getNomDesserts());

            }

        } // il ne reste que "plats"
        else if (typeRecettesSelected.equals("plats")) {
            idTypeRecetteSelected = 3;
            List<PlatsPOJO> platsList = platsDAO.findByRecette(idRecette);
            for (PlatsPOJO platsPOJO : platsList) {
                nomsRecettesList.add(platsPOJO.getNomPlats());

            }

        }

        for (String nomRecette : nomsRecettesList) {
            jComboBoxNomRecette.addItem(nomRecette);
        }

        // chargement de la liste des noms de recettes associés au type de recette sélectioné

    }//GEN-LAST:event_jComboBoxTypeRecetteActionPerformed

    private void jComboBoxNomRecetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNomRecetteActionPerformed
        // TODO add your handling code here:

        String ingredients = null;
        String nomRecettesSelected = null;

        if (jComboBoxNomRecette != null && jComboBoxNomRecette.getSelectedItem() != null) {
            nomRecettesSelected = jComboBoxNomRecette.getSelectedItem().toString();
        }

        // si type recette = apéritifs
        if (idTypeRecetteSelected == 1) {
            ingredients = aperitifsDAO.findIngredientsByNom(nomRecettesSelected);
        } // si type recette = entrée
        else if (idTypeRecetteSelected == 2) {
            ingredients = entreesDAO.findIngredientsByNom(nomRecettesSelected);
        } // si type recette = plat
        else if (idTypeRecetteSelected == 3) {
            ingredients = platsDAO.findIngredientsByNom(nomRecettesSelected);

        } // si type recette = desert
        else {
            ingredients = dessertsDAO.findIngredientsByNom(nomRecettesSelected);
        }

        affichageIngredients.setText(ingredients);
    }//GEN-LAST:event_jComboBoxNomRecetteActionPerformed

    private void jButtonajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonajouterActionPerformed
        final InsertRecette frame = new InsertRecette();
        
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(insertrecettes.EXIT_ON_CLOSE);
        
        
        
        
    }//GEN-LAST:event_jButtonajouterActionPerformed

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
            java.util.logging.Logger.getLogger(RecettesCuisine.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecettesCuisine.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecettesCuisine.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecettesCuisine.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RecettesCuisine recettesCuisine = new RecettesCuisine();
                recettesCuisine.setVisible(true);
                recettesCuisine.setTitle("Anuaire de cuisine");

            }
        });
    }

    private void init() {
        // TODO add your handling code here:
        ConnectionBDD connectionBDD = new ConnectionBDD();

        // mapping de la connexion de l'annuaire "this.connection"  avec la connexion retournee par 
        // connectionBDD.openConnectionBDD()
        this.connection = connectionBDD.openConnectionBDD();

        // Creation (instantiation) d'un DAO  en utilisant le
        // constructeur qui prend en parametre 
        // la connexion de l'annuaire "this.connection" 
        recettesDAO = new RecettesDAO(connection);

        aperitifsDAO = new AperitifsDAO((connection));

        entreesDAO = new EntreesDAO(connection);

        dessertsDAO = new DessertsDAO(connection);

        platsDAO = new PlatsDAO(connection);

        insertrecettes = new InsertRecette();
        insertrecettes.setVisible(true);

        // recuperation de la liste des recettespojo mappee avec la liste "listerecetttepojo" 
        // en executant la requête "select_all" definie dans la methode findAllArrondissement() du DAO
        List<RecettesPOJO> listeRecettesPOJOs = recettesDAO.findAllRecettes();

        jComboBoxTypeRecette.addItem("");

        // boucle sur la liste des arrondissements et ajout d'un item dans la combo box de
        // l'arrondissement courant
        for (RecettesPOJO listeRecettesPOJO : listeRecettesPOJOs) {
            jComboBoxTypeRecette.addItem(listeRecettesPOJO.getNomRecettes());

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane affichageIngredients;
    private javax.swing.JLabel afficheListeIngredients;
    private javax.swing.JButton jButtonajouter;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBoxNomRecette;
    private javax.swing.JComboBox<String> jComboBoxTypeRecette;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
