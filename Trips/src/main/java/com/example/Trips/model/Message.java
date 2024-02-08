package com.example.Trips.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Timestamp time;
    //@JsonBackReference("UserSender_Msg")
    @ManyToOne
    @JoinColumn(name="sender_id")
    private User sender;
    //@JsonManagedReference("UserReceiver_Msg")
    @ManyToOne
    @JoinColumn(name="receiver_id")
    private User receiver;

}
