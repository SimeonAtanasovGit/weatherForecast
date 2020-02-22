package weatherforecast;
import static java.awt.Frame.NORMAL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class WeatherForecast extends javax.swing.JFrame {
    public WeatherForecast() {
        initComponents();
        messageLabel.setText("Please insert a number of degrees and pick conditions");
        quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("Quit".equals(e.getActionCommand())) {
                    System.exit(NORMAL);
                }
            }
        });
        
        overrideItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooserOpen = new JFileChooser();
                fileChooserOpen.setCurrentDirectory(new File("./images"));
                fileChooserOpen.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        String[] acceptedExtensions = {".jpg", ".jpeg", ".png",
                                                       ".gif", ".tif", ".tiff" };
                        for (String ext : acceptedExtensions) {
                            if (pathname.getName().toLowerCase().endsWith(ext)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    
                    @Override
                    public String getDescription() {
                        return "Image files";
                    }
                });
                
                int returnVal = fileChooserOpen.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooserOpen.getSelectedFile();
                    imageW.setImage(file.getPath());
                } 
            }
        });
        
        seticonButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(inputDegrees.getText().equals("")) {
                    messageLabel.setText("Please input a number of degrees");
                    imageW.setImage("./images/error.png");
                }
                
                float value = Float.parseFloat(inputDegrees.getText());
                if((cb1.isSelected())&&(!cb2.isSelected())&&(!cb3.isSelected())) {
                    if(value <= 0) {
                        messageLabel.setText("Today is snowing with a temperature of " +value+ " °C");
                        imageW.setImage("./images/snowing.png");
                    }
                
                    else {
                        messageLabel.setText("Today is raining with a temperature of " +value+ " °C");
                        imageW.setImage("./images/raining.png"); 
                    }
                }
        
                else if((cb1.isSelected())&&(cb2.isSelected())&&(!cb3.isSelected())) {
                    if(value <= 0) {
                        messageLabel.setText("Tonight is snowing with a temperature of " +value+ " °C");
                        imageW.setImage("./images/snowing_night.png"); 
                    }
                
                    else {
                        messageLabel.setText("Tonight is raining with a temperature of " +value+ " °C");
                        imageW.setImage("./images/raining_night.png");    
                    }
                }
        
                else if((cb1.isSelected())&&(cb2.isSelected())&&(cb3.isSelected())) {
                    if(value <= 32) {
                        messageLabel.setText("Tonight is snowing with a temperature of " +value+ " °F");
                        imageW.setImage("./images/snowing_night.png"); 
                    }
                
                    else {
                        messageLabel.setText("Tonight is raining with a temperature of " +value+ " °F");
                        imageW.setImage("./images/raining_night.png");    
                    }
                }
        
                else if((cb1.isSelected())&&(!cb2.isSelected())&&(cb3.isSelected())) {
                    if(value <= 32) {
                        messageLabel.setText("Today is snowing with a temperature of " +value+ " °F");
                        imageW.setImage("./images/snowing.png");
                    }
                
                    else {
                        messageLabel.setText("Today is raining with a temperature of " +value+ " °F");
                        imageW.setImage("./images/raining.png");
                    }
                }

                else if((!cb1.isSelected())&&(cb2.isSelected())&&(cb3.isSelected())) {
                    messageLabel.setText("Tonight is clear sky with a temperature of " +value+ " °F");
                    imageW.setImage("./images/clear_night.png");
                }
        
                else if((!cb1.isSelected())&&(!cb2.isSelected())&&(cb3.isSelected())) {
                    messageLabel.setText("Today is clear sky with a temperature of " +value+ " °F");
                    imageW.setImage("./images/clear.png");
                }
            
                else if((!cb1.isSelected())&&(cb2.isSelected())&&(!cb3.isSelected())) {
                    messageLabel.setText("Tonight is clear sky with a temperature of " +value+ " °C");
                    imageW.setImage("./images/clear_night.png");                
                }
            
                else if((!cb1.isSelected())&&(!cb2.isSelected())&&(!cb3.isSelected())) {
                    messageLabel.setText("Today is clear sky with a temperature of " +value+ " °C");
                    imageW.setImage("./images/clear.png");    
                }
            }   
        });

        todayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imageW.setImage("./images/raining.png");
                messageLabel.setText("Today is raining with a temperature of 10.0 °C");
                inputDegrees.setText("10");
                if(!cb1.isSelected()) {
                    cb1.doClick(0);
                }
                if(cb2.isSelected()) {
                    cb2.doClick(0);
                }
                if(cb3.isSelected()) {
                    cb3.doClick(0);
                }
            } 
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        inputDegrees = new javax.swing.JTextField();
        degreesLabel = new javax.swing.JLabel();
        cb1 = new javax.swing.JCheckBox();
        cb2 = new javax.swing.JCheckBox();
        cb3 = new javax.swing.JCheckBox();
        precipitationsLabel = new javax.swing.JLabel();
        nightLabel = new javax.swing.JLabel();
        fahrenheitLabel = new javax.swing.JLabel();
        seticonButton = new javax.swing.JButton();
        todayButton = new javax.swing.JButton();
        imageW = new weatherforecast.ImagePanel();
        messageLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        overrideItem = new javax.swing.JMenuItem();
        quitItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Weather Forecast");

        degreesLabel.setText("Degrees");

        precipitationsLabel.setText("Precipitations?");

        nightLabel.setText("Night?");

        fahrenheitLabel.setText("Fahrenheit?");

        seticonButton.setText("Set Icon");

        todayButton.setText("Today's weather");

        javax.swing.GroupLayout imageWLayout = new javax.swing.GroupLayout(imageW);
        imageW.setLayout(imageWLayout);
        imageWLayout.setHorizontalGroup(
            imageWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );
        imageWLayout.setVerticalGroup(
            imageWLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );

        messageLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMenu1.setText("File");

        overrideItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        overrideItem.setText("Override");
        jMenu1.add(overrideItem);

        quitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        quitItem.setText("Quit");
        jMenu1.add(quitItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cb1)
                                .addComponent(inputDegrees, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nightLabel)
                            .addComponent(degreesLabel)
                            .addComponent(precipitationsLabel)
                            .addComponent(fahrenheitLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imageW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(seticonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(todayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputDegrees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(degreesLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb1)
                            .addComponent(precipitationsLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb2)
                            .addComponent(nightLabel))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fahrenheitLabel)
                            .addComponent(cb3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(imageW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seticonButton)
                    .addComponent(todayButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(messageLabel)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(WeatherForecast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherForecast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherForecast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherForecast.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherForecast().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb1;
    private javax.swing.JCheckBox cb2;
    private javax.swing.JCheckBox cb3;
    private javax.swing.JLabel degreesLabel;
    private javax.swing.JLabel fahrenheitLabel;
    private weatherforecast.ImagePanel imageW;
    private javax.swing.JTextField inputDegrees;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel nightLabel;
    private javax.swing.JMenuItem overrideItem;
    private javax.swing.JLabel precipitationsLabel;
    private javax.swing.JMenuItem quitItem;
    private javax.swing.JButton seticonButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton todayButton;
    // End of variables declaration//GEN-END:variables
}