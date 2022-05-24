/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Message;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import connection.clientExecute;
import java.awt.Color;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admins
 */
public class Client extends javax.swing.JFrame implements Runnable{
    private final clientExecute client;
    private int mouseX,mouseY;
    private Message message = new Message();
    private boolean isRunning = false;
    private Thread thread;
    /**
     * Creates new form Client
     */
    public Client(String name, int port, clientExecute client) {
        initComponents();
        Addcomponent();
        lbNameInput.setText(name);
        lbPortInput.setText(String.valueOf(port));
        this.setLocationRelativeTo(null);
        this.client=client;
        setResizable(false);
        isRunning=true;
        thread=new Thread(this);
        thread.start();
    }

    private void Addcomponent(){
        getRootPane().setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        txtMesDisplay.setEditable(false);
        txtMesDisplay.setLineWrap(true);
        txtMesInput.setLineWrap(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnMinimize = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbTittle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        lbPort = new javax.swing.JLabel();
        lbPortInput = new javax.swing.JLabel();
        lbNameInput = new javax.swing.JLabel();
        lbConnect = new javax.swing.JLabel();
        lbConnectInput = new javax.swing.JLabel();
        txtFindInput = new javax.swing.JTextField();
        lbFind = new javax.swing.JLabel();
        btnRandom = new javax.swing.JButton();
        btnCheck = new javax.swing.JButton();
        btnDisconnect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMesDisplay = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        btnSend = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMesInput = new javax.swing.JTextArea();
        btnAddWait = new javax.swing.JButton();
        btnLeaveWait = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnDeleteWait = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel3.setPreferredSize(new java.awt.Dimension(700, 800));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(700, 25));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        btnExit.setAlignmentY(0.0F);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize.png"))); // NOI18N
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        btnHelp.setBackground(new java.awt.Color(204, 255, 153));
        btnHelp.setFont(new java.awt.Font("Bw Surco Black", 3, 11)); // NOI18N
        btnHelp.setText("?");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(btnHelp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 603, Short.MAX_VALUE)
                .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
            .addComponent(btnHelp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 30));

        jPanel1.setBackground(new java.awt.Color(255, 225, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255), 3));
        jPanel1.setForeground(new java.awt.Color(255, 225, 255));

        lbTittle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbTittle.setText("TÌM BẠN BỐN PHƯƠNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbTittle)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTittle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 70));

        jPanel2.setBackground(new java.awt.Color(255, 225, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 255), 2));
        jPanel2.setForeground(new java.awt.Color(240, 240, 240));

        lbName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbName.setText("Nickname:");

        lbPort.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPort.setText("Cổng kết nối:");

        lbPortInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbPortInput.setText("NULL");

        lbNameInput.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbNameInput.setText("jLabel5");

        lbConnect.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbConnect.setText("Kết nối với:");

        lbConnectInput.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txtFindInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbFind.setText("Tìm nickname:");

        btnRandom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRandom.setText("Gợi ý kết nối");
        btnRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandomActionPerformed(evt);
            }
        });

        btnCheck.setText("Tìm kiếm");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        btnDisconnect.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDisconnect.setText("Hủy kết nối");
        btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisconnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lbConnect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbConnectInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(lbPort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPortInput, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbFind, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtFindInput, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnRandom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbName)
                        .addComponent(lbNameInput)
                        .addComponent(lbConnect)
                        .addComponent(lbPort, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbPortInput))
                    .addComponent(lbConnectInput, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbFind)
                        .addComponent(txtFindInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDisconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 640, 90));

        txtMesDisplay.setColumns(20);
        txtMesDisplay.setRows(5);
        jScrollPane1.setViewportView(txtMesDisplay);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 640, 380));

        jPanel4.setBackground(new java.awt.Color(200, 200, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(160, 160, 255), 3));

        btnSend.setText("Gửi");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtMesInput.setColumns(20);
        txtMesInput.setRows(5);
        jScrollPane2.setViewportView(txtMesInput);

        btnAddWait.setText("Vào danh sách chờ");
        btnAddWait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWaitActionPerformed(evt);
            }
        });

        btnLeaveWait.setText("Thoát danh sách chờ");
        btnLeaveWait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveWaitActionPerformed(evt);
            }
        });

        btnDelete.setText("Xóa tin nhắn");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnDeleteWait.setText("Xóa danh sách từ chối");
        btnDeleteWait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteWaitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAddWait, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeaveWait, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteWait, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAddWait, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnLeaveWait, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteWait, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 640, -1));

        Background.setBackground(new java.awt.Color(255, 225, 255));
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/name.png"))); // NOI18N
        jPanel3.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        if (txtFindInput.getText().equals("")) {
            JOptionPane.showMessageDialog(this,"Không được để trống nickname!","Lỗi",JOptionPane.ERROR_MESSAGE);
            return;
        }
        char[] t = txtFindInput.getText().toCharArray();
        if (t.length>24) {
            JOptionPane.showMessageDialog(this,"Nickname không được vượt quá 24 ký tự","Lỗi",JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (int i = 0; i<t.length; i++) {
            if (!(t[i]>64 && t[i]<91)&&!(t[i]==32)&&!(t[i]>96 && t[i]<123)&&!(t[i]>47 && t[i]<58)){
                JOptionPane.showMessageDialog(this,"Nickname chỉ được là số, chữ hoa, chữ thường và khoảng trắng!","Lỗi",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (txtFindInput.getText().equals(lbNameInput.getText())) {
            JOptionPane.showMessageDialog(this,"Nickname '" +txtFindInput.getText()+"' là chính bạn!");
            return;
        }
        Message mes = new Message("find",txtFindInput.getText());
        client.sendMessage(mes.exchangeJSON(mes));
        txtFindInput.setText("");
        System.out.println("Send option: "+mes.getOption()+" to server");
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandomActionPerformed
        if(!client.isConnected())
        {
            javax.swing.JOptionPane.showMessageDialog( this,
                    "Không thể kết nối đến server",
                    "Chương trình",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        else{
            Message mes = new Message("random","random");
            client.sendMessage(mes.exchangeJSON(mes));
            System.out.println("Send option: "+mes.getOption()+" to server");
        }
    }//GEN-LAST:event_btnRandomActionPerformed

    private void btnAddWaitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWaitActionPerformed
        int confirmExit = javax.swing.JOptionPane.showConfirmDialog(this, "Bạn có muốn vào danh sách chờ không?", "Danh sách chờ kết nối", javax.swing.JOptionPane.YES_NO_OPTION);
        if(confirmExit == javax.swing.JOptionPane.YES_OPTION){
                Message mes = new Message("joinWait",lbNameInput.getText());
                client.sendMessage(mes.exchangeJSON(mes));
                System.out.println("Send option: "+mes.getOption()+" to server");
        }
    }//GEN-LAST:event_btnAddWaitActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        try {
            if (!lbConnectInput.getText().equals("")){
                Message mes = new Message("send",txtMesInput.getText());
                client.sendMessage(mes.exchangeJSON(mes));
                System.out.println("Send option: "+mes.getOption()+" to server");
                LocalDateTime current = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
                String formatted = current.format(formatter);
                txtMesDisplay.append("*"+lbNameInput.getText()+"  -  "+formatted+"\n");
                txtMesDisplay.append("  "+mes.getMessage()+"\n\n");
            }
            else {
                JOptionPane.showMessageDialog(this, "Bạn chưa kết nối với tài khoản nào!","Lỗi",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtMesInput.setText("");
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int confirmExit = javax.swing.JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát?", "Chương trình", javax.swing.JOptionPane.YES_NO_OPTION);
        if(confirmExit == javax.swing.JOptionPane.YES_OPTION){
            Message mes = new Message("exit","0");
            client.sendMessage(mes.exchangeJSON(mes));
            System.out.println("Send option: "+mes.getOption()+" to server");
            client.close();
            this.dispose();
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        this.setState(javax.swing.JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        this.setLocation(this.getX() + evt.getX() - mouseX,this.getY() + evt.getY() - mouseY);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jPanel5MousePressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        txtMesDisplay.setText("");
        JOptionPane.showMessageDialog(this, "Đã xóa tất cả tin nhắn!");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnLeaveWaitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveWaitActionPerformed
        int confirmExit = javax.swing.JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát danh sách chờ?", "Danh sách chờ", javax.swing.JOptionPane.YES_NO_OPTION);
        if(confirmExit == javax.swing.JOptionPane.YES_OPTION){
            Message mes = new Message("leaveWait","");
            client.sendMessage(mes.exchangeJSON(mes));
            System.out.println("Send option: "+mes.getOption()+" to server");
        }
    }//GEN-LAST:event_btnLeaveWaitActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        help h = new help(this,true);
        h.setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisconnectActionPerformed
        if (!lbConnectInput.getText().equals("")){
            int confirmExit = javax.swing.JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn hủy kết nối hiện tại?", "Hủy kết nối", javax.swing.JOptionPane.YES_NO_OPTION);
            if(confirmExit == javax.swing.JOptionPane.YES_OPTION){
                Message mes = new Message("disconnect",lbConnectInput.getText());
                client.sendMessage(mes.exchangeJSON(mes));
                System.out.println("Send option: "+mes.getOption()+" to server");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Bạn chưa kết nối với tài khoản nào!","Lỗi",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDisconnectActionPerformed

    private void btnDeleteWaitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteWaitActionPerformed
        Message mes = new Message("deleteRefuse","");
        client.sendMessage(mes.exchangeJSON(mes));
        System.out.println("Send option: "+mes.getOption()+" to server");
    }//GEN-LAST:event_btnDeleteWaitActionPerformed
    
    public Message toMessage(String m) {
        Gson gson = new Gson();
        java.lang.reflect.Type objectType = new TypeToken<Message>(){}.getType();
        Message mes = gson.fromJson(m, objectType);
        return mes;
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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                clientExecute client1 = new clientExecute("127.0.0.1",5000);
                new Client("Minh3121Dominate",5000,client1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton btnAddWait;
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteWait;
    private javax.swing.JButton btnDisconnect;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnLeaveWait;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnRandom;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbConnect;
    private javax.swing.JLabel lbConnectInput;
    private javax.swing.JLabel lbFind;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNameInput;
    private javax.swing.JLabel lbPort;
    private javax.swing.JLabel lbPortInput;
    private javax.swing.JLabel lbTittle;
    private javax.swing.JTextField txtFindInput;
    private javax.swing.JTextArea txtMesDisplay;
    private javax.swing.JTextArea txtMesInput;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            while (isRunning) {
                message = toMessage(client.getMessage());
                handle(message);
            }
        }
        catch (Exception e){
            
        }   
    }
    private void handle (Message mes) {
        switch (mes.getOption()) {
            case "disconnect": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this,"Tài khoản nick name: '"+mes.getMessage()+"' đã hủy kết nối với bạn!");
                lbConnectInput.setText("");
                break;
            }
            case "disconnected": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this,"Đã hủy kết nối với tài khoản nick name: '"+mes.getMessage()+"' thành công!");
                lbConnectInput.setText("");
                break;
            }
            case "disconnectOut": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this,"Tài khoản nick name: '"+mes.getMessage()+"' đã thoát chương trình, liên kết bị hủy bỏ!");
                lbConnectInput.setText("");
                break;
            }
            case "joinWaitS": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Bạn đã vào danh sách chờ kết nối, mọi người có thể gửi lời mời kết nối tới bạn!");
                break;
            }
            case "joinWaitF": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Bạn đã ở trong danh sách chờ!","Danh sách chờ",JOptionPane.ERROR_MESSAGE);
                break;
            }
            case "randomS": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                int confirmExit = javax.swing.JOptionPane.showConfirmDialog(this, "Bạn có muốn kết nối với '"+mes.getMessage()+"' không?", "Kết nối", javax.swing.JOptionPane.YES_NO_OPTION);
                if(confirmExit == javax.swing.JOptionPane.YES_OPTION){
                    Message mess = new Message("connect",mes.getMessage());
                    client.sendMessage(mess.exchangeJSON(mess));
                    System.out.println("Send option: "+mess.getOption()+" to server");
                }
                else {
                    Message mess = new Message("addFuse",mes.getMessage());
                    client.sendMessage(mess.exchangeJSON(mess));
                    System.out.println("Send option: "+mess.getOption()+" to server");
                }
                break;
            }
            case "randomF": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Hiện không có ai trong danh sách chờ kết nối! Hoặc bạn đã từ chối tất cả");
                int confirmExit = javax.swing.JOptionPane.showConfirmDialog(this, "Bạn có muốn vào danh sách chờ không?", "Danh sách chờ kết nối", javax.swing.JOptionPane.YES_NO_OPTION);
                if(confirmExit == javax.swing.JOptionPane.YES_OPTION){
                    Message mess = new Message("joinWait",lbNameInput.getText());
                    client.sendMessage(mess.exchangeJSON(mess));
                    System.out.println("Send option: "+mess.getOption()+" to server");
                }
                break;
            }
            case "connectA": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                lbConnectInput.setText(mes.getMessage());
                JOptionPane.showMessageDialog(this, "Kết nối với '"+mes.getMessage()+"' thành công! 2 bạn có thể bắt đầu nhắn tin");
                txtMesDisplay.setText("");
                break;
            }
            case "connectD": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Đối phương đã từ chối kết nối với bạn!");
                break;
            }
            case "connectF": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Gửi yêu cầu kết nối thất bại! Tài khoản '"+mes.getMessage()+"' hiện không hoạt động");
                break;
            }
            case "wantConnect": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                int confirmExit = javax.swing.JOptionPane.showConfirmDialog(this, "Tài khoản nickname '"+mes.getMessage()+"' đang muốn kết nối với bạn. Đồng ý?", "Chờ kết nối", javax.swing.JOptionPane.YES_NO_OPTION);
                if(confirmExit == javax.swing.JOptionPane.YES_OPTION){
                    Message mess = new Message("acceptConnect",mes.getMessage());
                    client.sendMessage(mess.exchangeJSON(mess));
                    System.out.println("Send option: "+mess.getOption()+" to server");
                }
                else
                {
                    Message mess = new Message("denyConnect",mes.getMessage());
                    client.sendMessage(mess.exchangeJSON(mess));
                    System.out.println("Send option: "+mess.getOption()+" to server");
                }
                break;
            }
            case "leaveWaitS": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Đã rời khỏi danh sách chờ! Mọi người sẽ không gửi yêu cầu kết nối cho bạn được.");
                break;
            }
            case "leaveWaitF": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Bạn hiện không trong danh sách chờ!","danh sách chờ",JOptionPane.ERROR_MESSAGE);
                break;
            }
            case "receive": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                try {
                    LocalDateTime current = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
                    String formatted = current.format(formatter);
                    txtMesDisplay.append("*"+lbConnectInput.getText()+"  -  "+formatted+"\n");
                    txtMesDisplay.append("  "+mes.getMessage()+"\n\n");
                } catch (Exception e) {
                    Message mess= new Message("sendF",lbConnectInput.getText());
                    client.sendMessage(mess.exchangeJSON(mess));
                    System.out.println("Send option: "+mess.getOption()+" to server");
                }
                break;
            }
            case "sendF": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Gửi tin nhắn đến '"+mes.getMessage()+"' thất bại!");
                break;
            }
            case "deleteRefuseS": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Xóa danh sách từ chối thành công!");
                break;
            }
            case "deleteRefuseF": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Xóa danh sách từ chối thất bại!");
                break;
            }
            case "findS": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                int confirmExit = javax.swing.JOptionPane.showConfirmDialog(this, "Tài khoản nick name '"+mes.getMessage()+"' đang sẵn sàng kết nối. Bạn có muốn kết nối không?", "Kết nối", javax.swing.JOptionPane.YES_NO_OPTION);
                if(confirmExit == javax.swing.JOptionPane.YES_OPTION){
                    Message mess = new Message("connect",mes.getMessage());
                    client.sendMessage(mess.exchangeJSON(mess));
                    System.out.println("Send option: "+mess.getOption()+" to server");
                }
                else {
                    Message mess = new Message("addFuse",mes.getMessage());
                    client.sendMessage(mess.exchangeJSON(mess));
                    System.out.println("Send option: "+mess.getOption()+" to server");
                }
                break;
            }
            case "findD": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Tài khoản '"+mes.getMessage()+"' đang hoạt động nhưng đã từ chối kết nối với bạn!");
                break;
            }
            case "findF": {
                System.out.println("Receive option: "+mes.getOption()+" from server");
                JOptionPane.showMessageDialog(this, "Tài khoản '"+mes.getMessage()+"' không tồn tại hoặc đã thoát khỏi chương trình!");
                break;
            }    
            case "findB": {
                System.out.println("Receive option: " + mes.getOption() + " from server");
                JOptionPane.showMessageDialog(this, "Tài khoản '" + mes.getMessage() + "' đã kết nối với tài khoản khác!");
                break;
            }
            case "ConnectW": {
                System.out.println("Receive option: " + mes.getOption() + " from server");
                JOptionPane.showMessageDialog(this, "Tài khoản '" + mes.getMessage() + "' vừa gửi lời mời kết nối cho bạn!");
                break;
            }
        }
    }
}
