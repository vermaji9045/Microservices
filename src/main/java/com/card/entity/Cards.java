package com.card.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name="CARDS")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cards extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private long card_id;
    private String mobileNumber;
    private String cardNumber;
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;
}
