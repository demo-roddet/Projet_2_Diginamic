package fr.diginamic.projet.Entity;

import fr.diginamic.projet.Entity.Enumeration.StatutType;
import fr.diginamic.projet.Exception.AbsenceException;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("conge_anticipe")
public class CongeAnticipe extends AbsenceChoisie {

    public CongeAnticipe() throws AbsenceException {
    }

    public CongeAnticipe(LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(dateDebut, dateFin, motif);
    }

    public CongeAnticipe(StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(statut, dateDebut, dateFin, motif);
    }

    public CongeAnticipe(Long id, StatutType statut, LocalDate dateDebut, LocalDate dateFin, String motif) throws AbsenceException {
        super(id, statut, dateDebut, dateFin, motif);
    }


    @Override
    public String toString() {
        return "CongeAnticipe{" +
                "statut=" + statut +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", motif='" + motif + '\'' +
                ", id=" + id +
                '}';
    }
}
