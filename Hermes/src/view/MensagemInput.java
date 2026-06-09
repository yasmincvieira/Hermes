package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;

public class MensagemInput extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnOk;
    private JButton btnCancelar;
    private JLabel lblMensagem;
    private JTextField tfInput;
    private String resultado = null;
    private boolean fechou = false;

    public MensagemInput(String mensagem, String titulo) {
        setTitle(titulo);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 254);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(203, 228, 221));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblMensagem = new JLabel("<html><div style='text-align: center;'>" + mensagem + "</div></html>");
        lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblMensagem.setForeground(new Color(39, 79, 65));
        lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblMensagem.setBounds(10, 10, 414, 80);
        contentPane.add(lblMensagem);

        tfInput = new JTextField();
        tfInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfInput.setBounds(94, 100, 252, 30);
        tfInput.setColumns(10);
        contentPane.add(tfInput);

        btnOk = new JButton("Ok");
        btnOk.setForeground(new Color(39, 79, 65));
        btnOk.setBackground(new Color(122, 188, 170));
        btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnOk.setBounds(94, 160, 100, 30);
        btnOk.setFocusPainted(false);
        btnOk.addActionListener((ActionEvent e) -> {
            resultado = tfInput.getText();
            fechou = true;
            dispose();
        });
        contentPane.add(btnOk);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setForeground(new Color(39, 79, 65));
        btnCancelar.setBackground(new Color(122, 188, 170));
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnCancelar.setBounds(229, 160, 117, 30);
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener((ActionEvent e) -> {
            resultado = null;
            fechou = true;
            dispose();
        });
        contentPane.add(btnCancelar);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent e) {
                fechou = true;
            }
        });
    }

    public String getResultado() {
        return resultado;
    }

    public static String mostrarInput(String mensagem, String titulo) {
        final String[] resultado = {null};
        final boolean[] fechou = {false};

        SwingUtilities.invokeLater(() -> {
            MensagemInput frame = new MensagemInput(mensagem, titulo);
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent e) {
                    resultado[0] = frame.getResultado();
                    synchronized (fechou) {
                        fechou[0] = true;
                        fechou.notifyAll();
                    }
                }
            });
            frame.setVisible(true);
        });

        synchronized (fechou) {
            while (!fechou[0]) {
                try {
                    fechou.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultado[0];
    }
}