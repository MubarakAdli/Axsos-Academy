package com.axsos.abstractart;

public class Museum {

	public static void main(String[] args) {
		Painting paint=new Painting("mubarak","ahmed","hello world!","oil");
		paint.viewArt();
		Sculpture sculpture=new Sculpture("mubarak","ahmed","hello world!","soil");
		sculpture.viewArt();
	}

}
