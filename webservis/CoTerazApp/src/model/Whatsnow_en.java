package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the Whatsnow_en database table.
 * 
 */
@Entity
@NamedQueries(value = { @NamedQuery(name = "Whatsnow_en.findAll", query = "SELECT w FROM Whatsnow_en w"),
						@NamedQuery(name = "Whatsnow_en.findByType", query = "SELECT w FROM Whatsnow_en w WHERE  w.type=:type"),
						@NamedQuery(name = "Whatsnow_en.findById", query = "SELECT w FROM Whatsnow_en w WHERE  w.id=:id")
})
public class Whatsnow_en implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String adress;

	private String info;

	private double lat;

	private double lng;

	@Column(name = "marker_icon")
	private String markerIcon;

	private String name;

	private String phone;

	private int rating;

	private String type;

	private String www;

	@Column(name = "place_image ")
	private String placeImage;

	public Whatsnow_en() {
	}

	// ============
	public Whatsnow_en(int id, String name, String info, String markerIcon, double lat, double lng, int rating, String www,
			String adress, String phone, String type, String placeImage) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
		this.markerIcon = markerIcon;
		this.lat = lat;
		this.lng = lng;
		this.rating = rating;
		this.www = www;
		this.adress = adress;
		this.phone = phone;
		this.type = type;
		this.placeImage = placeImage;
	}
	// ============

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return this.lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getMarkerIcon() {
		return this.markerIcon;
	}

	public void setMarkerIcon(String markerIcon) {
		this.markerIcon = markerIcon;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWww() {
		return this.www;
	}

	public void setWww(String www) {
		this.www = www;
	}

	public String getPlaceImage() {
		return placeImage;
	}

	public void setPlaceImage(String placeImage) {
		this.placeImage = placeImage;
	}

}