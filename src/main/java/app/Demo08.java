package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

public class Demo08 {
	// Listado0 de los Usuario segun un tipo
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manager = fabrica.createEntityManager();
		
		String usuario = JOptionPane.showInputDialog("Ingrese su Usuario");
		String clave = JOptionPane.showInputDialog("Ingrese su Clave");
		
		
		// select * from tb_xxxx
		String sql = "select u from Usuario u where" 
				+ " u.usr_usua = :xusr and cla_usua = :xcla"; // jpa
		
		try {
			Usuario u = 
			manager.createQuery(sql, Usuario.class).setParameter("xusr", usuario).setParameter("xcla", clave).getSingleResult();
			
				System.out.println("Código....: " + u.getCod_usua());
				System.out.println("Nombre....: " + u.getNom_usua() + " " + u.getApe_usua());
				System.out.println("Tipo......: " + u.getIdtipo() + " " + u.getObjTipo().getDescripcion());
				System.out.println("............................");
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Usuario o Clave son incorrectos");
		}
		
		manager.close();
	}
}
