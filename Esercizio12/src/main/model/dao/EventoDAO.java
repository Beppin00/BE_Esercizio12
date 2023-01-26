package it.epicode.gestioneventi.model.dao;

import java.time.LocalDate;

import it.epicode.gestioneventi.model.Evento;
import it.epicode.gestioneventi.model.TipoEvento;
import it.epicode.gestioneventi.utils.JpaUtil;

public class EventoDAO {
	public static void save(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti) {
		try {
			Evento ev = new Evento();
			ev.setTitolo(titolo);
			ev.setDataEvento(dataEvento);
			ev.setDescrizione(descrizione);
			ev.setTipoEvento(TipoEvento.Pubblico);
			ev.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);

			JpaUtil.t.begin();
			JpaUtil.em.persist(ev);
			JpaUtil.t.commit();

			System.out.println("Evento aggiunto correttamente!");

		} catch (Exception e) {
			System.out.println("Errore nell'aggiunta dell'evento!");
		} finally {
			JpaUtil.em.close();
		}
	}

	public static void getById(int id) {
		Evento ev = JpaUtil.em.find(Evento.class, id);
		
		if ( ev == null) {
			System.out.println("Levento con id " + id + " non esiste.");
			return;
		}
		System.out.println("Dati evento #" + id);
		System.out.printf("Titolo: %s | Data evento: %s | Descrizione: %s | Tipo Evento: %s | Numero massimo di partecipanti %d", 
				ev.getTitolo(), ev.getDataEvento(), ev.getDescrizione(), ev.getTipoEvento(), ev.getNumeroMassimoPartecipanti());
	}
	
	public static void removeById(int id) {
		Evento ev = JpaUtil.em.find(Evento.class, id);
		
		if ( ev == null) {
			System.out.println("Levento con id " + id + " non esiste.");
			return;
		}
		System.out.println("Elimo L'evento con id #" + id);
		System.out.printf("Titolo: %s | Data evento: %s | Descrizione: %s | Tipo Evento: %s | Numero massimo di partecipanti %d%n", 
				ev.getTitolo(), ev.getDataEvento(), ev.getDescrizione(), ev.getTipoEvento(), ev.getNumeroMassimoPartecipanti());
		
		JpaUtil.t.begin();
		
		JpaUtil.em.remove(ev);
		
		JpaUtil.t.commit();
	}
}
