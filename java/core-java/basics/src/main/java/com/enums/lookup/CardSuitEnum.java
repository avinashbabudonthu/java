package com.enums.lookup;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

enum CardColorEnum {
	RED, BLACK;
}

@Getter
public enum CardSuitEnum {

	SPADE("Spade", "S", CardColorEnum.RED), HEART("Heart", "H", CardColorEnum.BLACK),
	DIAMOND("Diamond", "D", CardColorEnum.RED), CLUB("Club", "C", CardColorEnum.BLACK);

	private String cardName;
	private String cardSymbol;
	private CardColorEnum cardColor;
	private static final Map<String, CardSuitEnum> lookupMap = new HashMap<>(CardSuitEnum.values().length);

	static {
		for (CardSuitEnum cardSuitEnum : CardSuitEnum.values()) {
			lookupMap.put(cardSuitEnum.getCardName().toLowerCase(), cardSuitEnum);
		}
	}

	public static CardSuitEnum lookupByName(String name) {
		return lookupMap.get(name.toLowerCase());
	}

	private CardSuitEnum(String cardName, String cardSymbol, CardColorEnum cardColor) {
		this.cardName = cardName;
		this.cardSymbol = cardSymbol;
		this.cardColor = cardColor;
	}
}