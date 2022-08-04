package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
		this.patientNotes = new ArrayList<String>();
	}
	
    // TO DO: Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {
		String stringPin = String.valueOf(pin);
		if(stringPin.length() != 4) {
			return false;
		} else {
			this.pin = pin;
			return true;			
		}
	}
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		String stringID = String.valueOf(this.id);
		String confirmAuthIDAsString = String.valueOf(confirmedAuthID);
		if(stringID.equals(confirmAuthIDAsString)) {
			return true;			
		} else {
			return false;
		}
	}
	
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    
    // TO DO: Setters & Getters
    public ArrayList<String> getPatientNotes() {
    	return patientNotes;
    }
    
    public void setPatientNotes(ArrayList<String> patientNotes) {
    	this.patientNotes = patientNotes;
    }
    
}
