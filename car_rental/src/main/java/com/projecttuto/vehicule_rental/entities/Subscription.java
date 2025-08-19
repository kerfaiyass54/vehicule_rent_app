package com.projecttuto.vehicule_rental.entities;


import com.projecttuto.vehicule_rental.enums.SubscriptionType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idsubscrip")
    private long idSubscrip;

    @Column(name="type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SubscriptionType type;

    @Column(name="date_start")
    @CreatedDate
    private Instant dateStart;

    @Column(name="reduce", nullable = false)
    private int reduce;

    @Column(name="price", nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "id_supplier", referencedColumnName = "idsupp")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "idclient")
    private Client client;
}
