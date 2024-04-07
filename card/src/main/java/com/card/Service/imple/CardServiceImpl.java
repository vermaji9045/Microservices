package com.card.Service.imple;

import com.card.Dto.CardsDto;
import com.card.Exception.CardAlreadyExitsException;
import com.card.Exception.ResourceNotFoundException;
import com.card.Mapper.CardsMapper;
import com.card.Repository.CardsRepository;
import com.card.Service.ICardService;
import com.card.constants.CardsConstants;
import com.card.entity.Cards;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardService {


    private CardsRepository cardsRepository;
    @Override
    public void createCard(String mobileNumber) {

        Optional<Cards>optionalCards= cardsRepository.findByMobileNumber(mobileNumber);

        if(optionalCards.isPresent())
        {
            throw new CardAlreadyExitsException("Card Already regisatred with the given number" + mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber)
    {
        Cards newCard=new Cards();

        long randomCardNumber=1000000000L+new Random().nextInt(900000000);

        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setMobileNumber(mobileNumber);
    newCard.setAmountUsed(0);
    newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
    newCard.setCreatedAt(LocalDateTime.now());
    return newCard;

    }

    @Override
    public CardsDto fetch(String mobileNumber) {

        Cards mobNum=cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(

                ()->new ResourceNotFoundException("Card","MobileNumber",mobileNumber)
        );

        return CardsMapper.mapToCardsDto(mobNum,new CardsDto());

    }

    @Override
    public boolean UpdateCard(CardsDto cardsDto) {

        Cards cards=cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(

                ()->new ResourceNotFoundException("Cards","Card Number",cardsDto.getCardNumber())
        );
        CardsMapper.mapToCrads(cardsDto,cards);
        cardsRepository.save(cards);
        return true;
    }

    @Override
    public boolean DeleteCard(String mobileNumber) {

        Cards cards=cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(

                ()->new ResourceNotFoundException("Cards","MobileNumber",mobileNumber)
        );
        cardsRepository.deleteById(cards.getCard_id());

        return true;
    }


}

