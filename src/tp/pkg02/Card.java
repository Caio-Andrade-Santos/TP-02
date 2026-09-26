package tp.pkg02;

import java.awt.*;
import javax.swing.*;

public class Card extends JFrame {

    public Card() {
        // Configurações da Janela conforme a imagem
        setTitle("TP02 - LP214"); //[cite: 1]
        setSize(400, 180);        //[cite: 1]
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout principal para receber os dois painéis
        setLayout(new BorderLayout());

        // --- 1. Painel Superior (Formulário) ---
        JPanel painelSuperior = new JPanel();
        // Grid Layout (3x2) com hgap e vgap de 10
        painelSuperior.setLayout(new GridLayout(3, 2, 10, 10)); //[cite: 1]

        // Usando JLabel e JTextField (Swing) em vez de Label e TextField (AWT)
        JLabel labelNome = new JLabel("Nome:");
        JTextField inputNome = new JTextField();

        JLabel labelIdade = new JLabel("Idade:");
        JTextField inputIdade = new JTextField();

        JLabel labelEndereco = new JLabel("Endereço:");
        JTextField inputEndereco = new JTextField();

        // Adicionando na ordem correta da imagem (Nome, Idade, Endereço)
        painelSuperior.add(labelNome);
        painelSuperior.add(inputNome);

        painelSuperior.add(labelIdade);
        painelSuperior.add(inputIdade);

        painelSuperior.add(labelEndereco);
        painelSuperior.add(inputEndereco);

        // --- 2. Painel Inferior (Botões) ---
        JPanel painelInferior = new JPanel();
        // GridLayout com 4 botões na horizontal
        painelInferior.setLayout(new GridLayout(1, 4)); //[cite: 1]

        JButton botaoOK = new JButton("Ok");
        JButton botaoLimpar = new JButton("Limpar");
        JButton botaoMostrar = new JButton("Mostrar");
        JButton botaoSair = new JButton("Sair");

        painelInferior.add(botaoOK);
        painelInferior.add(botaoLimpar);
        painelInferior.add(botaoMostrar);
        painelInferior.add(botaoSair);

        // --- 3. Posicionar os painéis na Janela Principal ---
        add(painelSuperior, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        botaoOK.addActionListener(e -> {
            String nome = inputNome.getText();
            String endereco = inputEndereco.getText();

            // Tratamento simples caso o campo idade esteja vazio ou com texto inválido
            int idade = 0;
            try {
                idade = Integer.parseInt(inputIdade.getText());
            } catch (NumberFormatException ex) {
                System.out.println("Por favor, introduza uma idade válida.");
            }

            Aluno aluno = new Aluno(endereco, nome, idade);

        });

        botaoLimpar.addActionListener(e -> {
            inputNome.setText("");
            inputEndereco.setText("");
            inputIdade.setText("");
        });

        botaoMostrar.addActionListener(e -> {
            String mensagem = "";

            for (Aluno a : Aluno.alunos) {
                mensagem += "Nome: " + a.getNome() + "\n";
                mensagem += "ID: " + a.getUuid() + "\n";
                mensagem += "------------------\n";
            }

            if (mensagem.isEmpty()) {
                mensagem = "Nenhum aluno cadastrado.";
            }

            JOptionPane.showMessageDialog(this, mensagem);
        });

        botaoSair.addActionListener(e -> {
            dispose();
        });

        // --- Finalização da Janela ---
        setLocationRelativeTo(null); // Centraliza a janela no ecrã
        setVisible(true);
    }
}
