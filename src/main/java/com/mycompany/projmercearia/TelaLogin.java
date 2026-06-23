import javax.swing.*;


public class TelaLogin extends JFrame{


JTextField login = new JTextField();
JPasswordField senha = new JPasswordField();

JButton entrar = new JButton("Entrar");


public TelaLogin(){


setTitle("Sistema Mercearia");

setSize(300,200);

setLayout(null);



login.setBounds(50,30,200,30);
senha.setBounds(50,70,200,30);
entrar.setBounds(90,120,100,30);



add(login);
add(senha);
add(entrar);



setDefaultCloseOperation(EXIT_ON_CLOSE);

setVisible(true);


}


}
