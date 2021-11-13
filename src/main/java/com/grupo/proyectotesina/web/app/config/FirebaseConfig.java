package com.grupo.proyectotesina.web.app.config;
import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

/********CONFIGURACION FIREBASE****************************************************************************
 * @author Luis Muñoz Guerra 																*
 * @since 20/10/2021	  																	*
 * @version 1.0																				*	
*********************************************************************************************/

@Service
public class FirebaseConfig {

	@PostConstruct
	public void initialize() {
		try {
		FileInputStream serviceAccount =
		  new FileInputStream("./proyectotesis-e20af-firebase-adminsdk-3cpr0-81297fd628.json");
		FirebaseOptions options = FirebaseOptions.builder()
		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		  .build();
		FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
