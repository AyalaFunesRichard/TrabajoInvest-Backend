package com.grupo.proyectotesina.web.app.controlador;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.gson.Gson;
import com.grupo.proyectotesina.web.app.modelo.Cronograma;
import com.grupo.proyectotesina.web.app.service.FirebaseService;

/********REST CONTROLLER****************************************************************************
 * @author Luis Muñoz Guerra 																*
 * @since 20/10/2021	  																	*
 * @version 1.0																				*	
*********************************************************************************************/

@RestController
@CrossOrigin(origins = "*")
public class RestCronograma {

	 @Autowired
	 FirebaseService firebaseServices;
	 
	 @GetMapping("/getCronogramaDetail") 
	 public Cronograma getCronograma(@RequestHeader() String Id_Cronograma) throws InterruptedException, ExecutionException{ 
		 return firebaseServices.getCronogramaDeatils(Id_Cronograma);}
	 
	 @GetMapping("/getListaDetalle") 
	 public List<Cronograma> getAllDocument()throws InterruptedException, ExecutionException{	 
		return firebaseServices.getAllDocuments(); 
	 }

	 @PostMapping("/postCronograma") 
	 public String postCronograma(@RequestBody String crono) throws InterruptedException, ExecutionException{ 
		
		// System.out.print("\n\n\njson\n");
		// 		 System.out.print(crono);
		 
		 Gson g = new Gson();
		 Cronograma newCrono = g.fromJson(crono, Cronograma.class);

		// System.out.print("\nCronograma\n");
		// System.out.print("\n" + newCrono.getId_Cronograma());
		// System.out.print("\n" + newCrono.getNombre_Tarea());
		// System.out.print("\n" + newCrono.getSemaforo());
		// System.out.print("\n" + newCrono.getFecha_Inicio());
		// System.out.print("\n" + newCrono.getFecha_Fin());
		 

		 return firebaseServices.saveCronogramaDetails(newCrono); 
	}
	 
	 @PutMapping("/updateCronograma")
	 public String putCronograma(@RequestBody Cronograma cronograma)throws InterruptedException, ExecutionException {
		return firebaseServices.updateUserDetails(cronograma);
	 }

	 @DeleteMapping("/deleteCronograma")
	 public String deleteCronograma(@RequestHeader String Id_Cronograma) throws InterruptedException, ExecutionException{
		return firebaseServices.deletedCronogramaDetails(Id_Cronograma);
	 }
	
}
