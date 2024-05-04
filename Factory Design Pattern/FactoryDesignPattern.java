package DesignPatterns;

public class FactoryDesignPattern {
    private CardFactory cardFactory;

    public void setCardFactory(CardFactory cardFactory) {
        this.cardFactory = cardFactory;
    }

    public void createCard() {
        Card card = cardFactory.createCard();
        int amount = card.getAmount();
        System.out.println("Amount: " + amount);
    }

    public static void main(String[] args) {
        FactoryDesignPattern factoryDesignPattern = new FactoryDesignPattern();
        factoryDesignPattern.setCardFactory(new CreditCardFactory());
        factoryDesignPattern.createCard();
        factoryDesignPattern.setCardFactory(new DebitCardFactory());
        factoryDesignPattern.createCard(); 

        // Setting VisaCardFactory as the card factory
        factoryDesignPattern.setCardFactory(new VisaCardFactory());
        factoryDesignPattern.createCard(); // Creates a VisaCard
    }
}

interface Card {
    int getAmount();
}

interface CardFactory {
    Card createCard();
}

class Debit implements Card {
    @Override
    public int getAmount() {
        return 1;
    }
}

class Credit implements Card {
    @Override
    public int getAmount() {
        return 10;
    }
}

class Visa implements Card {
    @Override
    public int getAmount() {
        return 5;
    }
}

class CreditCardFactory implements CardFactory {
    @Override
    public Card createCard() {
        return new Credit();
    }
}

class DebitCardFactory implements CardFactory {
    @Override
    public Card createCard() {
        return new Debit();
    }
}

class VisaCardFactory implements CardFactory {
    @Override
    public Card createCard() {
        return new Visa();
    }
}
