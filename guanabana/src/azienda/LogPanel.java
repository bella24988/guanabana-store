package azienda;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LogPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private LogControllerAzienda logControllerAzienda;
	private JTextArea txtErrore;

	/**
	 * Create the frame.
	 */
	public LogPanel() {
		setLogControllerAzienda(new LogControllerAzienda(this));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 221, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblUser = new JLabel("User:");
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.EAST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 1;
		gbc_lblUser.gridy = 1;
		contentPane.add(lblUser, gbc_lblUser);

		txtUser = new JTextField();
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.insets = new Insets(0, 0, 5, 0);
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.gridx = 2;
		gbc_txtUser.gridy = 1;
		contentPane.add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 2;
		contentPane.add(lblPassword, gbc_lblPassword);

		txtPassword = new JPasswordField();
		GridBagConstraints gbc_pwdTxtpassword = new GridBagConstraints();
		gbc_pwdTxtpassword.insets = new Insets(0, 0, 5, 0);
		gbc_pwdTxtpassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdTxtpassword.gridx = 2;
		gbc_pwdTxtpassword.gridy = 2;
		contentPane.add(txtPassword, gbc_pwdTxtpassword);
		txtPassword.addKeyListener(logControllerAzienda);

		JButton btnEntra = new JButton("Entra");
		btnEntra.setBackground(Color.WHITE);
		//btnEntra.setIcon(new ImageIcon(LogPanel.class.getResource("/icons/login_icon1.gif")));
		GridBagConstraints gbc_btnEntra = new GridBagConstraints();
		gbc_btnEntra.insets = new Insets(0, 0, 5, 0);
		gbc_btnEntra.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEntra.gridwidth = 2;
		gbc_btnEntra.gridx = 1;
		gbc_btnEntra.gridy = 3;
		contentPane.add(btnEntra, gbc_btnEntra);
		btnEntra.addActionListener(logControllerAzienda);

		txtErrore = new JTextArea();
		txtErrore.setForeground(Color.RED);
		txtErrore.setBackground(UIManager.getColor("Panel.background"));
		txtErrore.setEditable(false);
		GridBagConstraints gbc_txtErrore = new GridBagConstraints();
		gbc_txtErrore.gridwidth = 2;
		gbc_txtErrore.insets = new Insets(0, 0, 0, 5);
		gbc_txtErrore.fill = GridBagConstraints.BOTH;
		gbc_txtErrore.gridx = 1;
		gbc_txtErrore.gridy = 4;
		contentPane.add(txtErrore, gbc_txtErrore);
	}

	/**
	 * Getter of the property <tt>logControllerAzienda</tt>
	 * 
	 * @return Returns the controllerAzienda.
	 * @uml.property name="logControllerAzienda"
	 */
	public LogControllerAzienda getLogControllerAzienda() {
		return logControllerAzienda;
	}

	/**
	 * Setter of the property <tt>logControllerAzienda</tt>
	 * 
	 * @param logControllerAzienda
	 *            The controllerAzienda to set.
	 * @uml.property name="logControllerAzienda"
	 */
	public void setLogControllerAzienda(
			LogControllerAzienda logControllerAzienda) {
		this.logControllerAzienda = logControllerAzienda;
	}

	public String getTxtUser() {
		return txtUser.getText();
	}

	public void setTxtUser(String txtUser) {
		this.txtUser.setText(txtUser);
	}

	public char[] getTxtPassword() {
		return txtPassword.getPassword();
	}

	public void setTxtPassword(String txtPassword) {
		this.txtPassword.setText(txtPassword);
	}

	public String getTxtErrore() {
		return txtErrore.getText();
	}

	public void setTxtErrore(String txtErrore) {
		this.txtErrore.setText(txtErrore);
	}

}
