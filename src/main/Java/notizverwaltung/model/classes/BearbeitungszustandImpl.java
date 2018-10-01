package notizverwaltung.model.classes;

import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.validators.StringValidator;

import javax.persistence.*;

/**
 * Implementierung von Bearbeitungszustand
 *
 * @author Shenna RWP
 * @author Michelle Blau
 */
@Entity
@Table(name = "Bearbeitungszustand")
public class BearbeitungszustandImpl implements Bearbeitungszustand
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BearbeitungszustandID", nullable = false, unique = true)
	private int bearbeitungszustandID;

	@Column(name = "BearbeitungszustandName")
	private String nameDerSpalte;
	// Irgendwas stimmt mit der Position in der Datenbank nicht, bei Konstruktoraufruf MIT Position wird das Unique-Constraint verletzt
	//	@Column(name = "Position", unique = true)
	//	private int position;

	/**
	 * Konstruktor
	 * @param nameDerSpalte
	 * @throws StringIsEmptyException
	 */
	public BearbeitungszustandImpl(String nameDerSpalte) throws StringIsEmptyException {
		setName(nameDerSpalte);
	}

	public BearbeitungszustandImpl() {}

	/**
	 * getter-Methode für ID der Bearbeitungszustand
	 * @return ID der Bearbeitungszustand
	 */
	@Override
	public int getBearbeitungsZustandID() {
		return bearbeitungszustandID;
	}

	/**
	 * Setter-Methode ID der Bearbeitungszustand
	 * @param bearbeitungszustandID
	 */

	@Override
	public void setBearbeitungszustandID(int bearbeitungszustandID) {
		this.bearbeitungszustandID = bearbeitungszustandID;
	}

	/**
	 * getter-Methode für die Name der Spalte von Bearbeitungszustand
	 * @return die Name der Spalte von Bearbeitungszustand
	 */
	@Override
	public String getName()  {
		return nameDerSpalte;
	}

	/**
	 * setter-Methode für die Name der Spalte von Bearbeitungszustand
	 * @param nameDerSpalte
	 * @throws StringIsEmptyException
	 */
	@Override
	public void setName(String nameDerSpalte) throws StringIsEmptyException {
		StringValidator.checkObStringLeerOderNullIst(nameDerSpalte);
		this.nameDerSpalte = nameDerSpalte;
	}

	/**
	 * getter-Methode für Position von Bearbeitungszustand
	 * @return
	 */
	@Override
	public int getPosition() {
//		return position;
		return 0;
	}

	/**
	 * setter-Methode für Position von Bearbeitungszustand
	 * @param position
	 */
	@Override
	public void setPosition(int position) {
//		this.position = position;
	}

	/**
	 * Bearbeitungszustände sind gleich, wenn sie die gleiche ID haben
	 * Vergleicht 2 Bearbeitungszustände
	 * @param object zu vergleichender Bearbeitungszustand
	 * @return true, wenn Zustände gleich, sonst false
	 * @author Michelle Blau
	 */
	@Override
	public boolean equals(Object object){
		if (object instanceof BearbeitungszustandImpl){
			BearbeitungszustandImpl vergleichsZustand = (BearbeitungszustandImpl) object;

			if (this.bearbeitungszustandID == vergleichsZustand.getBearbeitungsZustandID()){
				return true;
			}
		}
		return false;
	}


	/**
	 * toString-Methode
	 * @return Name der Bearbeitungszustand
	 */
	@Override
	public String toString() {
		return getName();
	}

}
