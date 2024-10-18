package apresentacao;

import Negocio.Medicamento;
import persistencia.ControlaMedicamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame{
    private JTextField TMedicamento;
    private JTextField TDataFabricacao;
    private JButton btnSalvar;
    private JButton btnLimpar;
    private JTextArea tResultado;
    private JPanel MainPanel;
    private JTextField TPrincipioAtivo;
    private JTextField TDataValidade;
    private JList Jlist1;
    private JButton mostrarTudoButton;

    ControlaMedicamento cm = new ControlaMedicamento();
//    DefaultListModel model = new DefaultListModel();

    public void limparCampos(){
        TMedicamento.setText("");
        TPrincipioAtivo.setText("");
        TDataFabricacao.setText("");
        TDataValidade.setText("");
        TMedicamento.requestFocus();
    }

    public Principal(){
        setContentPane(MainPanel);
        setTitle("Cadastro de Medicamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700,400);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 if ((!"".equals(TMedicamento.getText())) && (!"".equals(TPrincipioAtivo.getText())) && (!"".equals(TDataFabricacao.getText())) && (!"".equals(TDataValidade.getText()))) {
                     Medicamento medicamento = new Medicamento();

                     medicamento.setNome(TMedicamento.getText());
                     medicamento.setPrincipioAtivo(TPrincipioAtivo.getText());
                     medicamento.setDataFabricacao(TDataFabricacao.getText());
                     medicamento.setDataValidade(TDataValidade.getText());

                     if(cm.addMedicamento(medicamento)){
                         JOptionPane.showMessageDialog(null, "Medicamento cadastrado com sucesso!");
                         limparCampos();
                         tResultado.setText(String.valueOf(cm.mostrarMedicamentos()));

                         /*model.addElement(String.valueOf(cm.mostrarMedicamentos()));

                         Jlist1.setModel(model);*/
                     }else {
                         JOptionPane.showMessageDialog(null, "Erro ao cadastrar medicamento!");
                         limparCampos();
                     }

                 } else {
                     JOptionPane.showMessageDialog(null, "Prenchimento Obrigatório dos campos!");
                     limparCampos();
                 }
            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        mostrarTudoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlMostrarTudo dlg =new dlMostrarTudo(cm);
                dlg.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        //new Principal();
    }
}
