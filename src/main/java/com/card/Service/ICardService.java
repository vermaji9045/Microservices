package com.card.Service;

import com.card.Dto.CardsDto;
import com.card.entity.Cards;

public interface ICardService {

    void createCard(String mobileNumber);
    CardsDto fetch(String mobileNumber);
    boolean UpdateCard(CardsDto cardsDto);
    boolean DeleteCard(String mobileNumber);

}
