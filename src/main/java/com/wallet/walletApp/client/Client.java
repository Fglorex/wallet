package com.wallet.walletApp.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String email;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }

    private Long balance;

}
