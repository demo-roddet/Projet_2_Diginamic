package fr.diginamic.projet.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "salarie")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminant",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("salarie")
public class Salarie extends BasedEntity {

    @Column(name = "prenom", nullable = false)
    protected String prenom;

    @Column(name = "nom", nullable = false)
    protected String nom;

    @Column(name = "email", length = 100, nullable = false)
    protected String email;

    @Column(name = "date_naissance", nullable = false)
    protected LocalDate dateDeNaissance;

    @Column(name = "date_arrivee", nullable = false)
    protected LocalDate dateArrivee;

    @Column(name = "password_hashed", nullable = false)
    protected String password;


    @ManyToOne
    @JoinColumn(name = "id_service", referencedColumnName = "id", nullable = false)
    protected Departement departement;

    @OneToMany(mappedBy = "salaries")
    protected Set<Absence> absences = new HashSet<>();


    public Salarie(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement, Set<Absence> absences) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.dateArrivee = dateArrivee;
        this.password = password;
        this.departement = departement;
        this.absences = absences;
    }

    public Salarie() {
    }

    public Salarie(Long id, String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement) {
        super(id);
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.dateArrivee = dateArrivee;
        this.password = password;
        this.departement = departement;
    }

    public Salarie(String prenom, String nom, String email, LocalDate dateDeNaissance, LocalDate dateArrivee, String password, Departement departement) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.dateArrivee = dateArrivee;
        this.password = password;
        this.departement = departement;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(LocalDate dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public LocalDate getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(LocalDate dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public Set<Absence> getAbsences() {
        return absences;
    }

    public void setAbsences(Set<Absence> absences) {
        this.absences = absences;
    }

    public void addAbsence(Absence absence) {
        if (absence != null) {
            absence.setSalarie(this);
        }
    }

    public void removeAbsence(Absence absence) {
        if (absence != null) {
            absence.setSalarie(null);
        }
    }

    @Override
    public String toString() {
        return "Salarie{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", dateDeNaissance=" + dateDeNaissance +
                ", dateArrivee=" + dateArrivee +
                ", password='" + password + '\'' +
                ", service=" + departement +
                ", absences=" + absences +
                '}';
    }
}

