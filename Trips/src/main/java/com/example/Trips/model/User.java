package com.example.Trips.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Vous pouvez utiliser InheritanceType.TABLE_PER_CLASS ou InheritanceType.JOINED en fonction de vos besoins
//SINGLE_TABLE :
//Dans cette stratégie, toutes les classes de la hiérarchie sont mappées sur une seule table dans la base de données.
//////
//TABLE_PER_CLASS :
// Chaque classe de la hiérarchie est mappée sur une table distincte. Les tables des sous-classes ne contiennent que les champs spécifiques à cette sous-classe.
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@AllArgsConstructor
@NoArgsConstructor
public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    //@JsonManagedReference("UserSender_Msg")
    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Message> sentmessages = new ArrayList<>();
    //@JsonManagedReference("UserReceiver_Msg")
    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Message> receivedmessages = new ArrayList<>();
    @JsonManagedReference("User_Profile")
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profil profil;
    //@JsonManagedReference("Trip_User")
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Trip> trips = new ArrayList<>();
    @JsonManagedReference("User_Item")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Item> items = new ArrayList<>();

}
