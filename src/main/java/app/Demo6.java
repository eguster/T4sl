package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Productos;

public class Demo6 {
	// Listado0 de los Usuario.
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manager = fabrica.createEntityManager();
		
		// select * from tb_xxxx
		String sql = "select u from Productos u"; // jpa
		List<Productos> lstProductos = manager.createQuery(sql, Productos.class).getResultList();
		
		// recorre el listado y lo muestra
		for (Productos u : lstProductos) {
			System.out.println("Código....: " + u.getId_prod());
			System.out.println("descripcion....: " + u.getDes_prod());
			System.out.println("Stock......: " + u.getStk_prod() + " /" + u.getIdcategoria());
			System.out.println("precio....: " + u.getPre_prod());
			System.out.println("estado producto....: " + u.getEst_prod()+ " /" + u.getIdproveedor());
			System.out.println("............................");
		}
		
		manager.close();
	}
}
