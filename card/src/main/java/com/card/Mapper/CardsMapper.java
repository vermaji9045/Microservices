package com.card.Mapper;

import com.card.Dto.CardsDto;
import com.card.entity.Cards;

public class CardsMapper {


    public static CardsDto mapToCardsDto(Cards cards,CardsDto cardsDto)
    {
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        return cardsDto;
    }

    public static Cards mapToCrads(CardsDto cardsDto,Cards cards)
    {
        cards.setAmountUsed(cardsDto.getAmountUsed());
        cards.setCardType(cards.getCardType());
        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        return cards;
    }
}
