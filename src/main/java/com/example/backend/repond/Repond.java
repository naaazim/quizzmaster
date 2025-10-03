package com.example.RegisterLogin.repond;

import org.hibernate.annotations.*;

import com.example.RegisterLogin.appuser.AppUser;
import com.example.RegisterLogin.piece.Piece;
import com.example.RegisterLogin.reponse.Reponse;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Repond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String texte;
    private double note;
    private Boolean corrige = false;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AppUser user;
    @ManyToOne
    @JoinColumn(name = "reponse_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Reponse reponse;
    @OneToOne
    @JoinColumn(name = "piece_id")
    private Piece piece;

    public Repond(String texte, AppUser user, Reponse reponse) {
        this.texte = texte;
        this.user = user;
        this.reponse = reponse;
    }

}
