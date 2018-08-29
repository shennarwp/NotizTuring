package notizverwaltung.model.classes;

import notizverwaltung.exceptions.StringIsEmptyException;
import notizverwaltung.model.interfaces.Bearbeitungszustand;
import notizverwaltung.validators.StringValidator;

import javax.persistence.*;

/**
 * Implementierung von Bearbeitungszustand
 *
 * @author Shenna RWP
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

	@Column(name = "Position", unique = true)
	private int position;

	public BearbeitungszustandImpl(String nameDerSpalte) throws StringIsEmptyException {
		setName(nameDerSpalte);
	}

	public BearbeitungszustandImpl() {}

	@Override
	public int getBearbeitungsZustandID() {
		return bearbeitungszustandID;
	}

	@Override
	public void setBearbeitungszustandID(int bearbeitungszustandID) {
		this.bearbeitungszustandID = bearbeitungszustandID;
	}

	@Override
	public String getName()  {
		return nameDerSpalte;
	}

	@Override
	public void setName(String nameDerSpalte) throws StringIsEmptyException {
		StringValidator.checkObStringLeerOderNullIst(nameDerSpalte);
		this.nameDerSpalte = nameDerSpalte;
	}

	@Override
	public int getPosition() {
		return position;
	}

	@Override
	public void setPosition(int position) {
		this.position = position;
	}

}
