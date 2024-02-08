package com.example.Trips.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@DiscriminatorValue("PREMIUM_USER") // La valeur correspondant à cette classe
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PremiumUser extends User {
    private Date datestart;
    private Date dateend;
}
