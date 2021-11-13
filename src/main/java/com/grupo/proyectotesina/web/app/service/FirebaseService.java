package com.grupo.proyectotesina.web.app.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.grupo.proyectotesina.web.app.modelo.Cronograma;

import java.util.ArrayList;
import java.util.List;

/********SERVICIO****************************************************************************
 * @author Luis Muñoz Guerra 																*
 * @since 20/10/2021	  																	*
 * @version 1.0																				*	
*********************************************************************************************/

@Service
public class FirebaseService {

	/**
	 * GRABA O GUARDA EL CRONOGRAMA EN FIREBASE
	 * @param crono
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	
	public String saveCronogramaDetails(Cronograma crono) throws InterruptedException, ExecutionException{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("cronograma").document(crono.getId_Cronograma()).set(crono);
		return collectionApiFuture.get().getUpdateTime().toString();
		
		
	}
	
	/**
	 * OBTIENE EL CRONOGRAMA DESDE FIREBASE COMO SALIDA
	 * @param id_cronogr
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	
	public Cronograma getCronogramaDeatils(String id_cronogr) throws InterruptedException, ExecutionException{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("cronograma").document(id_cronogr);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		
		DocumentSnapshot document = future.get();
		
		Cronograma cron = null ; 
		if(document.exists()) 
		{
			cron = document.toObject(Cronograma.class);
			return cron;
		}else 
		{
			return null;
		}
	}
	
	
	
	
	/**
	 * MODIFICA EL CRONOGRAMA Y LO ACTUALIZA A FIREBASE
	 * @param cronog
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	
	public String updateUserDetails(Cronograma cronog) throws InterruptedException, ExecutionException{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection("cronograma").document(cronog.getId_Cronograma()).set(cronog);
		return collectionApiFuture.get().getUpdateTime().toString();
		
	}
	/**
	 * OBTETIENE VARIOS DE DOCUMENTOS DE UNA COLECCIÓN
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public List<Cronograma> getAllDocuments() throws InterruptedException, ExecutionException{
		//asynchronously retrieve all documents
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> collectionApiFuture = dbFirestore.collection("cronograma").get();
		// future.get() blocks on response
		List<Cronograma> cronList = new ArrayList<Cronograma>();
		List<QueryDocumentSnapshot> documents = collectionApiFuture.get().getDocuments(); 
		for (QueryDocumentSnapshot document : documents) {
			Cronograma crono = document.toObject(Cronograma.class);
			cronList.add(crono);
			}					
			return cronList;
			
	}
	
	public String deletedCronogramaDetails(String id_crono) throws InterruptedException, ExecutionException
	{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection("cronograma").document(id_crono).delete();
		return "Documento con ID "+id_crono+" ha sido eliminado";
	}
}
