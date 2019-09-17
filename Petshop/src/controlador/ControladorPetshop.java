/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoPetshop;
import javax.swing.JOptionPane;
import modelo.Petshop;
import tela.manutencao.ManutencaoPetshop;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrador
 */
public class ControladorPetshop {
    public static void inserir(ManutencaoPetshop man){
        Petshop objeto = new Petshop();
        objeto.setNome(man.jtfNome.getText());
        objeto.setEndereco(man.jtfEndereco.getText());
        objeto.setNumero(Integer.parseInt(man.jtfNumero.getText()));
        objeto.setAvaliacao(Integer.parseInt(man.jtfAvaliacao.getText()));
        
        boolean resultado = DaoPetshop.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Endereco");
        modelo.addColumn("Numero");
        modelo.addColumn("Avaliacao");
        List<Petshop> resultados = DaoPetshop.consultar();
        for (Petshop objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getEndereco());
            linha.add(objeto.getNumero());
            linha.add(objeto.getAvaliacao());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }

    public static void alterar(ManutencaoPetshop aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void alterar(ManutencaoPetshop man){
        Petshop objeto = new Petshop();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome(man.jtfNome.getText());
        objeto.setEndereco(man.jtfEndereco.getText());
        objeto.setNumero(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setAvaliacao(Integer.parseInt(man.jtfCodigo.getText()));
        boolean resultado = DaoPetshop.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}
