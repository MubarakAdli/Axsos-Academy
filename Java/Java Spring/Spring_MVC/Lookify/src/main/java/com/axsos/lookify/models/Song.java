package com.axsos.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="songs")
public class Song {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 200,message="title must have atleast 5 charachter")
    private String title;
    @NotNull
    @Size(min = 5, max = 200,message="artist name must have atleast 5 charachter")
    private String artist;
    @NotNull
    @Min(1)
    @Max(10)
    private double rate;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	public Song() {
		
	}
	public Song(@NotNull @Size(min = 5, max = 200, message = "title must have atleast 5 charachter") String title,
			@NotNull @Size(min = 5, max = 200, message = "artist name must have atleast 5 charachter") String artist,
			@NotNull @Min(value = 1, message = "must be atleast one") double rate) {
		
		this.title = title;
		this.artist = artist;
		this.rate = rate;
	}
	
	
	   public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
    
    
}


