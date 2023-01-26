package it.epicode.gestioneventi;

import java.time.LocalDate;

import it.epicode.gestioneventi.model.TipoEvento;
import it.epicode.gestioneventi.model.dao.EventoDAO;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventoDAO.save("Concerto1", LocalDate.parse("2023-01-23"), "Concerto di inizio anno1", TipoEvento.Pubblico, 1000);
		// EventoDAO.getById(1);
		//EventoDAO.removeById(1);
	}

}
