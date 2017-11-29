package nhomabc;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import org.codehaus.jackson.map.ObjectMapper;

public class chatabc extends javax.swing.JFrame {

    public static String CURRENT_USER;
    final private DefaultListModel listModel = new DefaultListModel();
    final private HashMap<String, String> mapContent = new HashMap<>();
    public chatabc() {
        initComponents();
        CURRENT_USER = LoginFrame.USER_NAME;
        lblUsername.setText(CURRENT_USER);
        lstFriends.setModel(listModel);
        getAndDisplayUser();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstFriends = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        txtChat = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lblReceiver = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstFriends.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFriendsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstFriends);

        jTextArea1.setColumns(30);
        jTextArea1.setRows(6);
        jScrollPane2.setViewportView(jTextArea1);

        txtContent.setColumns(30);
        txtContent.setRows(6);
        jScrollPane3.setViewportView(txtContent);

        btnSend.setText("Gửi");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Chat ABC");

        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);


        jButton3.setText("Nhận");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSend)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(48, 48, 48)
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblUsername))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(lblReceiver)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblReceiver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsername)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSend)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void lstFriendsValueChanged(javax.swing.event.ListSelectionEvent evt) {
     
        String content = txtContent.getText();
        String s = lblReceiver.getText();
        mapContent.put(s, content);
        
        if (!evt.getValueIsAdjusting()){
            JList source = (JList)evt.getSource();
            String selected = source.getSelectedValue().toString();
            lblReceiver.setText(selected);
            txtContent.setText(mapContent.get(selected));
        }
    }

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {
        String s = txtChat.getText();
        if(s.length()>0){
            try{
                MyMessage m = new MyMessage();
                m.sender = CURRENT_USER;
                m.receiver= lblReceiver.getText().trim();
                m.type="chat";
                m.content = s;
                ChatClient client = new ChatClient();
                MyMessage r = client.sendMessage(m);
                if (r.content.equalsIgnoreCase("ok")){
                    txtContent.append(CURRENT_USER + ": " + s + "\n");
                    txtChat.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
           
            txtChat.setText("");
        }
      
        
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
    
        try{
            MyMessage m = new MyMessage();
            m.sender = CURRENT_USER;
            m.receiver = "server";
            m.type = "getmessages";
            m.content = lblReceiver.getText().trim();
            ChatClient client = new ChatClient();
            MyMessage r = client.sendMessage(m);
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<String> b = mapper.readValue(r.content, ArrayList.class);
            for (String s:b){
                txtContent.append(m.content + ": " + s + "\n");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(chatabc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chatabc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chatabc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chatabc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chatabc().setVisible(true);
            }
        });
    }
    private javax.swing.JButton btnSend;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblReceiver;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JList lstFriends;
    private javax.swing.JTextField txtChat;
    private javax.swing.JTextArea txtContent;
    private void getAndDisplayUser(){
        try{
            MyMessage m = new MyMessage();
            m.sender = CURRENT_USER;
            m.receiver = "server";
            m.type = "getusers";
            ChatClient client = new ChatClient();
            MyMessage r = client.sendMessage(m);
            
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<String> b = mapper.readValue(r.content, ArrayList.class);
            for (int i=0; i<b.size(); i++){
                String s = b.get(i);
                listModel.addElement(s);
                mapContent.put(s, "");
                if (i == 0){
                    lblReceiver.setText(s);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
