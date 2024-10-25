package apresentacao;

import Negocio.Medicamento;
import persistencia.ControlaMedicamento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;

public class DLMostarMedicamentos extends JDialog {
    private JPanel contentPane;
    private JButton btnEditar;
    private JButton buttonCancel;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    ControlaMedicamento cm;
    DefaultTableModel modeloTabela;

    public DLMostarMedicamentos(ControlaMedicamento cm) {
        String[] colunas = { "ID", "Nome", "Data de Fabricacao", "Data de Validade", "Principo Ativo" };
        modeloTabela = new DefaultTableModel(colunas, 0);

        for (Medicamento medicamentos : cm.mostrarMedicamentos()) {
            Object[] dadosMedicamentos = { medicamentos.getId(), medicamentos.getNome(),
                    medicamentos.getDataFabricacao().format(formatter), medicamentos.getDataValidade().format(formatter), medicamentos.getPrincipioAtivo() };
            modeloTabela.addRow(dadosMedicamentos);
        }

        JTable tabelaMedicamentos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaMedicamentos);
        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Medicamentos", JOptionPane.INFORMATION_MESSAGE);

    }
    public DLMostarMedicamentos() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnEditar);

        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }


        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        DLMostarMedicamentos dialog = new DLMostarMedicamentos();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
