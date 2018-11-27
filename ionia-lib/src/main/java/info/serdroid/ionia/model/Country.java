package info.serdroid.ionia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY")
public class Country implements Serializable {
	private static final long serialVersionUID = -8395328771788885191L;

	private short id;
    private String name;
    private String alpha2Code;
    private String alpha3Code;
    private String m49Code;
    private String phoneCode;

    public Country() {}
    
    public Country(short id, String name, String alpha2Code, String alpha3Code, String m49Code, String phoneCode) {
        this.id = id;
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.m49Code = m49Code;
        this.phoneCode = phoneCode;
    }

    @Id
    @Column(name="ID")
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="ALPHA2CODE")
    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    @Column(name="ALPHA3CODE")
    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    @Column(name="M49CODE")
    public String getM49Code() {
        return m49Code;
    }

    public void setM49Code(String m49Code) {
        this.m49Code = m49Code;
    }

    @Column(name="PHONECODE")
    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", alpha3Code=" + alpha3Code + ", phoneCode=" + phoneCode + "]";
	}

}
